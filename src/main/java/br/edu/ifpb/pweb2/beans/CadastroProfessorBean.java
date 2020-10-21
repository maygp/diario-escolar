package br.edu.ifpb.pweb2.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.edu.ifpb.pweb2.controller.ProfessorController;
import br.edu.ifpb.pweb2.model.Aluno;
import br.edu.ifpb.pweb2.model.Professor;

public class CadastroProfessorBean extends GenericDiarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Professor professor;
	
	@Inject
	private ProfessorController controllerProfessor;
	
	@PostConstruct
	public void init() {
		Professor professorFlash = (Professor) this.getFlash("professor");
		if (professorFlash != null) {
			this.professor = professorFlash;
		}
	}
	
	public String cadastrar() {
		Integer id = professor.getId();
		controllerProfessor.saveOrUpdate(professor);
		
		this.keepMessages();
		if (id == null) {
			this.addInfoMessage("Professor cadatrado com sucesso!");
		} else {
			this.addInfoMessage("Professor atualizado com sucesso!");
		}
		
		// Limpa objeto do formulário
		professor = new Professor();
		
		// Retorna para mesma página
		return "consulta?faces-redirect=true";
	}

}
