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
import com.alain.monetizacion.service.SubsConfigurationLocalServiceUtil;

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
public class SubsConfigurationClp extends BaseModelImpl<SubsConfiguration>
	implements SubsConfiguration {
	public SubsConfigurationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SubsConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return SubsConfiguration.class.getName();
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

		attributes.put("configurationId", getConfigurationId());
		attributes.put("groupId", getGroupId());
		attributes.put("description", getDescription());
		attributes.put("amount", getAmount());
		attributes.put("cycle", getCycle());
		attributes.put("time", getTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long configurationId = (Long)attributes.get("configurationId");

		if (configurationId != null) {
			setConfigurationId(configurationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String cycle = (String)attributes.get("cycle");

		if (cycle != null) {
			setCycle(cycle);
		}

		Integer time = (Integer)attributes.get("time");

		if (time != null) {
			setTime(time);
		}
	}

	@Override
	public long getConfigurationId() {
		return _configurationId;
	}

	@Override
	public void setConfigurationId(long configurationId) {
		_configurationId = configurationId;

		if (_subsConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _subsConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setConfigurationId", long.class);

				method.invoke(_subsConfigurationRemoteModel, configurationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_subsConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _subsConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_subsConfigurationRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_subsConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _subsConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_subsConfigurationRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(double amount) {
		_amount = amount;

		if (_subsConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _subsConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setAmount", double.class);

				method.invoke(_subsConfigurationRemoteModel, amount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCycle() {
		return _cycle;
	}

	@Override
	public void setCycle(String cycle) {
		_cycle = cycle;

		if (_subsConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _subsConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setCycle", String.class);

				method.invoke(_subsConfigurationRemoteModel, cycle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTime() {
		return _time;
	}

	@Override
	public void setTime(int time) {
		_time = time;

		if (_subsConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _subsConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setTime", int.class);

				method.invoke(_subsConfigurationRemoteModel, time);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSubsConfigurationRemoteModel() {
		return _subsConfigurationRemoteModel;
	}

	public void setSubsConfigurationRemoteModel(
		BaseModel<?> subsConfigurationRemoteModel) {
		_subsConfigurationRemoteModel = subsConfigurationRemoteModel;
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

		Class<?> remoteModelClass = _subsConfigurationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_subsConfigurationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SubsConfigurationLocalServiceUtil.addSubsConfiguration(this);
		}
		else {
			SubsConfigurationLocalServiceUtil.updateSubsConfiguration(this);
		}
	}

	@Override
	public SubsConfiguration toEscapedModel() {
		return (SubsConfiguration)ProxyUtil.newProxyInstance(SubsConfiguration.class.getClassLoader(),
			new Class[] { SubsConfiguration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SubsConfigurationClp clone = new SubsConfigurationClp();

		clone.setConfigurationId(getConfigurationId());
		clone.setGroupId(getGroupId());
		clone.setDescription(getDescription());
		clone.setAmount(getAmount());
		clone.setCycle(getCycle());
		clone.setTime(getTime());

		return clone;
	}

	@Override
	public int compareTo(SubsConfiguration subsConfiguration) {
		long primaryKey = subsConfiguration.getPrimaryKey();

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

		if (!(obj instanceof SubsConfigurationClp)) {
			return false;
		}

		SubsConfigurationClp subsConfiguration = (SubsConfigurationClp)obj;

		long primaryKey = subsConfiguration.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{configurationId=");
		sb.append(getConfigurationId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", cycle=");
		sb.append(getCycle());
		sb.append(", time=");
		sb.append(getTime());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.alain.monetizacion.model.SubsConfiguration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>configurationId</column-name><column-value><![CDATA[");
		sb.append(getConfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cycle</column-name><column-value><![CDATA[");
		sb.append(getCycle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>time</column-name><column-value><![CDATA[");
		sb.append(getTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _configurationId;
	private long _groupId;
	private String _description;
	private double _amount;
	private String _cycle;
	private int _time;
	private BaseModel<?> _subsConfigurationRemoteModel;
	private Class<?> _clpSerializerClass = com.alain.monetizacion.service.ClpSerializer.class;
}