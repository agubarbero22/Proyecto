package ar.edu.arqSoft.jiraService.ticketService.dao;

import java.util.List;

import ar.edu.arqSoft.jiraService.ticketService.common.dao.GenericDao;
import ar.edu.arqSoft.jiraService.ticketService.model.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Long>{

	public List<Usuario> FindByName (String nombre);
}