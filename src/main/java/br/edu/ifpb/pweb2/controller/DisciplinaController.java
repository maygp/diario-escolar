package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.DisciplinaDAO;
import br.edu.ifpb.pweb2.dao.Transactional;
import br.edu.ifpb.pweb2.model.Disciplina;

public class DisciplinaController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private DisciplinaDAO disciplinaDAO;

	public List<Disciplina> findAll() {
		return disciplinaDAO.findAll();
	}

	public Disciplina find(Integer id) {
		return disciplinaDAO.find(id);
	}

	@Transactional
	public Disciplina insert(Disciplina disciplina) {
		return disciplinaDAO.insert(disciplina);
	}

	@Transactional
	public void excluir(Disciplina disciplina) {
		disciplinaDAO.delete(disciplina);
	}

	@Transactional
	public void saveOrUpdate(Disciplina disciplina) {
		if (disciplina.getId() != null) {
			disciplina = disciplinaDAO.update(disciplina);
		} else {
			disciplinaDAO.insert(disciplina);
		}
	}

}
