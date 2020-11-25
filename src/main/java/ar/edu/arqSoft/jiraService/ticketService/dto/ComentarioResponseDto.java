package ar.edu.arqSoft.jiraService.ticketService.dto;

import ar.edu.arqSoft.jiraService.ticketService.common.dto.*;
import ar.edu.arqSoft.jiraService.ticketService.model.Tarea;
import ar.edu.arqSoft.jiraService.ticketService.model.Usuario;

public class ComentarioResponseDto implements DtoEntity{
	
	private String description; 
	
	private Boolean estado;
	
	private Usuario usuario;
	
	private Tarea tarea;

	public Tarea getTarea() {
		return tarea;
	}

	public void setTask(Tarea tarea) {
		this.tarea = tarea;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}