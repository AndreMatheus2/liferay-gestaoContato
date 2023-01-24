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

package com.liferay.andre.contato.service.base;

import com.liferay.andre.contato.model.Contato;
import com.liferay.andre.contato.service.ContatoLocalService;
import com.liferay.andre.contato.service.ContatoLocalServiceUtil;
import com.liferay.andre.contato.service.persistence.ContatoPersistence;
import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the contato local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.andre.contato.service.impl.ContatoLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.andre.contato.service.impl.ContatoLocalServiceImpl
 * @generated
 */
public abstract class ContatoLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, ContatoLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ContatoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ContatoLocalServiceUtil</code>.
	 */

	/**
	 * Adds the contato to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contato the contato
	 * @return the contato that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Contato addContato(Contato contato) {
		contato.setNew(true);

		return contatoPersistence.update(contato);
	}

	/**
	 * Creates a new contato with the primary key. Does not add the contato to the database.
	 *
	 * @param contatoid the primary key for the new contato
	 * @return the new contato
	 */
	@Override
	@Transactional(enabled = false)
	public Contato createContato(long contatoid) {
		return contatoPersistence.create(contatoid);
	}

	/**
	 * Deletes the contato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contatoid the primary key of the contato
	 * @return the contato that was removed
	 * @throws PortalException if a contato with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Contato deleteContato(long contatoid) throws PortalException {
		return contatoPersistence.remove(contatoid);
	}

	/**
	 * Deletes the contato from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contato the contato
	 * @return the contato that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Contato deleteContato(Contato contato) {
		return contatoPersistence.remove(contato);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return contatoPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Contato.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return contatoPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.andre.contato.model.impl.ContatoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return contatoPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.andre.contato.model.impl.ContatoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return contatoPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return contatoPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return contatoPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Contato fetchContato(long contatoid) {
		return contatoPersistence.fetchByPrimaryKey(contatoid);
	}

	/**
	 * Returns the contato matching the UUID and group.
	 *
	 * @param uuid the contato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching contato, or <code>null</code> if a matching contato could not be found
	 */
	@Override
	public Contato fetchContatoByUuidAndGroupId(String uuid, long groupId) {
		return contatoPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the contato with the primary key.
	 *
	 * @param contatoid the primary key of the contato
	 * @return the contato
	 * @throws PortalException if a contato with the primary key could not be found
	 */
	@Override
	public Contato getContato(long contatoid) throws PortalException {
		return contatoPersistence.findByPrimaryKey(contatoid);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(contatoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Contato.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("contatoid");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			contatoLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Contato.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("contatoid");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(contatoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Contato.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("contatoid");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Contato>() {

				@Override
				public void performAction(Contato contato)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, contato);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(Contato.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return contatoPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return contatoLocalService.deleteContato((Contato)persistedModel);
	}

	@Override
	public BasePersistence<Contato> getBasePersistence() {
		return contatoPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return contatoPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the contatos matching the UUID and company.
	 *
	 * @param uuid the UUID of the contatos
	 * @param companyId the primary key of the company
	 * @return the matching contatos, or an empty list if no matches were found
	 */
	@Override
	public List<Contato> getContatosByUuidAndCompanyId(
		String uuid, long companyId) {

		return contatoPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of contatos matching the UUID and company.
	 *
	 * @param uuid the UUID of the contatos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching contatos, or an empty list if no matches were found
	 */
	@Override
	public List<Contato> getContatosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Contato> orderByComparator) {

		return contatoPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the contato matching the UUID and group.
	 *
	 * @param uuid the contato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching contato
	 * @throws PortalException if a matching contato could not be found
	 */
	@Override
	public Contato getContatoByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return contatoPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the contatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.andre.contato.model.impl.ContatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of contatos
	 */
	@Override
	public List<Contato> getContatos(int start, int end) {
		return contatoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of contatos.
	 *
	 * @return the number of contatos
	 */
	@Override
	public int getContatosCount() {
		return contatoPersistence.countAll();
	}

	/**
	 * Updates the contato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContatoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contato the contato
	 * @return the contato that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Contato updateContato(Contato contato) {
		return contatoPersistence.update(contato);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ContatoLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		contatoLocalService = (ContatoLocalService)aopProxy;

		_setLocalServiceUtilService(contatoLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ContatoLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Contato.class;
	}

	protected String getModelClassName() {
		return Contato.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = contatoPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		ContatoLocalService contatoLocalService) {

		try {
			Field field = ContatoLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, contatoLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected ContatoLocalService contatoLocalService;

	@Reference
	protected ContatoPersistence contatoPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	public abstract Contato updaContato(Contato contato);
}