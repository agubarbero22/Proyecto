package ar.edu.arqSoft.jiraService.ticketService.dao;

import org.springframework.stereotype.Repository;

import ar.edu.arqSoft.jiraService.ticketService.common.dao.GenericDaoImp;
import ar.edu.arqSoft.jiraService.ticketService.model.Comentario;

@Repository
public class ComentarioDaoImp extends GenericDaoImp<Comentario, Long> implements ComentarioDao{
	
}