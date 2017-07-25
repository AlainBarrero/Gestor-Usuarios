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

package com.alain.monetizacion.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Subscription. This utility wraps
 * {@link com.alain.monetizacion.service.impl.SubscriptionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Alain
 * @see SubscriptionLocalService
 * @see com.alain.monetizacion.service.base.SubscriptionLocalServiceBaseImpl
 * @see com.alain.monetizacion.service.impl.SubscriptionLocalServiceImpl
 * @generated
 */
public class SubscriptionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.alain.monetizacion.service.impl.SubscriptionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the subscription to the database. Also notifies the appropriate model listeners.
	*
	* @param subscription the subscription
	* @return the subscription that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Subscription addSubscription(
		com.alain.monetizacion.model.Subscription subscription)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSubscription(subscription);
	}

	/**
	* Creates a new subscription with the primary key. Does not add the subscription to the database.
	*
	* @param subscriptionId the primary key for the new subscription
	* @return the new subscription
	*/
	public static com.alain.monetizacion.model.Subscription createSubscription(
		long subscriptionId) {
		return getService().createSubscription(subscriptionId);
	}

	/**
	* Deletes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subscriptionId the primary key of the subscription
	* @return the subscription that was removed
	* @throws PortalException if a subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Subscription deleteSubscription(
		long subscriptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSubscription(subscriptionId);
	}

	/**
	* Deletes the subscription from the database. Also notifies the appropriate model listeners.
	*
	* @param subscription the subscription
	* @return the subscription that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Subscription deleteSubscription(
		com.alain.monetizacion.model.Subscription subscription)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSubscription(subscription);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.SubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.SubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.alain.monetizacion.model.Subscription fetchSubscription(
		long subscriptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSubscription(subscriptionId);
	}

	/**
	* Returns the subscription with the primary key.
	*
	* @param subscriptionId the primary key of the subscription
	* @return the subscription
	* @throws PortalException if a subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws com.alain.monetizacion.NoSuchSubscriptionException
	*/
	public static com.alain.monetizacion.model.Subscription getSubscription(
		long subscriptionId)
		throws com.alain.monetizacion.NoSuchSubscriptionException,
			com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubscription(subscriptionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.alain.monetizacion.model.Subscription> getSubscriptions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubscriptions(start, end);
	}

	/**
	* Returns the number of subscriptions.
	*
	* @return the number of subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int getSubscriptionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubscriptionsCount();
	}

	/**
	* Updates the subscription in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param subscription the subscription
	* @return the subscription that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Subscription updateSubscription(
		com.alain.monetizacion.model.Subscription subscription)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSubscription(subscription);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.alain.monetizacion.model.Subscription> findByUserId(
		long userId)
		throws com.alain.monetizacion.NoSuchSubsConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUserId(userId);
	}

	public static com.alain.monetizacion.model.Subscription addSubscription(
		long configurationId, long userId, java.util.Date expireDate,
		double payment, java.lang.String paypalProfile)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSubscription(configurationId, userId, expireDate,
			payment, paypalProfile);
	}

	public static com.alain.monetizacion.model.Subscription updateSbscriptionExpireDate(
		long subscriptionId, java.util.Date newExpireDate) {
		return getService()
				   .updateSbscriptionExpireDate(subscriptionId, newExpireDate);
	}

	public static java.util.List<com.alain.monetizacion.model.Subscription> deleteSubcriptionUser(
		java.lang.String users)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSubcriptionUser(users);
	}

	public static java.util.List<com.alain.monetizacion.model.Subscription> findByConfigurationId(
		long configurationId)
		throws com.alain.monetizacion.NoSuchSubsConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByConfigurationId(configurationId);
	}

	public static com.alain.monetizacion.model.Subscription updateUserActivation(
		long subscriptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserActivation(subscriptionId);
	}

	public static com.alain.monetizacion.model.Subscription updateUserReactivation(
		long subscriptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserReactivation(subscriptionId);
	}

	public static java.util.List<com.alain.monetizacion.model.Subscription> getAllSubscriptions() {
		return getService().getAllSubscriptions();
	}

	public static com.alain.monetizacion.model.Subscription getSubscriptionIntoConfiguration(
		long userId,
		java.util.List<com.alain.monetizacion.model.Subscription> subList) {
		return getService().getSubscriptionIntoConfiguration(userId, subList);
	}

	public static void clearService() {
		_service = null;
	}

	public static SubscriptionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SubscriptionLocalService.class.getName());

			if (invokableLocalService instanceof SubscriptionLocalService) {
				_service = (SubscriptionLocalService)invokableLocalService;
			}
			else {
				_service = new SubscriptionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SubscriptionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SubscriptionLocalService service) {
	}

	private static SubscriptionLocalService _service;
}