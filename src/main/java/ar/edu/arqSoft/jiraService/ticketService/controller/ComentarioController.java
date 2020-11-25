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
import ar.edu.arqSoft.jiraService.ticketService.dto.ComentarioRequestDto;
import ar.edu.arqSoft.jiraService.ticketService.dto.ComentarioResponseDto;
import ar.edu.arqSoft.jiraService.ticketService.services.ComentarioService;



@Controller
@RequestMapping("/comentario")
public class ComentarioController{
	
	@Autowired
    private ComentarioService comentarioService;

    @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ComentarioResponseDto> getAllComentario()
    {
        return comentarioService.getAllComentario();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ComentarioResponseDto lookupEstadoById(@PathVariable("id") Long id) throws EntityNotFoundException
    {
        return comentarioService.getComentarioById(id);
    }
    
    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody ComentarioResponseDto saveComentario(@RequestBody ComentarioRequestDto request) throws EntityNotFoundException, BadRequestException
    {
        return comentarioService.insertComentario(request);
    }

}