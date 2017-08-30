package com.alain.usuario;


import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.alain.monetizacion.model.Role_Config;
import com.alain.monetizacion.model.SubsConfiguration;
import com.alain.monetizacion.model.Subscription;
import com.alain.monetizacion.service.Role_ConfigLocalServiceUtil;
import com.alain.monetizacion.service.SubsConfigurationLocalServiceUtil;
import com.alain.monetizacion.service.SubscriptionLocalServiceUtil;
import com.alain.monetizacion.service.email.SendEmailService;
import com.alain.monetizacion.service.email.SendEmailServiceImpl;
import com.alain.monetizacion.service.paypal.ExpressCheckoutService;
import com.alain.monetizacion.service.paypal.ExpressCheckoutServiceImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
/**
 * Portlet implementation class User
 */
public class Usuario extends MVCPortlet {

	private ExpressCheckoutService payPalExpressCheckoutService = new ExpressCheckoutServiceImpl();
	private SendEmailService sendEmailService = new SendEmailServiceImpl();
	
	/*
	 * El método selecciona una de las suscripciones
	 */
	public void selectSuscription(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		long configurationId = ParamUtil.getLong(actionRequest, "userOption");
		SubsConfiguration sconfig = SubsConfigurationLocalServiceUtil.getSubsConfiguration(configurationId);
		
		actionRequest.getPortletSession().setAttribute("sconfigInfo", sconfig);
	}
	
	
	
	/*
	 * El método actualiza el estado del suscriptor
	 */
	public void updateUserActivation(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		long configurationId = ParamUtil.getLong(actionRequest, "configurationId");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Subscription> csubs = SubscriptionLocalServiceUtil.findByConfigurationId(configurationId);
		SubsConfiguration sconfig = SubsConfigurationLocalServiceUtil.getSubsConfiguration(configurationId);
		
		Subscription sub = SubscriptionLocalServiceUtil.getSubscriptionIntoConfiguration(themeDisplay.getUserId(), csubs);
		
		SubscriptionLocalServiceUtil.updateUserActivation(sub.getSubscriptionId());
		payPalExpressCheckoutService.UpdateRecurringPaymentsProfile(sub.getPaypalProfile(), sconfig);
		
		User u = UserLocalServiceUtil.getUser(sub.getUserId());
		Role_ConfigLocalServiceUtil.removeRoleToSuscribedUser(u.getUserId(), sconfig);
		sendEmailService.sendEmailJustAction(u.getEmailAddress(), sconfig, "desactive");
		
		actionRequest.getPortletSession().setAttribute("sconfigInfo", null);
	}
	
	
	
	/*
	 * El método obtiene los roles que oferta la configuración
	 */
	public String getConfigurationRoles(SubsConfiguration subsConfiguration) throws PortalException, SystemException{
		List<Role_Config> roleList = Role_ConfigLocalServiceUtil.getRoleConfig(subsConfiguration.getConfigurationId());
		String resultList = "";
		
		for(int i=0; i<roleList.size(); i++){
			Role role = RoleLocalServiceUtil.getRole(roleList.get(i).getRoleId());
			if(i == roleList.size()-1){
				resultList += " " + role.getName();
			}else{
				resultList += " " + role.getName() + ",";	
			}
		}
		
		return resultList;		
	}
	
	
	
	/*
	 * El método visualiza las opciones y las muestra en caso de ser selecciondas
	 */
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		SubsConfiguration sconfigInfo = (SubsConfiguration) renderRequest.getPortletSession().getAttribute("sconfigInfo");
		
		try {
			List<Subscription> subsList = SubscriptionLocalServiceUtil.findByUserId(themeDisplay.getRealUserId());
			List<SubsConfiguration> confList = SubsConfigurationLocalServiceUtil.findAllSubscribedConfiguration(subsList);
			
			renderRequest.setAttribute("confList", confList);
			
			if(sconfigInfo != null){
				String roles = getConfigurationRoles(sconfigInfo);
				
				renderRequest.setAttribute("sconfigInfo", sconfigInfo);
				renderRequest.setAttribute("roles", roles);
				super.doView(renderRequest, renderResponse);
				include("/html/user/information.jsp", renderRequest, renderResponse);
			}else{
				super.doView(renderRequest, renderResponse);
			}
		} catch (SystemException | PortalException e) {
			e.printStackTrace();
		}
	}

}
