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

package com.liferay.andre.contato.service;

import com.liferay.andre.contato.model.Contato;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for Contato. This utility wraps
 * <code>com.liferay.andre.contato.service.impl.ContatoServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ContatoService
 * @generated
 */
public class ContatoServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.andre.contato.service.impl.ContatoServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Contato addContato(
			long groupId, String nome, String telefone, String email, int idade,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addContato(
			groupId, nome, telefone, email, idade, serviceContext);
	}

	public static Contato deleteContato(long contatoId) throws PortalException {
		return getService().deleteContato(contatoId);
	}

	public static Contato getContato(long contatoId) throws PortalException {
		return getService().getContato(contatoId);
	}

	public static List<Contato> getContatoByGroupId(long groupId) {
		return getService().getContatoByGroupId(groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Contato updaContato(
			long contatoId, String nome, String telefone, String email,
			int idade)
		throws PortalException {

		return getService().updaContato(
			contatoId, nome, telefone, email, idade);
	}

	public static ContatoService getService() {
		return _service;
	}

	private static volatile ContatoService _service;

}