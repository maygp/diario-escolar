package br.edu.ifpb.pweb2.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.controller.AlunoController;
import br.edu.ifpb.pweb2.controller.AulaController;
import br.edu.ifpb.pweb2.model.Aluno;
import br.edu.ifpb.pweb2.model.Aula;

@Named(value = "aulaBean")
@ViewScoped
public class AulaBean extends GenericDiarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Aula aula;
	@Inject
	private Aluno aluno;
	@Inject
	private AlunoController controllerAluno;

	@Inject
	private AulaController controllerAula;
	private List<Aula> aulas;

	private List<Aluno> alunos;

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

	public String excluirAluno(Aluno aluno) {
		controllerAluno.excluir(aluno);
		this.addInfoMessage("Aluno excluído com sucesso!");
		this.init();
		return null;
	}

	public String registrarPresenca() {
		return "registrar";
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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		List<Aluno> listAlunos = new ArrayList<Aluno>();
		alunos = controllerAluno.findAll();
		for (int i = 0; i < alunos.size(); i++) {
			listAlunos.add(alunos.get(i));
		}
		return listAlunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
