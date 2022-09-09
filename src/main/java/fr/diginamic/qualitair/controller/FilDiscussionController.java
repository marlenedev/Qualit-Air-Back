package fr.diginamic.qualitair.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.qualitair.dto.FilDiscussionDto;
import fr.diginamic.qualitair.services.DiscussionService;

@RestController
public class FilDiscussionController {

	private DiscussionService discussionService;

	public FilDiscussionController(DiscussionService discussionService) {
		super();
		this.discussionService = discussionService;
	}
	
	 /**
	  * Récupère les fils de discussion avec date/titre/nbMessage/utilisateur
	  * */
	@GetMapping("discussions")
	public List<FilDiscussionDto> listAll(){
		return this.discussionService.findAll().stream().map(FilDiscussionDto::from).toList();
	}

}
