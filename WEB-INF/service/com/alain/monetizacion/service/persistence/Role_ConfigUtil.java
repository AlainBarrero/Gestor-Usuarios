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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the role_ config service. This utility wraps {@link Role_ConfigPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alain
 * @see Role_ConfigPersistence
 * @see Role_ConfigPersistenceImpl
 * @generated
 */
public class Role_ConfigUtil {
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
	public static void clearCache(Role_Config role_Config) {
		getPersistence().clearCache(role_Config);
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
	public static List<Role_Config> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Role_Config> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Role_Config> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Role_Config update(Role_Config role_Config)
		throws SystemException {
		return getPersistence().update(role_Config);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Role_Config update(Role_Config role_Config,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(role_Config, serviceContext);
	}

	/**
	* Returns all the role_ configs where configurationId = &#63;.
	*
	* @param configurationId the configuration ID
	* @return the matching role_ configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.alain.monetizacion.model.Role_Config> findByconfigurationId(
		long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByconfigurationId(configurationId);
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
	public static java.util.List<com.alain.monetizacion.model.Role_Config> findByconfigurationId(
		long configurationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByconfigurationId(configurationId, start, end);
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
	public static java.util.List<com.alain.monetizacion.model.Role_Config> findByconfigurationId(
		long configurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByconfigurationId(configurationId, start, end,
			orderByComparator);
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
	public static com.alain.monetizacion.model.Role_Config findByconfigurationId_First(
		long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchRole_ConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByconfigurationId_First(configurationId,
			orderByComparator);
	}

	/**
	* Returns the first role_ config in the ordered set where configurationId = &#63;.
	*
	* @param configurationId the configuration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching role_ config, or <code>null</code> if a matching role_ config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Role_Config fetchByconfigurationId_First(
		long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByconfigurationId_First(configurationId,
			orderByComparator);
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
	public static com.alain.monetizacion.model.Role_Config findByconfigurationId_Last(
		long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchRole_ConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByconfigurationId_Last(configurationId,
			orderByComparator);
	}

	/**
	* Returns the last role_ config in the ordered set where configurationId = &#63;.
	*
	* @param configurationId the configuration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching role_ config, or <code>null</code> if a matching role_ config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Role_Config fetchByconfigurationId_Last(
		long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByconfigurationId_Last(configurationId,
			orderByComparator);
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
	public static com.alain.monetizacion.model.Role_Config[] findByconfigurationId_PrevAndNext(
		com.alain.monetizacion.service.persistence.Role_ConfigPK role_ConfigPK,
		long configurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchRole_ConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByconfigurationId_PrevAndNext(role_ConfigPK,
			configurationId, orderByComparator);
	}

	/**
	* Removes all the role_ configs where configurationId = &#63; from the database.
	*
	* @param configurationId the configuration ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByconfigurationId(long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByconfigurationId(configurationId);
	}

	/**
	* Returns the number of role_ configs where configurationId = &#63;.
	*
	* @param configurationId the configuration ID
	* @return the number of matching role_ configs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByconfigurationId(long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByconfigurationId(configurationId);
	}

	/**
	* Caches the role_ config in the entity cache if it is enabled.
	*
	* @param role_Config the role_ config
	*/
	public static void cacheResult(
		com.alain.monetizacion.model.Role_Config role_Config) {
		getPersistence().cacheResult(role_Config);
	}

	/**
	* Caches the role_ configs in the entity cache if it is enabled.
	*
	* @param role_Configs the role_ configs
	*/
	public static void cacheResult(
		java.util.List<com.alain.monetizacion.model.Role_Config> role_Configs) {
		getPersistence().cacheResult(role_Configs);
	}

	/**
	* Creates a new role_ config with the primary key. Does not add the role_ config to the database.
	*
	* @param role_ConfigPK the primary key for the new role_ config
	* @return the new role_ config
	*/
	public static com.alain.monetizacion.model.Role_Config create(
		com.alain.monetizacion.service.persistence.Role_ConfigPK role_ConfigPK) {
		return getPersistence().create(role_ConfigPK);
	}

	/**
	* Removes the role_ config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param role_ConfigPK the primary key of the role_ config
	* @return the role_ config that was removed
	* @throws com.alain.monetizacion.NoSuchRole_ConfigException if a role_ config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Role_Config remove(
		com.alain.monetizacion.service.persistence.Role_ConfigPK role_ConfigPK)
		throws com.alain.monetizacion.NoSuchRole_ConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(role_ConfigPK);
	}

	public static com.alain.monetizacion.model.Role_Config updateImpl(
		com.alain.monetizacion.model.Role_Config role_Config)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(role_Config);
	}

	/**
	* Returns the role_ config with the primary key or throws a {@link com.alain.monetizacion.NoSuchRole_ConfigException} if it could not be found.
	*
	* @param role_ConfigPK the primary key of the role_ config
	* @return the role_ config
	* @throws com.alain.monetizacion.NoSuchRole_ConfigException if a role_ config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Role_Config findByPrimaryKey(
		com.alain.monetizacion.service.persistence.Role_ConfigPK role_ConfigPK)
		throws com.alain.monetizacion.NoSuchRole_ConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(role_ConfigPK);
	}

	/**
	* Returns the role_ config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param role_ConfigPK the primary key of the role_ config
	* @return the role_ config, or <code>null</code> if a role_ config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.alain.monetizacion.model.Role_Config fetchByPrimaryKey(
		com.alain.monetizacion.service.persistence.Role_ConfigPK role_ConfigPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(role_ConfigPK);
	}

	/**
	* Returns all the role_ configs.
	*
	* @return the role_ configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.alain.monetizacion.model.Role_Config> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.alain.monetizacion.model.Role_Config> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.alain.monetizacion.model.Role_Config> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the role_ configs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of role_ configs.
	*
	* @return the number of role_ configs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Role_ConfigPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Role_ConfigPersistence)PortletBeanLocatorUtil.locate(com.alain.monetizacion.service.ClpSerializer.getServletContextName(),
					Role_ConfigPersistence.class.getName());

			ReferenceRegistry.registerReference(Role_ConfigUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Role_ConfigPersistence persistence) {
	}

	private static Role_ConfigPersistence _persistence;
}