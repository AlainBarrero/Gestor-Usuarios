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
 * Provides a wrapper for {@link Role_ConfigLocalService}.
 *
 * @author Alain
 * @see Role_ConfigLocalService
 * @generated
 */
public class Role_ConfigLocalServiceWrapper implements Role_ConfigLocalService,
	ServiceWrapper<Role_ConfigLocalService> {
	public Role_ConfigLocalServiceWrapper(
		Role_ConfigLocalService role_ConfigLocalService) {
		_role_ConfigLocalService = role_ConfigLocalService;
	}

	/**
	* Adds the role_ config to the database. Also notifies the appropriate model listeners.
	*
	* @param role_Config the role_ config
	* @return the role_ config that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.alain.monetizacion.model.Role_Config addRole_Config(
		com.alain.monetizacion.model.Role_Config role_Config)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role_ConfigLocalService.addRole_Config(role_Config);
	}

	/**
	* Creates a new role_ config with the primary key. Does not add the role_ config to the database.
	*
	* @param role_ConfigPK the primary key for the new role_ config
	* @return the new role_ config
	*/
	@Override
	public com.alain.monetizacion.model.Role_Config createRole_Config(
		com.alain.monetizacion.service.persistence.Role_ConfigPK role_ConfigPK) {
		return _role_ConfigLocalService.createRole_Config(role_ConfigPK);
	}

	/**
	* Deletes the role_ config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param role_ConfigPK the primary key of the role_ config
	* @return the role_ config that was removed
	* @throws PortalException if a role_ config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.alain.monetizacion.model.Role_Config deleteRole_Config(
		com.alain.monetizacion.service.persistence.Role_ConfigPK role_ConfigPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _role_ConfigLocalService.deleteRole_Config(role_ConfigPK);
	}

	/**
	* Deletes the role_ config from the database. Also notifies the appropriate model listeners.
	*
	* @param role_Config the role_ config
	* @return the role_ config that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.alain.monetizacion.model.Role_Config deleteRole_Config(
		com.alain.monetizacion.model.Role_Config role_Config)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role_ConfigLocalService.deleteRole_Config(role_Config);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _role_ConfigLocalService.dynamicQuery();
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
		return _role_ConfigLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.Role_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _role_ConfigLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.Role_ConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _role_ConfigLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _role_ConfigLocalService.dynamicQueryCount(dynamicQuery);
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
		return _role_ConfigLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.alain.monetizacion.model.Role_Config fetchRole_Config(
		com.alain.monetizacion.service.persistence.Role_ConfigPK role_ConfigPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role_ConfigLocalService.fetchRole_Config(role_ConfigPK);
	}

	/**
	* Returns the role_ config with the primary key.
	*
	* @param role_ConfigPK the primary key of the role_ config
	* @return the role_ config
	* @throws PortalException if a role_ config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.alain.monetizacion.model.Role_Config getRole_Config(
		com.alain.monetizacion.service.persistence.Role_ConfigPK role_ConfigPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _role_ConfigLocalService.getRole_Config(role_ConfigPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _role_ConfigLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.alain.monetizacion.model.Role_Config> getRole_Configs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role_ConfigLocalService.getRole_Configs(start, end);
	}

	/**
	* Returns the number of role_ configs.
	*
	* @return the number of role_ configs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRole_ConfigsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role_ConfigLocalService.getRole_ConfigsCount();
	}

	/**
	* Updates the role_ config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param role_Config the role_ config
	* @return the role_ config that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.alain.monetizacion.model.Role_Config updateRole_Config(
		com.alain.monetizacion.model.Role_Config role_Config)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _role_ConfigLocalService.updateRole_Config(role_Config);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _role_ConfigLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_role_ConfigLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _role_ConfigLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.liferay.portal.model.Role> getRolesByConfiguration(
		long configurationId) {
		return _role_ConfigLocalService.getRolesByConfiguration(configurationId);
	}

	@Override
	public java.util.List<com.alain.monetizacion.model.Role_Config> getRoleConfig(
		long configurationId) {
		return _role_ConfigLocalService.getRoleConfig(configurationId);
	}

	@Override
	public java.util.List<com.alain.monetizacion.model.Role_Config> updateRoleConfig(
		long configurationId, java.lang.String roles)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _role_ConfigLocalService.updateRoleConfig(configurationId, roles);
	}

	@Override
	public java.util.List<com.alain.monetizacion.model.Role_Config> addRoleToSuscriptedUser(
		long userId, com.alain.monetizacion.model.SubsConfiguration sconfig) {
		return _role_ConfigLocalService.addRoleToSuscriptedUser(userId, sconfig);
	}

	@Override
	public java.lang.String removeRoleToSuscribedUser(long userId,
		com.alain.monetizacion.model.SubsConfiguration sconfig) {
		return _role_ConfigLocalService.removeRoleToSuscribedUser(userId,
			sconfig);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Role_ConfigLocalService getWrappedRole_ConfigLocalService() {
		return _role_ConfigLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRole_ConfigLocalService(
		Role_ConfigLocalService role_ConfigLocalService) {
		_role_ConfigLocalService = role_ConfigLocalService;
	}

	@Override
	public Role_ConfigLocalService getWrappedService() {
		return _role_ConfigLocalService;
	}

	@Override
	public void setWrappedService(
		Role_ConfigLocalService role_ConfigLocalService) {
		_role_ConfigLocalService = role_ConfigLocalService;
	}

	private Role_ConfigLocalService _role_ConfigLocalService;
}