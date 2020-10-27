package br.edu.ifpb.pweb2.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_turma")
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nu_codigo")
	private String codigo;

	@ManyToMany
	private List<Disciplina> disciplinas;
	@ManyToMany
	private List<Professor> professores;
	@ManyToMany
	private List<Aula> aulas;
	@ManyToMany
	private List<Nota> notas;
	@ManyToMany
	private List<Aluno> alunos;

	public Turma() {

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void addAulas(Aula aula) {
		this.aulas.add(aula);
	}

	public void addNotas(Nota nota) {
		this.notas.add(nota);
	}

	public void addAlunos(Aluno alunos) {
		this.alunos.add(alunos);
	}

	@Override
	public String toString() {
		return "Turma [codigo=" + codigo + "]";
	}

}
