package fr.diginamic.qualitair.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.qualitair.dto.AjouterMessageDto;
import fr.diginamic.qualitair.dto.FilDiscussionDto;
import fr.diginamic.qualitair.entites.FilDiscussion;
import fr.diginamic.qualitair.entites.Message;
import fr.diginamic.qualitair.repository.DiscussionRepository;
import fr.diginamic.qualitair.services.DiscussionService;
import fr.diginamic.qualitair.services.MessageService;

@RestController
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
	@GetMapping("discussions")
	public List<FilDiscussionDto> listAll() {
		return this.discussionService.findAll().stream().map(FilDiscussionDto::from).toList();
	}

	/**
	 * S015 POST/discussions/{discID}/themes/{themeId}/messages Ajouter un message à
	 * un fil de discussion
	 * 
	 * @param discussionId
	 * @param themeId
	 * @param ajouterMessageDto
	 * @return si réussi : nouvel instance de {@link AjouterMessageDto} / sinon
	 *         erreur 400
	 */
	@PostMapping("discussions/{discussionId}/themes/{themeId}/messages")
	public ResponseEntity<?> ajouterMessageADiscussion(@PathVariable(name = "discussionId") Integer discussionId,
			@PathVariable(name = "themeId") Integer themeId, @RequestBody AjouterMessageDto ajouterMessageDto) {

		try {
			Optional<FilDiscussion> optDiscussion = discussionService.findById(discussionId);

			// L'id du thème doit correspondre au thème de la discussion
			if(optDiscussion.isPresent()) {
				
			}
			if (optDiscussion.get().getTheme().getId() == themeId) {
				ajouterMessageDto.setDiscussionId(discussionId);
				Message nouveauMessage = messageService.creerMessage(ajouterMessageDto);
				return ResponseEntity.status(200).body(nouveauMessage);
			} else {
				return ResponseEntity.status(400).body("La discussion n'a pas été trouvé");
			}
		} catch(RuntimeException e) {
			return ResponseEntity.status(400).body("Le message n'a pas pu être crée");
		}
	}
}
