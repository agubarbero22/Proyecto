package ar.edu.arqSoft.jiraService.ticketService.dto;

import java.util.Date;

import ar.edu.arqSoft.jiraService.ticketService.common.dto.*;
import ar.edu.arqSoft.jiraService.ticketService.model.EstadoProyecto;

public class ProyectoRequestDto implements DtoEntity{
	
	private String name;
	
	private String description;
	
	private Date startDate;
	
	private Date finishDate;
	
	private EstadoProyecto estado;
	
	
	private Long idUsuario;

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

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
}