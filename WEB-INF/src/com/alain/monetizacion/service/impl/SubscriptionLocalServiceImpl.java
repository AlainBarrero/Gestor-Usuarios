/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.alain.monetizacion.service.impl;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import com.alain.monetizacion.NoSuchSubsConfigurationException;
import com.alain.monetizacion.NoSuchSubscriptionException;
import com.alain.monetizacion.model.SubsConfiguration;
import com.alain.monetizacion.model.Subscription;
import com.alain.monetizacion.service.Role_ConfigLocalServiceUtil;
import com.alain.monetizacion.service.SubsConfigurationLocalServiceUtil;
import com.alain.monetizacion.service.base.SubscriptionLocalServiceBaseImpl;
import com.alain.monetizacion.service.email.SendEmailService;
import com.alain.monetizacion.service.email.SendEmailServiceImpl;
import com.alain.monetizacion.service.paypal.ExpressCheckoutService;
import com.alain.monetizacion.service.paypal.ExpressCheckoutServiceImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;


/**
 * The implementation of the subscription local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.alain.monetizacion.service.SubscriptionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Alain
 * @see com.alain.monetizacion.service.base.SubscriptionLocalServiceBaseImpl
 * @see com.alain.monetizacion.service.SubscriptionLocalServiceUtil
 */
public class SubscriptionLocalServiceImpl
	extends SubscriptionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.alain.monetizacion.service.SubscriptionLocalServiceUtil} to access the subscription local service.
	 */
	
	
	
	private SendEmailService sendEmailService = new SendEmailServiceImpl();
	private ExpressCheckoutService expressCheckoutService = new ExpressCheckoutServiceImpl();
	
	
	
	/*
	 * El método se usa para la búsqueda de usuarios
	 */
	@Override
	public Subscription getSubscription (long subscriptionId) 
			throws SystemException, NoSuchSubscriptionException {
	    return subscriptionPersistence.findByPrimaryKey(subscriptionId);
	}
	
	
	
	/*
	 * El método se usa para la búsqueda de usuarios
	 */
	@Override 
	public List<Subscription> findByUserId(long userId)
			throws NoSuchSubsConfigurationException, SystemException {
		return subscriptionPersistence.findByuserId(userId);
	}
	
	
	/*
	 * El método crea la suscripción del usuario
	 */
	@Override
	public Subscription addSubscription(long configurationId,long userId, Date expireDate, double payment, String paypalProfile) 
			throws SystemException, PortalException {
		try{
			
			Date now = new Date();
			long subscriptionId = counterLocalService.increment();
			
			Subscription subscription = subscriptionPersistence.create(subscriptionId);
	
			subscription.setUserId(userId);
			subscription.setCreateDate(now);
			subscription.setExpireDate(expireDate);
			subscription.setPayment(payment);
			subscription.setConfigurationId(configurationId);
			subscription.setPaypalProfile(paypalProfile);
			subscription.setIsActive(true);

			subscriptionPersistence.update(subscription);
			return subscription;
		}catch(Exception e){
			System.out.println("Error:" + e);
			return null;
		}
	}
	
	/*
	 *	El método actualiza la fecha de expiración del usurio 
	 */
	@Override
	public Subscription updateSbscriptionExpireDate(long subscriptionId, Date newExpireDate){
		try {
			Subscription subscription = subscriptionPersistence.findByPrimaryKey(subscriptionId);
			
			subscription.setExpireDate(newExpireDate);
			
			subscriptionPersistence.update(subscription);
			return subscription;
		} catch (NoSuchSubscriptionException | SystemException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	/*
	 *	El método borra los usuarios seleccionados por el administrador
	 */
	@Override
	public List<Subscription> deleteSubcriptionUser(String users) throws SystemException, PortalException {
		List<Subscription> resultList = new ArrayList<Subscription>();
		String[] subscriptionList = (users.split(","));
		try{
			for(int i = 0; i<subscriptionList.length; i++){
				Subscription sub = subscriptionPersistence.findByPrimaryKey(Long.parseLong(subscriptionList[i]));
				
				SubsConfiguration sconfig = SubsConfigurationLocalServiceUtil.getSubsConfiguration(sub.getConfigurationId());
				User u = UserLocalServiceUtil.getUser(sub.getUserId());
				sendEmailService.sendEmailJustAction(u.getEmailAddress(), sconfig, "delete");
				expressCheckoutService.UpdateRecurringPaymentsProfileCancel(sub.getPaypalProfile(), sconfig);
				Role_ConfigLocalServiceUtil.removeRoleToSuscribedUser(u.getUserId(), sconfig);
				
				subscriptionPersistence.remove(Long.parseLong(subscriptionList[i]));
				resultList.add(sub);
			}
		}catch(Exception e){
			
		}
		return resultList;
	}
	
	
	
	/*
	 *	El método busca la configuración a la que pertenece su suscripción
	 */
	@Override
	public List<Subscription> findByConfigurationId(long configurationId)
			throws NoSuchSubsConfigurationException, SystemException {
		return subscriptionPersistence.findByconfigurationId(configurationId);
	}
	
	
	
	/*
	 *	El método actualiza la activación de la suscripción
	 */
	@Override
	public Subscription updateUserActivation(long subscriptionId) throws SystemException, PortalException{
		Subscription sub = subscriptionPersistence.findByPrimaryKey(subscriptionId);
		sub.setIsActive(false);
		
		subscriptionPersistence.update(sub);
		return sub;
	}
	
	
	
	/*
	 *	El método actualiza la activación de la suscripción
	 */
	@Override
	public Subscription updateUserReactivation(long subscriptionId) throws SystemException, PortalException{
		Subscription sub = subscriptionPersistence.findByPrimaryKey(subscriptionId);
		sub.setIsActive(true);
		
		subscriptionPersistence.update(sub);
		return sub;
	}
	
	
	
	/*
	 *	El método obtiene todas las suscripciones de la base de datos
	 */
	@Override
	public List<Subscription> getAllSubscriptions(){
		try {
			return subscriptionPersistence.findAll();
		} catch (SystemException e) {
			e.printStackTrace();
			return new ArrayList<Subscription>();
		}
	}
	
	
	
	/*
	 *	El método busca al suscriptor que queremos de la configuración
	 */
	@Override
	public Subscription getSubscriptionIntoConfiguration(long userId, List<Subscription> subList){
		Subscription sub = null;
		for(int i=0; i<subList.size(); i++){
			if(subList.get(i).getUserId() == userId){
				 sub = subList.get(i);
			}
		}
		return sub;
	}
}