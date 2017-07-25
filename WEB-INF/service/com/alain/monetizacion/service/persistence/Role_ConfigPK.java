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

package com.alain.monetizacion.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Alain
 * @generated
 */
public class Role_ConfigPK implements Comparable<Role_ConfigPK>, Serializable {
	public long roleId;
	public long configurationId;

	public Role_ConfigPK() {
	}

	public Role_ConfigPK(long roleId, long configurationId) {
		this.roleId = roleId;
		this.configurationId = configurationId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getConfigurationId() {
		return configurationId;
	}

	public void setConfigurationId(long configurationId) {
		this.configurationId = configurationId;
	}

	@Override
	public int compareTo(Role_ConfigPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (roleId < pk.roleId) {
			value = -1;
		}
		else if (roleId > pk.roleId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (configurationId < pk.configurationId) {
			value = -1;
		}
		else if (configurationId > pk.configurationId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Role_ConfigPK)) {
			return false;
		}

		Role_ConfigPK pk = (Role_ConfigPK)obj;

		if ((roleId == pk.roleId) && (configurationId == pk.configurationId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(roleId) + String.valueOf(configurationId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("roleId");
		sb.append(StringPool.EQUAL);
		sb.append(roleId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("configurationId");
		sb.append(StringPool.EQUAL);
		sb.append(configurationId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}