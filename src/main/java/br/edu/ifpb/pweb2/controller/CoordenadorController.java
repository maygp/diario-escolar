package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.CoordenadorDAO;
import br.edu.ifpb.pweb2.dao.Transactional;
import br.edu.ifpb.pweb2.model.Coordenador;

public class CoordenadorController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private CoordenadorDAO coordenadorDao;

	public Coordenador find(Integer id) {
		return coordenadorDao.find(id);
	}

	@Transactional
	public Coordenador insert(Coordenador coordenador) {
		return coordenadorDao.insert(coordenador);
	}

	@Transactional
	public void excluir(Coordenador coordenador) {
		coordenadorDao.delete(coordenador);
	}

	@Transactional
	public void saveOrUpdate(Coordenador coordenador) {
		if (coordenador.getId() != null) {
			coordenador = coordenadorDao.update(coordenador);
		} else {
			coordenadorDao.insert(coordenador);
		}
	}
}
