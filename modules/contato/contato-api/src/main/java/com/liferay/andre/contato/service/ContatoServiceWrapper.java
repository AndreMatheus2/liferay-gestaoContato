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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContatoService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContatoService
 * @generated
 */
public class ContatoServiceWrapper
	implements ContatoService, ServiceWrapper<ContatoService> {

	public ContatoServiceWrapper() {
		this(null);
	}

	public ContatoServiceWrapper(ContatoService contatoService) {
		_contatoService = contatoService;
	}

	@Override
	public com.liferay.andre.contato.model.Contato addContato(
			long groupId, String nome, String telefone, String email, int idade,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contatoService.addContato(
			groupId, nome, telefone, email, idade, serviceContext);
	}

	@Override
	public com.liferay.andre.contato.model.Contato deleteContato(long contatoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contatoService.deleteContato(contatoId);
	}

	@Override
	public com.liferay.andre.contato.model.Contato getContato(long contatoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contatoService.getContato(contatoId);
	}

	@Override
	public java.util.List<com.liferay.andre.contato.model.Contato>
		getContatoByGroupId(long groupId) {

		return _contatoService.getContatoByGroupId(groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contatoService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.andre.contato.model.Contato updaContato(
			long contatoId, String nome, String telefone, String email,
			int idade)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contatoService.updaContato(
			contatoId, nome, telefone, email, idade);
	}

	@Override
	public ContatoService getWrappedService() {
		return _contatoService;
	}

	@Override
	public void setWrappedService(ContatoService contatoService) {
		_contatoService = contatoService;
	}

	private ContatoService _contatoService;

}