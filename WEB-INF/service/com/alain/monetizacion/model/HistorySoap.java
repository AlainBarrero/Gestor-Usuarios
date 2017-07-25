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
public class HistorySoap implements Serializable {
	public static HistorySoap toSoapModel(History model) {
		HistorySoap soapModel = new HistorySoap();

		soapModel.setHistoryId(model.getHistoryId());
		soapModel.setSubscriptionId(model.getSubscriptionId());
		soapModel.setPaidDate(model.getPaidDate());
		soapModel.setLastPaid(model.getLastPaid());
		soapModel.setPendingPayment(model.getPendingPayment());

		return soapModel;
	}

	public static HistorySoap[] toSoapModels(History[] models) {
		HistorySoap[] soapModels = new HistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HistorySoap[][] toSoapModels(History[][] models) {
		HistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new HistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HistorySoap[] toSoapModels(List<History> models) {
		List<HistorySoap> soapModels = new ArrayList<HistorySoap>(models.size());

		for (History model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HistorySoap[soapModels.size()]);
	}

	public HistorySoap() {
	}

	public long getPrimaryKey() {
		return _historyId;
	}

	public void setPrimaryKey(long pk) {
		setHistoryId(pk);
	}

	public long getHistoryId() {
		return _historyId;
	}

	public void setHistoryId(long historyId) {
		_historyId = historyId;
	}

	public long getSubscriptionId() {
		return _subscriptionId;
	}

	public void setSubscriptionId(long subscriptionId) {
		_subscriptionId = subscriptionId;
	}

	public Date getPaidDate() {
		return _paidDate;
	}

	public void setPaidDate(Date paidDate) {
		_paidDate = paidDate;
	}

	public Date getLastPaid() {
		return _lastPaid;
	}

	public void setLastPaid(Date lastPaid) {
		_lastPaid = lastPaid;
	}

	public Date getPendingPayment() {
		return _pendingPayment;
	}

	public void setPendingPayment(Date pendingPayment) {
		_pendingPayment = pendingPayment;
	}

	private long _historyId;
	private long _subscriptionId;
	private Date _paidDate;
	private Date _lastPaid;
	private Date _pendingPayment;
}