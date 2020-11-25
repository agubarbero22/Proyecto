package ar.edu.arqSoft.jiraService.ticketService.dao;

import java.util.List;

import ar.edu.arqSoft.jiraService.ticketService.common.dao.*;
import ar.edu.arqSoft.jiraService.ticketService.model.Tarea;

public interface TareaDao extends GenericDao<Tarea, Long>{
	
	public List<Tarea> FindByName (String nombre);
	
}