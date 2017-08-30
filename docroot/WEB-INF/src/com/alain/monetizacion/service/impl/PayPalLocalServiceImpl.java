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

import com.alain.monetizacion.NoSuchPayPalException;
import com.alain.monetizacion.model.PayPal;
import com.alain.monetizacion.service.base.PayPalLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the pay pal local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.alain.monetizacion.service.PayPalLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Alain
 * @see com.alain.monetizacion.service.base.PayPalLocalServiceBaseImpl
 * @see com.alain.monetizacion.service.PayPalLocalServiceUtil
 */
public class PayPalLocalServiceImpl extends PayPalLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.alain.monetizacion.service.PayPalLocalServiceUtil} to access the pay pal local service.
	 */
	
	/*
	 * El método busca las configuraciones PayPal
	 */
	@Override
	public PayPal findByConfigurationId(long configurationId) 
				throws  NoSuchPayPalException,SystemException{
		return payPalPersistence.findByPrimaryKey(configurationId);
	}
	
	/*
	 * El método crea una nueva configuración PayPal si esta no existe
	 */
	@Override
	public PayPal createPayPal(long configurationId){
		return payPalPersistence.create(configurationId);
	}
	
	
	
	/*
	 * El método actualiza los campos intrducidos por el administrador
	 */
	@Override
	public PayPal updatePayPal(String paypalUser, String paypalPassword, String paypalFirm, String paypalEmail,
			PayPal paypal) throws PortalException, SystemException {
	try{
			paypal.setPaypalEmail(paypalEmail);
			paypal.setPaypalFirm(paypalFirm);
			paypal.setPaypalPassword(paypalPassword);
			paypal.setPaypalUser(paypalUser);
			
			payPalPersistence.update(paypal);
			return paypal;
		}catch(Exception e){
			System.out.println("Error:" + e);
			return null;
		}
	}

}