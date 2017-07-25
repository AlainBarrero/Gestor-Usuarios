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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Role_Config}.
 * </p>
 *
 * @author Alain
 * @see Role_Config
 * @generated
 */
public class Role_ConfigWrapper implements Role_Config,
	ModelWrapper<Role_Config> {
	public Role_ConfigWrapper(Role_Config role_Config) {
		_role_Config = role_Config;
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

	/**
	* Returns the primary key of this role_ config.
	*
	* @return the primary key of this role_ config
	*/
	@Override
	public com.alain.monetizacion.service.persistence.Role_ConfigPK getPrimaryKey() {
		return _role_Config.getPrimaryKey();
	}

	/**
	* Sets the primary key of this role_ config.
	*
	* @param primaryKey the primary key of this role_ config
	*/
	@Override
	public void setPrimaryKey(
		com.alain.monetizacion.service.persistence.Role_ConfigPK primaryKey) {
		_role_Config.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the role ID of this role_ config.
	*
	* @return the role ID of this role_ config
	*/
	@Override
	public long getRoleId() {
		return _role_Config.getRoleId();
	}

	/**
	* Sets the role ID of this role_ config.
	*
	* @param roleId the role ID of this role_ config
	*/
	@Override
	public void setRoleId(long roleId) {
		_role_Config.setRoleId(roleId);
	}

	/**
	* Returns the configuration ID of this role_ config.
	*
	* @return the configuration ID of this role_ config
	*/
	@Override
	public long getConfigurationId() {
		return _role_Config.getConfigurationId();
	}

	/**
	* Sets the configuration ID of this role_ config.
	*
	* @param configurationId the configuration ID of this role_ config
	*/
	@Override
	public void setConfigurationId(long configurationId) {
		_role_Config.setConfigurationId(configurationId);
	}

	@Override
	public boolean isNew() {
		return _role_Config.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_role_Config.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _role_Config.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_role_Config.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _role_Config.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _role_Config.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_role_Config.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _role_Config.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_role_Config.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_role_Config.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_role_Config.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Role_ConfigWrapper((Role_Config)_role_Config.clone());
	}

	@Override
	public int compareTo(com.alain.monetizacion.model.Role_Config role_Config) {
		return _role_Config.compareTo(role_Config);
	}

	@Override
	public int hashCode() {
		return _role_Config.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.alain.monetizacion.model.Role_Config> toCacheModel() {
		return _role_Config.toCacheModel();
	}

	@Override
	public com.alain.monetizacion.model.Role_Config toEscapedModel() {
		return new Role_ConfigWrapper(_role_Config.toEscapedModel());
	}

	@Override
	public com.alain.monetizacion.model.Role_Config toUnescapedModel() {
		return new Role_ConfigWrapper(_role_Config.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _role_Config.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _role_Config.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_role_Config.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Role_ConfigWrapper)) {
			return false;
		}

		Role_ConfigWrapper role_ConfigWrapper = (Role_ConfigWrapper)obj;

		if (Validator.equals(_role_Config, role_ConfigWrapper._role_Config)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Role_Config getWrappedRole_Config() {
		return _role_Config;
	}

	@Override
	public Role_Config getWrappedModel() {
		return _role_Config;
	}

	@Override
	public void resetOriginalValues() {
		_role_Config.resetOriginalValues();
	}

	private Role_Config _role_Config;
}