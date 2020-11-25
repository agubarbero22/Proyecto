package ar.edu.arqSoft.jiraService.ticketService.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.arqSoft.jiraService.ticketService.common.model.GenericObject;

@Entity
@Table(name="ESTADO")
public class Estado extends GenericObject{
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="ESTADO")
	private String name;
	
	@Size(min=1, max=250)
	@Column (name="DESCRIPTION")
	private String description;
	
	@OneToMany (targetEntity=Usuario.class, mappedBy="Tarea", fetch = FetchType.LAZY)
	private Set<Tarea> tareas;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(Set<Tarea> tareas) {
		this.tareas = tareas;
	}
	
	
}