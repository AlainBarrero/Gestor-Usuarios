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

package com.alain.monetizacion.model;

import com.alain.monetizacion.service.persistence.Role_ConfigPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Alain
 * @generated
 */
public class Role_ConfigSoap implements Serializable {
	public static Role_ConfigSoap toSoapModel(Role_Config model) {
		Role_ConfigSoap soapModel = new Role_ConfigSoap();

		soapModel.setRoleId(model.getRoleId());
		soapModel.setConfigurationId(model.getConfigurationId());

		return soapModel;
	}

	public static Role_ConfigSoap[] toSoapModels(Role_Config[] models) {
		Role_ConfigSoap[] soapModels = new Role_ConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Role_ConfigSoap[][] toSoapModels(Role_Config[][] models) {
		Role_ConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Role_ConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Role_ConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Role_ConfigSoap[] toSoapModels(List<Role_Config> models) {
		List<Role_ConfigSoap> soapModels = new ArrayList<Role_ConfigSoap>(models.size());

		for (Role_Config model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Role_ConfigSoap[soapModels.size()]);
	}

	public Role_ConfigSoap() {
	}

	public Role_ConfigPK getPrimaryKey() {
		return new Role_ConfigPK(_roleId, _configurationId);
	}

	public void setPrimaryKey(Role_ConfigPK pk) {
		setRoleId(pk.roleId);
		setConfigurationId(pk.configurationId);
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public long getConfigurationId() {
		return _configurationId;
	}

	public void setConfigurationId(long configurationId) {
		_configurationId = configurationId;
	}

	private long _roleId;
	private long _configurationId;
}