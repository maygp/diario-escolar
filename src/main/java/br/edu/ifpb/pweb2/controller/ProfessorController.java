package br.edu.ifpb.pweb2.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.edu.ifpb.pweb2.dao.ProfessorDAO;
import br.edu.ifpb.pweb2.model.Professor;

public class ProfessorController {
	private static final long serialVersionUID = 1L;

	@Inject
	private ProfessorDAO professorDAO;

	public void excluir(Professor professor) {
		professorDAO.delete(professor);

	}

	public List<Professor> findAll() {
		return professorDAO.findAll();
	}

	public Professor find(Integer id) {
		return professorDAO.find(id);
	}

	@Transactional
	public Professor insert(Professor professor) {
		return professorDAO.insert(professor);
	}

	@Transactional
	public void saveOrUpdate(Professor professor) {
		if (professor.getId() != null) {
			professor = professorDAO.update(professor);
		} else {
			professorDAO.insert(professor);
		}

	}
}
