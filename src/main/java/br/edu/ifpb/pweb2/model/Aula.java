package br.edu.ifpb.pweb2.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_aula")
public class Aula {

	@Id
	@Column(name = "nu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nm_assunto")
	private String assunto;

	@Column(name = "dt_aula")
	@Temporal(TemporalType.DATE)
	private Date data;

	@ManyToMany
	private List<Aluno> presenca;

	public Aula() {

	}

	public Aula(String assunto, Date data) {
		super();
		this.assunto = assunto;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Aluno> getPresenca() {
		return presenca;
	}

	public void setPresenca(List<Aluno> presenca) {
		this.presenca = presenca;
	}

	@Override
	public String toString() {
		return "Aula [assunto=" + assunto + ", data=" + data + "]";
	}

}
