package br.edu.ifpb.pweb2.beans;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.controller.AlunoController;
import br.edu.ifpb.pweb2.controller.DisciplinaController;
import br.edu.ifpb.pweb2.model.Aluno;
import br.edu.ifpb.pweb2.model.Disciplina;

@Named(value = "alunoBean")
@ViewScoped
public class AlunoBean extends GenericDiarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Aluno aluno;
//	@Inject
//	private Disciplina disciplina;

	private List<Disciplina> disciplinas;

	private List<Aluno> alunos;
	private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
	private Integer id;

	@Inject
	private AlunoController controllerAluno;
	@Inject
	private DisciplinaController controllerDisciplina;

	public void init() {
		if (id == null) {
			alunos = controllerAluno.findAll();
		} else {
			alunos = Collections.singletonList(controllerAluno.find(id));
		}
	}

	public String excluir(Aluno aluno) {
		controllerAluno.excluir(aluno);
		this.addInfoMessage("Aluno excluído com sucesso!");
		this.init();
		return null;
	}

	public String editar(Aluno aluno) {
		this.putFlash("aluno", aluno);
		return "cadastro?faces-redirect=true";

	}

	public String matricular() {
		System.out.println("/////////////////////////////////////////// " + aluno);
		Integer id = aluno.getId();
		controllerAluno.saveOrUpdate(aluno);

		this.keepMessages();

		if (id == null) {
			this.addInfoMessage("Aluno matriculado com sucesso!");
		} else {
			this.addInfoMessage("Aluno atualizado com sucesso!");
		}

		// Limpa objeto do formulário
		aluno = new Aluno();

		// Retorna para mesma página
		return "consulta?faces-redirect=true";
	}

	public String excluirSelecionados() {
		Aluno a = null;
		for (Integer id : checked.keySet()) {
			if (checked.get(id)) {
				a = controllerAluno.find(id);
				controllerAluno.excluir(a);
			}
		}
		alunos = controllerAluno.findAll();
		checked.clear();
		this.addInfoMessage("Alunos selecionados excluídos com sucesso!");
		return null;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
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

	public List<Disciplina> getDisciplinas() {

		List<Disciplina> disciplinas = controllerDisciplina.findAll();
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
