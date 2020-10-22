package br.edu.ifpb.pweb2.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_disciplina")
public class Disciplina {

	@Id
	@Column(name = "nu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nu_codigo")
	private String codigo;

	@Column(name = "nm_nome")
	private String nome;

	private List<String> cursos;
	@OneToMany
	private List<Turma> turmas;

	public Disciplina() {

	}

	public Disciplina(String nome, String codigo, List<String> cursos) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.cursos = cursos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<String> getCursos() {
		return cursos;
	}

	public void setCursos(List<String> cursos) {
		this.cursos = cursos;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public void adicionarTurma(Turma turma) {
		this.turmas.add(turma);
	}

	@Override
	public String toString() {
		return "Disciplina [nome=" + nome + ", codigo=" + codigo + ", curso=" + cursos + "]";
	}

}
