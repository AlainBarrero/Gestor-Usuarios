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

import com.alain.monetizacion.service.ClpSerializer;
import com.alain.monetizacion.service.HistoryLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alain
 */
public class HistoryClp extends BaseModelImpl<History> implements History {
	public HistoryClp() {
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
	public long getPrimaryKey() {
		return _historyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHistoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _historyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getHistoryId() {
		return _historyId;
	}

	@Override
	public void setHistoryId(long historyId) {
		_historyId = historyId;

		if (_historyRemoteModel != null) {
			try {
				Class<?> clazz = _historyRemoteModel.getClass();

				Method method = clazz.getMethod("setHistoryId", long.class);

				method.invoke(_historyRemoteModel, historyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubscriptionId() {
		return _subscriptionId;
	}

	@Override
	public void setSubscriptionId(long subscriptionId) {
		_subscriptionId = subscriptionId;

		if (_historyRemoteModel != null) {
			try {
				Class<?> clazz = _historyRemoteModel.getClass();

				Method method = clazz.getMethod("setSubscriptionId", long.class);

				method.invoke(_historyRemoteModel, subscriptionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPaidDate() {
		return _paidDate;
	}

	@Override
	public void setPaidDate(Date paidDate) {
		_paidDate = paidDate;

		if (_historyRemoteModel != null) {
			try {
				Class<?> clazz = _historyRemoteModel.getClass();

				Method method = clazz.getMethod("setPaidDate", Date.class);

				method.invoke(_historyRemoteModel, paidDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastPaid() {
		return _lastPaid;
	}

	@Override
	public void setLastPaid(Date lastPaid) {
		_lastPaid = lastPaid;

		if (_historyRemoteModel != null) {
			try {
				Class<?> clazz = _historyRemoteModel.getClass();

				Method method = clazz.getMethod("setLastPaid", Date.class);

				method.invoke(_historyRemoteModel, lastPaid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPendingPayment() {
		return _pendingPayment;
	}

	@Override
	public void setPendingPayment(Date pendingPayment) {
		_pendingPayment = pendingPayment;

		if (_historyRemoteModel != null) {
			try {
				Class<?> clazz = _historyRemoteModel.getClass();

				Method method = clazz.getMethod("setPendingPayment", Date.class);

				method.invoke(_historyRemoteModel, pendingPayment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getHistoryRemoteModel() {
		return _historyRemoteModel;
	}

	public void setHistoryRemoteModel(BaseModel<?> historyRemoteModel) {
		_historyRemoteModel = historyRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _historyRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_historyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			HistoryLocalServiceUtil.addHistory(this);
		}
		else {
			HistoryLocalServiceUtil.updateHistory(this);
		}
	}

	@Override
	public History toEscapedModel() {
		return (History)ProxyUtil.newProxyInstance(History.class.getClassLoader(),
			new Class[] { History.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HistoryClp clone = new HistoryClp();

		clone.setHistoryId(getHistoryId());
		clone.setSubscriptionId(getSubscriptionId());
		clone.setPaidDate(getPaidDate());
		clone.setLastPaid(getLastPaid());
		clone.setPendingPayment(getPendingPayment());

		return clone;
	}

	@Override
	public int compareTo(History history) {
		long primaryKey = history.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HistoryClp)) {
			return false;
		}

		HistoryClp history = (HistoryClp)obj;

		long primaryKey = history.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{historyId=");
		sb.append(getHistoryId());
		sb.append(", subscriptionId=");
		sb.append(getSubscriptionId());
		sb.append(", paidDate=");
		sb.append(getPaidDate());
		sb.append(", lastPaid=");
		sb.append(getLastPaid());
		sb.append(", pendingPayment=");
		sb.append(getPendingPayment());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.alain.monetizacion.model.History");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>historyId</column-name><column-value><![CDATA[");
		sb.append(getHistoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subscriptionId</column-name><column-value><![CDATA[");
		sb.append(getSubscriptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paidDate</column-name><column-value><![CDATA[");
		sb.append(getPaidDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPaid</column-name><column-value><![CDATA[");
		sb.append(getLastPaid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pendingPayment</column-name><column-value><![CDATA[");
		sb.append(getPendingPayment());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _historyId;
	private long _subscriptionId;
	private Date _paidDate;
	private Date _lastPaid;
	private Date _pendingPayment;
	private BaseModel<?> _historyRemoteModel;
	private Class<?> _clpSerializerClass = com.alain.monetizacion.service.ClpSerializer.class;
}