package ar.edu.arqSoft.jiraService.ticketService.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ar.edu.arqSoft.jiraService.ticketService.common.dao.*;
import ar.edu.arqSoft.jiraService.ticketService.model.Tarea;

@Repository
public class TareaDaoImp extends GenericDaoImp<Tarea, Long> implements TareaDao{
	
	public List<Tarea> FindByName (String nombre){

		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Tarea> criteria = builder.createQuery(Tarea.class);
        Root<Tarea> entity = criteria.from(Tarea.class);

        criteria.select(entity).where(builder.equal(entity.get("name"+" "+"lastname"), nombre));
        return em.createQuery(criteria).getResultList();
	}
}