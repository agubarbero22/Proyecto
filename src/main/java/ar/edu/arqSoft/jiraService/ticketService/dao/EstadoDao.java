package ar.edu.arqSoft.jiraService.ticketService.dao;

import java.util.List;

import ar.edu.arqSoft.jiraService.ticketService.common.dao.GenericDao;
import ar.edu.arqSoft.jiraService.ticketService.model.Estado;

public interface EstadoDao extends GenericDao<Estado, Long>{

	public List<Estado> FindByName (String nombre);
}