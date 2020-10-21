package br.edu.ifpb.pweb2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_nota")
public class Nota {
	
	@Id
	@Column(name="nu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nu_nota")
    private Integer nota;
    
    public Nota(){
        
    }

	public Nota(Integer nota) {
		super();
		this.nota = nota;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Nota [nota=" + nota + "]";
	}
    
    
}
