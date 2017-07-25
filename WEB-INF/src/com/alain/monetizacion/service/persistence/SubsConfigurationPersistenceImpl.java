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

import com.alain.monetizacion.NoSuchSubsConfigurationException;
import com.alain.monetizacion.model.SubsConfiguration;
import com.alain.monetizacion.model.impl.SubsConfigurationImpl;
import com.alain.monetizacion.model.impl.SubsConfigurationModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the subs configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alain
 * @see SubsConfigurationPersistence
 * @see SubsConfigurationUtil
 * @generated
 */
public class SubsConfigurationPersistenceImpl extends BasePersistenceImpl<SubsConfiguration>
	implements SubsConfigurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubsConfigurationUtil} to access the subs configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubsConfigurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SubsConfigurationModelImpl.FINDER_CACHE_ENABLED,
			SubsConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SubsConfigurationModelImpl.FINDER_CACHE_ENABLED,
			SubsConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SubsConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(SubsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SubsConfigurationModelImpl.FINDER_CACHE_ENABLED,
			SubsConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(SubsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SubsConfigurationModelImpl.FINDER_CACHE_ENABLED,
			SubsConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			SubsConfigurationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SubsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SubsConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the subs configurations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching subs configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubsConfiguration> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subs configurations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.SubsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of subs configurations
	 * @param end the upper bound of the range of subs configurations (not inclusive)
	 * @return the range of matching subs configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubsConfiguration> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the subs configurations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.SubsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of subs configurations
	 * @param end the upper bound of the range of subs configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subs configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubsConfiguration> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<SubsConfiguration> list = (List<SubsConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SubsConfiguration subsConfiguration : list) {
				if ((groupId != subsConfiguration.getGroupId())) {
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

			query.append(_SQL_SELECT_SUBSCONFIGURATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubsConfigurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<SubsConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubsConfiguration>(list);
				}
				else {
					list = (List<SubsConfiguration>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first subs configuration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subs configuration
	 * @throws com.alain.monetizacion.NoSuchSubsConfigurationException if a matching subs configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubsConfiguration findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSubsConfigurationException, SystemException {
		SubsConfiguration subsConfiguration = fetchByGroupId_First(groupId,
				orderByComparator);

		if (subsConfiguration != null) {
			return subsConfiguration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubsConfigurationException(msg.toString());
	}

	/**
	 * Returns the first subs configuration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subs configuration, or <code>null</code> if a matching subs configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubsConfiguration fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SubsConfiguration> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last subs configuration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subs configuration
	 * @throws com.alain.monetizacion.NoSuchSubsConfigurationException if a matching subs configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubsConfiguration findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSubsConfigurationException, SystemException {
		SubsConfiguration subsConfiguration = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (subsConfiguration != null) {
			return subsConfiguration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubsConfigurationException(msg.toString());
	}

	/**
	 * Returns the last subs configuration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subs configuration, or <code>null</code> if a matching subs configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubsConfiguration fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<SubsConfiguration> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the subs configurations before and after the current subs configuration in the ordered set where groupId = &#63;.
	 *
	 * @param configurationId the primary key of the current subs configuration
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subs configuration
	 * @throws com.alain.monetizacion.NoSuchSubsConfigurationException if a subs configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubsConfiguration[] findByGroupId_PrevAndNext(long configurationId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchSubsConfigurationException, SystemException {
		SubsConfiguration subsConfiguration = findByPrimaryKey(configurationId);

		Session session = null;

		try {
			session = openSession();

			SubsConfiguration[] array = new SubsConfigurationImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, subsConfiguration,
					groupId, orderByComparator, true);

			array[1] = subsConfiguration;

			array[2] = getByGroupId_PrevAndNext(session, subsConfiguration,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubsConfiguration getByGroupId_PrevAndNext(Session session,
		SubsConfiguration subsConfiguration, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBSCONFIGURATION_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(SubsConfigurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(subsConfiguration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubsConfiguration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subs configurations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (SubsConfiguration subsConfiguration : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(subsConfiguration);
		}
	}

	/**
	 * Returns the number of subs configurations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching subs configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBSCONFIGURATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "subsConfiguration.groupId = ?";

	public SubsConfigurationPersistenceImpl() {
		setModelClass(SubsConfiguration.class);
	}

	/**
	 * Caches the subs configuration in the entity cache if it is enabled.
	 *
	 * @param subsConfiguration the subs configuration
	 */
	@Override
	public void cacheResult(SubsConfiguration subsConfiguration) {
		EntityCacheUtil.putResult(SubsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SubsConfigurationImpl.class, subsConfiguration.getPrimaryKey(),
			subsConfiguration);

		subsConfiguration.resetOriginalValues();
	}

	/**
	 * Caches the subs configurations in the entity cache if it is enabled.
	 *
	 * @param subsConfigurations the subs configurations
	 */
	@Override
	public void cacheResult(List<SubsConfiguration> subsConfigurations) {
		for (SubsConfiguration subsConfiguration : subsConfigurations) {
			if (EntityCacheUtil.getResult(
						SubsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						SubsConfigurationImpl.class,
						subsConfiguration.getPrimaryKey()) == null) {
				cacheResult(subsConfiguration);
			}
			else {
				subsConfiguration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all subs configurations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SubsConfigurationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SubsConfigurationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the subs configuration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SubsConfiguration subsConfiguration) {
		EntityCacheUtil.removeResult(SubsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SubsConfigurationImpl.class, subsConfiguration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SubsConfiguration> subsConfigurations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SubsConfiguration subsConfiguration : subsConfigurations) {
			EntityCacheUtil.removeResult(SubsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				SubsConfigurationImpl.class, subsConfiguration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new subs configuration with the primary key. Does not add the subs configuration to the database.
	 *
	 * @param configurationId the primary key for the new subs configuration
	 * @return the new subs configuration
	 */
	@Override
	public SubsConfiguration create(long configurationId) {
		SubsConfiguration subsConfiguration = new SubsConfigurationImpl();

		subsConfiguration.setNew(true);
		subsConfiguration.setPrimaryKey(configurationId);

		return subsConfiguration;
	}

	/**
	 * Removes the subs configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configurationId the primary key of the subs configuration
	 * @return the subs configuration that was removed
	 * @throws com.alain.monetizacion.NoSuchSubsConfigurationException if a subs configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubsConfiguration remove(long configurationId)
		throws NoSuchSubsConfigurationException, SystemException {
		return remove((Serializable)configurationId);
	}

	/**
	 * Removes the subs configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subs configuration
	 * @return the subs configuration that was removed
	 * @throws com.alain.monetizacion.NoSuchSubsConfigurationException if a subs configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubsConfiguration remove(Serializable primaryKey)
		throws NoSuchSubsConfigurationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SubsConfiguration subsConfiguration = (SubsConfiguration)session.get(SubsConfigurationImpl.class,
					primaryKey);

			if (subsConfiguration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubsConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(subsConfiguration);
		}
		catch (NoSuchSubsConfigurationException nsee) {
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
	protected SubsConfiguration removeImpl(SubsConfiguration subsConfiguration)
		throws SystemException {
		subsConfiguration = toUnwrappedModel(subsConfiguration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subsConfiguration)) {
				subsConfiguration = (SubsConfiguration)session.get(SubsConfigurationImpl.class,
						subsConfiguration.getPrimaryKeyObj());
			}

			if (subsConfiguration != null) {
				session.delete(subsConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (subsConfiguration != null) {
			clearCache(subsConfiguration);
		}

		return subsConfiguration;
	}

	@Override
	public SubsConfiguration updateImpl(
		com.alain.monetizacion.model.SubsConfiguration subsConfiguration)
		throws SystemException {
		subsConfiguration = toUnwrappedModel(subsConfiguration);

		boolean isNew = subsConfiguration.isNew();

		SubsConfigurationModelImpl subsConfigurationModelImpl = (SubsConfigurationModelImpl)subsConfiguration;

		Session session = null;

		try {
			session = openSession();

			if (subsConfiguration.isNew()) {
				session.save(subsConfiguration);

				subsConfiguration.setNew(false);
			}
			else {
				session.merge(subsConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SubsConfigurationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((subsConfigurationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						subsConfigurationModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { subsConfigurationModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(SubsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			SubsConfigurationImpl.class, subsConfiguration.getPrimaryKey(),
			subsConfiguration);

		return subsConfiguration;
	}

	protected SubsConfiguration toUnwrappedModel(
		SubsConfiguration subsConfiguration) {
		if (subsConfiguration instanceof SubsConfigurationImpl) {
			return subsConfiguration;
		}

		SubsConfigurationImpl subsConfigurationImpl = new SubsConfigurationImpl();

		subsConfigurationImpl.setNew(subsConfiguration.isNew());
		subsConfigurationImpl.setPrimaryKey(subsConfiguration.getPrimaryKey());

		subsConfigurationImpl.setConfigurationId(subsConfiguration.getConfigurationId());
		subsConfigurationImpl.setGroupId(subsConfiguration.getGroupId());
		subsConfigurationImpl.setDescription(subsConfiguration.getDescription());
		subsConfigurationImpl.setAmount(subsConfiguration.getAmount());
		subsConfigurationImpl.setCycle(subsConfiguration.getCycle());
		subsConfigurationImpl.setTime(subsConfiguration.getTime());

		return subsConfigurationImpl;
	}

	/**
	 * Returns the subs configuration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the subs configuration
	 * @return the subs configuration
	 * @throws com.alain.monetizacion.NoSuchSubsConfigurationException if a subs configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubsConfiguration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubsConfigurationException, SystemException {
		SubsConfiguration subsConfiguration = fetchByPrimaryKey(primaryKey);

		if (subsConfiguration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubsConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return subsConfiguration;
	}

	/**
	 * Returns the subs configuration with the primary key or throws a {@link com.alain.monetizacion.NoSuchSubsConfigurationException} if it could not be found.
	 *
	 * @param configurationId the primary key of the subs configuration
	 * @return the subs configuration
	 * @throws com.alain.monetizacion.NoSuchSubsConfigurationException if a subs configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubsConfiguration findByPrimaryKey(long configurationId)
		throws NoSuchSubsConfigurationException, SystemException {
		return findByPrimaryKey((Serializable)configurationId);
	}

	/**
	 * Returns the subs configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subs configuration
	 * @return the subs configuration, or <code>null</code> if a subs configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubsConfiguration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SubsConfiguration subsConfiguration = (SubsConfiguration)EntityCacheUtil.getResult(SubsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				SubsConfigurationImpl.class, primaryKey);

		if (subsConfiguration == _nullSubsConfiguration) {
			return null;
		}

		if (subsConfiguration == null) {
			Session session = null;

			try {
				session = openSession();

				subsConfiguration = (SubsConfiguration)session.get(SubsConfigurationImpl.class,
						primaryKey);

				if (subsConfiguration != null) {
					cacheResult(subsConfiguration);
				}
				else {
					EntityCacheUtil.putResult(SubsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						SubsConfigurationImpl.class, primaryKey,
						_nullSubsConfiguration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SubsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
					SubsConfigurationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return subsConfiguration;
	}

	/**
	 * Returns the subs configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configurationId the primary key of the subs configuration
	 * @return the subs configuration, or <code>null</code> if a subs configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubsConfiguration fetchByPrimaryKey(long configurationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)configurationId);
	}

	/**
	 * Returns all the subs configurations.
	 *
	 * @return the subs configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubsConfiguration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subs configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.SubsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subs configurations
	 * @param end the upper bound of the range of subs configurations (not inclusive)
	 * @return the range of subs configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubsConfiguration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the subs configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.SubsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subs configurations
	 * @param end the upper bound of the range of subs configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subs configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubsConfiguration> findAll(int start, int end,
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

		List<SubsConfiguration> list = (List<SubsConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBSCONFIGURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBSCONFIGURATION;

				if (pagination) {
					sql = sql.concat(SubsConfigurationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SubsConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubsConfiguration>(list);
				}
				else {
					list = (List<SubsConfiguration>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the subs configurations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SubsConfiguration subsConfiguration : findAll()) {
			remove(subsConfiguration);
		}
	}

	/**
	 * Returns the number of subs configurations.
	 *
	 * @return the number of subs configurations
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

				Query q = session.createQuery(_SQL_COUNT_SUBSCONFIGURATION);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the subs configuration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.alain.monetizacion.model.SubsConfiguration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SubsConfiguration>> listenersList = new ArrayList<ModelListener<SubsConfiguration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SubsConfiguration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SubsConfigurationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUBSCONFIGURATION = "SELECT subsConfiguration FROM SubsConfiguration subsConfiguration";
	private static final String _SQL_SELECT_SUBSCONFIGURATION_WHERE = "SELECT subsConfiguration FROM SubsConfiguration subsConfiguration WHERE ";
	private static final String _SQL_COUNT_SUBSCONFIGURATION = "SELECT COUNT(subsConfiguration) FROM SubsConfiguration subsConfiguration";
	private static final String _SQL_COUNT_SUBSCONFIGURATION_WHERE = "SELECT COUNT(subsConfiguration) FROM SubsConfiguration subsConfiguration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "subsConfiguration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SubsConfiguration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SubsConfiguration exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SubsConfigurationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"time"
			});
	private static SubsConfiguration _nullSubsConfiguration = new SubsConfigurationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SubsConfiguration> toCacheModel() {
				return _nullSubsConfigurationCacheModel;
			}
		};

	private static CacheModel<SubsConfiguration> _nullSubsConfigurationCacheModel =
		new CacheModel<SubsConfiguration>() {
			@Override
			public SubsConfiguration toEntityModel() {
				return _nullSubsConfiguration;
			}
		};
}