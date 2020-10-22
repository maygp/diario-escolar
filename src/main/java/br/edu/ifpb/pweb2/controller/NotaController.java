package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.NotaDAO;
import br.edu.ifpb.pweb2.dao.Transactional;
import br.edu.ifpb.pweb2.model.Nota;

public class NotaController implements Serializable {
	private static final long serialVersionUID = 1L;

    @Inject
    private NotaDAO notaDAO;

    public List<Nota> findAll(){
        return notaDAO.findAll();
    }

    public Nota find(Integer id){
        return notaDAO.find(id);
    }
    
    @Transactional
    public Nota insert(Nota nota){
        return notaDAO.insert(nota);
    }

    @Transactional
    public void excluir(Nota nota){
        notaDAO.delete(nota);
    }

    @Transactional
	public void saveOrUpdate(Nota nota) {
		if (nota.getId() != null) {
			nota = notaDAO.update(nota);
		} else {
			notaDAO.insert(nota);
		}
	}
}
