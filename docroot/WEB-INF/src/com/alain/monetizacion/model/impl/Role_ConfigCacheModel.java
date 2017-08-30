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

package com.alain.monetizacion.model.impl;

import com.alain.monetizacion.model.Role_Config;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Role_Config in entity cache.
 *
 * @author Alain
 * @see Role_Config
 * @generated
 */
public class Role_ConfigCacheModel implements CacheModel<Role_Config>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{roleId=");
		sb.append(roleId);
		sb.append(", configurationId=");
		sb.append(configurationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Role_Config toEntityModel() {
		Role_ConfigImpl role_ConfigImpl = new Role_ConfigImpl();

		role_ConfigImpl.setRoleId(roleId);
		role_ConfigImpl.setConfigurationId(configurationId);

		role_ConfigImpl.resetOriginalValues();

		return role_ConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		roleId = objectInput.readLong();
		configurationId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(roleId);
		objectOutput.writeLong(configurationId);
	}

	public long roleId;
	public long configurationId;
}