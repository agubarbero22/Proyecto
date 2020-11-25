package ar.edu.arqSoft.jiraService.ticketService.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.arqSoft.jiraService.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.jiraService.ticketService.common.exception.EntityNotFoundException;
import ar.edu.arqSoft.jiraService.ticketService.dto.UsuarioRequestDto;
import ar.edu.arqSoft.jiraService.ticketService.dto.UsuarioResponseDto;
import ar.edu.arqSoft.jiraService.ticketService.services.UsuarioService;


@Controller
@RequestMapping("/usuario")
public class UsuarioController{
	
	@Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UsuarioResponseDto> getAllUsuario()
    {
        return usuarioService.getAllUsuarios();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> lookupEstadoById(@PathVariable("id") Long id) throws EntityNotFoundException, BadRequestException
    {
        UsuarioResponseDto dto = usuarioService.getUsuarioById(id);
		return new ResponseEntity<Object>(dto, HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UsuarioResponseDto registarUsuario(@RequestBody UsuarioRequestDto request)
    {
        return usuarioService.insertUsuario(request);
    }
}