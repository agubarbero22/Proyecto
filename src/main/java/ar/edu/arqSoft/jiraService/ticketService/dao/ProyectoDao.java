package ar.edu.arqSoft.jiraService.ticketService.dao;

import java.util.List;

import ar.edu.arqSoft.jiraService.ticketService.common.dao.GenericDao;
import ar.edu.arqSoft.jiraService.ticketService.model.Proyecto;

public interface ProyectoDao extends GenericDao<Proyecto, Long>{
	
	public List<Proyecto> FindByName (String nombre);
}