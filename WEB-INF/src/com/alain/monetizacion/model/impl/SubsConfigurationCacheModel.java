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

import com.alain.monetizacion.model.SubsConfiguration;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SubsConfiguration in entity cache.
 *
 * @author Alain
 * @see SubsConfiguration
 * @generated
 */
public class SubsConfigurationCacheModel implements CacheModel<SubsConfiguration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{configurationId=");
		sb.append(configurationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", cycle=");
		sb.append(cycle);
		sb.append(", time=");
		sb.append(time);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SubsConfiguration toEntityModel() {
		SubsConfigurationImpl subsConfigurationImpl = new SubsConfigurationImpl();

		subsConfigurationImpl.setConfigurationId(configurationId);
		subsConfigurationImpl.setGroupId(groupId);

		if (description == null) {
			subsConfigurationImpl.setDescription(StringPool.BLANK);
		}
		else {
			subsConfigurationImpl.setDescription(description);
		}

		subsConfigurationImpl.setAmount(amount);

		if (cycle == null) {
			subsConfigurationImpl.setCycle(StringPool.BLANK);
		}
		else {
			subsConfigurationImpl.setCycle(cycle);
		}

		subsConfigurationImpl.setTime(time);

		subsConfigurationImpl.resetOriginalValues();

		return subsConfigurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		configurationId = objectInput.readLong();
		groupId = objectInput.readLong();
		description = objectInput.readUTF();
		amount = objectInput.readDouble();
		cycle = objectInput.readUTF();
		time = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(configurationId);
		objectOutput.writeLong(groupId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeDouble(amount);

		if (cycle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cycle);
		}

		objectOutput.writeInt(time);
	}

	public long configurationId;
	public long groupId;
	public String description;
	public double amount;
	public String cycle;
	public int time;
}