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
import com.alain.monetizacion.service.PayPalLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alain
 */
public class PayPalClp extends BaseModelImpl<PayPal> implements PayPal {
	public PayPalClp() {
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
	public long getPrimaryKey() {
		return _configurationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setConfigurationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _configurationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getPaypalUser() {
		return _paypalUser;
	}

	@Override
	public void setPaypalUser(String paypalUser) {
		_paypalUser = paypalUser;

		if (_payPalRemoteModel != null) {
			try {
				Class<?> clazz = _payPalRemoteModel.getClass();

				Method method = clazz.getMethod("setPaypalUser", String.class);

				method.invoke(_payPalRemoteModel, paypalUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPaypalPassword() {
		return _paypalPassword;
	}

	@Override
	public void setPaypalPassword(String paypalPassword) {
		_paypalPassword = paypalPassword;

		if (_payPalRemoteModel != null) {
			try {
				Class<?> clazz = _payPalRemoteModel.getClass();

				Method method = clazz.getMethod("setPaypalPassword",
						String.class);

				method.invoke(_payPalRemoteModel, paypalPassword);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPaypalFirm() {
		return _paypalFirm;
	}

	@Override
	public void setPaypalFirm(String paypalFirm) {
		_paypalFirm = paypalFirm;

		if (_payPalRemoteModel != null) {
			try {
				Class<?> clazz = _payPalRemoteModel.getClass();

				Method method = clazz.getMethod("setPaypalFirm", String.class);

				method.invoke(_payPalRemoteModel, paypalFirm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPaypalEmail() {
		return _paypalEmail;
	}

	@Override
	public void setPaypalEmail(String paypalEmail) {
		_paypalEmail = paypalEmail;

		if (_payPalRemoteModel != null) {
			try {
				Class<?> clazz = _payPalRemoteModel.getClass();

				Method method = clazz.getMethod("setPaypalEmail", String.class);

				method.invoke(_payPalRemoteModel, paypalEmail);
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

		if (_payPalRemoteModel != null) {
			try {
				Class<?> clazz = _payPalRemoteModel.getClass();

				Method method = clazz.getMethod("setConfigurationId", long.class);

				method.invoke(_payPalRemoteModel, configurationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPayPalRemoteModel() {
		return _payPalRemoteModel;
	}

	public void setPayPalRemoteModel(BaseModel<?> payPalRemoteModel) {
		_payPalRemoteModel = payPalRemoteModel;
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

		Class<?> remoteModelClass = _payPalRemoteModel.getClass();

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

		Object returnValue = method.invoke(_payPalRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PayPalLocalServiceUtil.addPayPal(this);
		}
		else {
			PayPalLocalServiceUtil.updatePayPal(this);
		}
	}

	@Override
	public PayPal toEscapedModel() {
		return (PayPal)ProxyUtil.newProxyInstance(PayPal.class.getClassLoader(),
			new Class[] { PayPal.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PayPalClp clone = new PayPalClp();

		clone.setPaypalUser(getPaypalUser());
		clone.setPaypalPassword(getPaypalPassword());
		clone.setPaypalFirm(getPaypalFirm());
		clone.setPaypalEmail(getPaypalEmail());
		clone.setConfigurationId(getConfigurationId());

		return clone;
	}

	@Override
	public int compareTo(PayPal payPal) {
		long primaryKey = payPal.getPrimaryKey();

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

		if (!(obj instanceof PayPalClp)) {
			return false;
		}

		PayPalClp payPal = (PayPalClp)obj;

		long primaryKey = payPal.getPrimaryKey();

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

		sb.append("{paypalUser=");
		sb.append(getPaypalUser());
		sb.append(", paypalPassword=");
		sb.append(getPaypalPassword());
		sb.append(", paypalFirm=");
		sb.append(getPaypalFirm());
		sb.append(", paypalEmail=");
		sb.append(getPaypalEmail());
		sb.append(", configurationId=");
		sb.append(getConfigurationId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.alain.monetizacion.model.PayPal");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>paypalUser</column-name><column-value><![CDATA[");
		sb.append(getPaypalUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paypalPassword</column-name><column-value><![CDATA[");
		sb.append(getPaypalPassword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paypalFirm</column-name><column-value><![CDATA[");
		sb.append(getPaypalFirm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paypalEmail</column-name><column-value><![CDATA[");
		sb.append(getPaypalEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>configurationId</column-name><column-value><![CDATA[");
		sb.append(getConfigurationId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _paypalUser;
	private String _paypalPassword;
	private String _paypalFirm;
	private String _paypalEmail;
	private long _configurationId;
	private BaseModel<?> _payPalRemoteModel;
	private Class<?> _clpSerializerClass = com.alain.monetizacion.service.ClpSerializer.class;
}