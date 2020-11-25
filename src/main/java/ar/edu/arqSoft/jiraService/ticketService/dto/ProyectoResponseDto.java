package ar.edu.arqSoft.jiraService.ticketService.dto;

import java.util.Date;
import java.util.Set;

import ar.edu.arqSoft.jiraService.ticketService.common.dto.*;
import ar.edu.arqSoft.jiraService.ticketService.model.*;

public class ProyectoResponseDto implements DtoEntity{
	
	private String name;
	
	private String description;
	
	private Date startDate;
	
	private Date finishDate;
	
	private EstadoProyecto estado;
	
	private Set<Tarea> tarea;
	
	private Set<Usuario> usuario;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public EstadoProyecto getEstado() {
		return estado;
	}

	public void setEstado(EstadoProyecto estado) {
		this.estado = estado;
	}

	public Set<Tarea> getTarea() {
		return tarea;
	}

	public void setTarea(Set<Tarea> tarea) {
		this.tarea = tarea;
	}

	public Set<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}