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

import com.alain.monetizacion.NoSuchPayPalException;
import com.alain.monetizacion.model.PayPal;
import com.alain.monetizacion.model.impl.PayPalImpl;
import com.alain.monetizacion.model.impl.PayPalModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the pay pal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alain
 * @see PayPalPersistence
 * @see PayPalUtil
 * @generated
 */
public class PayPalPersistenceImpl extends BasePersistenceImpl<PayPal>
	implements PayPalPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PayPalUtil} to access the pay pal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PayPalImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PayPalModelImpl.ENTITY_CACHE_ENABLED,
			PayPalModelImpl.FINDER_CACHE_ENABLED, PayPalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PayPalModelImpl.ENTITY_CACHE_ENABLED,
			PayPalModelImpl.FINDER_CACHE_ENABLED, PayPalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PayPalModelImpl.ENTITY_CACHE_ENABLED,
			PayPalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PayPalPersistenceImpl() {
		setModelClass(PayPal.class);
	}

	/**
	 * Caches the pay pal in the entity cache if it is enabled.
	 *
	 * @param payPal the pay pal
	 */
	@Override
	public void cacheResult(PayPal payPal) {
		EntityCacheUtil.putResult(PayPalModelImpl.ENTITY_CACHE_ENABLED,
			PayPalImpl.class, payPal.getPrimaryKey(), payPal);

		payPal.resetOriginalValues();
	}

	/**
	 * Caches the pay pals in the entity cache if it is enabled.
	 *
	 * @param payPals the pay pals
	 */
	@Override
	public void cacheResult(List<PayPal> payPals) {
		for (PayPal payPal : payPals) {
			if (EntityCacheUtil.getResult(
						PayPalModelImpl.ENTITY_CACHE_ENABLED, PayPalImpl.class,
						payPal.getPrimaryKey()) == null) {
				cacheResult(payPal);
			}
			else {
				payPal.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pay pals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PayPalImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PayPalImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pay pal.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PayPal payPal) {
		EntityCacheUtil.removeResult(PayPalModelImpl.ENTITY_CACHE_ENABLED,
			PayPalImpl.class, payPal.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PayPal> payPals) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PayPal payPal : payPals) {
			EntityCacheUtil.removeResult(PayPalModelImpl.ENTITY_CACHE_ENABLED,
				PayPalImpl.class, payPal.getPrimaryKey());
		}
	}

	/**
	 * Creates a new pay pal with the primary key. Does not add the pay pal to the database.
	 *
	 * @param configurationId the primary key for the new pay pal
	 * @return the new pay pal
	 */
	@Override
	public PayPal create(long configurationId) {
		PayPal payPal = new PayPalImpl();

		payPal.setNew(true);
		payPal.setPrimaryKey(configurationId);

		return payPal;
	}

	/**
	 * Removes the pay pal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configurationId the primary key of the pay pal
	 * @return the pay pal that was removed
	 * @throws com.alain.monetizacion.NoSuchPayPalException if a pay pal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayPal remove(long configurationId)
		throws NoSuchPayPalException, SystemException {
		return remove((Serializable)configurationId);
	}

	/**
	 * Removes the pay pal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pay pal
	 * @return the pay pal that was removed
	 * @throws com.alain.monetizacion.NoSuchPayPalException if a pay pal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayPal remove(Serializable primaryKey)
		throws NoSuchPayPalException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PayPal payPal = (PayPal)session.get(PayPalImpl.class, primaryKey);

			if (payPal == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPayPalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(payPal);
		}
		catch (NoSuchPayPalException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PayPal removeImpl(PayPal payPal) throws SystemException {
		payPal = toUnwrappedModel(payPal);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payPal)) {
				payPal = (PayPal)session.get(PayPalImpl.class,
						payPal.getPrimaryKeyObj());
			}

			if (payPal != null) {
				session.delete(payPal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (payPal != null) {
			clearCache(payPal);
		}

		return payPal;
	}

	@Override
	public PayPal updateImpl(com.alain.monetizacion.model.PayPal payPal)
		throws SystemException {
		payPal = toUnwrappedModel(payPal);

		boolean isNew = payPal.isNew();

		Session session = null;

		try {
			session = openSession();

			if (payPal.isNew()) {
				session.save(payPal);

				payPal.setNew(false);
			}
			else {
				session.merge(payPal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(PayPalModelImpl.ENTITY_CACHE_ENABLED,
			PayPalImpl.class, payPal.getPrimaryKey(), payPal);

		return payPal;
	}

	protected PayPal toUnwrappedModel(PayPal payPal) {
		if (payPal instanceof PayPalImpl) {
			return payPal;
		}

		PayPalImpl payPalImpl = new PayPalImpl();

		payPalImpl.setNew(payPal.isNew());
		payPalImpl.setPrimaryKey(payPal.getPrimaryKey());

		payPalImpl.setPaypalUser(payPal.getPaypalUser());
		payPalImpl.setPaypalPassword(payPal.getPaypalPassword());
		payPalImpl.setPaypalFirm(payPal.getPaypalFirm());
		payPalImpl.setPaypalEmail(payPal.getPaypalEmail());
		payPalImpl.setConfigurationId(payPal.getConfigurationId());

		return payPalImpl;
	}

	/**
	 * Returns the pay pal with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the pay pal
	 * @return the pay pal
	 * @throws com.alain.monetizacion.NoSuchPayPalException if a pay pal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayPal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPayPalException, SystemException {
		PayPal payPal = fetchByPrimaryKey(primaryKey);

		if (payPal == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPayPalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return payPal;
	}

	/**
	 * Returns the pay pal with the primary key or throws a {@link com.alain.monetizacion.NoSuchPayPalException} if it could not be found.
	 *
	 * @param configurationId the primary key of the pay pal
	 * @return the pay pal
	 * @throws com.alain.monetizacion.NoSuchPayPalException if a pay pal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayPal findByPrimaryKey(long configurationId)
		throws NoSuchPayPalException, SystemException {
		return findByPrimaryKey((Serializable)configurationId);
	}

	/**
	 * Returns the pay pal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pay pal
	 * @return the pay pal, or <code>null</code> if a pay pal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayPal fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PayPal payPal = (PayPal)EntityCacheUtil.getResult(PayPalModelImpl.ENTITY_CACHE_ENABLED,
				PayPalImpl.class, primaryKey);

		if (payPal == _nullPayPal) {
			return null;
		}

		if (payPal == null) {
			Session session = null;

			try {
				session = openSession();

				payPal = (PayPal)session.get(PayPalImpl.class, primaryKey);

				if (payPal != null) {
					cacheResult(payPal);
				}
				else {
					EntityCacheUtil.putResult(PayPalModelImpl.ENTITY_CACHE_ENABLED,
						PayPalImpl.class, primaryKey, _nullPayPal);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PayPalModelImpl.ENTITY_CACHE_ENABLED,
					PayPalImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return payPal;
	}

	/**
	 * Returns the pay pal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configurationId the primary key of the pay pal
	 * @return the pay pal, or <code>null</code> if a pay pal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayPal fetchByPrimaryKey(long configurationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)configurationId);
	}

	/**
	 * Returns all the pay pals.
	 *
	 * @return the pay pals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PayPal> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<PayPal> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<PayPal> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<PayPal> list = (List<PayPal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PAYPAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PAYPAL;

				if (pagination) {
					sql = sql.concat(PayPalModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PayPal>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PayPal>(list);
				}
				else {
					list = (List<PayPal>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the pay pals from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PayPal payPal : findAll()) {
			remove(payPal);
		}
	}

	/**
	 * Returns the number of pay pals.
	 *
	 * @return the number of pay pals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PAYPAL);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the pay pal persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.alain.monetizacion.model.PayPal")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PayPal>> listenersList = new ArrayList<ModelListener<PayPal>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PayPal>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PayPalImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PAYPAL = "SELECT payPal FROM PayPal payPal";
	private static final String _SQL_COUNT_PAYPAL = "SELECT COUNT(payPal) FROM PayPal payPal";
	private static final String _ORDER_BY_ENTITY_ALIAS = "payPal.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PayPal exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PayPalPersistenceImpl.class);
	private static PayPal _nullPayPal = new PayPalImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PayPal> toCacheModel() {
				return _nullPayPalCacheModel;
			}
		};

	private static CacheModel<PayPal> _nullPayPalCacheModel = new CacheModel<PayPal>() {
			@Override
			public PayPal toEntityModel() {
				return _nullPayPal;
			}
		};
}