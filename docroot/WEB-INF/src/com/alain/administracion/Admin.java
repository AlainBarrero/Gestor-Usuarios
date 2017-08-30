package com.alain.administracion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;



import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.alain.monetizacion.model.PayPal;
import com.alain.monetizacion.model.SubsConfiguration;
import com.alain.monetizacion.model.Subscription;
import com.alain.monetizacion.service.PayPalLocalServiceUtil;
import com.alain.monetizacion.service.Role_ConfigLocalServiceUtil;
import com.alain.monetizacion.service.SubsConfigurationLocalServiceUtil;
import com.alain.monetizacion.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Admin
 */
public class Admin extends MVCPortlet {
	
	/*
	 * El método se usa para la actualización o creación de la configuración 
	 */
	public void updateConfiguration(ActionRequest request, ActionResponse response)
	        throws PortalException, SystemException {
	    
	    /*SubsConfiguration variables*/
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	    String description = ParamUtil.getString(request, "description");
	    double amount = ParamUtil.getDouble(request, "amount");
	    int time = ParamUtil.getInteger(request, "time");
	    String cycle = ParamUtil.getString(request, "cycle");
	    
	    /*De esta manera sabemos si la configuración es nueva o hay que editarla*/
	    long configurationId = ParamUtil.getLong(request, "configurationId");
	    SubsConfiguration sconfig;
	    PayPal pconfig;
	    if(configurationId == 0){
	    	sconfig = SubsConfigurationLocalServiceUtil.createConfiguration();
	    	pconfig = PayPalLocalServiceUtil.createPayPal(sconfig.getConfigurationId());
	    }else{
	    	sconfig = SubsConfigurationLocalServiceUtil.getSubsConfiguration(configurationId);
	    	pconfig = PayPalLocalServiceUtil.findByConfigurationId(sconfig.getConfigurationId());
	    }
	    
	    /*PayPal variables*/
	    String paypalUser = ParamUtil.getString(request, "paypalUser");
	    String paypalPassword = ParamUtil.getString(request, "paypalPassword");
	    String paypalFirm = ParamUtil.getString(request, "paypalFirm");
	    String paypalEmail = ParamUtil.getString(request, "paypalEmail");
	    
	    /*Role_Config variables*/
	    String roles = ParamUtil.getString(request, "roles");

    	
	    try {
	    	SubsConfigurationLocalServiceUtil.updateConfiguration(description, amount, time, cycle, themeDisplay.getScopeGroupId(), sconfig);
	    	PayPalLocalServiceUtil.updatePayPal(paypalUser, paypalPassword, paypalFirm, paypalEmail, pconfig);
	        Role_ConfigLocalServiceUtil.updateRoleConfig(sconfig.getConfigurationId(), roles);
	        SessionMessages.add(request, "ConfigurationkAdded");
	    } catch (Exception e) {
	        SessionErrors.add(request, e.getClass().getName());
	        response.setRenderParameter("mvcPath","/html/admin/view.jsp");
	    }

	}
	
	
	/*
	 * El método se usa para borrar los usuarios deseados
	 */
	public void deleteSubcriptionUser(ActionRequest request, ActionResponse response){
		String users = ParamUtil.getString(request, "userId");
		try {
				SubscriptionLocalServiceUtil.deleteSubcriptionUser(users);
				
				List<User> susers = getConfigurationUsers(ParamUtil.getLong(request, "configurationId"));
				List<Subscription> cusers = SubscriptionLocalServiceUtil.findByConfigurationId(ParamUtil.getLong(request, "configurationId"));
				request.getPortletSession().setAttribute("susers", susers);
				request.getPortletSession().setAttribute("cusers", cusers);
				
				SessionMessages.add(request, "ConfigurationkAdded");
				response.setRenderParameter("mvcPath","/html/admin/usuarios.jsp");
		    } catch (Exception e) {
		        SessionErrors.add(request, e.getClass().getName());
		        response.setRenderParameter("mvcPath","/html/admin/usuarios.jsp");
		    }
	}
	
	
	
	
	/*
	 * El método se usa para construir la vista o la edición 
	 */
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
				List<SubsConfiguration> cf = SubsConfigurationLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());
				if(cf.isEmpty()){
					renderRequest.setAttribute("sconfig", (long) 0);  //El objeto que se usará en la vista
					
					List<Role> roles = RoleLocalServiceUtil.getTypeRoles(2); //El tipo de role que necesitamos es el 2
					renderRequest.setAttribute("roles", roles);
					
					super.doView(renderRequest, renderResponse);
				}else{
					renderRequest.setAttribute("sconfig", cf.get(0)); //El primero que se encuentre
					
					PayPal pconfig = PayPalLocalServiceUtil.findByConfigurationId(cf.get(0).getConfigurationId());
					renderRequest.setAttribute("pconfig", pconfig);
					
					List<Role> roles = RoleLocalServiceUtil.getTypeRoles(2); //El tipo de role que necesitamos es el 2
					renderRequest.setAttribute("roles", roles);
					
					List<Role> croles = Role_ConfigLocalServiceUtil.getRolesByConfiguration(cf.get(0).getConfigurationId());
					renderRequest.setAttribute("croles", croles);
					
					/*Lista de usuarios*/
					List<User> susers = getConfigurationUsers(cf.get(0).getConfigurationId());
					List<Subscription> cusers = SubscriptionLocalServiceUtil.findByConfigurationId(cf.get(0).getConfigurationId());
					renderRequest.getPortletSession().setAttribute("susers", susers);
					renderRequest.getPortletSession().setAttribute("cusers", cusers);
					renderRequest.getPortletSession().setAttribute("rolesUser", croles);
					
					super.doEdit(renderRequest, renderResponse);
				}
		} catch (SystemException | PortalException e) {
				e.printStackTrace();
		}
	}
	
	
	/*
	 * El método optine los usuarios suscritos a la configuración
	 */
	public List<User> getConfigurationUsers(long configurationId) throws SystemException, PortalException{
		List<Subscription> cusers = SubscriptionLocalServiceUtil.findByConfigurationId(configurationId);
		List<User> susers = new ArrayList<User>();
		for(int i=0; i<cusers.size(); i++){
			susers.add(UserLocalServiceUtil.getUser(cusers.get(i).getUserId()));
		}
		return susers;
	}
}
