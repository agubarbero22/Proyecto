package ar.edu.arqSoft.jiraService.ticketService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.jiraService.ticketService.common.dto.ModelDtoConverter;
import ar.edu.arqSoft.jiraService.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.jiraService.ticketService.common.exception.EntityNotFoundException;
import ar.edu.arqSoft.jiraService.ticketService.dao.EstadoDao;
import ar.edu.arqSoft.jiraService.ticketService.dto.EstadoRequestDto;
import ar.edu.arqSoft.jiraService.ticketService.dto.EstadoResponseDto;
import ar.edu.arqSoft.jiraService.ticketService.model.Estado;

@Service
@Transactional
public class EstadoService{
	
	@Autowired
	private EstadoDao estadoDao;
	
	public EstadoResponseDto insertEstado (EstadoRequestDto request){
		
		Estado estado = new Estado();
		
		estado.setName(request.getName());
		estado.setDescription(request.getDescription());
		
		estadoDao.insert(estado);
		
		EstadoResponseDto response = new EstadoResponseDto();
		
		response.setName(estado.getName());
		response.setDescription(estado.getDescription());		
		return response;
		
	}
	

	public List<EstadoResponseDto> GetByName(String name) throws EntityNotFoundException, BadRequestException {
		List<Estado> estados = estadoDao.FindByName(name);
		
		List<EstadoResponseDto> response = new ArrayList<EstadoResponseDto>();
		for(Estado estado: estados) {
			response.add((EstadoResponseDto) new ModelDtoConverter().convertToDto(estado,new EstadoResponseDto()));
		}
		return response;
	}



	public EstadoResponseDto getEstadoById(Long id) {
		Estado estado = estadoDao.load(id);
		
		EstadoResponseDto response = (EstadoResponseDto) new ModelDtoConverter().convertToDto(estado, new EstadoResponseDto());	
		return response;
	}
}