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


import com.alain.monetizacion.model.Role_Config;
import com.alain.monetizacion.model.SubsConfiguration;
import com.alain.monetizacion.service.base.Role_ConfigLocalServiceBaseImpl;
import com.alain.monetizacion.service.persistence.Role_ConfigPK;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;

/**
 * The implementation of the role_ config local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.alain.monetizacion.service.Role_ConfigLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Alain
 * @see com.alain.monetizacion.service.base.Role_ConfigLocalServiceBaseImpl
 * @see com.alain.monetizacion.service.Role_ConfigLocalServiceUtil
 */
public class Role_ConfigLocalServiceImpl extends Role_ConfigLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.alain.monetizacion.service.Role_ConfigLocalServiceUtil} to access the role_ config local service.
	 */
	
	
	
	/*
	 * El método se utilza para obtener los roles de la configuración
	 */
	@Override
	public List<Role> getRolesByConfiguration(long configurationId) {
		try {
			List<Role_Config> roles_config = role_ConfigPersistence.findByconfigurationId(configurationId);
			List<Role> roles = new ArrayList<Role>();
			
			for(int i=0; i<roles_config.size(); i++){
				roles.add(RoleLocalServiceUtil.getRole(roles_config.get(i).getRoleId()));
			}
			return roles;
		} catch (SystemException | PortalException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/*
	 * El método se utilza para obtener los roles de la configuración
	 */
	@Override 
	public List<Role_Config> getRoleConfig(long configurationId){
		try {
			return role_ConfigPersistence.findByconfigurationId(configurationId);
		} catch (SystemException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	/*
	 * El método se utilza para actualizar o crear los roles de la configuración
	 */
	@Override
	public List<Role_Config> updateRoleConfig(long configurationId, String roles) throws PortalException, SystemException {
		try{
			
			List<Role_Config> roleRemove = getRoleConfig(configurationId);
			for(int j=0; j<roleRemove.size(); j++){
				role_ConfigPersistence.remove(roleRemove.get(j));
			}
			
			List<Role_Config> resultList = new ArrayList<Role_Config>();
			String[] roleList = (roles.split(","));
			
			for(int i = 0; i<roleList.length; i++){
				Role_ConfigPK roleC = new Role_ConfigPK();
				
				roleC.setConfigurationId(configurationId);
				roleC.setRoleId(Long.parseLong(roleList[i]));
				
				Role_Config role_config = role_ConfigPersistence.create(roleC);
				role_ConfigPersistence.update(role_config);
				
				resultList.add(role_config);
			}
			
			return resultList;
		}catch(Exception e){
			System.out.println("Error:" + e);
			return null;
		}
	}
	
	
	
	/*
	 *El método da todos los permisos al usuairo suscrito 
	 */
	public List<Role_Config> addRoleToSuscriptedUser(long userId, SubsConfiguration sconfig){
		List<Role_Config> roleconfigList = new ArrayList<Role_Config>();
		
		try{
			roleconfigList = getRoleConfig(sconfig.getConfigurationId());
			long[] roleIds = new long[roleconfigList.size()];
			
			for(int i=0; i<roleconfigList.size(); i++){
				roleIds[i] = roleconfigList.get(i).getRoleId();
			}	
			UserGroupRoleLocalServiceUtil.addUserGroupRoles(userId, sconfig.getGroupId(), roleIds);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return roleconfigList;
	}
	
	
	
	/*
	 *	El método quita todos los permisos obtenidos de la suscripción al usuario	 
	 */
	@Override
	public String removeRoleToSuscribedUser(long userId, SubsConfiguration sconfig){
		long[] groupIds = new long[]{sconfig.getGroupId()};
		
		try {
			UserGroupRoleLocalServiceUtil.deleteUserGroupRoles(userId, groupIds);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return "OK";
	}
	
	
	
}