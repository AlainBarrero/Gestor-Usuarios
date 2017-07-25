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
import com.alain.monetizacion.service.MessageLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alain
 */
public class MessageClp extends BaseModelImpl<Message> implements Message {
	public MessageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Message.class;
	}

	@Override
	public String getModelClassName() {
		return Message.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _messageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMessageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _messageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("messageId", getMessageId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("description", getDescription());
		attributes.put("isValidate", getIsValidate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean isValidate = (Boolean)attributes.get("isValidate");

		if (isValidate != null) {
			setIsValidate(isValidate);
		}
	}

	@Override
	public long getMessageId() {
		return _messageId;
	}

	@Override
	public void setMessageId(long messageId) {
		_messageId = messageId;

		if (_messageRemoteModel != null) {
			try {
				Class<?> clazz = _messageRemoteModel.getClass();

				Method method = clazz.getMethod("setMessageId", long.class);

				method.invoke(_messageRemoteModel, messageId);
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

		if (_messageRemoteModel != null) {
			try {
				Class<?> clazz = _messageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_messageRemoteModel, userId);
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
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_messageRemoteModel != null) {
			try {
				Class<?> clazz = _messageRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_messageRemoteModel, companyId);
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

		if (_messageRemoteModel != null) {
			try {
				Class<?> clazz = _messageRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_messageRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsValidate() {
		return _isValidate;
	}

	@Override
	public boolean isIsValidate() {
		return _isValidate;
	}

	@Override
	public void setIsValidate(boolean isValidate) {
		_isValidate = isValidate;

		if (_messageRemoteModel != null) {
			try {
				Class<?> clazz = _messageRemoteModel.getClass();

				Method method = clazz.getMethod("setIsValidate", boolean.class);

				method.invoke(_messageRemoteModel, isValidate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMessageRemoteModel() {
		return _messageRemoteModel;
	}

	public void setMessageRemoteModel(BaseModel<?> messageRemoteModel) {
		_messageRemoteModel = messageRemoteModel;
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

		Class<?> remoteModelClass = _messageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_messageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MessageLocalServiceUtil.addMessage(this);
		}
		else {
			MessageLocalServiceUtil.updateMessage(this);
		}
	}

	@Override
	public Message toEscapedModel() {
		return (Message)ProxyUtil.newProxyInstance(Message.class.getClassLoader(),
			new Class[] { Message.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MessageClp clone = new MessageClp();

		clone.setMessageId(getMessageId());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setDescription(getDescription());
		clone.setIsValidate(getIsValidate());

		return clone;
	}

	@Override
	public int compareTo(Message message) {
		long primaryKey = message.getPrimaryKey();

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

		if (!(obj instanceof MessageClp)) {
			return false;
		}

		MessageClp message = (MessageClp)obj;

		long primaryKey = message.getPrimaryKey();

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

		sb.append("{messageId=");
		sb.append(getMessageId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", isValidate=");
		sb.append(getIsValidate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.alain.monetizacion.model.Message");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isValidate</column-name><column-value><![CDATA[");
		sb.append(getIsValidate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _messageId;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private String _description;
	private boolean _isValidate;
	private BaseModel<?> _messageRemoteModel;
	private Class<?> _clpSerializerClass = com.alain.monetizacion.service.ClpSerializer.class;
}