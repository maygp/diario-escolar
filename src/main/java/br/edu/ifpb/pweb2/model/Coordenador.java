package br.edu.ifpb.pweb2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_coordenador")
public class Coordenador {
	@Id
	@Column(name="nu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "bl_situacao")
	private Boolean ativo;
	
	@OneToOne
	private Usuario usuario;

	public Coordenador() {

	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Coordenador [ativo=" + ativo + "]";
	}

}
