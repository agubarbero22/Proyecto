package ar.edu.arqSoft.jiraService.ticketService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.jiraService.ticketService.common.dto.*;
import ar.edu.arqSoft.jiraService.ticketService.dao.EstadoDao;
import ar.edu.arqSoft.jiraService.ticketService.dao.TareaDao;
import ar.edu.arqSoft.jiraService.ticketService.dto.TareaRequestDto;
import ar.edu.arqSoft.jiraService.ticketService.dto.TareaResponseDto;
import ar.edu.arqSoft.jiraService.ticketService.model.Tarea;

@Service
@Transactional
public class TareaService {

	@Autowired
	private TareaDao tareaDao;
	
	@Autowired
	private EstadoDao estadoDao;
	
 public TareaResponseDto insertTarea(TareaRequestDto request){
		
		Tarea tarea = (Tarea) new ModelDtoConverter().convertToEntity(new Tarea(), request);
		
		tareaDao.insert(tarea);
		
		TareaResponseDto response = new TareaResponseDto();
		
		response.setProyecto(tarea.getProyecto().getId());
		response.setName(tarea.getName());
		response.setDescription(tarea.getDescription());
		response.setEstado(tarea.getEstado());
		response.setComentario(tarea.getComentarios());
		response.setUsuario(tarea.getUsuarios());
		
		return response;
	}
 
 
 public List<TareaResponseDto> getAllTareas() {
	 List<Tarea> tareas = tareaDao.getAll();
	 List<TareaResponseDto> response = new ArrayList<TareaResponseDto>();
	 
	 for (Tarea tarea : tareas) {
		response.add((TareaResponseDto) new ModelDtoConverter().convertToDto(tarea, new TareaResponseDto()));
	 }
	
	 return response;
}
 
 public TareaResponseDto getTareaByName(String name) {
		
		Tarea tarea = (Tarea) tareaDao.FindByName(name);
				
		TareaResponseDto response = (TareaResponseDto) new ModelDtoConverter().convertToDto(tarea, new TareaResponseDto());	
		return response;
	}
 
 
 public TareaResponseDto getTareaById(Long id) {
		Tarea tarea = tareaDao.load(id);
				
		TareaResponseDto response = (TareaResponseDto) new ModelDtoConverter().convertToDto(tarea, new TareaResponseDto());	
		return response;
	}
 
 public TareaResponseDto cambioEstado(Long id, Long request) {
		Tarea tarea = tareaDao.load(id);

		tarea.setEstado(estadoDao.load(request));
		tareaDao.update(tarea);

		Tarea task_after_update = tareaDao.load(id);
		TareaResponseDto response = new TareaResponseDto();

		response.setProyecto(task_after_update.getId());
		response.setName(task_after_update.getName());
		response.setDescription(task_after_update.getDescription());
		response.setUsuario(task_after_update.getUsuarios());
		response.setProyecto(task_after_update.getProyecto().getId());
		response.setEstado(task_after_update.getEstado());
		
		return response;
	}
 
	
}