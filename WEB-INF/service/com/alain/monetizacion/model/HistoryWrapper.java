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
 * This class is a wrapper for {@link History}.
 * </p>
 *
 * @author Alain
 * @see History
 * @generated
 */
public class HistoryWrapper implements History, ModelWrapper<History> {
	public HistoryWrapper(History history) {
		_history = history;
	}

	@Override
	public Class<?> getModelClass() {
		return History.class;
	}

	@Override
	public String getModelClassName() {
		return History.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("historyId", getHistoryId());
		attributes.put("subscriptionId", getSubscriptionId());
		attributes.put("paidDate", getPaidDate());
		attributes.put("lastPaid", getLastPaid());
		attributes.put("pendingPayment", getPendingPayment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long historyId = (Long)attributes.get("historyId");

		if (historyId != null) {
			setHistoryId(historyId);
		}

		Long subscriptionId = (Long)attributes.get("subscriptionId");

		if (subscriptionId != null) {
			setSubscriptionId(subscriptionId);
		}

		Date paidDate = (Date)attributes.get("paidDate");

		if (paidDate != null) {
			setPaidDate(paidDate);
		}

		Date lastPaid = (Date)attributes.get("lastPaid");

		if (lastPaid != null) {
			setLastPaid(lastPaid);
		}

		Date pendingPayment = (Date)attributes.get("pendingPayment");

		if (pendingPayment != null) {
			setPendingPayment(pendingPayment);
		}
	}

	/**
	* Returns the primary key of this history.
	*
	* @return the primary key of this history
	*/
	@Override
	public long getPrimaryKey() {
		return _history.getPrimaryKey();
	}

	/**
	* Sets the primary key of this history.
	*
	* @param primaryKey the primary key of this history
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_history.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the history ID of this history.
	*
	* @return the history ID of this history
	*/
	@Override
	public long getHistoryId() {
		return _history.getHistoryId();
	}

	/**
	* Sets the history ID of this history.
	*
	* @param historyId the history ID of this history
	*/
	@Override
	public void setHistoryId(long historyId) {
		_history.setHistoryId(historyId);
	}

	/**
	* Returns the subscription ID of this history.
	*
	* @return the subscription ID of this history
	*/
	@Override
	public long getSubscriptionId() {
		return _history.getSubscriptionId();
	}

	/**
	* Sets the subscription ID of this history.
	*
	* @param subscriptionId the subscription ID of this history
	*/
	@Override
	public void setSubscriptionId(long subscriptionId) {
		_history.setSubscriptionId(subscriptionId);
	}

	/**
	* Returns the paid date of this history.
	*
	* @return the paid date of this history
	*/
	@Override
	public java.util.Date getPaidDate() {
		return _history.getPaidDate();
	}

	/**
	* Sets the paid date of this history.
	*
	* @param paidDate the paid date of this history
	*/
	@Override
	public void setPaidDate(java.util.Date paidDate) {
		_history.setPaidDate(paidDate);
	}

	/**
	* Returns the last paid of this history.
	*
	* @return the last paid of this history
	*/
	@Override
	public java.util.Date getLastPaid() {
		return _history.getLastPaid();
	}

	/**
	* Sets the last paid of this history.
	*
	* @param lastPaid the last paid of this history
	*/
	@Override
	public void setLastPaid(java.util.Date lastPaid) {
		_history.setLastPaid(lastPaid);
	}

	/**
	* Returns the pending payment of this history.
	*
	* @return the pending payment of this history
	*/
	@Override
	public java.util.Date getPendingPayment() {
		return _history.getPendingPayment();
	}

	/**
	* Sets the pending payment of this history.
	*
	* @param pendingPayment the pending payment of this history
	*/
	@Override
	public void setPendingPayment(java.util.Date pendingPayment) {
		_history.setPendingPayment(pendingPayment);
	}

	@Override
	public boolean isNew() {
		return _history.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_history.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _history.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_history.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _history.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _history.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_history.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _history.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_history.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_history.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_history.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HistoryWrapper((History)_history.clone());
	}

	@Override
	public int compareTo(com.alain.monetizacion.model.History history) {
		return _history.compareTo(history);
	}

	@Override
	public int hashCode() {
		return _history.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.alain.monetizacion.model.History> toCacheModel() {
		return _history.toCacheModel();
	}

	@Override
	public com.alain.monetizacion.model.History toEscapedModel() {
		return new HistoryWrapper(_history.toEscapedModel());
	}

	@Override
	public com.alain.monetizacion.model.History toUnescapedModel() {
		return new HistoryWrapper(_history.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _history.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _history.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_history.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HistoryWrapper)) {
			return false;
		}

		HistoryWrapper historyWrapper = (HistoryWrapper)obj;

		if (Validator.equals(_history, historyWrapper._history)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public History getWrappedHistory() {
		return _history;
	}

	@Override
	public History getWrappedModel() {
		return _history;
	}

	@Override
	public void resetOriginalValues() {
		_history.resetOriginalValues();
	}

	private History _history;
}