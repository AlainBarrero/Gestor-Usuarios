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

import com.alain.monetizacion.service.ClpSerializer;
import com.alain.monetizacion.service.Role_ConfigLocalServiceUtil;
import com.alain.monetizacion.service.persistence.Role_ConfigPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alain
 */
public class Role_ConfigClp extends BaseModelImpl<Role_Config>
	implements Role_Config {
	public Role_ConfigClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Role_Config.class;
	}

	@Override
	public String getModelClassName() {
		return Role_Config.class.getName();
	}

	@Override
	public Role_ConfigPK getPrimaryKey() {
		return new Role_ConfigPK(_roleId, _configurationId);
	}

	@Override
	public void setPrimaryKey(Role_ConfigPK primaryKey) {
		setRoleId(primaryKey.roleId);
		setConfigurationId(primaryKey.configurationId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new Role_ConfigPK(_roleId, _configurationId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((Role_ConfigPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("roleId", getRoleId());
		attributes.put("configurationId", getConfigurationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Long configurationId = (Long)attributes.get("configurationId");

		if (configurationId != null) {
			setConfigurationId(configurationId);
		}
	}

	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_roleId = roleId;

		if (_role_ConfigRemoteModel != null) {
			try {
				Class<?> clazz = _role_ConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setRoleId", long.class);

				method.invoke(_role_ConfigRemoteModel, roleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getConfigurationId() {
		return _configurationId;
	}

	@Override
	public void setConfigurationId(long configurationId) {
		_configurationId = configurationId;

		if (_role_ConfigRemoteModel != null) {
			try {
				Class<?> clazz = _role_ConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setConfigurationId", long.class);

				method.invoke(_role_ConfigRemoteModel, configurationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRole_ConfigRemoteModel() {
		return _role_ConfigRemoteModel;
	}

	public void setRole_ConfigRemoteModel(BaseModel<?> role_ConfigRemoteModel) {
		_role_ConfigRemoteModel = role_ConfigRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _role_ConfigRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_role_ConfigRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Role_ConfigLocalServiceUtil.addRole_Config(this);
		}
		else {
			Role_ConfigLocalServiceUtil.updateRole_Config(this);
		}
	}

	@Override
	public Role_Config toEscapedModel() {
		return (Role_Config)ProxyUtil.newProxyInstance(Role_Config.class.getClassLoader(),
			new Class[] { Role_Config.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Role_ConfigClp clone = new Role_ConfigClp();

		clone.setRoleId(getRoleId());
		clone.setConfigurationId(getConfigurationId());

		return clone;
	}

	@Override
	public int compareTo(Role_Config role_Config) {
		Role_ConfigPK primaryKey = role_Config.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Role_ConfigClp)) {
			return false;
		}

		Role_ConfigClp role_Config = (Role_ConfigClp)obj;

		Role_ConfigPK primaryKey = role_Config.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{roleId=");
		sb.append(getRoleId());
		sb.append(", configurationId=");
		sb.append(getConfigurationId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.alain.monetizacion.model.Role_Config");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>configurationId</column-name><column-value><![CDATA[");
		sb.append(getConfigurationId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _roleId;
	private long _configurationId;
	private BaseModel<?> _role_ConfigRemoteModel;
	private Class<?> _clpSerializerClass = com.alain.monetizacion.service.ClpSerializer.class;
}