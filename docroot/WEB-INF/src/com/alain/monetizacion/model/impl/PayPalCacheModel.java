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

import com.alain.monetizacion.model.PayPal;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PayPal in entity cache.
 *
 * @author Alain
 * @see PayPal
 * @generated
 */
public class PayPalCacheModel implements CacheModel<PayPal>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{paypalUser=");
		sb.append(paypalUser);
		sb.append(", paypalPassword=");
		sb.append(paypalPassword);
		sb.append(", paypalFirm=");
		sb.append(paypalFirm);
		sb.append(", paypalEmail=");
		sb.append(paypalEmail);
		sb.append(", configurationId=");
		sb.append(configurationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PayPal toEntityModel() {
		PayPalImpl payPalImpl = new PayPalImpl();

		if (paypalUser == null) {
			payPalImpl.setPaypalUser(StringPool.BLANK);
		}
		else {
			payPalImpl.setPaypalUser(paypalUser);
		}

		if (paypalPassword == null) {
			payPalImpl.setPaypalPassword(StringPool.BLANK);
		}
		else {
			payPalImpl.setPaypalPassword(paypalPassword);
		}

		if (paypalFirm == null) {
			payPalImpl.setPaypalFirm(StringPool.BLANK);
		}
		else {
			payPalImpl.setPaypalFirm(paypalFirm);
		}

		if (paypalEmail == null) {
			payPalImpl.setPaypalEmail(StringPool.BLANK);
		}
		else {
			payPalImpl.setPaypalEmail(paypalEmail);
		}

		payPalImpl.setConfigurationId(configurationId);

		payPalImpl.resetOriginalValues();

		return payPalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		paypalUser = objectInput.readUTF();
		paypalPassword = objectInput.readUTF();
		paypalFirm = objectInput.readUTF();
		paypalEmail = objectInput.readUTF();
		configurationId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (paypalUser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paypalUser);
		}

		if (paypalPassword == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paypalPassword);
		}

		if (paypalFirm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paypalFirm);
		}

		if (paypalEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paypalEmail);
		}

		objectOutput.writeLong(configurationId);
	}

	public String paypalUser;
	public String paypalPassword;
	public String paypalFirm;
	public String paypalEmail;
	public long configurationId;
}