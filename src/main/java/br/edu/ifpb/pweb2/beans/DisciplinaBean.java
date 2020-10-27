package br.edu.ifpb.pweb2.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private List<Disciplina> disciplinas;

	private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();

	private Integer id;

	@Inject
	private DisciplinaController controllerDisciplina;

	public void init() {
		if (id == null) {
			disciplinas = controllerDisciplina.findAll();
		} else {
			disciplinas = Collections.singletonList(controllerDisciplina.find(id));
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

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public List<Disciplina> getDisciplinas() {
		List<Disciplina> listDisciplinas = new ArrayList<Disciplina>();
		disciplinas = controllerDisciplina.findAll();
		for(int i = 0 ; i < disciplinas.size(); i++){
			listDisciplinas.add(disciplinas.get(i));
	 }
		return listDisciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String excluirSelecionados() {
		Disciplina d = null;
		for (Integer id : checked.keySet()) {
			if (checked.get(id)) {
				d = controllerDisciplina.find(id);
				controllerDisciplina.excluir(d);
			}
		}
		disciplinas = controllerDisciplina.findAll();
		checked.clear();
		this.addInfoMessage("Disciplinas selecionadas excluídas com sucesso!");
		return null;
	}

	public String excluir(Disciplina disciplina) {
		controllerDisciplina.excluir(disciplina);
		this.addInfoMessage("Disciplina excluída com sucesso!");
		this.init();
		return null;
	}

	public String editar(Disciplina disciplina) {
		controllerDisciplina.saveOrUpdate(disciplina);
		this.addInfoMessage("Disciplina alterada com sucesso!");
		this.init();
		return null;

	}

	public Map<Integer, Boolean> getChecked() {
		return checked;
	}

	public void setChecked(Map<Integer, Boolean> checked) {
		this.checked = checked;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}