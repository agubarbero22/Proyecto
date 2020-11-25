package ar.edu.arqSoft.jiraService.ticketService.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.arqSoft.jiraService.ticketService.common.model.GenericObject;

@Entity
@Table(name = "USUARIO")
public class Usuario extends GenericObject{
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="NAME")
	private String name;
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="LASTNAME")
	private String lastName;
	
	@NotNull
	@Size(min=1, max=100)
	@Column (name="EMAIL")
	private String email;
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="USUARIONAME")
	private String usuarioName;
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="PASSWORD")
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Tarea> tareas;
	
	@OneToMany (targetEntity=Usuario.class, mappedBy="USUARIO", fetch = FetchType.LAZY)
	private Set<Comentario> comentarios;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Proyecto> proyectos;
	
	public Set<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(Tarea tareas) {
		this.tareas.add(tareas);
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Set<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(Set<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	


	public String getUsuarioName() {
		return usuarioName;
	}

	public void setUsuarioName(String usuarioName) {
		this.usuarioName = usuarioName;
	}

	public void setTareas(Set<Tarea> tareas) {
		this.tareas = tareas;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
	
}