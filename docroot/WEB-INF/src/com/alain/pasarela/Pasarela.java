package com.alain.pasarela;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Pasarela
 */
public class Pasarela extends MVCPortlet {
 
	private ExpressCheckoutService payPalExpressCheckoutService = new ExpressCheckoutServiceImpl();
	private SendEmailService sendEmailService = new SendEmailServiceImpl();
	private String TOKEN, PAYERID; 
	private String returnURL, cancelURL;
	
	/*Cancel URL parameters*/
	private String id = "p_p_id=pasarela_WAR_Monetizacionportlet";
	private String lifecycle = "p_p_lifecycle=1";
	private String state = "p_p_state=normal";
	private String mode = "p_p_mode=view";
	private String action = "_pasarela_WAR_Monetizacionportlet_javax.portlet.action=deleteSessionParameter";
	
	
	/*
	 * El método crea la conexión entre el cliente y el servidor de PayPal
	 */
	public void shortcutExpressCheckout(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		try{
		
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			returnURL = PortalUtil.getLayoutURL(themeDisplay); 
			cancelURL = PortalUtil.getLayoutURL(themeDisplay) + "?" + id + "&" + lifecycle + "&" + state + "&" + mode + "&" + action;
			
			
			List<SubsConfiguration> cf = SubsConfigurationLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());
			List<Subscription> csubs = SubscriptionLocalServiceUtil.findByConfigurationId(cf.get(0).getConfigurationId());
			Subscription sub = SubscriptionLocalServiceUtil.getSubscriptionIntoConfiguration(themeDisplay.getUserId(), csubs);
			

			if(sub !=  null){
				SubscriptionLocalServiceUtil.updateUserReactivation(sub.getSubscriptionId());
				payPalExpressCheckoutService.UpdateRecurringPaymentsProfileReactive(sub.getPaypalProfile(), cf.get(0));
				
				User u = UserLocalServiceUtil.getUser(sub.getUserId());
				Role_ConfigLocalServiceUtil.addRoleToSuscriptedUser(u.getUserId(), cf.get(0));
				sendEmailService.sendEmailJustAction(u.getEmailAddress(), cf.get(0), "suscribe");
			}else{
				HashMap<String, String> nvp = payPalExpressCheckoutService.SetExpressCheckoutRecurringPayments(returnURL, cancelURL, cf.get(0));
				if(nvp != null){
					String strAck = nvp.get("ACK").toString();
					if(strAck !=null && strAck.equalsIgnoreCase("Success")){
						TOKEN = nvp.get("TOKEN").toString();
						
						actionRequest.getPortletSession().setAttribute("payState", "checkout");
						
						String paypalURL = "https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token=" + nvp.get("TOKEN").toString();
						actionResponse.sendRedirect(actionResponse.encodeURL( paypalURL ));
						
					}else{
						actionResponse.setRenderParameter("myUrl", "/html/pasarela/view.jsp");
					}
				}else{
					actionResponse.setRenderParameter("myUrl", "/html/pasarela/view.jsp");
				}
			}
		}catch(Exception e){
			actionResponse.setRenderParameter("myUrl", "/html/pasarela/view.jsp");
		}
	}
	
	
	/*
	 * El método crea el perfil del cliente
	 */
	public void getExpressCheckoutDetails(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<SubsConfiguration> cf = SubsConfigurationLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());
		
		try{		
			if (TOKEN != null){
				HashMap<String, String> nvp = payPalExpressCheckoutService.GetExpressCheckoutDetails(TOKEN, cf.get(0));
				if(nvp != null){
					String strAck = nvp.get("ACK").toString();
					if(strAck != null && (strAck.equalsIgnoreCase("Success") || strAck.equalsIgnoreCase("SuccessWithWarning"))){
						PAYERID = nvp.get("PAYERID").toString();
						actionRequest.getPortletSession().setAttribute("payState", "confirm");
					} else { 	
						actionResponse.setRenderParameter("myUrl", "/html/pasarela/view.jsp");
					}
				}else{
					actionResponse.setRenderParameter("myUrl", "/html/pasarela/view.jsp");
				}	
			} else {
				actionResponse.setRenderParameter("myUrl", "/html/pasarela/view.jsp");
			}
		} catch (Exception e){
			actionResponse.setRenderParameter("myUrl", "/html/pasarela/view.jsp");
		}		
	}
	
	
	
	/*
	 * El método finaliza la transacción del pago
	 */
	public void confirmOrderPayPal(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<SubsConfiguration> cf = SubsConfigurationLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());
		
		try{	
			if (TOKEN != null){
				HashMap<String, String> nvp = payPalExpressCheckoutService.CreateRecurringPaymentsProfile(TOKEN, PAYERID, cf.get(0));
				if(nvp != null){
					String strAck = nvp.get("ACK").toString();
					if(strAck !=null && (strAck.equalsIgnoreCase("Success") || strAck.equalsIgnoreCase("SuccessWithWarning"))){
						Subscription sup = SubscriptionLocalServiceUtil.addSubscription(cf.get(0).getConfigurationId(), themeDisplay.getUserId(), 
								getExpireDate(new Date(), cf.get(0).getCycle(), cf.get(0).getTime()), cf.get(0).getAmount(), nvp.get("PROFILEID"));										
						
						User u = UserLocalServiceUtil.getUser(sup.getUserId());
						Role_ConfigLocalServiceUtil.addRoleToSuscriptedUser(sup.getUserId(), cf.get(0));
						sendEmailService.sendEmailJustAction(u.getEmailAddress(), cf.get(0), "suscribe");
						actionRequest.getPortletSession().setAttribute("payState", null);
					} else {
						actionResponse.setRenderParameter("myUrl", "/html/pasarela/view.jsp");
					}					
				}else{
					actionResponse.setRenderParameter("myUrl", "/html/pasarela/view.jsp");
				}				
			} else {
				actionResponse.setRenderParameter("myUrl", "/html/pasarela/view.jsp");
			}	
		} catch (Exception e){
			actionResponse.setRenderParameter("myUrl", "/html/pasarela/view.jsp");
		}		
	}
	
	

	/*
	 * El método obtiene la fecha de expiración de la suscripción
	 */
	public Date getExpireDate(Date date, String cycle, int time){
		Calendar cal = Calendar.getInstance();
        cal.setTime(date);
		
		switch(cycle){
			case "Day":  
						cal.add(Calendar.DATE, time);
						return cal.getTime();
			case "Week":
						cal.add(Calendar.DATE , time * 7);
						return cal.getTime();
			case "Month":
						cal.add(Calendar.DATE , time * 30);
						return cal.getTime();
			case "Year":
						cal.add(Calendar.DATE , time * 365);
						return cal.getTime();
			default: 	return date;
		}
	}
	
	
	
	/*
	 * El método actualiza la activación del usuario
	 */
	public void updateUserActivation(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<SubsConfiguration> cf = SubsConfigurationLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());
		List<Subscription> csubs = SubscriptionLocalServiceUtil.findByConfigurationId(cf.get(0).getConfigurationId());
		
		Subscription sub = SubscriptionLocalServiceUtil.getSubscriptionIntoConfiguration(themeDisplay.getUserId(), csubs);
		
		SubscriptionLocalServiceUtil.updateUserActivation(sub.getSubscriptionId());
		payPalExpressCheckoutService.UpdateRecurringPaymentsProfile(sub.getPaypalProfile(), cf.get(0));
		
		User u = UserLocalServiceUtil.getUser(sub.getUserId());
		Role_ConfigLocalServiceUtil.removeRoleToSuscribedUser(u.getUserId(), cf.get(0));
		sendEmailService.sendEmailJustAction(u.getEmailAddress(), cf.get(0), "desactive");
	}
	
	
	

	/*
	 * El método borrar la variable de sesión del portal
	 */
	public void deleteSessionParameter(ActionRequest actionRequest, ActionResponse actionResponse){
		actionRequest.getPortletSession().setAttribute("payState", null);
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
	 * El método muestra la vista que corresponde en cada momento
	 */
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String payState = (String) renderRequest.getPortletSession().getAttribute("payState");
		long userId = themeDisplay.getUserId();
		
		try {
			List<SubsConfiguration> cf = SubsConfigurationLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());
			List<Subscription> csubs = new ArrayList<Subscription>();
			
			if(!cf.isEmpty()){
				csubs = SubscriptionLocalServiceUtil.findByConfigurationId(cf.get(0).getConfigurationId());
				Subscription sub = SubscriptionLocalServiceUtil.getSubscriptionIntoConfiguration(userId, csubs);
				String roles = getConfigurationRoles(cf.get(0));
				
				if(payState != null){
					if(payState.equals("checkout")){
						 include("/html/pasarela/paynow.jsp", renderRequest, renderResponse);
					}else if(payState.equals("confirm")){
						 include("/html/pasarela/confirm.jsp", renderRequest, renderResponse);
					}
				}else{
					if(sub != null){
						if(sub.getIsActive()){
							renderRequest.setAttribute("sconfig", cf.get(0));
							renderRequest.setAttribute("roles", roles);
							include("/html/pasarela/suscrito.jsp", renderRequest, renderResponse);
						}else{
							super.doView(renderRequest, renderResponse);
						}
					}else{
						super.doView(renderRequest, renderResponse);
					}
				}	
				
			}else{
				super.doAbout(renderRequest, renderResponse);
			}
		} catch (SystemException | PortalException e) {
			e.printStackTrace();
		}
	}

}
