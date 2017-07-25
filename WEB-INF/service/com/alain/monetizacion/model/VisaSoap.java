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
public class VisaSoap implements Serializable {
	public static VisaSoap toSoapModel(Visa model) {
		VisaSoap soapModel = new VisaSoap();

		soapModel.setCardNumber(model.getCardNumber());
		soapModel.setCardExpireDate(model.getCardExpireDate());
		soapModel.setCardVerification(model.getCardVerification());
		soapModel.setConfigurationId(model.getConfigurationId());

		return soapModel;
	}

	public static VisaSoap[] toSoapModels(Visa[] models) {
		VisaSoap[] soapModels = new VisaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VisaSoap[][] toSoapModels(Visa[][] models) {
		VisaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VisaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VisaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VisaSoap[] toSoapModels(List<Visa> models) {
		List<VisaSoap> soapModels = new ArrayList<VisaSoap>(models.size());

		for (Visa model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VisaSoap[soapModels.size()]);
	}

	public VisaSoap() {
	}

	public long getPrimaryKey() {
		return _cardNumber;
	}

	public void setPrimaryKey(long pk) {
		setCardNumber(pk);
	}

	public long getCardNumber() {
		return _cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		_cardNumber = cardNumber;
	}

	public Date getCardExpireDate() {
		return _cardExpireDate;
	}

	public void setCardExpireDate(Date cardExpireDate) {
		_cardExpireDate = cardExpireDate;
	}

	public int getCardVerification() {
		return _cardVerification;
	}

	public void setCardVerification(int cardVerification) {
		_cardVerification = cardVerification;
	}

	public long getConfigurationId() {
		return _configurationId;
	}

	public void setConfigurationId(long configurationId) {
		_configurationId = configurationId;
	}

	private long _cardNumber;
	private Date _cardExpireDate;
	private int _cardVerification;
	private long _configurationId;
}