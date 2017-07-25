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
import com.alain.monetizacion.service.SubscriptionLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alain
 */
public class SubscriptionClp extends BaseModelImpl<Subscription>
	implements Subscription {
	public SubscriptionClp() {
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
	public long getPrimaryKey() {
		return _subscriptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSubscriptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _subscriptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSubscriptionId() {
		return _subscriptionId;
	}

	@Override
	public void setSubscriptionId(long subscriptionId) {
		_subscriptionId = subscriptionId;

		if (_subscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _subscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setSubscriptionId", long.class);

				method.invoke(_subscriptionRemoteModel, subscriptionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_subscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _subscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_subscriptionRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_subscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _subscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_subscriptionRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExpireDate() {
		return _expireDate;
	}

	@Override
	public void setExpireDate(Date expireDate) {
		_expireDate = expireDate;

		if (_subscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _subscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setExpireDate", Date.class);

				method.invoke(_subscriptionRemoteModel, expireDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPayment() {
		return _payment;
	}

	@Override
	public void setPayment(double payment) {
		_payment = payment;

		if (_subscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _subscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPayment", double.class);

				method.invoke(_subscriptionRemoteModel, payment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getConfigurationId() {
		return _configurationId;
	}

	@Override
	public void setConfigurationId(long configurationId) {
		_configurationId = configurationId;

		if (_subscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _subscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setConfigurationId", long.class);

				method.invoke(_subscriptionRemoteModel, configurationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPaypalProfile() {
		return _paypalProfile;
	}

	@Override
	public void setPaypalProfile(String paypalProfile) {
		_paypalProfile = paypalProfile;

		if (_subscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _subscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPaypalProfile", String.class);

				method.invoke(_subscriptionRemoteModel, paypalProfile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsActive() {
		return _isActive;
	}

	@Override
	public boolean isIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(boolean isActive) {
		_isActive = isActive;

		if (_subscriptionRemoteModel != null) {
			try {
				Class<?> clazz = _subscriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setIsActive", boolean.class);

				method.invoke(_subscriptionRemoteModel, isActive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSubscriptionRemoteModel() {
		return _subscriptionRemoteModel;
	}

	public void setSubscriptionRemoteModel(BaseModel<?> subscriptionRemoteModel) {
		_subscriptionRemoteModel = subscriptionRemoteModel;
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

		Class<?> remoteModelClass = _subscriptionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_subscriptionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SubscriptionLocalServiceUtil.addSubscription(this);
		}
		else {
			SubscriptionLocalServiceUtil.updateSubscription(this);
		}
	}

	@Override
	public Subscription toEscapedModel() {
		return (Subscription)ProxyUtil.newProxyInstance(Subscription.class.getClassLoader(),
			new Class[] { Subscription.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SubscriptionClp clone = new SubscriptionClp();

		clone.setSubscriptionId(getSubscriptionId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setExpireDate(getExpireDate());
		clone.setPayment(getPayment());
		clone.setConfigurationId(getConfigurationId());
		clone.setPaypalProfile(getPaypalProfile());
		clone.setIsActive(getIsActive());

		return clone;
	}

	@Override
	public int compareTo(Subscription subscription) {
		long primaryKey = subscription.getPrimaryKey();

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

		if (!(obj instanceof SubscriptionClp)) {
			return false;
		}

		SubscriptionClp subscription = (SubscriptionClp)obj;

		long primaryKey = subscription.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{subscriptionId=");
		sb.append(getSubscriptionId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", expireDate=");
		sb.append(getExpireDate());
		sb.append(", payment=");
		sb.append(getPayment());
		sb.append(", configurationId=");
		sb.append(getConfigurationId());
		sb.append(", paypalProfile=");
		sb.append(getPaypalProfile());
		sb.append(", isActive=");
		sb.append(getIsActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.alain.monetizacion.model.Subscription");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>subscriptionId</column-name><column-value><![CDATA[");
		sb.append(getSubscriptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expireDate</column-name><column-value><![CDATA[");
		sb.append(getExpireDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>payment</column-name><column-value><![CDATA[");
		sb.append(getPayment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>configurationId</column-name><column-value><![CDATA[");
		sb.append(getConfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paypalProfile</column-name><column-value><![CDATA[");
		sb.append(getPaypalProfile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _subscriptionId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _expireDate;
	private double _payment;
	private long _configurationId;
	private String _paypalProfile;
	private boolean _isActive;
	private BaseModel<?> _subscriptionRemoteModel;
	private Class<?> _clpSerializerClass = com.alain.monetizacion.service.ClpSerializer.class;
}