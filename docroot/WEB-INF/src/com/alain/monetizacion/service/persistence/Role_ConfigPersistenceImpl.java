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

import com.alain.monetizacion.NoSuchRole_ConfigException;
import com.alain.monetizacion.model.Role_Config;
import com.alain.monetizacion.model.impl.Role_ConfigImpl;
import com.alain.monetizacion.model.impl.Role_ConfigModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the role_ config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alain
 * @see Role_ConfigPersistence
 * @see Role_ConfigUtil
 * @generated
 */
public class Role_ConfigPersistenceImpl extends BasePersistenceImpl<Role_Config>
	implements Role_ConfigPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Role_ConfigUtil} to access the role_ config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Role_ConfigImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Role_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			Role_ConfigModelImpl.FINDER_CACHE_ENABLED, Role_ConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Role_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			Role_ConfigModelImpl.FINDER_CACHE_ENABLED, Role_ConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Role_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			Role_ConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONFIGURATIONID =
		new FinderPath(Role_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			Role_ConfigModelImpl.FINDER_CACHE_ENABLED, Role_ConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByconfigurationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGURATIONID =
		new FinderPath(Role_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			Role_ConfigModelImpl.FINDER_CACHE_ENABLED, Role_ConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByconfigurationId",
			new String[] { Long.class.getName() },
			Role_ConfigModelImpl.CONFIGURATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONFIGURATIONID = new FinderPath(Role_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			Role_ConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByconfigurationId", new String[] { Long.class.getName() });

	/**
	 * Returns all the role_ configs where configurationId = &#63;.
	 *
	 * @param configurationId the configuration ID
	 * @return the matching role_ configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Role_Config> findByconfigurationId(long configurationId)
		throws SystemException {
		return findByconfigurationId(configurationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role_ configs where configurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.Role_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param configurationId the configuration ID
	 * @param start the lower bound of the range of role_ configs
	 * @param end the upper bound of the range of role_ configs (not inclusive)
	 * @return the range of matching role_ configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Role_Config> findByconfigurationId(long configurationId,
		int start, int end) throws SystemException {
		return findByconfigurationId(configurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the role_ configs where configurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.Role_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param configurationId the configuration ID
	 * @param start the lower bound of the range of role_ configs
	 * @param end the upper bound of the range of role_ configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role_ configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Role_Config> findByconfigurationId(long configurationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGURATIONID;
			finderArgs = new Object[] { configurationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONFIGURATIONID;
			finderArgs = new Object[] {
					configurationId,
					
					start, end, orderByComparator
				};
		}

		List<Role_Config> list = (List<Role_Config>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Role_Config role_Config : list) {
				if ((configurationId != role_Config.getConfigurationId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ROLE_CONFIG_WHERE);

			query.append(_FINDER_COLUMN_CONFIGURATIONID_CONFIGURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Role_ConfigModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(configurationId);

				if (!pagination) {
					list = (List<Role_Config>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Role_Config>(list);
				}
				else {
					list = (List<Role_Config>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first role_ config in the ordered set where configurationId = &#63;.
	 *
	 * @param configurationId the configuration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role_ config
	 * @throws com.alain.monetizacion.NoSuchRole_ConfigException if a matching role_ config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role_Config findByconfigurationId_First(long configurationId,
		OrderByComparator orderByComparator)
		throws NoSuchRole_ConfigException, SystemException {
		Role_Config role_Config = fetchByconfigurationId_First(configurationId,
				orderByComparator);

		if (role_Config != null) {
			return role_Config;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("configurationId=");
		msg.append(configurationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRole_ConfigException(msg.toString());
	}

	/**
	 * Returns the first role_ config in the ordered set where configurationId = &#63;.
	 *
	 * @param configurationId the configuration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role_ config, or <code>null</code> if a matching role_ config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role_Config fetchByconfigurationId_First(long configurationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Role_Config> list = findByconfigurationId(configurationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last role_ config in the ordered set where configurationId = &#63;.
	 *
	 * @param configurationId the configuration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role_ config
	 * @throws com.alain.monetizacion.NoSuchRole_ConfigException if a matching role_ config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role_Config findByconfigurationId_Last(long configurationId,
		OrderByComparator orderByComparator)
		throws NoSuchRole_ConfigException, SystemException {
		Role_Config role_Config = fetchByconfigurationId_Last(configurationId,
				orderByComparator);

		if (role_Config != null) {
			return role_Config;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("configurationId=");
		msg.append(configurationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRole_ConfigException(msg.toString());
	}

	/**
	 * Returns the last role_ config in the ordered set where configurationId = &#63;.
	 *
	 * @param configurationId the configuration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role_ config, or <code>null</code> if a matching role_ config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role_Config fetchByconfigurationId_Last(long configurationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByconfigurationId(configurationId);

		if (count == 0) {
			return null;
		}

		List<Role_Config> list = findByconfigurationId(configurationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the role_ configs before and after the current role_ config in the ordered set where configurationId = &#63;.
	 *
	 * @param role_ConfigPK the primary key of the current role_ config
	 * @param configurationId the configuration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role_ config
	 * @throws com.alain.monetizacion.NoSuchRole_ConfigException if a role_ config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role_Config[] findByconfigurationId_PrevAndNext(
		Role_ConfigPK role_ConfigPK, long configurationId,
		OrderByComparator orderByComparator)
		throws NoSuchRole_ConfigException, SystemException {
		Role_Config role_Config = findByPrimaryKey(role_ConfigPK);

		Session session = null;

		try {
			session = openSession();

			Role_Config[] array = new Role_ConfigImpl[3];

			array[0] = getByconfigurationId_PrevAndNext(session, role_Config,
					configurationId, orderByComparator, true);

			array[1] = role_Config;

			array[2] = getByconfigurationId_PrevAndNext(session, role_Config,
					configurationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Role_Config getByconfigurationId_PrevAndNext(Session session,
		Role_Config role_Config, long configurationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ROLE_CONFIG_WHERE);

		query.append(_FINDER_COLUMN_CONFIGURATIONID_CONFIGURATIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Role_ConfigModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(configurationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(role_Config);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Role_Config> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the role_ configs where configurationId = &#63; from the database.
	 *
	 * @param configurationId the configuration ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByconfigurationId(long configurationId)
		throws SystemException {
		for (Role_Config role_Config : findByconfigurationId(configurationId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(role_Config);
		}
	}

	/**
	 * Returns the number of role_ configs where configurationId = &#63;.
	 *
	 * @param configurationId the configuration ID
	 * @return the number of matching role_ configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByconfigurationId(long configurationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONFIGURATIONID;

		Object[] finderArgs = new Object[] { configurationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ROLE_CONFIG_WHERE);

			query.append(_FINDER_COLUMN_CONFIGURATIONID_CONFIGURATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(configurationId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONFIGURATIONID_CONFIGURATIONID_2 =
		"role_Config.id.configurationId = ?";

	public Role_ConfigPersistenceImpl() {
		setModelClass(Role_Config.class);
	}

	/**
	 * Caches the role_ config in the entity cache if it is enabled.
	 *
	 * @param role_Config the role_ config
	 */
	@Override
	public void cacheResult(Role_Config role_Config) {
		EntityCacheUtil.putResult(Role_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			Role_ConfigImpl.class, role_Config.getPrimaryKey(), role_Config);

		role_Config.resetOriginalValues();
	}

	/**
	 * Caches the role_ configs in the entity cache if it is enabled.
	 *
	 * @param role_Configs the role_ configs
	 */
	@Override
	public void cacheResult(List<Role_Config> role_Configs) {
		for (Role_Config role_Config : role_Configs) {
			if (EntityCacheUtil.getResult(
						Role_ConfigModelImpl.ENTITY_CACHE_ENABLED,
						Role_ConfigImpl.class, role_Config.getPrimaryKey()) == null) {
				cacheResult(role_Config);
			}
			else {
				role_Config.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all role_ configs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Role_ConfigImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Role_ConfigImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the role_ config.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Role_Config role_Config) {
		EntityCacheUtil.removeResult(Role_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			Role_ConfigImpl.class, role_Config.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Role_Config> role_Configs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Role_Config role_Config : role_Configs) {
			EntityCacheUtil.removeResult(Role_ConfigModelImpl.ENTITY_CACHE_ENABLED,
				Role_ConfigImpl.class, role_Config.getPrimaryKey());
		}
	}

	/**
	 * Creates a new role_ config with the primary key. Does not add the role_ config to the database.
	 *
	 * @param role_ConfigPK the primary key for the new role_ config
	 * @return the new role_ config
	 */
	@Override
	public Role_Config create(Role_ConfigPK role_ConfigPK) {
		Role_Config role_Config = new Role_ConfigImpl();

		role_Config.setNew(true);
		role_Config.setPrimaryKey(role_ConfigPK);

		return role_Config;
	}

	/**
	 * Removes the role_ config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param role_ConfigPK the primary key of the role_ config
	 * @return the role_ config that was removed
	 * @throws com.alain.monetizacion.NoSuchRole_ConfigException if a role_ config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role_Config remove(Role_ConfigPK role_ConfigPK)
		throws NoSuchRole_ConfigException, SystemException {
		return remove((Serializable)role_ConfigPK);
	}

	/**
	 * Removes the role_ config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the role_ config
	 * @return the role_ config that was removed
	 * @throws com.alain.monetizacion.NoSuchRole_ConfigException if a role_ config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role_Config remove(Serializable primaryKey)
		throws NoSuchRole_ConfigException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Role_Config role_Config = (Role_Config)session.get(Role_ConfigImpl.class,
					primaryKey);

			if (role_Config == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRole_ConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(role_Config);
		}
		catch (NoSuchRole_ConfigException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Role_Config removeImpl(Role_Config role_Config)
		throws SystemException {
		role_Config = toUnwrappedModel(role_Config);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(role_Config)) {
				role_Config = (Role_Config)session.get(Role_ConfigImpl.class,
						role_Config.getPrimaryKeyObj());
			}

			if (role_Config != null) {
				session.delete(role_Config);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (role_Config != null) {
			clearCache(role_Config);
		}

		return role_Config;
	}

	@Override
	public Role_Config updateImpl(
		com.alain.monetizacion.model.Role_Config role_Config)
		throws SystemException {
		role_Config = toUnwrappedModel(role_Config);

		boolean isNew = role_Config.isNew();

		Role_ConfigModelImpl role_ConfigModelImpl = (Role_ConfigModelImpl)role_Config;

		Session session = null;

		try {
			session = openSession();

			if (role_Config.isNew()) {
				session.save(role_Config);

				role_Config.setNew(false);
			}
			else {
				session.merge(role_Config);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Role_ConfigModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((role_ConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGURATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						role_ConfigModelImpl.getOriginalConfigurationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONFIGURATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGURATIONID,
					args);

				args = new Object[] { role_ConfigModelImpl.getConfigurationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONFIGURATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGURATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(Role_ConfigModelImpl.ENTITY_CACHE_ENABLED,
			Role_ConfigImpl.class, role_Config.getPrimaryKey(), role_Config);

		return role_Config;
	}

	protected Role_Config toUnwrappedModel(Role_Config role_Config) {
		if (role_Config instanceof Role_ConfigImpl) {
			return role_Config;
		}

		Role_ConfigImpl role_ConfigImpl = new Role_ConfigImpl();

		role_ConfigImpl.setNew(role_Config.isNew());
		role_ConfigImpl.setPrimaryKey(role_Config.getPrimaryKey());

		role_ConfigImpl.setRoleId(role_Config.getRoleId());
		role_ConfigImpl.setConfigurationId(role_Config.getConfigurationId());

		return role_ConfigImpl;
	}

	/**
	 * Returns the role_ config with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the role_ config
	 * @return the role_ config
	 * @throws com.alain.monetizacion.NoSuchRole_ConfigException if a role_ config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role_Config findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRole_ConfigException, SystemException {
		Role_Config role_Config = fetchByPrimaryKey(primaryKey);

		if (role_Config == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRole_ConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return role_Config;
	}

	/**
	 * Returns the role_ config with the primary key or throws a {@link com.alain.monetizacion.NoSuchRole_ConfigException} if it could not be found.
	 *
	 * @param role_ConfigPK the primary key of the role_ config
	 * @return the role_ config
	 * @throws com.alain.monetizacion.NoSuchRole_ConfigException if a role_ config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role_Config findByPrimaryKey(Role_ConfigPK role_ConfigPK)
		throws NoSuchRole_ConfigException, SystemException {
		return findByPrimaryKey((Serializable)role_ConfigPK);
	}

	/**
	 * Returns the role_ config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the role_ config
	 * @return the role_ config, or <code>null</code> if a role_ config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role_Config fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Role_Config role_Config = (Role_Config)EntityCacheUtil.getResult(Role_ConfigModelImpl.ENTITY_CACHE_ENABLED,
				Role_ConfigImpl.class, primaryKey);

		if (role_Config == _nullRole_Config) {
			return null;
		}

		if (role_Config == null) {
			Session session = null;

			try {
				session = openSession();

				role_Config = (Role_Config)session.get(Role_ConfigImpl.class,
						primaryKey);

				if (role_Config != null) {
					cacheResult(role_Config);
				}
				else {
					EntityCacheUtil.putResult(Role_ConfigModelImpl.ENTITY_CACHE_ENABLED,
						Role_ConfigImpl.class, primaryKey, _nullRole_Config);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Role_ConfigModelImpl.ENTITY_CACHE_ENABLED,
					Role_ConfigImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return role_Config;
	}

	/**
	 * Returns the role_ config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param role_ConfigPK the primary key of the role_ config
	 * @return the role_ config, or <code>null</code> if a role_ config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Role_Config fetchByPrimaryKey(Role_ConfigPK role_ConfigPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)role_ConfigPK);
	}

	/**
	 * Returns all the role_ configs.
	 *
	 * @return the role_ configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Role_Config> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role_ configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.Role_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of role_ configs
	 * @param end the upper bound of the range of role_ configs (not inclusive)
	 * @return the range of role_ configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Role_Config> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the role_ configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.Role_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of role_ configs
	 * @param end the upper bound of the range of role_ configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of role_ configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Role_Config> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Role_Config> list = (List<Role_Config>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ROLE_CONFIG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ROLE_CONFIG;

				if (pagination) {
					sql = sql.concat(Role_ConfigModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Role_Config>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Role_Config>(list);
				}
				else {
					list = (List<Role_Config>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the role_ configs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Role_Config role_Config : findAll()) {
			remove(role_Config);
		}
	}

	/**
	 * Returns the number of role_ configs.
	 *
	 * @return the number of role_ configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ROLE_CONFIG);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the role_ config persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.alain.monetizacion.model.Role_Config")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Role_Config>> listenersList = new ArrayList<ModelListener<Role_Config>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Role_Config>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(Role_ConfigImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ROLE_CONFIG = "SELECT role_Config FROM Role_Config role_Config";
	private static final String _SQL_SELECT_ROLE_CONFIG_WHERE = "SELECT role_Config FROM Role_Config role_Config WHERE ";
	private static final String _SQL_COUNT_ROLE_CONFIG = "SELECT COUNT(role_Config) FROM Role_Config role_Config";
	private static final String _SQL_COUNT_ROLE_CONFIG_WHERE = "SELECT COUNT(role_Config) FROM Role_Config role_Config WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "role_Config.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Role_Config exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Role_Config exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Role_ConfigPersistenceImpl.class);
	private static Role_Config _nullRole_Config = new Role_ConfigImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Role_Config> toCacheModel() {
				return _nullRole_ConfigCacheModel;
			}
		};

	private static CacheModel<Role_Config> _nullRole_ConfigCacheModel = new CacheModel<Role_Config>() {
			@Override
			public Role_Config toEntityModel() {
				return _nullRole_Config;
			}
		};
}