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

import com.alain.monetizacion.NoSuchSubscriptionException;
import com.alain.monetizacion.model.Subscription;
import com.alain.monetizacion.model.impl.SubscriptionImpl;
import com.alain.monetizacion.model.impl.SubscriptionModelImpl;

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
 * The persistence implementation for the subscription service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alain
 * @see SubscriptionPersistence
 * @see SubscriptionUtil
 * @generated
 */
public class SubscriptionPersistenceImpl extends BasePersistenceImpl<Subscription>
	implements SubscriptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubscriptionUtil} to access the subscription persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubscriptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionModelImpl.FINDER_CACHE_ENABLED, SubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionModelImpl.FINDER_CACHE_ENABLED, SubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONFIGURATIONID =
		new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionModelImpl.FINDER_CACHE_ENABLED, SubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByconfigurationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGURATIONID =
		new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionModelImpl.FINDER_CACHE_ENABLED, SubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByconfigurationId",
			new String[] { Long.class.getName() },
			SubscriptionModelImpl.CONFIGURATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONFIGURATIONID = new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByconfigurationId", new String[] { Long.class.getName() });

	/**
	 * Returns all the subscriptions where configurationId = &#63;.
	 *
	 * @param configurationId the configuration ID
	 * @return the matching subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subscription> findByconfigurationId(long configurationId)
		throws SystemException {
		return findByconfigurationId(configurationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subscriptions where configurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.SubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param configurationId the configuration ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @return the range of matching subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subscription> findByconfigurationId(long configurationId,
		int start, int end) throws SystemException {
		return findByconfigurationId(configurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the subscriptions where configurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.SubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param configurationId the configuration ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subscription> findByconfigurationId(long configurationId,
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

		List<Subscription> list = (List<Subscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Subscription subscription : list) {
				if ((configurationId != subscription.getConfigurationId())) {
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

			query.append(_SQL_SELECT_SUBSCRIPTION_WHERE);

			query.append(_FINDER_COLUMN_CONFIGURATIONID_CONFIGURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(configurationId);

				if (!pagination) {
					list = (List<Subscription>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Subscription>(list);
				}
				else {
					list = (List<Subscription>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first subscription in the ordered set where configurationId = &#63;.
	 *
	 * @param configurationId the configuration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription
	 * @throws com.alain.monetizacion.NoSuchSubscriptionException if a matching subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription findByconfigurationId_First(long configurationId,
		OrderByComparator orderByComparator)
		throws NoSuchSubscriptionException, SystemException {
		Subscription subscription = fetchByconfigurationId_First(configurationId,
				orderByComparator);

		if (subscription != null) {
			return subscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("configurationId=");
		msg.append(configurationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubscriptionException(msg.toString());
	}

	/**
	 * Returns the first subscription in the ordered set where configurationId = &#63;.
	 *
	 * @param configurationId the configuration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription fetchByconfigurationId_First(long configurationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Subscription> list = findByconfigurationId(configurationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last subscription in the ordered set where configurationId = &#63;.
	 *
	 * @param configurationId the configuration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription
	 * @throws com.alain.monetizacion.NoSuchSubscriptionException if a matching subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription findByconfigurationId_Last(long configurationId,
		OrderByComparator orderByComparator)
		throws NoSuchSubscriptionException, SystemException {
		Subscription subscription = fetchByconfigurationId_Last(configurationId,
				orderByComparator);

		if (subscription != null) {
			return subscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("configurationId=");
		msg.append(configurationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubscriptionException(msg.toString());
	}

	/**
	 * Returns the last subscription in the ordered set where configurationId = &#63;.
	 *
	 * @param configurationId the configuration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription fetchByconfigurationId_Last(long configurationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByconfigurationId(configurationId);

		if (count == 0) {
			return null;
		}

		List<Subscription> list = findByconfigurationId(configurationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the subscriptions before and after the current subscription in the ordered set where configurationId = &#63;.
	 *
	 * @param subscriptionId the primary key of the current subscription
	 * @param configurationId the configuration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subscription
	 * @throws com.alain.monetizacion.NoSuchSubscriptionException if a subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription[] findByconfigurationId_PrevAndNext(
		long subscriptionId, long configurationId,
		OrderByComparator orderByComparator)
		throws NoSuchSubscriptionException, SystemException {
		Subscription subscription = findByPrimaryKey(subscriptionId);

		Session session = null;

		try {
			session = openSession();

			Subscription[] array = new SubscriptionImpl[3];

			array[0] = getByconfigurationId_PrevAndNext(session, subscription,
					configurationId, orderByComparator, true);

			array[1] = subscription;

			array[2] = getByconfigurationId_PrevAndNext(session, subscription,
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

	protected Subscription getByconfigurationId_PrevAndNext(Session session,
		Subscription subscription, long configurationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBSCRIPTION_WHERE);

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
			query.append(SubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(configurationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(subscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Subscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subscriptions where configurationId = &#63; from the database.
	 *
	 * @param configurationId the configuration ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByconfigurationId(long configurationId)
		throws SystemException {
		for (Subscription subscription : findByconfigurationId(
				configurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(subscription);
		}
	}

	/**
	 * Returns the number of subscriptions where configurationId = &#63;.
	 *
	 * @param configurationId the configuration ID
	 * @return the number of matching subscriptions
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

			query.append(_SQL_COUNT_SUBSCRIPTION_WHERE);

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
		"subscription.configurationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionModelImpl.FINDER_CACHE_ENABLED, SubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionModelImpl.FINDER_CACHE_ENABLED, SubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			SubscriptionModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the subscriptions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subscription> findByuserId(long userId)
		throws SystemException {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subscriptions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.SubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @return the range of matching subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subscription> findByuserId(long userId, int start, int end)
		throws SystemException {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the subscriptions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.SubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subscription> findByuserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Subscription> list = (List<Subscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Subscription subscription : list) {
				if ((userId != subscription.getUserId())) {
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

			query.append(_SQL_SELECT_SUBSCRIPTION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Subscription>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Subscription>(list);
				}
				else {
					list = (List<Subscription>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription
	 * @throws com.alain.monetizacion.NoSuchSubscriptionException if a matching subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription findByuserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSubscriptionException, SystemException {
		Subscription subscription = fetchByuserId_First(userId,
				orderByComparator);

		if (subscription != null) {
			return subscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubscriptionException(msg.toString());
	}

	/**
	 * Returns the first subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription fetchByuserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Subscription> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription
	 * @throws com.alain.monetizacion.NoSuchSubscriptionException if a matching subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription findByuserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSubscriptionException, SystemException {
		Subscription subscription = fetchByuserId_Last(userId, orderByComparator);

		if (subscription != null) {
			return subscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubscriptionException(msg.toString());
	}

	/**
	 * Returns the last subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription fetchByuserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Subscription> list = findByuserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the subscriptions before and after the current subscription in the ordered set where userId = &#63;.
	 *
	 * @param subscriptionId the primary key of the current subscription
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subscription
	 * @throws com.alain.monetizacion.NoSuchSubscriptionException if a subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription[] findByuserId_PrevAndNext(long subscriptionId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchSubscriptionException, SystemException {
		Subscription subscription = findByPrimaryKey(subscriptionId);

		Session session = null;

		try {
			session = openSession();

			Subscription[] array = new SubscriptionImpl[3];

			array[0] = getByuserId_PrevAndNext(session, subscription, userId,
					orderByComparator, true);

			array[1] = subscription;

			array[2] = getByuserId_PrevAndNext(session, subscription, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Subscription getByuserId_PrevAndNext(Session session,
		Subscription subscription, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBSCRIPTION_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(SubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(subscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Subscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subscriptions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserId(long userId) throws SystemException {
		for (Subscription subscription : findByuserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(subscription);
		}
	}

	/**
	 * Returns the number of subscriptions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBSCRIPTION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "subscription.userId = ?";

	public SubscriptionPersistenceImpl() {
		setModelClass(Subscription.class);
	}

	/**
	 * Caches the subscription in the entity cache if it is enabled.
	 *
	 * @param subscription the subscription
	 */
	@Override
	public void cacheResult(Subscription subscription) {
		EntityCacheUtil.putResult(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionImpl.class, subscription.getPrimaryKey(), subscription);

		subscription.resetOriginalValues();
	}

	/**
	 * Caches the subscriptions in the entity cache if it is enabled.
	 *
	 * @param subscriptions the subscriptions
	 */
	@Override
	public void cacheResult(List<Subscription> subscriptions) {
		for (Subscription subscription : subscriptions) {
			if (EntityCacheUtil.getResult(
						SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
						SubscriptionImpl.class, subscription.getPrimaryKey()) == null) {
				cacheResult(subscription);
			}
			else {
				subscription.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all subscriptions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SubscriptionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SubscriptionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the subscription.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Subscription subscription) {
		EntityCacheUtil.removeResult(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionImpl.class, subscription.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Subscription> subscriptions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Subscription subscription : subscriptions) {
			EntityCacheUtil.removeResult(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
				SubscriptionImpl.class, subscription.getPrimaryKey());
		}
	}

	/**
	 * Creates a new subscription with the primary key. Does not add the subscription to the database.
	 *
	 * @param subscriptionId the primary key for the new subscription
	 * @return the new subscription
	 */
	@Override
	public Subscription create(long subscriptionId) {
		Subscription subscription = new SubscriptionImpl();

		subscription.setNew(true);
		subscription.setPrimaryKey(subscriptionId);

		return subscription;
	}

	/**
	 * Removes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subscriptionId the primary key of the subscription
	 * @return the subscription that was removed
	 * @throws com.alain.monetizacion.NoSuchSubscriptionException if a subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription remove(long subscriptionId)
		throws NoSuchSubscriptionException, SystemException {
		return remove((Serializable)subscriptionId);
	}

	/**
	 * Removes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subscription
	 * @return the subscription that was removed
	 * @throws com.alain.monetizacion.NoSuchSubscriptionException if a subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription remove(Serializable primaryKey)
		throws NoSuchSubscriptionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Subscription subscription = (Subscription)session.get(SubscriptionImpl.class,
					primaryKey);

			if (subscription == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubscriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(subscription);
		}
		catch (NoSuchSubscriptionException nsee) {
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
	protected Subscription removeImpl(Subscription subscription)
		throws SystemException {
		subscription = toUnwrappedModel(subscription);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subscription)) {
				subscription = (Subscription)session.get(SubscriptionImpl.class,
						subscription.getPrimaryKeyObj());
			}

			if (subscription != null) {
				session.delete(subscription);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (subscription != null) {
			clearCache(subscription);
		}

		return subscription;
	}

	@Override
	public Subscription updateImpl(
		com.alain.monetizacion.model.Subscription subscription)
		throws SystemException {
		subscription = toUnwrappedModel(subscription);

		boolean isNew = subscription.isNew();

		SubscriptionModelImpl subscriptionModelImpl = (SubscriptionModelImpl)subscription;

		Session session = null;

		try {
			session = openSession();

			if (subscription.isNew()) {
				session.save(subscription);

				subscription.setNew(false);
			}
			else {
				session.merge(subscription);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SubscriptionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((subscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGURATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						subscriptionModelImpl.getOriginalConfigurationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONFIGURATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGURATIONID,
					args);

				args = new Object[] { subscriptionModelImpl.getConfigurationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONFIGURATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGURATIONID,
					args);
			}

			if ((subscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						subscriptionModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { subscriptionModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionImpl.class, subscription.getPrimaryKey(), subscription);

		return subscription;
	}

	protected Subscription toUnwrappedModel(Subscription subscription) {
		if (subscription instanceof SubscriptionImpl) {
			return subscription;
		}

		SubscriptionImpl subscriptionImpl = new SubscriptionImpl();

		subscriptionImpl.setNew(subscription.isNew());
		subscriptionImpl.setPrimaryKey(subscription.getPrimaryKey());

		subscriptionImpl.setSubscriptionId(subscription.getSubscriptionId());
		subscriptionImpl.setUserId(subscription.getUserId());
		subscriptionImpl.setCreateDate(subscription.getCreateDate());
		subscriptionImpl.setExpireDate(subscription.getExpireDate());
		subscriptionImpl.setPayment(subscription.getPayment());
		subscriptionImpl.setConfigurationId(subscription.getConfigurationId());
		subscriptionImpl.setPaypalProfile(subscription.getPaypalProfile());
		subscriptionImpl.setIsActive(subscription.isIsActive());

		return subscriptionImpl;
	}

	/**
	 * Returns the subscription with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the subscription
	 * @return the subscription
	 * @throws com.alain.monetizacion.NoSuchSubscriptionException if a subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubscriptionException, SystemException {
		Subscription subscription = fetchByPrimaryKey(primaryKey);

		if (subscription == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubscriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return subscription;
	}

	/**
	 * Returns the subscription with the primary key or throws a {@link com.alain.monetizacion.NoSuchSubscriptionException} if it could not be found.
	 *
	 * @param subscriptionId the primary key of the subscription
	 * @return the subscription
	 * @throws com.alain.monetizacion.NoSuchSubscriptionException if a subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription findByPrimaryKey(long subscriptionId)
		throws NoSuchSubscriptionException, SystemException {
		return findByPrimaryKey((Serializable)subscriptionId);
	}

	/**
	 * Returns the subscription with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subscription
	 * @return the subscription, or <code>null</code> if a subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Subscription subscription = (Subscription)EntityCacheUtil.getResult(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
				SubscriptionImpl.class, primaryKey);

		if (subscription == _nullSubscription) {
			return null;
		}

		if (subscription == null) {
			Session session = null;

			try {
				session = openSession();

				subscription = (Subscription)session.get(SubscriptionImpl.class,
						primaryKey);

				if (subscription != null) {
					cacheResult(subscription);
				}
				else {
					EntityCacheUtil.putResult(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
						SubscriptionImpl.class, primaryKey, _nullSubscription);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
					SubscriptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return subscription;
	}

	/**
	 * Returns the subscription with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subscriptionId the primary key of the subscription
	 * @return the subscription, or <code>null</code> if a subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Subscription fetchByPrimaryKey(long subscriptionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)subscriptionId);
	}

	/**
	 * Returns all the subscriptions.
	 *
	 * @return the subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subscription> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.SubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @return the range of subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subscription> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.SubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Subscription> findAll(int start, int end,
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

		List<Subscription> list = (List<Subscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBSCRIPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBSCRIPTION;

				if (pagination) {
					sql = sql.concat(SubscriptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Subscription>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Subscription>(list);
				}
				else {
					list = (List<Subscription>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the subscriptions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Subscription subscription : findAll()) {
			remove(subscription);
		}
	}

	/**
	 * Returns the number of subscriptions.
	 *
	 * @return the number of subscriptions
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

				Query q = session.createQuery(_SQL_COUNT_SUBSCRIPTION);

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
	 * Initializes the subscription persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.alain.monetizacion.model.Subscription")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Subscription>> listenersList = new ArrayList<ModelListener<Subscription>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Subscription>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SubscriptionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUBSCRIPTION = "SELECT subscription FROM Subscription subscription";
	private static final String _SQL_SELECT_SUBSCRIPTION_WHERE = "SELECT subscription FROM Subscription subscription WHERE ";
	private static final String _SQL_COUNT_SUBSCRIPTION = "SELECT COUNT(subscription) FROM Subscription subscription";
	private static final String _SQL_COUNT_SUBSCRIPTION_WHERE = "SELECT COUNT(subscription) FROM Subscription subscription WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "subscription.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Subscription exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Subscription exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SubscriptionPersistenceImpl.class);
	private static Subscription _nullSubscription = new SubscriptionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Subscription> toCacheModel() {
				return _nullSubscriptionCacheModel;
			}
		};

	private static CacheModel<Subscription> _nullSubscriptionCacheModel = new CacheModel<Subscription>() {
			@Override
			public Subscription toEntityModel() {
				return _nullSubscription;
			}
		};
}