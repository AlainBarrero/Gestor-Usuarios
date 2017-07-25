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

import com.alain.monetizacion.model.SubsConfiguration;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the subs configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alain
 * @see SubsConfigurationPersistenceImpl
 * @see SubsConfigurationUtil
 * @generated
 */
public interface SubsConfigurationPersistence extends BasePersistence<SubsConfiguration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubsConfigurationUtil} to access the subs configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the subs configurations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching subs configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.alain.monetizacion.model.SubsConfiguration> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.alain.monetizacion.model.SubsConfiguration> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.alain.monetizacion.model.SubsConfiguration> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first subs configuration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subs configuration
	* @throws com.alain.monetizacion.NoSuchSubsConfigurationException if a matching subs configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.SubsConfiguration findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchSubsConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first subs configuration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subs configuration, or <code>null</code> if a matching subs configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.SubsConfiguration fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last subs configuration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subs configuration
	* @throws com.alain.monetizacion.NoSuchSubsConfigurationException if a matching subs configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.SubsConfiguration findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchSubsConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last subs configuration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subs configuration, or <code>null</code> if a matching subs configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.SubsConfiguration fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.alain.monetizacion.model.SubsConfiguration[] findByGroupId_PrevAndNext(
		long configurationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.alain.monetizacion.NoSuchSubsConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subs configurations where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subs configurations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching subs configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the subs configuration in the entity cache if it is enabled.
	*
	* @param subsConfiguration the subs configuration
	*/
	public void cacheResult(
		com.alain.monetizacion.model.SubsConfiguration subsConfiguration);

	/**
	* Caches the subs configurations in the entity cache if it is enabled.
	*
	* @param subsConfigurations the subs configurations
	*/
	public void cacheResult(
		java.util.List<com.alain.monetizacion.model.SubsConfiguration> subsConfigurations);

	/**
	* Creates a new subs configuration with the primary key. Does not add the subs configuration to the database.
	*
	* @param configurationId the primary key for the new subs configuration
	* @return the new subs configuration
	*/
	public com.alain.monetizacion.model.SubsConfiguration create(
		long configurationId);

	/**
	* Removes the subs configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configurationId the primary key of the subs configuration
	* @return the subs configuration that was removed
	* @throws com.alain.monetizacion.NoSuchSubsConfigurationException if a subs configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.SubsConfiguration remove(
		long configurationId)
		throws com.alain.monetizacion.NoSuchSubsConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.alain.monetizacion.model.SubsConfiguration updateImpl(
		com.alain.monetizacion.model.SubsConfiguration subsConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subs configuration with the primary key or throws a {@link com.alain.monetizacion.NoSuchSubsConfigurationException} if it could not be found.
	*
	* @param configurationId the primary key of the subs configuration
	* @return the subs configuration
	* @throws com.alain.monetizacion.NoSuchSubsConfigurationException if a subs configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.SubsConfiguration findByPrimaryKey(
		long configurationId)
		throws com.alain.monetizacion.NoSuchSubsConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subs configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param configurationId the primary key of the subs configuration
	* @return the subs configuration, or <code>null</code> if a subs configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.alain.monetizacion.model.SubsConfiguration fetchByPrimaryKey(
		long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the subs configurations.
	*
	* @return the subs configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.alain.monetizacion.model.SubsConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.alain.monetizacion.model.SubsConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.alain.monetizacion.model.SubsConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subs configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subs configurations.
	*
	* @return the number of subs configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}