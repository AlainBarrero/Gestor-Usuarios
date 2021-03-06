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

package com.alain.monetizacion.service.base;

import com.alain.monetizacion.model.Subscription;
import com.alain.monetizacion.service.SubscriptionLocalService;
import com.alain.monetizacion.service.persistence.PayPalPersistence;
import com.alain.monetizacion.service.persistence.Role_ConfigPersistence;
import com.alain.monetizacion.service.persistence.SubsConfigurationPersistence;
import com.alain.monetizacion.service.persistence.SubscriptionPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the subscription local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.alain.monetizacion.service.impl.SubscriptionLocalServiceImpl}.
 * </p>
 *
 * @author Alain
 * @see com.alain.monetizacion.service.impl.SubscriptionLocalServiceImpl
 * @see com.alain.monetizacion.service.SubscriptionLocalServiceUtil
 * @generated
 */
public abstract class SubscriptionLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SubscriptionLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.alain.monetizacion.service.SubscriptionLocalServiceUtil} to access the subscription local service.
	 */

	/**
	 * Adds the subscription to the database. Also notifies the appropriate model listeners.
	 *
	 * @param subscription the subscription
	 * @return the subscription that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Subscription addSubscription(Subscription subscription)
		throws SystemException {
		subscription.setNew(true);

		return subscriptionPersistence.update(subscription);
	}

	/**
	 * Creates a new subscription with the primary key. Does not add the subscription to the database.
	 *
	 * @param subscriptionId the primary key for the new subscription
	 * @return the new subscription
	 */
	@Override
	public Subscription createSubscription(long subscriptionId) {
		return subscriptionPersistence.create(subscriptionId);
	}

	/**
	 * Deletes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subscriptionId the primary key of the subscription
	 * @return the subscription that was removed
	 * @throws PortalException if a subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Subscription deleteSubscription(long subscriptionId)
		throws PortalException, SystemException {
		return subscriptionPersistence.remove(subscriptionId);
	}

	/**
	 * Deletes the subscription from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subscription the subscription
	 * @return the subscription that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Subscription deleteSubscription(Subscription subscription)
		throws SystemException {
		return subscriptionPersistence.remove(subscription);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Subscription.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return subscriptionPersistence.findWithDynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return subscriptionPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return subscriptionPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return subscriptionPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return subscriptionPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Subscription fetchSubscription(long subscriptionId)
		throws SystemException {
		return subscriptionPersistence.fetchByPrimaryKey(subscriptionId);
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
	@Override
	public Subscription getSubscription(long subscriptionId)
		throws PortalException, SystemException,
			com.alain.monetizacion.NoSuchSubscriptionException {
		return subscriptionPersistence.findByPrimaryKey(subscriptionId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return subscriptionPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<Subscription> getSubscriptions(int start, int end)
		throws SystemException {
		return subscriptionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of subscriptions.
	 *
	 * @return the number of subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSubscriptionsCount() throws SystemException {
		return subscriptionPersistence.countAll();
	}

	/**
	 * Updates the subscription in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param subscription the subscription
	 * @return the subscription that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Subscription updateSubscription(Subscription subscription)
		throws SystemException {
		return subscriptionPersistence.update(subscription);
	}

	/**
	 * Returns the pay pal local service.
	 *
	 * @return the pay pal local service
	 */
	public com.alain.monetizacion.service.PayPalLocalService getPayPalLocalService() {
		return payPalLocalService;
	}

	/**
	 * Sets the pay pal local service.
	 *
	 * @param payPalLocalService the pay pal local service
	 */
	public void setPayPalLocalService(
		com.alain.monetizacion.service.PayPalLocalService payPalLocalService) {
		this.payPalLocalService = payPalLocalService;
	}

	/**
	 * Returns the pay pal persistence.
	 *
	 * @return the pay pal persistence
	 */
	public PayPalPersistence getPayPalPersistence() {
		return payPalPersistence;
	}

	/**
	 * Sets the pay pal persistence.
	 *
	 * @param payPalPersistence the pay pal persistence
	 */
	public void setPayPalPersistence(PayPalPersistence payPalPersistence) {
		this.payPalPersistence = payPalPersistence;
	}

	/**
	 * Returns the role_ config local service.
	 *
	 * @return the role_ config local service
	 */
	public com.alain.monetizacion.service.Role_ConfigLocalService getRole_ConfigLocalService() {
		return role_ConfigLocalService;
	}

	/**
	 * Sets the role_ config local service.
	 *
	 * @param role_ConfigLocalService the role_ config local service
	 */
	public void setRole_ConfigLocalService(
		com.alain.monetizacion.service.Role_ConfigLocalService role_ConfigLocalService) {
		this.role_ConfigLocalService = role_ConfigLocalService;
	}

	/**
	 * Returns the role_ config persistence.
	 *
	 * @return the role_ config persistence
	 */
	public Role_ConfigPersistence getRole_ConfigPersistence() {
		return role_ConfigPersistence;
	}

	/**
	 * Sets the role_ config persistence.
	 *
	 * @param role_ConfigPersistence the role_ config persistence
	 */
	public void setRole_ConfigPersistence(
		Role_ConfigPersistence role_ConfigPersistence) {
		this.role_ConfigPersistence = role_ConfigPersistence;
	}

	/**
	 * Returns the subs configuration local service.
	 *
	 * @return the subs configuration local service
	 */
	public com.alain.monetizacion.service.SubsConfigurationLocalService getSubsConfigurationLocalService() {
		return subsConfigurationLocalService;
	}

	/**
	 * Sets the subs configuration local service.
	 *
	 * @param subsConfigurationLocalService the subs configuration local service
	 */
	public void setSubsConfigurationLocalService(
		com.alain.monetizacion.service.SubsConfigurationLocalService subsConfigurationLocalService) {
		this.subsConfigurationLocalService = subsConfigurationLocalService;
	}

	/**
	 * Returns the subs configuration persistence.
	 *
	 * @return the subs configuration persistence
	 */
	public SubsConfigurationPersistence getSubsConfigurationPersistence() {
		return subsConfigurationPersistence;
	}

	/**
	 * Sets the subs configuration persistence.
	 *
	 * @param subsConfigurationPersistence the subs configuration persistence
	 */
	public void setSubsConfigurationPersistence(
		SubsConfigurationPersistence subsConfigurationPersistence) {
		this.subsConfigurationPersistence = subsConfigurationPersistence;
	}

	/**
	 * Returns the subscription local service.
	 *
	 * @return the subscription local service
	 */
	public com.alain.monetizacion.service.SubscriptionLocalService getSubscriptionLocalService() {
		return subscriptionLocalService;
	}

	/**
	 * Sets the subscription local service.
	 *
	 * @param subscriptionLocalService the subscription local service
	 */
	public void setSubscriptionLocalService(
		com.alain.monetizacion.service.SubscriptionLocalService subscriptionLocalService) {
		this.subscriptionLocalService = subscriptionLocalService;
	}

	/**
	 * Returns the subscription persistence.
	 *
	 * @return the subscription persistence
	 */
	public SubscriptionPersistence getSubscriptionPersistence() {
		return subscriptionPersistence;
	}

	/**
	 * Sets the subscription persistence.
	 *
	 * @param subscriptionPersistence the subscription persistence
	 */
	public void setSubscriptionPersistence(
		SubscriptionPersistence subscriptionPersistence) {
		this.subscriptionPersistence = subscriptionPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.alain.monetizacion.model.Subscription",
			subscriptionLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.alain.monetizacion.model.Subscription");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Subscription.class;
	}

	protected String getModelClassName() {
		return Subscription.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = subscriptionPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.alain.monetizacion.service.PayPalLocalService.class)
	protected com.alain.monetizacion.service.PayPalLocalService payPalLocalService;
	@BeanReference(type = PayPalPersistence.class)
	protected PayPalPersistence payPalPersistence;
	@BeanReference(type = com.alain.monetizacion.service.Role_ConfigLocalService.class)
	protected com.alain.monetizacion.service.Role_ConfigLocalService role_ConfigLocalService;
	@BeanReference(type = Role_ConfigPersistence.class)
	protected Role_ConfigPersistence role_ConfigPersistence;
	@BeanReference(type = com.alain.monetizacion.service.SubsConfigurationLocalService.class)
	protected com.alain.monetizacion.service.SubsConfigurationLocalService subsConfigurationLocalService;
	@BeanReference(type = SubsConfigurationPersistence.class)
	protected SubsConfigurationPersistence subsConfigurationPersistence;
	@BeanReference(type = com.alain.monetizacion.service.SubscriptionLocalService.class)
	protected com.alain.monetizacion.service.SubscriptionLocalService subscriptionLocalService;
	@BeanReference(type = SubscriptionPersistence.class)
	protected SubscriptionPersistence subscriptionPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SubscriptionLocalServiceClpInvoker _clpInvoker = new SubscriptionLocalServiceClpInvoker();
}