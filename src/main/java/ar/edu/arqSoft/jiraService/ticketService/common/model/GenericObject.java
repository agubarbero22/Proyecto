package ar.edu.arqSoft.jiraService.ticketService.common.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import ar.edu.arqSoft.jiraService.ticketService.model.Estado;
import ar.edu.arqSoft.jiraService.ticketService.model.Proyecto;

@MappedSuperclass
public abstract class GenericObject {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROYECTO")
	private Proyecto id;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ESTADO")
	private Estado id1;

	public Proyecto getId() {
		return id;
	}

	public void setId(Proyecto id) {
		this.id = id;
	}

	public Estado getId1() {
		return id1;
	}

	public void setId1(Estado id1) {
		this.id1 = id1;
	}
	
	

	
		
}