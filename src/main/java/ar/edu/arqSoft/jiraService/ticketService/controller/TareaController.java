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

import ar.edu.arqSoft.jiraService.ticketService.dto.TareaRequestDto;
import ar.edu.arqSoft.jiraService.ticketService.dto.TareaResponseDto;
import ar.edu.arqSoft.jiraService.ticketService.services.TareaService;


	@Controller
	@RequestMapping("/tarea")

	public class TareaController {
		
		@Autowired
	    private TareaService tareaService;

	    @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody List<TareaResponseDto> getAllTarea()
	    {
	        return tareaService.getAllTareas();
	    }

	    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody TareaResponseDto lookupEstadoById(@PathVariable("id") Long id)
	    {
	        return tareaService.getTareaById(id);
	    }
	    
	    @RequestMapping(value="/changeStateFromTask/{id}", method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody TareaResponseDto changeEstado(@PathVariable("id") Long id, @RequestBody Long request)
	    {
	        return tareaService.cambioEstado(id, request);
	    }
	    
	    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(code = HttpStatus.CREATED)
	    public @ResponseBody TareaResponseDto saveTarea(@RequestBody TareaRequestDto request)
	    {
	        return tareaService.insertTarea(request);
	    }
	    
	}