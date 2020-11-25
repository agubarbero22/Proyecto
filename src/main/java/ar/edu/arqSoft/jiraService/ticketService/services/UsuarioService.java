package ar.edu.arqSoft.jiraService.ticketService.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.jiraService.ticketService.common.dto.ModelDtoConverter;
import ar.edu.arqSoft.jiraService.ticketService.dao.UsuarioDao;
import ar.edu.arqSoft.jiraService.ticketService.dto.UsuarioRequestDto;
import ar.edu.arqSoft.jiraService.ticketService.dto.UsuarioResponseDto;
import ar.edu.arqSoft.jiraService.ticketService.model.Usuario;

@Service
@Transactional
public class UsuarioService {

	private UsuarioDao usuarioDao;
	
	public UsuarioResponseDto insertUsuario(UsuarioRequestDto request){
		
		Usuario usuario = (Usuario) new ModelDtoConverter().convertToEntity(new Usuario(), request);
		
		usuarioDao.insert(usuario);
		
		UsuarioResponseDto response = new UsuarioResponseDto();
		
		response.setName(usuario.getName());
		response.setLastName(usuario.getLastName());
		response.setEmail(usuario.getEmail());
		
		
		return response;
	}
	
	public UsuarioResponseDto getUsuarioByName(String name) {
		
		Usuario usuario = (Usuario) usuarioDao.FindByName(name);
				
		UsuarioResponseDto response = (UsuarioResponseDto) new ModelDtoConverter().convertToDto(usuario, new UsuarioResponseDto());	
		return response;
	}
	
	public UsuarioResponseDto getUsuarioById(Long id) {
        
		Usuario usuario = usuarioDao.load(id);
				
		UsuarioResponseDto response = (UsuarioResponseDto) new ModelDtoConverter().convertToDto(usuario, new UsuarioResponseDto());	
		return response;
	}
	
	public List<UsuarioResponseDto> getAllUsuarios() {
		
		List<Usuario> usuarios = usuarioDao.getAll();
		
		List<UsuarioResponseDto> response = new ArrayList<UsuarioResponseDto>();
		 
		for (Usuario usuario : usuarios) {
			response.add((UsuarioResponseDto) new ModelDtoConverter().convertToDto(usuario, new UsuarioResponseDto()));
		}
		
		return response;
	}
	
}