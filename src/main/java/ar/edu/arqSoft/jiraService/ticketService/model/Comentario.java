package ar.edu.arqSoft.jiraService.ticketService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.arqSoft.jiraService.ticketService.common.model.GenericObject;


@Entity
@Table(name="COMENTARIO")
public class Comentario extends GenericObject{
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="DESCRIPTION")
	private String description;
	
	@Column(name="ESTADO_DEL_COMENTARIO") //VER
	private Boolean estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COMENTARIO_ID")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USUARIO")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="TAREA_ID")
	private Tarea tarea;

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

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}