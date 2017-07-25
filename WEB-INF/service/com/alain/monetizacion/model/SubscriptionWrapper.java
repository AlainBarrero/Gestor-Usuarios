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
 * This class is a wrapper for {@link Subscription}.
 * </p>
 *
 * @author Alain
 * @see Subscription
 * @generated
 */
public class SubscriptionWrapper implements Subscription,
	ModelWrapper<Subscription> {
	public SubscriptionWrapper(Subscription subscription) {
		_subscription = subscription;
	}

	@Override
	public Class<?> getModelClass() {
		return Subscription.class;
	}

	@Override
	public String getModelClassName() {
		return Subscription.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subscriptionId", getSubscriptionId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("expireDate", getExpireDate());
		attributes.put("payment", getPayment());
		attributes.put("configurationId", getConfigurationId());
		attributes.put("paypalProfile", getPaypalProfile());
		attributes.put("isActive", getIsActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subscriptionId = (Long)attributes.get("subscriptionId");

		if (subscriptionId != null) {
			setSubscriptionId(subscriptionId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date expireDate = (Date)attributes.get("expireDate");

		if (expireDate != null) {
			setExpireDate(expireDate);
		}

		Double payment = (Double)attributes.get("payment");

		if (payment != null) {
			setPayment(payment);
		}

		Long configurationId = (Long)attributes.get("configurationId");

		if (configurationId != null) {
			setConfigurationId(configurationId);
		}

		String paypalProfile = (String)attributes.get("paypalProfile");

		if (paypalProfile != null) {
			setPaypalProfile(paypalProfile);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}
	}

	/**
	* Returns the primary key of this subscription.
	*
	* @return the primary key of this subscription
	*/
	@Override
	public long getPrimaryKey() {
		return _subscription.getPrimaryKey();
	}

	/**
	* Sets the primary key of this subscription.
	*
	* @param primaryKey the primary key of this subscription
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_subscription.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the subscription ID of this subscription.
	*
	* @return the subscription ID of this subscription
	*/
	@Override
	public long getSubscriptionId() {
		return _subscription.getSubscriptionId();
	}

	/**
	* Sets the subscription ID of this subscription.
	*
	* @param subscriptionId the subscription ID of this subscription
	*/
	@Override
	public void setSubscriptionId(long subscriptionId) {
		_subscription.setSubscriptionId(subscriptionId);
	}

	/**
	* Returns the user ID of this subscription.
	*
	* @return the user ID of this subscription
	*/
	@Override
	public long getUserId() {
		return _subscription.getUserId();
	}

	/**
	* Sets the user ID of this subscription.
	*
	* @param userId the user ID of this subscription
	*/
	@Override
	public void setUserId(long userId) {
		_subscription.setUserId(userId);
	}

	/**
	* Returns the user uuid of this subscription.
	*
	* @return the user uuid of this subscription
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subscription.getUserUuid();
	}

	/**
	* Sets the user uuid of this subscription.
	*
	* @param userUuid the user uuid of this subscription
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_subscription.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this subscription.
	*
	* @return the create date of this subscription
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _subscription.getCreateDate();
	}

	/**
	* Sets the create date of this subscription.
	*
	* @param createDate the create date of this subscription
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_subscription.setCreateDate(createDate);
	}

	/**
	* Returns the expire date of this subscription.
	*
	* @return the expire date of this subscription
	*/
	@Override
	public java.util.Date getExpireDate() {
		return _subscription.getExpireDate();
	}

	/**
	* Sets the expire date of this subscription.
	*
	* @param expireDate the expire date of this subscription
	*/
	@Override
	public void setExpireDate(java.util.Date expireDate) {
		_subscription.setExpireDate(expireDate);
	}

	/**
	* Returns the payment of this subscription.
	*
	* @return the payment of this subscription
	*/
	@Override
	public double getPayment() {
		return _subscription.getPayment();
	}

	/**
	* Sets the payment of this subscription.
	*
	* @param payment the payment of this subscription
	*/
	@Override
	public void setPayment(double payment) {
		_subscription.setPayment(payment);
	}

	/**
	* Returns the configuration ID of this subscription.
	*
	* @return the configuration ID of this subscription
	*/
	@Override
	public long getConfigurationId() {
		return _subscription.getConfigurationId();
	}

	/**
	* Sets the configuration ID of this subscription.
	*
	* @param configurationId the configuration ID of this subscription
	*/
	@Override
	public void setConfigurationId(long configurationId) {
		_subscription.setConfigurationId(configurationId);
	}

	/**
	* Returns the paypal profile of this subscription.
	*
	* @return the paypal profile of this subscription
	*/
	@Override
	public java.lang.String getPaypalProfile() {
		return _subscription.getPaypalProfile();
	}

	/**
	* Sets the paypal profile of this subscription.
	*
	* @param paypalProfile the paypal profile of this subscription
	*/
	@Override
	public void setPaypalProfile(java.lang.String paypalProfile) {
		_subscription.setPaypalProfile(paypalProfile);
	}

	/**
	* Returns the is active of this subscription.
	*
	* @return the is active of this subscription
	*/
	@Override
	public boolean getIsActive() {
		return _subscription.getIsActive();
	}

	/**
	* Returns <code>true</code> if this subscription is is active.
	*
	* @return <code>true</code> if this subscription is is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsActive() {
		return _subscription.isIsActive();
	}

	/**
	* Sets whether this subscription is is active.
	*
	* @param isActive the is active of this subscription
	*/
	@Override
	public void setIsActive(boolean isActive) {
		_subscription.setIsActive(isActive);
	}

	@Override
	public boolean isNew() {
		return _subscription.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_subscription.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _subscription.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_subscription.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _subscription.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _subscription.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_subscription.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _subscription.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_subscription.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_subscription.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_subscription.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubscriptionWrapper((Subscription)_subscription.clone());
	}

	@Override
	public int compareTo(com.alain.monetizacion.model.Subscription subscription) {
		return _subscription.compareTo(subscription);
	}

	@Override
	public int hashCode() {
		return _subscription.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.alain.monetizacion.model.Subscription> toCacheModel() {
		return _subscription.toCacheModel();
	}

	@Override
	public com.alain.monetizacion.model.Subscription toEscapedModel() {
		return new SubscriptionWrapper(_subscription.toEscapedModel());
	}

	@Override
	public com.alain.monetizacion.model.Subscription toUnescapedModel() {
		return new SubscriptionWrapper(_subscription.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _subscription.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _subscription.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_subscription.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubscriptionWrapper)) {
			return false;
		}

		SubscriptionWrapper subscriptionWrapper = (SubscriptionWrapper)obj;

		if (Validator.equals(_subscription, subscriptionWrapper._subscription)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Subscription getWrappedSubscription() {
		return _subscription;
	}

	@Override
	public Subscription getWrappedModel() {
		return _subscription;
	}

	@Override
	public void resetOriginalValues() {
		_subscription.resetOriginalValues();
	}

	private Subscription _subscription;
}