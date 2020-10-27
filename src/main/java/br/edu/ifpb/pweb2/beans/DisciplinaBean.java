package br.edu.ifpb.pweb2.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.controller.DisciplinaController;
import br.edu.ifpb.pweb2.model.Disciplina;

@Named(value = "cadDisciplina")
@ViewScoped
public class DisciplinaBean extends GenericDiarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Disciplina disciplina;
	
//	@Inject
//	private List<Disciplina> disciplinas;

	@Inject
	private DisciplinaController controllerDisciplina;

	@PostConstruct
	public void init() {
		Disciplina disciplinaFlash = (Disciplina) this.getFlash("disciplina");
		if (disciplinaFlash != null) {
			this.disciplina = disciplinaFlash;
		}
	}

	public String cadastrar() {
		Integer id = disciplina.getId();
		controllerDisciplina.saveOrUpdate(disciplina);

		this.keepMessages();
		if (id == null) {
			this.addInfoMessage("Disciplina cadastrada com sucesso!");
		} else {
			this.addInfoMessage("Disciplina atualizada com sucesso!");
		}

		// Limpa objeto do formulário
		disciplina = new Disciplina();

		// Retorna para mesma página
		return "consulta?faces-redirect=true";
	}

//	public List<Disciplina> getDisciplinas() {
//		return disciplinas;
//	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}