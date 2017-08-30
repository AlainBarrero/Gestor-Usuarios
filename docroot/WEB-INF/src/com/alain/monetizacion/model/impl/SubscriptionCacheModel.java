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

import com.alain.monetizacion.model.Subscription;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Subscription in entity cache.
 *
 * @author Alain
 * @see Subscription
 * @generated
 */
public class SubscriptionCacheModel implements CacheModel<Subscription>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{subscriptionId=");
		sb.append(subscriptionId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", expireDate=");
		sb.append(expireDate);
		sb.append(", payment=");
		sb.append(payment);
		sb.append(", configurationId=");
		sb.append(configurationId);
		sb.append(", paypalProfile=");
		sb.append(paypalProfile);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Subscription toEntityModel() {
		SubscriptionImpl subscriptionImpl = new SubscriptionImpl();

		subscriptionImpl.setSubscriptionId(subscriptionId);
		subscriptionImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			subscriptionImpl.setCreateDate(null);
		}
		else {
			subscriptionImpl.setCreateDate(new Date(createDate));
		}

		if (expireDate == Long.MIN_VALUE) {
			subscriptionImpl.setExpireDate(null);
		}
		else {
			subscriptionImpl.setExpireDate(new Date(expireDate));
		}

		subscriptionImpl.setPayment(payment);
		subscriptionImpl.setConfigurationId(configurationId);

		if (paypalProfile == null) {
			subscriptionImpl.setPaypalProfile(StringPool.BLANK);
		}
		else {
			subscriptionImpl.setPaypalProfile(paypalProfile);
		}

		subscriptionImpl.setIsActive(isActive);

		subscriptionImpl.resetOriginalValues();

		return subscriptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		subscriptionId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		expireDate = objectInput.readLong();
		payment = objectInput.readDouble();
		configurationId = objectInput.readLong();
		paypalProfile = objectInput.readUTF();
		isActive = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(subscriptionId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(expireDate);
		objectOutput.writeDouble(payment);
		objectOutput.writeLong(configurationId);

		if (paypalProfile == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paypalProfile);
		}

		objectOutput.writeBoolean(isActive);
	}

	public long subscriptionId;
	public long userId;
	public long createDate;
	public long expireDate;
	public double payment;
	public long configurationId;
	public String paypalProfile;
	public boolean isActive;
}