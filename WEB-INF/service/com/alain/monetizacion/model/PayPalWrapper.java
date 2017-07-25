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
 * This class is a wrapper for {@link PayPal}.
 * </p>
 *
 * @author Alain
 * @see PayPal
 * @generated
 */
public class PayPalWrapper implements PayPal, ModelWrapper<PayPal> {
	public PayPalWrapper(PayPal payPal) {
		_payPal = payPal;
	}

	@Override
	public Class<?> getModelClass() {
		return PayPal.class;
	}

	@Override
	public String getModelClassName() {
		return PayPal.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("paypalUser", getPaypalUser());
		attributes.put("paypalPassword", getPaypalPassword());
		attributes.put("paypalFirm", getPaypalFirm());
		attributes.put("paypalEmail", getPaypalEmail());
		attributes.put("configurationId", getConfigurationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String paypalUser = (String)attributes.get("paypalUser");

		if (paypalUser != null) {
			setPaypalUser(paypalUser);
		}

		String paypalPassword = (String)attributes.get("paypalPassword");

		if (paypalPassword != null) {
			setPaypalPassword(paypalPassword);
		}

		String paypalFirm = (String)attributes.get("paypalFirm");

		if (paypalFirm != null) {
			setPaypalFirm(paypalFirm);
		}

		String paypalEmail = (String)attributes.get("paypalEmail");

		if (paypalEmail != null) {
			setPaypalEmail(paypalEmail);
		}

		Long configurationId = (Long)attributes.get("configurationId");

		if (configurationId != null) {
			setConfigurationId(configurationId);
		}
	}

	/**
	* Returns the primary key of this pay pal.
	*
	* @return the primary key of this pay pal
	*/
	@Override
	public long getPrimaryKey() {
		return _payPal.getPrimaryKey();
	}

	/**
	* Sets the primary key of this pay pal.
	*
	* @param primaryKey the primary key of this pay pal
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_payPal.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the paypal user of this pay pal.
	*
	* @return the paypal user of this pay pal
	*/
	@Override
	public java.lang.String getPaypalUser() {
		return _payPal.getPaypalUser();
	}

	/**
	* Sets the paypal user of this pay pal.
	*
	* @param paypalUser the paypal user of this pay pal
	*/
	@Override
	public void setPaypalUser(java.lang.String paypalUser) {
		_payPal.setPaypalUser(paypalUser);
	}

	/**
	* Returns the paypal password of this pay pal.
	*
	* @return the paypal password of this pay pal
	*/
	@Override
	public java.lang.String getPaypalPassword() {
		return _payPal.getPaypalPassword();
	}

	/**
	* Sets the paypal password of this pay pal.
	*
	* @param paypalPassword the paypal password of this pay pal
	*/
	@Override
	public void setPaypalPassword(java.lang.String paypalPassword) {
		_payPal.setPaypalPassword(paypalPassword);
	}

	/**
	* Returns the paypal firm of this pay pal.
	*
	* @return the paypal firm of this pay pal
	*/
	@Override
	public java.lang.String getPaypalFirm() {
		return _payPal.getPaypalFirm();
	}

	/**
	* Sets the paypal firm of this pay pal.
	*
	* @param paypalFirm the paypal firm of this pay pal
	*/
	@Override
	public void setPaypalFirm(java.lang.String paypalFirm) {
		_payPal.setPaypalFirm(paypalFirm);
	}

	/**
	* Returns the paypal email of this pay pal.
	*
	* @return the paypal email of this pay pal
	*/
	@Override
	public java.lang.String getPaypalEmail() {
		return _payPal.getPaypalEmail();
	}

	/**
	* Sets the paypal email of this pay pal.
	*
	* @param paypalEmail the paypal email of this pay pal
	*/
	@Override
	public void setPaypalEmail(java.lang.String paypalEmail) {
		_payPal.setPaypalEmail(paypalEmail);
	}

	/**
	* Returns the configuration ID of this pay pal.
	*
	* @return the configuration ID of this pay pal
	*/
	@Override
	public long getConfigurationId() {
		return _payPal.getConfigurationId();
	}

	/**
	* Sets the configuration ID of this pay pal.
	*
	* @param configurationId the configuration ID of this pay pal
	*/
	@Override
	public void setConfigurationId(long configurationId) {
		_payPal.setConfigurationId(configurationId);
	}

	@Override
	public boolean isNew() {
		return _payPal.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_payPal.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _payPal.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_payPal.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _payPal.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _payPal.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_payPal.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _payPal.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_payPal.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_payPal.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_payPal.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PayPalWrapper((PayPal)_payPal.clone());
	}

	@Override
	public int compareTo(com.alain.monetizacion.model.PayPal payPal) {
		return _payPal.compareTo(payPal);
	}

	@Override
	public int hashCode() {
		return _payPal.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.alain.monetizacion.model.PayPal> toCacheModel() {
		return _payPal.toCacheModel();
	}

	@Override
	public com.alain.monetizacion.model.PayPal toEscapedModel() {
		return new PayPalWrapper(_payPal.toEscapedModel());
	}

	@Override
	public com.alain.monetizacion.model.PayPal toUnescapedModel() {
		return new PayPalWrapper(_payPal.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _payPal.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _payPal.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_payPal.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PayPalWrapper)) {
			return false;
		}

		PayPalWrapper payPalWrapper = (PayPalWrapper)obj;

		if (Validator.equals(_payPal, payPalWrapper._payPal)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PayPal getWrappedPayPal() {
		return _payPal;
	}

	@Override
	public PayPal getWrappedModel() {
		return _payPal;
	}

	@Override
	public void resetOriginalValues() {
		_payPal.resetOriginalValues();
	}

	private PayPal _payPal;
}