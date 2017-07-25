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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Visa}.
 * </p>
 *
 * @author Alain
 * @see Visa
 * @generated
 */
public class VisaWrapper implements Visa, ModelWrapper<Visa> {
	public VisaWrapper(Visa visa) {
		_visa = visa;
	}

	@Override
	public Class<?> getModelClass() {
		return Visa.class;
	}

	@Override
	public String getModelClassName() {
		return Visa.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cardNumber", getCardNumber());
		attributes.put("cardExpireDate", getCardExpireDate());
		attributes.put("cardVerification", getCardVerification());
		attributes.put("configurationId", getConfigurationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cardNumber = (Long)attributes.get("cardNumber");

		if (cardNumber != null) {
			setCardNumber(cardNumber);
		}

		Date cardExpireDate = (Date)attributes.get("cardExpireDate");

		if (cardExpireDate != null) {
			setCardExpireDate(cardExpireDate);
		}

		Integer cardVerification = (Integer)attributes.get("cardVerification");

		if (cardVerification != null) {
			setCardVerification(cardVerification);
		}

		Long configurationId = (Long)attributes.get("configurationId");

		if (configurationId != null) {
			setConfigurationId(configurationId);
		}
	}

	/**
	* Returns the primary key of this visa.
	*
	* @return the primary key of this visa
	*/
	@Override
	public long getPrimaryKey() {
		return _visa.getPrimaryKey();
	}

	/**
	* Sets the primary key of this visa.
	*
	* @param primaryKey the primary key of this visa
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_visa.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the card number of this visa.
	*
	* @return the card number of this visa
	*/
	@Override
	public long getCardNumber() {
		return _visa.getCardNumber();
	}

	/**
	* Sets the card number of this visa.
	*
	* @param cardNumber the card number of this visa
	*/
	@Override
	public void setCardNumber(long cardNumber) {
		_visa.setCardNumber(cardNumber);
	}

	/**
	* Returns the card expire date of this visa.
	*
	* @return the card expire date of this visa
	*/
	@Override
	public java.util.Date getCardExpireDate() {
		return _visa.getCardExpireDate();
	}

	/**
	* Sets the card expire date of this visa.
	*
	* @param cardExpireDate the card expire date of this visa
	*/
	@Override
	public void setCardExpireDate(java.util.Date cardExpireDate) {
		_visa.setCardExpireDate(cardExpireDate);
	}

	/**
	* Returns the card verification of this visa.
	*
	* @return the card verification of this visa
	*/
	@Override
	public int getCardVerification() {
		return _visa.getCardVerification();
	}

	/**
	* Sets the card verification of this visa.
	*
	* @param cardVerification the card verification of this visa
	*/
	@Override
	public void setCardVerification(int cardVerification) {
		_visa.setCardVerification(cardVerification);
	}

	/**
	* Returns the configuration ID of this visa.
	*
	* @return the configuration ID of this visa
	*/
	@Override
	public long getConfigurationId() {
		return _visa.getConfigurationId();
	}

	/**
	* Sets the configuration ID of this visa.
	*
	* @param configurationId the configuration ID of this visa
	*/
	@Override
	public void setConfigurationId(long configurationId) {
		_visa.setConfigurationId(configurationId);
	}

	@Override
	public boolean isNew() {
		return _visa.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_visa.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _visa.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_visa.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _visa.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _visa.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_visa.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _visa.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_visa.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_visa.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_visa.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VisaWrapper((Visa)_visa.clone());
	}

	@Override
	public int compareTo(com.alain.monetizacion.model.Visa visa) {
		return _visa.compareTo(visa);
	}

	@Override
	public int hashCode() {
		return _visa.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.alain.monetizacion.model.Visa> toCacheModel() {
		return _visa.toCacheModel();
	}

	@Override
	public com.alain.monetizacion.model.Visa toEscapedModel() {
		return new VisaWrapper(_visa.toEscapedModel());
	}

	@Override
	public com.alain.monetizacion.model.Visa toUnescapedModel() {
		return new VisaWrapper(_visa.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _visa.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _visa.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_visa.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VisaWrapper)) {
			return false;
		}

		VisaWrapper visaWrapper = (VisaWrapper)obj;

		if (Validator.equals(_visa, visaWrapper._visa)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Visa getWrappedVisa() {
		return _visa;
	}

	@Override
	public Visa getWrappedModel() {
		return _visa;
	}

	@Override
	public void resetOriginalValues() {
		_visa.resetOriginalValues();
	}

	private Visa _visa;
}