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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Message}.
 * </p>
 *
 * @author Alain
 * @see Message
 * @generated
 */
public class MessageWrapper implements Message, ModelWrapper<Message> {
	public MessageWrapper(Message message) {
		_message = message;
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

	/**
	* Returns the primary key of this message.
	*
	* @return the primary key of this message
	*/
	@Override
	public long getPrimaryKey() {
		return _message.getPrimaryKey();
	}

	/**
	* Sets the primary key of this message.
	*
	* @param primaryKey the primary key of this message
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_message.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the message ID of this message.
	*
	* @return the message ID of this message
	*/
	@Override
	public long getMessageId() {
		return _message.getMessageId();
	}

	/**
	* Sets the message ID of this message.
	*
	* @param messageId the message ID of this message
	*/
	@Override
	public void setMessageId(long messageId) {
		_message.setMessageId(messageId);
	}

	/**
	* Returns the user ID of this message.
	*
	* @return the user ID of this message
	*/
	@Override
	public long getUserId() {
		return _message.getUserId();
	}

	/**
	* Sets the user ID of this message.
	*
	* @param userId the user ID of this message
	*/
	@Override
	public void setUserId(long userId) {
		_message.setUserId(userId);
	}

	/**
	* Returns the user uuid of this message.
	*
	* @return the user uuid of this message
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _message.getUserUuid();
	}

	/**
	* Sets the user uuid of this message.
	*
	* @param userUuid the user uuid of this message
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_message.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this message.
	*
	* @return the company ID of this message
	*/
	@Override
	public long getCompanyId() {
		return _message.getCompanyId();
	}

	/**
	* Sets the company ID of this message.
	*
	* @param companyId the company ID of this message
	*/
	@Override
	public void setCompanyId(long companyId) {
		_message.setCompanyId(companyId);
	}

	/**
	* Returns the description of this message.
	*
	* @return the description of this message
	*/
	@Override
	public java.lang.String getDescription() {
		return _message.getDescription();
	}

	/**
	* Sets the description of this message.
	*
	* @param description the description of this message
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_message.setDescription(description);
	}

	/**
	* Returns the is validate of this message.
	*
	* @return the is validate of this message
	*/
	@Override
	public boolean getIsValidate() {
		return _message.getIsValidate();
	}

	/**
	* Returns <code>true</code> if this message is is validate.
	*
	* @return <code>true</code> if this message is is validate; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsValidate() {
		return _message.isIsValidate();
	}

	/**
	* Sets whether this message is is validate.
	*
	* @param isValidate the is validate of this message
	*/
	@Override
	public void setIsValidate(boolean isValidate) {
		_message.setIsValidate(isValidate);
	}

	@Override
	public boolean isNew() {
		return _message.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_message.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _message.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_message.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _message.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _message.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_message.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _message.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_message.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_message.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_message.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MessageWrapper((Message)_message.clone());
	}

	@Override
	public int compareTo(com.alain.monetizacion.model.Message message) {
		return _message.compareTo(message);
	}

	@Override
	public int hashCode() {
		return _message.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.alain.monetizacion.model.Message> toCacheModel() {
		return _message.toCacheModel();
	}

	@Override
	public com.alain.monetizacion.model.Message toEscapedModel() {
		return new MessageWrapper(_message.toEscapedModel());
	}

	@Override
	public com.alain.monetizacion.model.Message toUnescapedModel() {
		return new MessageWrapper(_message.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _message.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _message.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_message.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MessageWrapper)) {
			return false;
		}

		MessageWrapper messageWrapper = (MessageWrapper)obj;

		if (Validator.equals(_message, messageWrapper._message)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Message getWrappedMessage() {
		return _message;
	}

	@Override
	public Message getWrappedModel() {
		return _message;
	}

	@Override
	public void resetOriginalValues() {
		_message.resetOriginalValues();
	}

	private Message _message;
}