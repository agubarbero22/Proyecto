package ar.edu.arqSoft.jiraService.ticketService.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ar.edu.arqSoft.jiraService.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.jiraService.ticketService.common.exception.EntityNotFoundException;
import ar.edu.arqSoft.jiraService.ticketService.dto.ProyectoRequestDto;
import ar.edu.arqSoft.jiraService.ticketService.dto.ProyectoResponseDto;
import ar.edu.arqSoft.jiraService.ticketService.services.ProyectoService;
import ar.edu.arqSoft.jiraService.ticketService.services.UsuarioService;

@Controller
@RequestMapping("/proyecto")
public class ProyectoController{

	@Autowired
	private ProyectoService proyectoService;

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ProyectoResponseDto> getAllProjecto() {
		return proyectoService.getAllProyecto();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProyectoResponseDto lookupEstadoById(@PathVariable("id") Long id) throws EntityNotFoundException {
		return proyectoService.getProyectoById(id);
	}
	
	@RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ProyectoResponseDto> lookupEstadoById(@PathVariable("name") String name) {
		return proyectoService.getProyectoByName(name);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody ProyectoResponseDto saveProjecto(@RequestBody ProyectoRequestDto request) throws BadRequestException, EntityNotFoundException {
		return proyectoService.insertProyecto(request);
	}

	@RequestMapping(value = "/setUsuarioToProjecto/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProyectoResponseDto setUsuario(@PathVariable("id") Long id, @RequestBody Long request) throws EntityNotFoundException, BadRequestException {
		System.out.println("aca comenzamos");
		return proyectoService.addUsuario(id, request);
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
}
