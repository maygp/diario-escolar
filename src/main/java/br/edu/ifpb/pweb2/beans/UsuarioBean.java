package br.edu.ifpb.pweb2.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.model.Usuario;

@Named
@ViewScoped
public class UsuarioBean extends GenericDiarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Inject
	private Usuario usuario = new Usuario();

	public String autentique() {
		String proxPag = null;

		if (this.usuario.getLogin().equals("aluno") && this.usuario.getSenha().equals("123")) {
			proxPag = "alunos/pagAluno";
		} else if (this.usuario.getLogin().equals("professor") && this.usuario.getSenha().equals("123")) {
			proxPag = "professores/pagProf";
		} else if (this.usuario.getLogin().equals("coordenador") && this.usuario.getSenha().equals("123")) {
			proxPag = "coordenadores/pagCoordenador";
		}

		else {
			this.addInfoMessage("Login inválido!");
		}
		return proxPag;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
