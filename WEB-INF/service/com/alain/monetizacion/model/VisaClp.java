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
import com.alain.monetizacion.service.VisaLocalServiceUtil;

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
public class VisaClp extends BaseModelImpl<Visa> implements Visa {
	public VisaClp() {
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
	public long getPrimaryKey() {
		return _cardNumber;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCardNumber(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cardNumber;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getCardNumber() {
		return _cardNumber;
	}

	@Override
	public void setCardNumber(long cardNumber) {
		_cardNumber = cardNumber;

		if (_visaRemoteModel != null) {
			try {
				Class<?> clazz = _visaRemoteModel.getClass();

				Method method = clazz.getMethod("setCardNumber", long.class);

				method.invoke(_visaRemoteModel, cardNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCardExpireDate() {
		return _cardExpireDate;
	}

	@Override
	public void setCardExpireDate(Date cardExpireDate) {
		_cardExpireDate = cardExpireDate;

		if (_visaRemoteModel != null) {
			try {
				Class<?> clazz = _visaRemoteModel.getClass();

				Method method = clazz.getMethod("setCardExpireDate", Date.class);

				method.invoke(_visaRemoteModel, cardExpireDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCardVerification() {
		return _cardVerification;
	}

	@Override
	public void setCardVerification(int cardVerification) {
		_cardVerification = cardVerification;

		if (_visaRemoteModel != null) {
			try {
				Class<?> clazz = _visaRemoteModel.getClass();

				Method method = clazz.getMethod("setCardVerification", int.class);

				method.invoke(_visaRemoteModel, cardVerification);
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

		if (_visaRemoteModel != null) {
			try {
				Class<?> clazz = _visaRemoteModel.getClass();

				Method method = clazz.getMethod("setConfigurationId", long.class);

				method.invoke(_visaRemoteModel, configurationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVisaRemoteModel() {
		return _visaRemoteModel;
	}

	public void setVisaRemoteModel(BaseModel<?> visaRemoteModel) {
		_visaRemoteModel = visaRemoteModel;
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

		Class<?> remoteModelClass = _visaRemoteModel.getClass();

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

		Object returnValue = method.invoke(_visaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VisaLocalServiceUtil.addVisa(this);
		}
		else {
			VisaLocalServiceUtil.updateVisa(this);
		}
	}

	@Override
	public Visa toEscapedModel() {
		return (Visa)ProxyUtil.newProxyInstance(Visa.class.getClassLoader(),
			new Class[] { Visa.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VisaClp clone = new VisaClp();

		clone.setCardNumber(getCardNumber());
		clone.setCardExpireDate(getCardExpireDate());
		clone.setCardVerification(getCardVerification());
		clone.setConfigurationId(getConfigurationId());

		return clone;
	}

	@Override
	public int compareTo(Visa visa) {
		long primaryKey = visa.getPrimaryKey();

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

		if (!(obj instanceof VisaClp)) {
			return false;
		}

		VisaClp visa = (VisaClp)obj;

		long primaryKey = visa.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{cardNumber=");
		sb.append(getCardNumber());
		sb.append(", cardExpireDate=");
		sb.append(getCardExpireDate());
		sb.append(", cardVerification=");
		sb.append(getCardVerification());
		sb.append(", configurationId=");
		sb.append(getConfigurationId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.alain.monetizacion.model.Visa");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cardNumber</column-name><column-value><![CDATA[");
		sb.append(getCardNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cardExpireDate</column-name><column-value><![CDATA[");
		sb.append(getCardExpireDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cardVerification</column-name><column-value><![CDATA[");
		sb.append(getCardVerification());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>configurationId</column-name><column-value><![CDATA[");
		sb.append(getConfigurationId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _cardNumber;
	private Date _cardExpireDate;
	private int _cardVerification;
	private long _configurationId;
	private BaseModel<?> _visaRemoteModel;
	private Class<?> _clpSerializerClass = com.alain.monetizacion.service.ClpSerializer.class;
}