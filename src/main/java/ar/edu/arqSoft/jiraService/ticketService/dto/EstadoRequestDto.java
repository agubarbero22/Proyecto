package ar.edu.arqSoft.jiraService.ticketService.dto;


import ar.edu.arqSoft.jiraService.ticketService.common.dto.*;
public class EstadoRequestDto implements DtoEntity{

	private String name;
	
	private String description;

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

}