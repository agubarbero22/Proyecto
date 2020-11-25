package ar.edu.arqSoft.jiraService.ticketService.dto;

import ar.edu.arqSoft.jiraService.ticketService.common.dto.*;

public class TareaRequestDto implements DtoEntity{
	
	private Long id;
	
	private Long idEstado;
	
	private Long idUsuario;
	
	private Long idProyecto;
	
	private String name;
	
	private String description;	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}

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
}