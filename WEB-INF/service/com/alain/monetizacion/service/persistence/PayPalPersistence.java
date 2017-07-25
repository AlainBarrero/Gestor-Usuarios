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

import com.alain.monetizacion.model.PayPal;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the pay pal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alain
 * @see PayPalPersistenceImpl
 * @see PayPalUtil
 * @generated
 */
public interface PayPalPersistence extends BasePersistence<PayPal> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PayPalUtil} to access the pay pal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the pay pal in the entity cache if it is enabled.
	*
	* @param payPal the pay pal
	*/
	public void cacheResult(com.alain.monetizacion.model.PayPal payPal);

	/**
	* Caches the pay pals in the entity cache if it is enabled.
	*
	* @param payPals the pay pals
	*/
	public void cacheResult(
		java.util.List<com.alain.monetizacion.model.PayPal> payPals);

	/**
	* Creates a new pay pal with the primary key. Does not add the pay pal to the database.
	*
	* @param configurationId the primary key for the new pay pal
	* @return the new pay pal
	*/
	public com.alain.monetizacion.model.PayPal create(long configurationId);

	/**
	* Removes the pay pal with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configurationId the primary key of the pay pal
	* @return the pay pal that was removed
	* @throws com.alain.monetizacion.NoSuchPayPalException if a pay pal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.PayPal remove(long configurationId)
		throws com.alain.monetizacion.NoSuchPayPalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.alain.monetizacion.model.PayPal updateImpl(
		com.alain.monetizacion.model.PayPal payPal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pay pal with the primary key or throws a {@link com.alain.monetizacion.NoSuchPayPalException} if it could not be found.
	*
	* @param configurationId the primary key of the pay pal
	* @return the pay pal
	* @throws com.alain.monetizacion.NoSuchPayPalException if a pay pal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.PayPal findByPrimaryKey(
		long configurationId)
		throws com.alain.monetizacion.NoSuchPayPalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pay pal with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param configurationId the primary key of the pay pal
	* @return the pay pal, or <code>null</code> if a pay pal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.PayPal fetchByPrimaryKey(
		long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the pay pals.
	*
	* @return the pay pals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.alain.monetizacion.model.PayPal> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.alain.monetizacion.model.PayPal> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the pay pals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.PayPalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pay pals
	* @param end the upper bound of the range of pay pals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of pay pals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.alain.monetizacion.model.PayPal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the pay pals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pay pals.
	*
	* @return the number of pay pals
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}