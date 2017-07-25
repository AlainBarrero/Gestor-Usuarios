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
 * This class is a wrapper for {@link SubsConfiguration}.
 * </p>
 *
 * @author Alain
 * @see SubsConfiguration
 * @generated
 */
public class SubsConfigurationWrapper implements SubsConfiguration,
	ModelWrapper<SubsConfiguration> {
	public SubsConfigurationWrapper(SubsConfiguration subsConfiguration) {
		_subsConfiguration = subsConfiguration;
	}

	@Override
	public Class<?> getModelClass() {
		return SubsConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return SubsConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("configurationId", getConfigurationId());
		attributes.put("groupId", getGroupId());
		attributes.put("description", getDescription());
		attributes.put("amount", getAmount());
		attributes.put("cycle", getCycle());
		attributes.put("time", getTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long configurationId = (Long)attributes.get("configurationId");

		if (configurationId != null) {
			setConfigurationId(configurationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String cycle = (String)attributes.get("cycle");

		if (cycle != null) {
			setCycle(cycle);
		}

		Integer time = (Integer)attributes.get("time");

		if (time != null) {
			setTime(time);
		}
	}

	/**
	* Returns the primary key of this subs configuration.
	*
	* @return the primary key of this subs configuration
	*/
	@Override
	public long getPrimaryKey() {
		return _subsConfiguration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this subs configuration.
	*
	* @param primaryKey the primary key of this subs configuration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_subsConfiguration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the configuration ID of this subs configuration.
	*
	* @return the configuration ID of this subs configuration
	*/
	@Override
	public long getConfigurationId() {
		return _subsConfiguration.getConfigurationId();
	}

	/**
	* Sets the configuration ID of this subs configuration.
	*
	* @param configurationId the configuration ID of this subs configuration
	*/
	@Override
	public void setConfigurationId(long configurationId) {
		_subsConfiguration.setConfigurationId(configurationId);
	}

	/**
	* Returns the group ID of this subs configuration.
	*
	* @return the group ID of this subs configuration
	*/
	@Override
	public long getGroupId() {
		return _subsConfiguration.getGroupId();
	}

	/**
	* Sets the group ID of this subs configuration.
	*
	* @param groupId the group ID of this subs configuration
	*/
	@Override
	public void setGroupId(long groupId) {
		_subsConfiguration.setGroupId(groupId);
	}

	/**
	* Returns the description of this subs configuration.
	*
	* @return the description of this subs configuration
	*/
	@Override
	public java.lang.String getDescription() {
		return _subsConfiguration.getDescription();
	}

	/**
	* Sets the description of this subs configuration.
	*
	* @param description the description of this subs configuration
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_subsConfiguration.setDescription(description);
	}

	/**
	* Returns the amount of this subs configuration.
	*
	* @return the amount of this subs configuration
	*/
	@Override
	public double getAmount() {
		return _subsConfiguration.getAmount();
	}

	/**
	* Sets the amount of this subs configuration.
	*
	* @param amount the amount of this subs configuration
	*/
	@Override
	public void setAmount(double amount) {
		_subsConfiguration.setAmount(amount);
	}

	/**
	* Returns the cycle of this subs configuration.
	*
	* @return the cycle of this subs configuration
	*/
	@Override
	public java.lang.String getCycle() {
		return _subsConfiguration.getCycle();
	}

	/**
	* Sets the cycle of this subs configuration.
	*
	* @param cycle the cycle of this subs configuration
	*/
	@Override
	public void setCycle(java.lang.String cycle) {
		_subsConfiguration.setCycle(cycle);
	}

	/**
	* Returns the time of this subs configuration.
	*
	* @return the time of this subs configuration
	*/
	@Override
	public int getTime() {
		return _subsConfiguration.getTime();
	}

	/**
	* Sets the time of this subs configuration.
	*
	* @param time the time of this subs configuration
	*/
	@Override
	public void setTime(int time) {
		_subsConfiguration.setTime(time);
	}

	@Override
	public boolean isNew() {
		return _subsConfiguration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_subsConfiguration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _subsConfiguration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_subsConfiguration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _subsConfiguration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _subsConfiguration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_subsConfiguration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _subsConfiguration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_subsConfiguration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_subsConfiguration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_subsConfiguration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubsConfigurationWrapper((SubsConfiguration)_subsConfiguration.clone());
	}

	@Override
	public int compareTo(
		com.alain.monetizacion.model.SubsConfiguration subsConfiguration) {
		return _subsConfiguration.compareTo(subsConfiguration);
	}

	@Override
	public int hashCode() {
		return _subsConfiguration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.alain.monetizacion.model.SubsConfiguration> toCacheModel() {
		return _subsConfiguration.toCacheModel();
	}

	@Override
	public com.alain.monetizacion.model.SubsConfiguration toEscapedModel() {
		return new SubsConfigurationWrapper(_subsConfiguration.toEscapedModel());
	}

	@Override
	public com.alain.monetizacion.model.SubsConfiguration toUnescapedModel() {
		return new SubsConfigurationWrapper(_subsConfiguration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _subsConfiguration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _subsConfiguration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_subsConfiguration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubsConfigurationWrapper)) {
			return false;
		}

		SubsConfigurationWrapper subsConfigurationWrapper = (SubsConfigurationWrapper)obj;

		if (Validator.equals(_subsConfiguration,
					subsConfigurationWrapper._subsConfiguration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SubsConfiguration getWrappedSubsConfiguration() {
		return _subsConfiguration;
	}

	@Override
	public SubsConfiguration getWrappedModel() {
		return _subsConfiguration;
	}

	@Override
	public void resetOriginalValues() {
		_subsConfiguration.resetOriginalValues();
	}

	private SubsConfiguration _subsConfiguration;
}