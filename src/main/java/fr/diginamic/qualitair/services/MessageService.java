package fr.diginamic.qualitair.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.qualitair.dto.AjouterMessageDto;
import fr.diginamic.qualitair.entites.FilDiscussion;
import fr.diginamic.qualitair.entites.Message;
import fr.diginamic.qualitair.repository.DiscussionRepository;
import fr.diginamic.qualitair.repository.MessageRepository;
import fr.diginamic.qualitair.repository.ThemeRepository;

@Service
public class MessageService {

	private MessageRepository messageRepository;
	private DiscussionRepository discussionRepository;
	public MessageService(MessageRepository messageRepository, DiscussionRepository discussionRepository, ThemeRepository themeRepository) {
		super();
		this.messageRepository = messageRepository;
		this.discussionRepository = discussionRepository;
	}

	/**
	 * Récupère tous les messages
	 */
	public List<Message> findAll() {
		return this.messageRepository.findAll();
	}

	/**
	 * Ajouter un message avec texte du message, fil de discussion
	 * 
	 * @param ajouterMessageDto
	 * @return sauvegarde du message
	 */
	@Transactional
	public Message creerMessage(AjouterMessageDto ajouterMessageDto) {
		Optional<FilDiscussion> optDiscussion = discussionRepository.findById(ajouterMessageDto.getDiscussionId());
		
		Message message = new Message();
		message.setDate(LocalDateTime.now());
		message.setMessage(ajouterMessageDto.getMessage());
		message.setNbReactions(0);
		message.setNbVues(0);
		message.setFilDiscussion(optDiscussion.get());
		messageRepository.save(message);
		return message;
	}

}
