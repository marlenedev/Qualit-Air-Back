package fr.diginamic.qualitair.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import fr.diginamic.qualitair.dto.AjouterDiscussionDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import fr.diginamic.qualitair.dto.AjouterMessageDto;
import fr.diginamic.qualitair.dto.FilDiscussionDto;
import fr.diginamic.qualitair.entites.FilDiscussion;
import fr.diginamic.qualitair.entites.Message;
import fr.diginamic.qualitair.repository.DiscussionRepository;
import fr.diginamic.qualitair.services.DiscussionService;
import fr.diginamic.qualitair.services.MessageService;

@RestController
@CrossOrigin
@RequestMapping("fil-discussions")
public class FilDiscussionController {

	private DiscussionService discussionService;
	private MessageService messageService;
	public DiscussionRepository discussionRepository;

	public FilDiscussionController(DiscussionService discussionService, MessageService messageService,
			DiscussionRepository discussionRepository) {
		super();
		this.discussionService = discussionService;
		this.messageService = messageService;
		this.discussionRepository = discussionRepository;
	}

	/**
	 * Récupère les fils de discussion avec date/titre/nbMessage/utilisateur
	 */
	@GetMapping
	public List<FilDiscussionDto> listAll() {
		return this.discussionService.findAll().stream().map(FilDiscussionDto::from).toList();
	}
	
	@GetMapping("/{id}")
	public FilDiscussionDto findDiscussionsById(@PathVariable(name = "id") Integer id) {
		Optional<FilDiscussionDto> optDiscussion = this.discussionService.findById(id).map(FilDiscussionDto::from);
		
		if(optDiscussion.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return optDiscussion.get();
	}


	/**
	 * Ajoute une discussion
	 * */
	@PostMapping
	public ResponseEntity<FilDiscussion>addFilDiscussion(@RequestBody AjouterDiscussionDto filDiscussionDto){
		return ResponseEntity.ok(discussionService.creerDiscussion(filDiscussionDto));
	}

	/**
	 * Récupère les fils de discussion lié à un thème
	 * */
	@GetMapping("/theme/{idTheme}")
	public List<FilDiscussionDto> findAllByTheme(@PathVariable Integer idTheme) throws Exception {
		return this.discussionService.findAllByTheme(idTheme).stream().map(FilDiscussionDto::from).toList();
	}
}
