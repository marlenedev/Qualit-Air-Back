package fr.diginamic.qualitair.controller;

import java.util.List;

import fr.diginamic.qualitair.dto.AjouterMessageDto;
import fr.diginamic.qualitair.entites.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.diginamic.qualitair.dto.MessageDto;
import fr.diginamic.qualitair.services.MessageService;

@RestController
@CrossOrigin
@RequestMapping("messages")
public class MessageController {
	
	private MessageService messageService;

	public MessageController(MessageService messageService) {
		super();
		this.messageService = messageService;
	}
	
	/**
	  * Récupère les messages avec date/titre fil discussion /nb de like/ pseudo
	  * */
	@GetMapping
	public List<MessageDto> listAll(){
		return this.messageService.findAll().stream().map(MessageDto::from).toList();
	}

	/**
	 * Récupère les messages d'un fil discussion en particulier
	 * */
	@GetMapping("/fil-discussion/{idFilDiscussion}")
	public List<MessageDto> findAllByFilDiscussion (@PathVariable Integer idFilDiscussion) throws Exception{
		return this.messageService.findAllByFilDiscussion(idFilDiscussion).stream().map(MessageDto::from).toList();
	}

	/**
	 * Ajoute un message
	 * */
	@PostMapping
	public ResponseEntity<Message> addMessage(@RequestBody AjouterMessageDto ajouterMessageDto){
		return ResponseEntity.ok(messageService.creerMessage(ajouterMessageDto));
	}
}
