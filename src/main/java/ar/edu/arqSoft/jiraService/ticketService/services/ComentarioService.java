package ar.edu.arqSoft.jiraService.ticketService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.jiraService.ticketService.common.dto.ModelDtoConverter;
import ar.edu.arqSoft.jiraService.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.jiraService.ticketService.common.exception.EntityNotFoundException;
import ar.edu.arqSoft.jiraService.ticketService.dao.ComentarioDao;
import ar.edu.arqSoft.jiraService.ticketService.dao.TareaDao;
import ar.edu.arqSoft.jiraService.ticketService.dao.UsuarioDao;
import ar.edu.arqSoft.jiraService.ticketService.dto.ComentarioRequestDto;
import ar.edu.arqSoft.jiraService.ticketService.dto.ComentarioResponseDto;
import ar.edu.arqSoft.jiraService.ticketService.model.Comentario;


@Service
@Transactional
public class ComentarioService{
	
	@Autowired
	private ComentarioDao comentarioDao;
	
	private TareaDao tareaDao;
	
	private UsuarioDao usuarioDao;
	
	public ComentarioResponseDto insertComentario (ComentarioRequestDto request) throws EntityNotFoundException, BadRequestException{
	
		Comentario comentario = new Comentario();
		
		comentario.setDescription(request.getDescription());
		comentario.setEstado(request.getEstado());
		comentario.setUsuario(usuarioDao.load(request.getIdUsuario()));
		comentario.setTarea(tareaDao.load(request.getIdTarea()));
		
		comentarioDao.insert(comentario);
		
		ComentarioResponseDto response = new ComentarioResponseDto();
		
		response.setDescription(comentario.getDescription());
		response.setEstado(comentario.getEstado());
		response.setUsuario(comentario.getUsuario());
		response.setTask(comentario.getTarea());
		
		return response;
	}
	
	public List<ComentarioResponseDto> getAll() throws EntityNotFoundException, BadRequestException{
		List<Comentario> comentarios = comentarioDao.getAll();
		List<ComentarioResponseDto> response = new ArrayList<ComentarioResponseDto>();
		for (Comentario comentario : comentarios) {
			response.add((ComentarioResponseDto) new ModelDtoConverter().convertToDto(comentario, new ComentarioResponseDto()));
			}
		return response;
	}


	public ComentarioResponseDto getComentarioById(Long id) {
		Comentario comentario = comentarioDao.load(id);
		
		ComentarioResponseDto response = (ComentarioResponseDto) new ModelDtoConverter().convertToDto(comentario, new ComentarioResponseDto());	
		return response;
	}

	public List<ComentarioResponseDto> getAllComentario() {
		List<Comentario> comentarios = comentarioDao.getAll();
		 List<ComentarioResponseDto> response = new ArrayList<ComentarioResponseDto>();
		 
		 for (Comentario comentario : comentarios) {
			response.add((ComentarioResponseDto) new ModelDtoConverter().convertToDto(comentario, new ComentarioResponseDto()));
		 }
		
		 return response;
	}
	
	

}