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

import com.alain.monetizacion.model.SubsConfiguration;
import com.alain.monetizacion.model.Subscription;
import com.alain.monetizacion.service.base.SubsConfigurationLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;




/**
 * The implementation of the subs configuration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.alain.monetizacion.service.SubsConfigurationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Alain
 * @see com.alain.monetizacion.service.base.SubsConfigurationLocalServiceBaseImpl
 * @see com.alain.monetizacion.service.SubsConfigurationLocalServiceUtil
 */
public class SubsConfigurationLocalServiceImpl extends SubsConfigurationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.alain.monetizacion.service.SubsConfigurationLocalServiceUtil} to access the subs configuration local service.
	 */


	/*
	 * El método se utilza para obtener la suscripción con su id
	 */
	@Override
	public SubsConfiguration getSubsConfiguration(long configurationId) 
			throws NoSuchSubsConfigurationException, SystemException {
		return subsConfigurationPersistence.findByPrimaryKey(configurationId);
	}
	
	
	
	/*
	 * El método se utilza para obtener la suscripción con el grupo
	 */
	@Override
	public List<SubsConfiguration> findByGroupId(long groupId) 
				throws NoSuchSubsConfigurationException, SystemException {
		return subsConfigurationPersistence.findByGroupId(groupId);
	}
	
	
	
	/*
	 * El método obtiene las configuraciones de las suscripciones
	 */
	@Override
	public List<SubsConfiguration> findAllSubscribedConfiguration(List<Subscription> subsList){
		List<SubsConfiguration> resultList = new ArrayList<SubsConfiguration>();
		try {
			for(int i=0; i<subsList.size(); i++){
				if(subsList.get(i).getIsActive()){
					SubsConfiguration sconfig = getSubsConfiguration(subsList.get(i).getConfigurationId());
					resultList.add(sconfig);
				}
			}
		} catch (NoSuchSubsConfigurationException | SystemException e) {
				e.printStackTrace();
		}
		return resultList;
	}
	
	
	
	/*
	 * El método crea una nueva configuración si esta no existe
	 */
	@Override 
	public SubsConfiguration createConfiguration() 
			throws PortalException, SystemException{
		long configurationId = counterLocalService.increment();
		return subsConfigurationPersistence.create(configurationId);
	}
	
	
	
	/*
	 * El método actualiza los campos intrducidos por el administrador
	 */
	@Override
	public SubsConfiguration updateConfiguration(String description, double amount, int time, String cycle, 
			 			long groupId, SubsConfiguration configuration) throws PortalException, SystemException {
		try{
			
			configuration.setGroupId(groupId);
			configuration.setDescription(description);
			configuration.setAmount(amount);
			configuration.setTime(time);
			configuration.setCycle(cycle);
			
			
			subsConfigurationPersistence.update(configuration);
			return configuration;
		}catch(Exception e){
			System.out.println("Error:" + e);
			return null;
		}
	}		

}