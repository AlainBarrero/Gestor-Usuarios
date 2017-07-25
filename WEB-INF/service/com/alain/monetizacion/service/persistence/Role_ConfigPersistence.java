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

import com.alain.monetizacion.model.Role_Config;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the role_ config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alain
 * @see Role_ConfigPersistenceImpl
 * @see Role_ConfigUtil
 * @generated
 */
public interface Role_ConfigPersistence extends BasePersistence<Role_Config> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Role_ConfigUtil} to access the role_ config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the role_ configs where configurationId = &#63;.
	*
	* @param configurationId the configuration ID
	* @return the matching role_ configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.alain.monetizacion.model.Role_Config> findByconfigurationId(
		long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.alain.monetizacion.model.Role_Config> findByconfigurationId(
		long configurationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.alain.monetizacion.model.Role_Config> findByconfigurationId(
		long configurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first role_ config in the ordered set where configurationId = &#63;.
	*
	* @param configurationId the configuration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching role_ config
	* @throws com.alain.monetizacion.NoSuchRole_ConfigException if a matching role_ config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.Role_Config findByconfigurationId_First(
		long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchRole_ConfigException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first role_ config in the ordered set where configurationId = &#63;.
	*
	* @param configurationId the configuration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching role_ config, or <code>null</code> if a matching role_ config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.Role_Config fetchByconfigurationId_First(
		long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last role_ config in the ordered set where configurationId = &#63;.
	*
	* @param configurationId the configuration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching role_ config
	* @throws com.alain.monetizacion.NoSuchRole_ConfigException if a matching role_ config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.Role_Config findByconfigurationId_Last(
		long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchRole_ConfigException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last role_ config in the ordered set where configurationId = &#63;.
	*
	* @param configurationId the configuration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching role_ config, or <code>null</code> if a matching role_ config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.Role_Config fetchByconfigurationId_Last(
		long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.alain.monetizacion.model.Role_Config[] findByconfigurationId_PrevAndNext(
		com.alain.monetizacion.service.persistence.Role_ConfigPK role_ConfigPK,
		long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchRole_ConfigException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the role_ configs where configurationId = &#63; from the database.
	*
	* @param configurationId the configuration ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByconfigurationId(long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of role_ configs where configurationId = &#63;.
	*
	* @param configurationId the configuration ID
	* @return the number of matching role_ configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByconfigurationId(long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the role_ config in the entity cache if it is enabled.
	*
	* @param role_Config the role_ config
	*/
	public void cacheResult(
		com.alain.monetizacion.model.Role_Config role_Config);

	/**
	* Caches the role_ configs in the entity cache if it is enabled.
	*
	* @param role_Configs the role_ configs
	*/
	public void cacheResult(
		java.util.List<com.alain.monetizacion.model.Role_Config> role_Configs);

	/**
	* Creates a new role_ config with the primary key. Does not add the role_ config to the database.
	*
	* @param role_ConfigPK the primary key for the new role_ config
	* @return the new role_ config
	*/
	public com.alain.monetizacion.model.Role_Config create(
		com.alain.monetizacion.service.persistence.Role_ConfigPK role_ConfigPK);

	/**
	* Removes the role_ config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param role_ConfigPK the primary key of the role_ config
	* @return the role_ config that was removed
	* @throws com.alain.monetizacion.NoSuchRole_ConfigException if a role_ config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.Role_Config remove(
		com.alain.monetizacion.service.persistence.Role_ConfigPK role_ConfigPK)
		throws com.alain.monetizacion.NoSuchRole_ConfigException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.alain.monetizacion.model.Role_Config updateImpl(
		com.alain.monetizacion.model.Role_Config role_Config)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the role_ config with the primary key or throws a {@link com.alain.monetizacion.NoSuchRole_ConfigException} if it could not be found.
	*
	* @param role_ConfigPK the primary key of the role_ config
	* @return the role_ config
	* @throws com.alain.monetizacion.NoSuchRole_ConfigException if a role_ config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.Role_Config findByPrimaryKey(
		com.alain.monetizacion.service.persistence.Role_ConfigPK role_ConfigPK)
		throws com.alain.monetizacion.NoSuchRole_ConfigException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the role_ config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param role_ConfigPK the primary key of the role_ config
	* @return the role_ config, or <code>null</code> if a role_ config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.Role_Config fetchByPrimaryKey(
		com.alain.monetizacion.service.persistence.Role_ConfigPK role_ConfigPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the role_ configs.
	*
	* @return the role_ configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.alain.monetizacion.model.Role_Config> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.alain.monetizacion.model.Role_Config> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.alain.monetizacion.model.Role_Config> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the role_ configs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of role_ configs.
	*
	* @return the number of role_ configs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}