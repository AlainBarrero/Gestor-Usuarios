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
import com.alain.monetizacion.model.SubscriptionModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Subscription service. Represents a row in the &quot;MT_Subscription&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.alain.monetizacion.model.SubscriptionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SubscriptionImpl}.
 * </p>
 *
 * @author Alain
 * @see SubscriptionImpl
 * @see com.alain.monetizacion.model.Subscription
 * @see com.alain.monetizacion.model.SubscriptionModel
 * @generated
 */
public class SubscriptionModelImpl extends BaseModelImpl<Subscription>
	implements SubscriptionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a subscription model instance should use the {@link com.alain.monetizacion.model.Subscription} interface instead.
	 */
	public static final String TABLE_NAME = "MT_Subscription";
	public static final Object[][] TABLE_COLUMNS = {
			{ "subscriptionId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "expireDate", Types.TIMESTAMP },
			{ "payment", Types.DOUBLE },
			{ "configurationId", Types.BIGINT },
			{ "paypalProfile", Types.VARCHAR },
			{ "isActive", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table MT_Subscription (subscriptionId LONG not null primary key,userId LONG,createDate DATE null,expireDate DATE null,payment DOUBLE,configurationId LONG,paypalProfile VARCHAR(75) null,isActive BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table MT_Subscription";
	public static final String ORDER_BY_JPQL = " ORDER BY subscription.subscriptionId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MT_Subscription.subscriptionId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.alain.monetizacion.model.Subscription"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.alain.monetizacion.model.Subscription"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.alain.monetizacion.model.Subscription"),
			true);
	public static long CONFIGURATIONID_COLUMN_BITMASK = 1L;
	public static long USERID_COLUMN_BITMASK = 2L;
	public static long SUBSCRIPTIONID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.alain.monetizacion.model.Subscription"));

	public SubscriptionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _subscriptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSubscriptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _subscriptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Subscription.class;
	}

	@Override
	public String getModelClassName() {
		return Subscription.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subscriptionId", getSubscriptionId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("expireDate", getExpireDate());
		attributes.put("payment", getPayment());
		attributes.put("configurationId", getConfigurationId());
		attributes.put("paypalProfile", getPaypalProfile());
		attributes.put("isActive", getIsActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subscriptionId = (Long)attributes.get("subscriptionId");

		if (subscriptionId != null) {
			setSubscriptionId(subscriptionId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date expireDate = (Date)attributes.get("expireDate");

		if (expireDate != null) {
			setExpireDate(expireDate);
		}

		Double payment = (Double)attributes.get("payment");

		if (payment != null) {
			setPayment(payment);
		}

		Long configurationId = (Long)attributes.get("configurationId");

		if (configurationId != null) {
			setConfigurationId(configurationId);
		}

		String paypalProfile = (String)attributes.get("paypalProfile");

		if (paypalProfile != null) {
			setPaypalProfile(paypalProfile);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}
	}

	@Override
	public long getSubscriptionId() {
		return _subscriptionId;
	}

	@Override
	public void setSubscriptionId(long subscriptionId) {
		_subscriptionId = subscriptionId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getExpireDate() {
		return _expireDate;
	}

	@Override
	public void setExpireDate(Date expireDate) {
		_expireDate = expireDate;
	}

	@Override
	public double getPayment() {
		return _payment;
	}

	@Override
	public void setPayment(double payment) {
		_payment = payment;
	}

	@Override
	public long getConfigurationId() {
		return _configurationId;
	}

	@Override
	public void setConfigurationId(long configurationId) {
		_columnBitmask |= CONFIGURATIONID_COLUMN_BITMASK;

		if (!_setOriginalConfigurationId) {
			_setOriginalConfigurationId = true;

			_originalConfigurationId = _configurationId;
		}

		_configurationId = configurationId;
	}

	public long getOriginalConfigurationId() {
		return _originalConfigurationId;
	}

	@Override
	public String getPaypalProfile() {
		if (_paypalProfile == null) {
			return StringPool.BLANK;
		}
		else {
			return _paypalProfile;
		}
	}

	@Override
	public void setPaypalProfile(String paypalProfile) {
		_paypalProfile = paypalProfile;
	}

	@Override
	public boolean getIsActive() {
		return _isActive;
	}

	@Override
	public boolean isIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(boolean isActive) {
		_isActive = isActive;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Subscription.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Subscription toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Subscription)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SubscriptionImpl subscriptionImpl = new SubscriptionImpl();

		subscriptionImpl.setSubscriptionId(getSubscriptionId());
		subscriptionImpl.setUserId(getUserId());
		subscriptionImpl.setCreateDate(getCreateDate());
		subscriptionImpl.setExpireDate(getExpireDate());
		subscriptionImpl.setPayment(getPayment());
		subscriptionImpl.setConfigurationId(getConfigurationId());
		subscriptionImpl.setPaypalProfile(getPaypalProfile());
		subscriptionImpl.setIsActive(getIsActive());

		subscriptionImpl.resetOriginalValues();

		return subscriptionImpl;
	}

	@Override
	public int compareTo(Subscription subscription) {
		long primaryKey = subscription.getPrimaryKey();

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

		if (!(obj instanceof Subscription)) {
			return false;
		}

		Subscription subscription = (Subscription)obj;

		long primaryKey = subscription.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		SubscriptionModelImpl subscriptionModelImpl = this;

		subscriptionModelImpl._originalUserId = subscriptionModelImpl._userId;

		subscriptionModelImpl._setOriginalUserId = false;

		subscriptionModelImpl._originalConfigurationId = subscriptionModelImpl._configurationId;

		subscriptionModelImpl._setOriginalConfigurationId = false;

		subscriptionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Subscription> toCacheModel() {
		SubscriptionCacheModel subscriptionCacheModel = new SubscriptionCacheModel();

		subscriptionCacheModel.subscriptionId = getSubscriptionId();

		subscriptionCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			subscriptionCacheModel.createDate = createDate.getTime();
		}
		else {
			subscriptionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date expireDate = getExpireDate();

		if (expireDate != null) {
			subscriptionCacheModel.expireDate = expireDate.getTime();
		}
		else {
			subscriptionCacheModel.expireDate = Long.MIN_VALUE;
		}

		subscriptionCacheModel.payment = getPayment();

		subscriptionCacheModel.configurationId = getConfigurationId();

		subscriptionCacheModel.paypalProfile = getPaypalProfile();

		String paypalProfile = subscriptionCacheModel.paypalProfile;

		if ((paypalProfile != null) && (paypalProfile.length() == 0)) {
			subscriptionCacheModel.paypalProfile = null;
		}

		subscriptionCacheModel.isActive = getIsActive();

		return subscriptionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{subscriptionId=");
		sb.append(getSubscriptionId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", expireDate=");
		sb.append(getExpireDate());
		sb.append(", payment=");
		sb.append(getPayment());
		sb.append(", configurationId=");
		sb.append(getConfigurationId());
		sb.append(", paypalProfile=");
		sb.append(getPaypalProfile());
		sb.append(", isActive=");
		sb.append(getIsActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.alain.monetizacion.model.Subscription");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>subscriptionId</column-name><column-value><![CDATA[");
		sb.append(getSubscriptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expireDate</column-name><column-value><![CDATA[");
		sb.append(getExpireDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>payment</column-name><column-value><![CDATA[");
		sb.append(getPayment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>configurationId</column-name><column-value><![CDATA[");
		sb.append(getConfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paypalProfile</column-name><column-value><![CDATA[");
		sb.append(getPaypalProfile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Subscription.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Subscription.class
		};
	private long _subscriptionId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private Date _createDate;
	private Date _expireDate;
	private double _payment;
	private long _configurationId;
	private long _originalConfigurationId;
	private boolean _setOriginalConfigurationId;
	private String _paypalProfile;
	private boolean _isActive;
	private long _columnBitmask;
	private Subscription _escapedModel;
}