package com.alain.monetizacion.service.email;

import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.alain.monetizacion.model.Role_Config;
import com.alain.monetizacion.model.SubsConfiguration;
import com.alain.monetizacion.service.PayPalLocalServiceUtil;
import com.alain.monetizacion.service.Role_ConfigLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;


public class SendEmailServiceImpl implements SendEmailService {
	
	Log log = LogFactoryUtil.getLog(this.getClass());
	
	
	/*
	 * El método envía un mensaje al usuario suscrito
	 */
	@Override
	public void sendEmailJustAction(String userEmail, SubsConfiguration subsConfiguration, String action) throws Exception {
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		
		String adminEmail = PayPalLocalServiceUtil.findByConfigurationId(subsConfiguration.getConfigurationId()).getPaypalEmail();
		
		try{
			/*Creamos las direcciones de correo a las que hay que enviar el mensaje*/
			fromAddress = new InternetAddress(adminEmail);
			toAddress = new InternetAddress(userEmail);
			
			/*Creamos el mensaje que vamos a enviar*/
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject(subsConfiguration.getDescription());
			
			/*Generamos el cuerpo del mensaje*/
			String emailBody = 	"";
			
			switch(action){
				case "suscribe"  : 	emailBody = "Felicidades por su suscripción, a continuación se muestran los detalles de la misma.<br>";
									break;
				case "desactive" : 	emailBody = "Su suscripción ha sido desactivada con éxito.<br>";
									break;
				case "delete"	 : 	emailBody = "El administrador a borrado su suscripción.<br>";
									break;
				case "cycle"	 :	emailBody = "Su suscripción expira el ciclo, se cobrara la cuantia del mismo en una semana.<br>";
									break;
				case "notCycle"  :	emailBody = "Su suscripción esta a punto de expirar, si desea conservarla vuelva a activarla antes de una semana.<br>";
									break;
				case "autoDelete":	emailBody = "Su suscripción ha sido eliminada debido a su inactividad. <br>";
									break;
				case "autoPay"	 : 	emailBody = "Su suscripción a sido reenbolsada. Gracias por confiar en nosotros <br>";
									break;
			}
			emailBody +=	"<strong>Descripción: </strong>" + subsConfiguration.getDescription() + "<br>" +
							"<strong>Coste: </strong>" + subsConfiguration.getAmount() + " €<br>" +
							"<strong>Periodicidad: </strong>" + subsConfiguration.getTime() + " " + subsConfiguration.getCycle() + "<br>" +
							"<strong>Roles:</strong>" + getConfigurationRoles(subsConfiguration);
			
			mailMessage.setBody(emailBody);
			mailMessage.setHTMLFormat(true);
			
			MailServiceUtil.sendEmail(mailMessage);
			log.debug("Mensaje de confirmación envíado");
		}catch (AddressException e){
			e.printStackTrace();
		}
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
}
