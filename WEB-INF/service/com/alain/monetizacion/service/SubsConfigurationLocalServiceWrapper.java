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
 * Provides a wrapper for {@link SubsConfigurationLocalService}.
 *
 * @author Alain
 * @see SubsConfigurationLocalService
 * @generated
 */
public class SubsConfigurationLocalServiceWrapper
	implements SubsConfigurationLocalService,
		ServiceWrapper<SubsConfigurationLocalService> {
	public SubsConfigurationLocalServiceWrapper(
		SubsConfigurationLocalService subsConfigurationLocalService) {
		_subsConfigurationLocalService = subsConfigurationLocalService;
	}

	/**
	* Adds the subs configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param subsConfiguration the subs configuration
	* @return the subs configuration that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.alain.monetizacion.model.SubsConfiguration addSubsConfiguration(
		com.alain.monetizacion.model.SubsConfiguration subsConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subsConfigurationLocalService.addSubsConfiguration(subsConfiguration);
	}

	/**
	* Creates a new subs configuration with the primary key. Does not add the subs configuration to the database.
	*
	* @param configurationId the primary key for the new subs configuration
	* @return the new subs configuration
	*/
	@Override
	public com.alain.monetizacion.model.SubsConfiguration createSubsConfiguration(
		long configurationId) {
		return _subsConfigurationLocalService.createSubsConfiguration(configurationId);
	}

	/**
	* Deletes the subs configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configurationId the primary key of the subs configuration
	* @return the subs configuration that was removed
	* @throws PortalException if a subs configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.alain.monetizacion.model.SubsConfiguration deleteSubsConfiguration(
		long configurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subsConfigurationLocalService.deleteSubsConfiguration(configurationId);
	}

	/**
	* Deletes the subs configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param subsConfiguration the subs configuration
	* @return the subs configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.alain.monetizacion.model.SubsConfiguration deleteSubsConfiguration(
		com.alain.monetizacion.model.SubsConfiguration subsConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subsConfigurationLocalService.deleteSubsConfiguration(subsConfiguration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subsConfigurationLocalService.dynamicQuery();
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
		return _subsConfigurationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.SubsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _subsConfigurationLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.alain.monetizacion.model.impl.SubsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _subsConfigurationLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _subsConfigurationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _subsConfigurationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.alain.monetizacion.model.SubsConfiguration fetchSubsConfiguration(
		long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subsConfigurationLocalService.fetchSubsConfiguration(configurationId);
	}

	/**
	* Returns the subs configuration with the primary key.
	*
	* @param configurationId the primary key of the subs configuration
	* @return the subs configuration
	* @throws PortalException if a subs configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws com.alain.monetizacion.NoSuchSubsConfigurationException
	*/
	@Override
	public com.alain.monetizacion.model.SubsConfiguration getSubsConfiguration(
		long configurationId)
		throws com.alain.monetizacion.NoSuchSubsConfigurationException,
			com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subsConfigurationLocalService.getSubsConfiguration(configurationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subsConfigurationLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.alain.monetizacion.model.SubsConfiguration> getSubsConfigurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subsConfigurationLocalService.getSubsConfigurations(start, end);
	}

	/**
	* Returns the number of subs configurations.
	*
	* @return the number of subs configurations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSubsConfigurationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subsConfigurationLocalService.getSubsConfigurationsCount();
	}

	/**
	* Updates the subs configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param subsConfiguration the subs configuration
	* @return the subs configuration that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.alain.monetizacion.model.SubsConfiguration updateSubsConfiguration(
		com.alain.monetizacion.model.SubsConfiguration subsConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subsConfigurationLocalService.updateSubsConfiguration(subsConfiguration);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _subsConfigurationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_subsConfigurationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _subsConfigurationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.alain.monetizacion.model.SubsConfiguration> findByGroupId(
		long groupId)
		throws com.alain.monetizacion.NoSuchSubsConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subsConfigurationLocalService.findByGroupId(groupId);
	}

	@Override
	public java.util.List<com.alain.monetizacion.model.SubsConfiguration> findAllSubscribedConfiguration(
		java.util.List<com.alain.monetizacion.model.Subscription> subsList) {
		return _subsConfigurationLocalService.findAllSubscribedConfiguration(subsList);
	}

	@Override
	public com.alain.monetizacion.model.SubsConfiguration createConfiguration()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subsConfigurationLocalService.createConfiguration();
	}

	@Override
	public com.alain.monetizacion.model.SubsConfiguration updateConfiguration(
		java.lang.String description, double amount, int time,
		java.lang.String cycle, long groupId,
		com.alain.monetizacion.model.SubsConfiguration configuration)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subsConfigurationLocalService.updateConfiguration(description,
			amount, time, cycle, groupId, configuration);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SubsConfigurationLocalService getWrappedSubsConfigurationLocalService() {
		return _subsConfigurationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSubsConfigurationLocalService(
		SubsConfigurationLocalService subsConfigurationLocalService) {
		_subsConfigurationLocalService = subsConfigurationLocalService;
	}

	@Override
	public SubsConfigurationLocalService getWrappedService() {
		return _subsConfigurationLocalService;
	}

	@Override
	public void setWrappedService(
		SubsConfigurationLocalService subsConfigurationLocalService) {
		_subsConfigurationLocalService = subsConfigurationLocalService;
	}

	private SubsConfigurationLocalService _subsConfigurationLocalService;
}