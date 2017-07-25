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

package com.alain.monetizacion.model.impl;

import com.alain.monetizacion.model.Message;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Message in entity cache.
 *
 * @author Alain
 * @see Message
 * @generated
 */
public class MessageCacheModel implements CacheModel<Message>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{messageId=");
		sb.append(messageId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", isValidate=");
		sb.append(isValidate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Message toEntityModel() {
		MessageImpl messageImpl = new MessageImpl();

		messageImpl.setMessageId(messageId);
		messageImpl.setUserId(userId);
		messageImpl.setCompanyId(companyId);

		if (description == null) {
			messageImpl.setDescription(StringPool.BLANK);
		}
		else {
			messageImpl.setDescription(description);
		}

		messageImpl.setIsValidate(isValidate);

		messageImpl.resetOriginalValues();

		return messageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		messageId = objectInput.readLong();
		userId = objectInput.readLong();
		companyId = objectInput.readLong();
		description = objectInput.readUTF();
		isValidate = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(messageId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(companyId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(isValidate);
	}

	public long messageId;
	public long userId;
	public long companyId;
	public String description;
	public boolean isValidate;
}