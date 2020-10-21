package br.edu.ifpb.pweb2.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.edu.ifpb.pweb2.model.Usuario;

public class LoginController {
	private Usuario usuario = new Usuario();

	public String doEfetuarLogin() {
		if ("usuario".equals(usuario.getLogin()) && "123".equals(usuario.getSenha())) {
			return "index2";
		} else {
			FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");

			FacesContext.getCurrentInstance().addMessage("erro", msg);
			return null;
		}
	}
}
