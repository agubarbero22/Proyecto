package ar.edu.arqSoft.jiraService.ticketService.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.arqSoft.jiraService.ticketService.common.model.GenericObject;

@Entity
@Table(name = "TAREA")
public class Tarea extends GenericObject{
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="NAME")
	private String name;
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="DESCRIPCION")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PROYECTO_ID")
	private Proyecto proyecto;
	
	@ManyToMany(mappedBy = "Users")
	private Set<Usuario> usuarios;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="STATE_ID")
	private Estado estado;
	
	@OneToMany (targetEntity=Usuario.class, mappedBy="usuario", fetch = FetchType.LAZY)
	private Set<Comentario> comentarios;
	
	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}