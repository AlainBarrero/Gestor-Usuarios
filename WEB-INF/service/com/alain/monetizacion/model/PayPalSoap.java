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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Alain
 * @generated
 */
public class PayPalSoap implements Serializable {
	public static PayPalSoap toSoapModel(PayPal model) {
		PayPalSoap soapModel = new PayPalSoap();

		soapModel.setPaypalUser(model.getPaypalUser());
		soapModel.setPaypalPassword(model.getPaypalPassword());
		soapModel.setPaypalFirm(model.getPaypalFirm());
		soapModel.setPaypalEmail(model.getPaypalEmail());
		soapModel.setConfigurationId(model.getConfigurationId());

		return soapModel;
	}

	public static PayPalSoap[] toSoapModels(PayPal[] models) {
		PayPalSoap[] soapModels = new PayPalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PayPalSoap[][] toSoapModels(PayPal[][] models) {
		PayPalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PayPalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PayPalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PayPalSoap[] toSoapModels(List<PayPal> models) {
		List<PayPalSoap> soapModels = new ArrayList<PayPalSoap>(models.size());

		for (PayPal model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PayPalSoap[soapModels.size()]);
	}

	public PayPalSoap() {
	}

	public long getPrimaryKey() {
		return _configurationId;
	}

	public void setPrimaryKey(long pk) {
		setConfigurationId(pk);
	}

	public String getPaypalUser() {
		return _paypalUser;
	}

	public void setPaypalUser(String paypalUser) {
		_paypalUser = paypalUser;
	}

	public String getPaypalPassword() {
		return _paypalPassword;
	}

	public void setPaypalPassword(String paypalPassword) {
		_paypalPassword = paypalPassword;
	}

	public String getPaypalFirm() {
		return _paypalFirm;
	}

	public void setPaypalFirm(String paypalFirm) {
		_paypalFirm = paypalFirm;
	}

	public String getPaypalEmail() {
		return _paypalEmail;
	}

	public void setPaypalEmail(String paypalEmail) {
		_paypalEmail = paypalEmail;
	}

	public long getConfigurationId() {
		return _configurationId;
	}

	public void setConfigurationId(long configurationId) {
		_configurationId = configurationId;
	}

	private String _paypalUser;
	private String _paypalPassword;
	private String _paypalFirm;
	private String _paypalEmail;
	private long _configurationId;
}