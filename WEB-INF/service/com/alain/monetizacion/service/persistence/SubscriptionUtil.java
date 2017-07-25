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

import com.alain.monetizacion.model.Subscription;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the subscription service. This utility wraps {@link SubscriptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alain
 * @see SubscriptionPersistence
 * @see SubscriptionPersistenceImpl
 * @generated
 */
public class SubscriptionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Subscription subscription) {
		getPersistence().clearCache(subscription);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Subscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Subscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Subscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Subscription update(Subscription subscription)
		throws SystemException {
		return getPersistence().update(subscription);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Subscription update(Subscription subscription,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(subscription, serviceContext);
	}

	/**
	* Returns all the subscriptions where configurationId = &#63;.
	*
	* @param configurationId the configuration ID
	* @return the matching subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.alain.monetizacion.model.Subscription> findByconfigurationId(
		long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByconfigurationId(configurationId);
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
	public static java.util.List<com.alain.monetizacion.model.Subscription> findByconfigurationId(
		long configurationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByconfigurationId(configurationId, start, end);
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
	public static java.util.List<com.alain.monetizacion.model.Subscription> findByconfigurationId(
		long configurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByconfigurationId(configurationId, start, end,
			orderByComparator);
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
	public static com.alain.monetizacion.model.Subscription findByconfigurationId_First(
		long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchSubscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByconfigurationId_First(configurationId,
			orderByComparator);
	}

	/**
	* Returns the first subscription in the ordered set where configurationId = &#63;.
	*
	* @param configurationId the configuration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Subscription fetchByconfigurationId_First(
		long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByconfigurationId_First(configurationId,
			orderByComparator);
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
	public static com.alain.monetizacion.model.Subscription findByconfigurationId_Last(
		long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchSubscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByconfigurationId_Last(configurationId,
			orderByComparator);
	}

	/**
	* Returns the last subscription in the ordered set where configurationId = &#63;.
	*
	* @param configurationId the configuration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Subscription fetchByconfigurationId_Last(
		long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByconfigurationId_Last(configurationId,
			orderByComparator);
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
	public static com.alain.monetizacion.model.Subscription[] findByconfigurationId_PrevAndNext(
		long subscriptionId, long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchSubscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByconfigurationId_PrevAndNext(subscriptionId,
			configurationId, orderByComparator);
	}

	/**
	* Removes all the subscriptions where configurationId = &#63; from the database.
	*
	* @param configurationId the configuration ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByconfigurationId(long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByconfigurationId(configurationId);
	}

	/**
	* Returns the number of subscriptions where configurationId = &#63;.
	*
	* @param configurationId the configuration ID
	* @return the number of matching subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByconfigurationId(long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByconfigurationId(configurationId);
	}

	/**
	* Returns all the subscriptions where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.alain.monetizacion.model.Subscription> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId(userId);
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
	public static java.util.List<com.alain.monetizacion.model.Subscription> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId(userId, start, end);
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
	public static java.util.List<com.alain.monetizacion.model.Subscription> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator);
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
	public static com.alain.monetizacion.model.Subscription findByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchSubscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first subscription in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Subscription fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserId_First(userId, orderByComparator);
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
	public static com.alain.monetizacion.model.Subscription findByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchSubscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last subscription in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Subscription fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
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
	public static com.alain.monetizacion.model.Subscription[] findByuserId_PrevAndNext(
		long subscriptionId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchSubscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserId_PrevAndNext(subscriptionId, userId,
			orderByComparator);
	}

	/**
	* Removes all the subscriptions where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByuserId(userId);
	}

	/**
	* Returns the number of subscriptions where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Caches the subscription in the entity cache if it is enabled.
	*
	* @param subscription the subscription
	*/
	public static void cacheResult(
		com.alain.monetizacion.model.Subscription subscription) {
		getPersistence().cacheResult(subscription);
	}

	/**
	* Caches the subscriptions in the entity cache if it is enabled.
	*
	* @param subscriptions the subscriptions
	*/
	public static void cacheResult(
		java.util.List<com.alain.monetizacion.model.Subscription> subscriptions) {
		getPersistence().cacheResult(subscriptions);
	}

	/**
	* Creates a new subscription with the primary key. Does not add the subscription to the database.
	*
	* @param subscriptionId the primary key for the new subscription
	* @return the new subscription
	*/
	public static com.alain.monetizacion.model.Subscription create(
		long subscriptionId) {
		return getPersistence().create(subscriptionId);
	}

	/**
	* Removes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subscriptionId the primary key of the subscription
	* @return the subscription that was removed
	* @throws com.alain.monetizacion.NoSuchSubscriptionException if a subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Subscription remove(
		long subscriptionId)
		throws com.alain.monetizacion.NoSuchSubscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(subscriptionId);
	}

	public static com.alain.monetizacion.model.Subscription updateImpl(
		com.alain.monetizacion.model.Subscription subscription)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(subscription);
	}

	/**
	* Returns the subscription with the primary key or throws a {@link com.alain.monetizacion.NoSuchSubscriptionException} if it could not be found.
	*
	* @param subscriptionId the primary key of the subscription
	* @return the subscription
	* @throws com.alain.monetizacion.NoSuchSubscriptionException if a subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Subscription findByPrimaryKey(
		long subscriptionId)
		throws com.alain.monetizacion.NoSuchSubscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(subscriptionId);
	}

	/**
	* Returns the subscription with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subscriptionId the primary key of the subscription
	* @return the subscription, or <code>null</code> if a subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Subscription fetchByPrimaryKey(
		long subscriptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(subscriptionId);
	}

	/**
	* Returns all the subscriptions.
	*
	* @return the subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.alain.monetizacion.model.Subscription> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.alain.monetizacion.model.Subscription> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.alain.monetizacion.model.Subscription> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the subscriptions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of subscriptions.
	*
	* @return the number of subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SubscriptionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SubscriptionPersistence)PortletBeanLocatorUtil.locate(com.alain.monetizacion.service.ClpSerializer.getServletContextName(),
					SubscriptionPersistence.class.getName());

			ReferenceRegistry.registerReference(SubscriptionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SubscriptionPersistence persistence) {
	}

	private static SubscriptionPersistence _persistence;
}