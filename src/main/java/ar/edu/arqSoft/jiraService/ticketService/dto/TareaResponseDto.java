package ar.edu.arqSoft.jiraService.ticketService.dto;

import java.util.Set;

import ar.edu.arqSoft.jiraService.ticketService.common.dto.*;
import ar.edu.arqSoft.jiraService.ticketService.model.*;

public class TareaResponseDto implements DtoEntity{
	
	private String name;
	
	private String description;
	
	private Set<Usuario> usuario;
	
	private Set<Comentario> comentario;
	
	private Proyecto proyecto;
	

	private Estado estado;
	
	

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
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

	public Set<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Set<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(Set<Comentario> comentario) {
		this.comentario = comentario;
	}


	
	
	
}