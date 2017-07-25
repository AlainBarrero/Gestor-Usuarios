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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Message service. Represents a row in the &quot;MT_Message&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.alain.monetizacion.model.impl.MessageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.alain.monetizacion.model.impl.MessageImpl}.
 * </p>
 *
 * @author Alain
 * @see Message
 * @see com.alain.monetizacion.model.impl.MessageImpl
 * @see com.alain.monetizacion.model.impl.MessageModelImpl
 * @generated
 */
public interface MessageModel extends BaseModel<Message> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a message model instance should use the {@link Message} interface instead.
	 */

	/**
	 * Returns the primary key of this message.
	 *
	 * @return the primary key of this message
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this message.
	 *
	 * @param primaryKey the primary key of this message
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the message ID of this message.
	 *
	 * @return the message ID of this message
	 */
	public long getMessageId();

	/**
	 * Sets the message ID of this message.
	 *
	 * @param messageId the message ID of this message
	 */
	public void setMessageId(long messageId);

	/**
	 * Returns the user ID of this message.
	 *
	 * @return the user ID of this message
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this message.
	 *
	 * @param userId the user ID of this message
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this message.
	 *
	 * @return the user uuid of this message
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this message.
	 *
	 * @param userUuid the user uuid of this message
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the company ID of this message.
	 *
	 * @return the company ID of this message
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this message.
	 *
	 * @param companyId the company ID of this message
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the description of this message.
	 *
	 * @return the description of this message
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this message.
	 *
	 * @param description the description of this message
	 */
	public void setDescription(String description);

	/**
	 * Returns the is validate of this message.
	 *
	 * @return the is validate of this message
	 */
	public boolean getIsValidate();

	/**
	 * Returns <code>true</code> if this message is is validate.
	 *
	 * @return <code>true</code> if this message is is validate; <code>false</code> otherwise
	 */
	public boolean isIsValidate();

	/**
	 * Sets whether this message is is validate.
	 *
	 * @param isValidate the is validate of this message
	 */
	public void setIsValidate(boolean isValidate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.alain.monetizacion.model.Message message);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.alain.monetizacion.model.Message> toCacheModel();

	@Override
	public com.alain.monetizacion.model.Message toEscapedModel();

	@Override
	public com.alain.monetizacion.model.Message toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}