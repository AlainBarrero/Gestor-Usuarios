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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PayPalLocalService}.
 *
 * @author Alain
 * @see PayPalLocalService
 * @generated
 */
public class PayPalLocalServiceWrapper implements PayPalLocalService,
	ServiceWrapper<PayPalLocalService> {
	public PayPalLocalServiceWrapper(PayPalLocalService payPalLocalService) {
		_payPalLocalService = payPalLocalService;
	}

	/**
	* Adds the pay pal to the database. Also notifies the appropriate model listeners.
	*
	* @param payPal the pay pal
	* @return the pay pal that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.alain.monetizacion.model.PayPal addPayPal(
		com.alain.monetizacion.model.PayPal payPal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.addPayPal(payPal);
	}

	/**
	* Creates a new pay pal with the primary key. Does not add the pay pal to the database.
	*
	* @param configurationId the primary key for the new pay pal
	* @return the new pay pal
	*/
	@Override
	public com.alain.monetizacion.model.PayPal createPayPal(
		long configurationId) {
		return _payPalLocalService.createPayPal(configurationId);
	}

	/**
	* Deletes the pay pal with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configurationId the primary key of the pay pal
	* @return the pay pal that was removed
	* @throws PortalException if a pay pal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.alain.monetizacion.model.PayPal deletePayPal(
		long configurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.deletePayPal(configurationId);
	}

	/**
	* Deletes the pay pal from the database. Also notifies the appropriate model listeners.
	*
	* @param payPal the pay pal
	* @return the pay pal that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.alain.monetizacion.model.PayPal deletePayPal(
		com.alain.monetizacion.model.PayPal payPal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.deletePayPal(payPal);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _payPalLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.PayPalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.PayPalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.alain.monetizacion.model.PayPal fetchPayPal(long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.fetchPayPal(configurationId);
	}

	/**
	* Returns the pay pal with the primary key.
	*
	* @param configurationId the primary key of the pay pal
	* @return the pay pal
	* @throws PortalException if a pay pal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.alain.monetizacion.model.PayPal getPayPal(long configurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.getPayPal(configurationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the pay pals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.PayPalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pay pals
	* @param end the upper bound of the range of pay pals (not inclusive)
	* @return the range of pay pals
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.alain.monetizacion.model.PayPal> getPayPals(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.getPayPals(start, end);
	}

	/**
	* Returns the number of pay pals.
	*
	* @return the number of pay pals
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPayPalsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.getPayPalsCount();
	}

	/**
	* Updates the pay pal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param payPal the pay pal
	* @return the pay pal that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.alain.monetizacion.model.PayPal updatePayPal(
		com.alain.monetizacion.model.PayPal payPal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.updatePayPal(payPal);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _payPalLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_payPalLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _payPalLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.alain.monetizacion.model.PayPal findByConfigurationId(
		long configurationId)
		throws com.alain.monetizacion.NoSuchPayPalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.findByConfigurationId(configurationId);
	}

	@Override
	public com.alain.monetizacion.model.PayPal updatePayPal(
		java.lang.String paypalUser, java.lang.String paypalPassword,
		java.lang.String paypalFirm, java.lang.String paypalEmail,
		com.alain.monetizacion.model.PayPal paypal)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _payPalLocalService.updatePayPal(paypalUser, paypalPassword,
			paypalFirm, paypalEmail, paypal);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PayPalLocalService getWrappedPayPalLocalService() {
		return _payPalLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPayPalLocalService(
		PayPalLocalService payPalLocalService) {
		_payPalLocalService = payPalLocalService;
	}

	@Override
	public PayPalLocalService getWrappedService() {
		return _payPalLocalService;
	}

	@Override
	public void setWrappedService(PayPalLocalService payPalLocalService) {
		_payPalLocalService = payPalLocalService;
	}

	private PayPalLocalService _payPalLocalService;
}