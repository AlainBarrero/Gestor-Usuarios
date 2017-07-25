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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Alain
 * @generated
 */
public class SubsConfigurationSoap implements Serializable {
	public static SubsConfigurationSoap toSoapModel(SubsConfiguration model) {
		SubsConfigurationSoap soapModel = new SubsConfigurationSoap();

		soapModel.setConfigurationId(model.getConfigurationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setDescription(model.getDescription());
		soapModel.setAmount(model.getAmount());
		soapModel.setCycle(model.getCycle());
		soapModel.setTime(model.getTime());

		return soapModel;
	}

	public static SubsConfigurationSoap[] toSoapModels(
		SubsConfiguration[] models) {
		SubsConfigurationSoap[] soapModels = new SubsConfigurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubsConfigurationSoap[][] toSoapModels(
		SubsConfiguration[][] models) {
		SubsConfigurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubsConfigurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubsConfigurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubsConfigurationSoap[] toSoapModels(
		List<SubsConfiguration> models) {
		List<SubsConfigurationSoap> soapModels = new ArrayList<SubsConfigurationSoap>(models.size());

		for (SubsConfiguration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubsConfigurationSoap[soapModels.size()]);
	}

	public SubsConfigurationSoap() {
	}

	public long getPrimaryKey() {
		return _configurationId;
	}

	public void setPrimaryKey(long pk) {
		setConfigurationId(pk);
	}

	public long getConfigurationId() {
		return _configurationId;
	}

	public void setConfigurationId(long configurationId) {
		_configurationId = configurationId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public String getCycle() {
		return _cycle;
	}

	public void setCycle(String cycle) {
		_cycle = cycle;
	}

	public int getTime() {
		return _time;
	}

	public void setTime(int time) {
		_time = time;
	}

	private long _configurationId;
	private long _groupId;
	private String _description;
	private double _amount;
	private String _cycle;
	private int _time;
}