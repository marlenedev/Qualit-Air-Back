package fr.diginamic.qualitair.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.qualitair.dto.MessageDto;
import fr.diginamic.qualitair.services.MessageService;

@RestController
public class MessageController {
	
	private MessageService messageService;

	public MessageController(MessageService messageService) {
		super();
		this.messageService = messageService;
	}
	
	/**
	  * Récupère les messages avec date/titre fil discussion /nb de like/ pseudo
	  * */
	@GetMapping("messages")
	public List<MessageDto> listAll(){
		return this.messageService.findAll().stream().map(MessageDto::from).toList();
	}

}
