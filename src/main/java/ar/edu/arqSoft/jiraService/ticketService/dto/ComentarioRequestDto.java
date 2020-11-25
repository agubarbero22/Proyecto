package ar.edu.arqSoft.jiraService.ticketService.dto;

import ar.edu.arqSoft.jiraService.ticketService.common.dto.*;

public class ComentarioRequestDto implements DtoEntity{

	private String description;
	
	private Boolean estado;
	
	private Long idTarea;
	
	private Long idUsuario;

	
	public Long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}