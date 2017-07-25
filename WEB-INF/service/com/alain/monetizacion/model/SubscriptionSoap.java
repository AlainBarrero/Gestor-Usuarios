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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Alain
 * @generated
 */
public class SubscriptionSoap implements Serializable {
	public static SubscriptionSoap toSoapModel(Subscription model) {
		SubscriptionSoap soapModel = new SubscriptionSoap();

		soapModel.setSubscriptionId(model.getSubscriptionId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setExpireDate(model.getExpireDate());
		soapModel.setPayment(model.getPayment());
		soapModel.setConfigurationId(model.getConfigurationId());
		soapModel.setPaypalProfile(model.getPaypalProfile());
		soapModel.setIsActive(model.getIsActive());

		return soapModel;
	}

	public static SubscriptionSoap[] toSoapModels(Subscription[] models) {
		SubscriptionSoap[] soapModels = new SubscriptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubscriptionSoap[][] toSoapModels(Subscription[][] models) {
		SubscriptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubscriptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubscriptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubscriptionSoap[] toSoapModels(List<Subscription> models) {
		List<SubscriptionSoap> soapModels = new ArrayList<SubscriptionSoap>(models.size());

		for (Subscription model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubscriptionSoap[soapModels.size()]);
	}

	public SubscriptionSoap() {
	}

	public long getPrimaryKey() {
		return _subscriptionId;
	}

	public void setPrimaryKey(long pk) {
		setSubscriptionId(pk);
	}

	public long getSubscriptionId() {
		return _subscriptionId;
	}

	public void setSubscriptionId(long subscriptionId) {
		_subscriptionId = subscriptionId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getExpireDate() {
		return _expireDate;
	}

	public void setExpireDate(Date expireDate) {
		_expireDate = expireDate;
	}

	public double getPayment() {
		return _payment;
	}

	public void setPayment(double payment) {
		_payment = payment;
	}

	public long getConfigurationId() {
		return _configurationId;
	}

	public void setConfigurationId(long configurationId) {
		_configurationId = configurationId;
	}

	public String getPaypalProfile() {
		return _paypalProfile;
	}

	public void setPaypalProfile(String paypalProfile) {
		_paypalProfile = paypalProfile;
	}

	public boolean getIsActive() {
		return _isActive;
	}

	public boolean isIsActive() {
		return _isActive;
	}

	public void setIsActive(boolean isActive) {
		_isActive = isActive;
	}

	private long _subscriptionId;
	private long _userId;
	private Date _createDate;
	private Date _expireDate;
	private double _payment;
	private long _configurationId;
	private String _paypalProfile;
	private boolean _isActive;
}