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
import java.util.List;

import com.alain.monetizacion.NoSuchSubsConfigurationException;
import com.alain.monetizacion.model.Message;
import com.alain.monetizacion.service.base.MessageLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the message local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.alain.monetizacion.service.MessageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Alain
 * @see com.alain.monetizacion.service.base.MessageLocalServiceBaseImpl
 * @see com.alain.monetizacion.service.MessageLocalServiceUtil
 */
public class MessageLocalServiceImpl extends MessageLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.alain.monetizacion.service.MessageLocalServiceUtil} to access the message local service.
	 */
	@Override
	public List<Message> findByGroupId(long companyId)
			throws NoSuchSubsConfigurationException, SystemException {
		return messagePersistence.findBycompanyId(companyId);
	}
	
	@Override
	public List<Message> findByUserId(long userId)
			throws NoSuchSubsConfigurationException, SystemException {
		return messagePersistence.findByuserId(userId);
	}
	
	@Override
	public Message addMessage(String userId, String description, ServiceContext serviceContext)
			throws PortalException, SystemException {
		try{
			long massageId = counterLocalService.increment();
			Message massage = messagePersistence.create(massageId);
			
			massage.setUserId(Long.parseLong(userId));
			massage.setCompanyId(serviceContext.getThemeDisplay().getCompanyId());
			massage.setDescription(description);
			massage.setIsValidate(false);
			massage.setExpandoBridgeAttributes(serviceContext);
			
			messagePersistence.update(massage);
			return massage;
		}catch(Exception e){
			System.out.println("Error:" + e);
			return null;
		}
	}
	
	@Override
	public List<Message> updateMessage(String messages) throws PortalException, SystemException {
		try{
			List<Message> resultList = new ArrayList<Message>();
			String[] messageList = (messages.split(","));
			
			for(int i = 0; i<messageList.length; i++)
			{
				Message msg = messagePersistence.findByPrimaryKey(Long.parseLong(messageList[i]));
				msg.setIsValidate(true);
				
				messagePersistence.update(msg);
				
				resultList.add(msg);
			}
			return resultList;
		}catch(Exception e){
			System.out.println("Error:" + e);
			return null;
		}	
	}
}