package ar.edu.arqSoft.jiraService.ticketService.model;

import java.util.Date;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.arqSoft.jiraService.ticketService.common.model.GenericObject;

@Entity
@Table(name="PROYECTO")
public class Proyecto extends GenericObject{
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="NAME")
	private String name;
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="DESCRPTION")
	private String description;
	
	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ESTADO_DEL_PROYECTO")
	private EstadoProyecto estado;
	
	@ManyToMany(mappedBy = "usuarios")
	private Set<Usuario> usuarios;
	
	@OneToMany (targetEntity=Usuario.class, mappedBy="TAREA", fetch = FetchType.LAZY)
	private Set<Tarea>  tareas;

	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date finishDate;
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

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setTareas(Set<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios.add(usuarios);
	}

	public Set<Tarea> getTareas() {
		return tareas;
	}

	public void setTasks(Tarea tareas) {
		this.tareas.add(tareas);
	}
	
	
}