package br.edu.ifpb.pweb2.beans;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.controller.AulaController;
import br.edu.ifpb.pweb2.model.Aula;

@Named(value = "aulaBean")
@ViewScoped
public class AulaBean extends GenericDiarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Aula aula;
	@Inject
	private AulaController controllerAula;
	private List<Aula> aulas;

	private List<Aula> presencas;
	private Integer id;

	public void init() {
		if (id == null) {
			aulas = controllerAula.findAll();
		} else {
			aulas = Collections.singletonList(controllerAula.find(id));
		}
	}

	public String registrar() {
		Integer id = aula.getId();
		controllerAula.saveOrUpdate(aula);

		this.keepMessages();
		if (id == null) {
			this.addInfoMessage("Aula registrada com sucesso!");
		} else {
			this.addInfoMessage("Aula atualizada com sucesso!");
		}

		// Limpa objeto do formulário
		aula = new Aula();

		// Retorna para mesma página
		return "consulta?faces-redirect=true";
	}

	public String editar(Aula aula) {
		this.putFlash("aula", aula);
		return "cadastro?faces-redirect=true";

	}

	public String excluir(Aula aula) {
		controllerAula.excluir(aula);
		this.addInfoMessage("Aula excluída com sucesso!");
		this.init();
		return null;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public List<Aula> getPresencas() {
		return presencas;
	}

	public void setPresencas(List<Aula> presencas) {
		this.presencas = presencas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
