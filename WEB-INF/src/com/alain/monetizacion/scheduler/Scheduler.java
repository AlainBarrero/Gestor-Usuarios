package com.alain.monetizacion.scheduler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alain.monetizacion.model.SubsConfiguration;
import com.alain.monetizacion.model.Subscription;
import com.alain.monetizacion.service.Role_ConfigLocalServiceUtil;
import com.alain.monetizacion.service.SubsConfigurationLocalServiceUtil;
import com.alain.monetizacion.service.SubscriptionLocalServiceUtil;
import com.alain.monetizacion.service.email.SendEmailService;
import com.alain.monetizacion.service.email.SendEmailServiceImpl;
import com.alain.monetizacion.service.paypal.ExpressCheckoutService;
import com.alain.monetizacion.service.paypal.ExpressCheckoutServiceImpl;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
 

public class Scheduler implements MessageListener{
	
	private ExpressCheckoutService payPalExpressCheckoutService = new ExpressCheckoutServiceImpl();
	private SendEmailService sendEmailService = new SendEmailServiceImpl();

	/*
	 *	El método avisa a los usuarios de los eventos que van a suceder 
	 */
	@Override
	public void receive(Message arg0) throws MessageListenerException {
		try{
			List<Subscription> subsList = SubscriptionLocalServiceUtil.getAllSubscriptions();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			Date nowCalendar = Calendar.getInstance().getTime();
			String nowDate = sdf.format(nowCalendar);
			
			for(int i=0; i<subsList.size(); i++){	
				
				/*La fecha en la que expira la suscripción*/
				Date expire = subsList.get(i).getExpireDate();
				String expireDate = sdf.format(expire);
				
				
				/*La fecha de expiración una semana antes*/
				Calendar expireWeek = Calendar.getInstance();
				expireWeek.setTime(expire); 
				expireWeek.add(Calendar.DAY_OF_YEAR, -7);
				String expireWeekDate = sdf.format(expireWeek.getTime());
				
				
				/*Comparamos la fecha de una semana antes con la de hoy y avisamos al suscriptor*/
				if(nowDate.equals(expireWeekDate)){
					User u = UserLocalServiceUtil.getUser(subsList.get(i).getUserId());
					SubsConfiguration sconfig = SubsConfigurationLocalServiceUtil.getSubsConfiguration(subsList.get(i).getConfigurationId());
					
					if(subsList.get(i).getIsActive()){
						sendEmailService.sendEmailJustAction(u.getEmailAddress(), sconfig, "cycle");
					}else{
						sendEmailService.sendEmailJustAction(u.getEmailAddress(), sconfig, "notCycle");
					}
				}
				
				
				/*Compromabos si la suscripción ya se ha caducado y hacemos lo correspondiente*/
				if(nowDate.equals(expireDate)){
					User u = UserLocalServiceUtil.getUser(subsList.get(i).getUserId());
					SubsConfiguration sconfig = SubsConfigurationLocalServiceUtil.getSubsConfiguration(subsList.get(i).getConfigurationId());
					
					if(subsList.get(i).getIsActive()){
						sendEmailService.sendEmailJustAction(u.getEmailAddress(), sconfig, "autoPay");
						Date newExpireDate = getExpireDate(new Date(), sconfig.getCycle(), sconfig.getTime());
						SubscriptionLocalServiceUtil.updateSbscriptionExpireDate(subsList.get(i).getSubscriptionId(), newExpireDate);
						
						/*Gestión de los roles*/
						Role_ConfigLocalServiceUtil.removeRoleToSuscribedUser(u.getUserId(), sconfig);
						Role_ConfigLocalServiceUtil.addRoleToSuscriptedUser(u.getUserId(), sconfig);
						
						
					}else{
						Role_ConfigLocalServiceUtil.removeRoleToSuscribedUser(u.getUserId(), sconfig);
						
						payPalExpressCheckoutService.UpdateRecurringPaymentsProfileCancel(subsList.get(i).getPaypalProfile(), sconfig);
						SubscriptionLocalServiceUtil.deleteSubscription(subsList.get(i).getSubscriptionId());
						sendEmailService.sendEmailJustAction(u.getEmailAddress(), sconfig, "autoDelete");
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
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
}
