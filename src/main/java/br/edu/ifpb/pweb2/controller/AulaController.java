package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.AulaDAO;
import br.edu.ifpb.pweb2.dao.Transactional;
import br.edu.ifpb.pweb2.model.Aula;

public class AulaController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private AulaDAO aulaDAO;

	public List<Aula> findAll() {
		return aulaDAO.findAll();
	}

	public Aula find(Integer id) {
		return aulaDAO.find(id);
	}

	@Transactional
	public Aula insert(Aula aula) {
		return aulaDAO.insert(aula);
	}

	@Transactional
	public void excluir(Aula aula) {
		aulaDAO.delete(aula);
	}

	@Transactional
	public void saveOrUpdate(Aula aula) {
		if (aula.getId() != null) {
			aula = aulaDAO.update(aula);
		} else {
			aulaDAO.insert(aula);
		}
	}

}
