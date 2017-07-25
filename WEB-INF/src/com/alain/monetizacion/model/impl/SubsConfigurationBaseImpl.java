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
import com.alain.monetizacion.service.SubsConfigurationLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the SubsConfiguration service. Represents a row in the &quot;MT_SubsConfiguration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SubsConfigurationImpl}.
 * </p>
 *
 * @author Alain
 * @see SubsConfigurationImpl
 * @see com.alain.monetizacion.model.SubsConfiguration
 * @generated
 */
public abstract class SubsConfigurationBaseImpl
	extends SubsConfigurationModelImpl implements SubsConfiguration {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a subs configuration model instance should use the {@link SubsConfiguration} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SubsConfigurationLocalServiceUtil.addSubsConfiguration(this);
		}
		else {
			SubsConfigurationLocalServiceUtil.updateSubsConfiguration(this);
		}
	}
}