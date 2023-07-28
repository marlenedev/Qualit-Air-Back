package fr.diginamic.qualitair.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import fr.diginamic.qualitair.entites.Utilisateur;
import fr.diginamic.qualitair.repository.UtilisateurRepository;
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

	private UtilisateurRepository utilisateurRepository;

	public MessageService(MessageRepository messageRepository, DiscussionRepository discussionRepository,UtilisateurRepository utilisateurRepository) {
		super();
		this.messageRepository = messageRepository;
		this.discussionRepository = discussionRepository;
		this.utilisateurRepository = utilisateurRepository;
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
	 * @param ajouterMessageDto {@link AjouterMessageDto}
	 * @return Le nouveau message
	 */
	@Transactional
	public Message creerMessage(AjouterMessageDto ajouterMessageDto) {

		Utilisateur utilisateur = utilisateurRepository.findByPseudo(ajouterMessageDto.getUtilisateur().getPseudo());

		Optional<FilDiscussion> optDiscussion = discussionRepository.findById(ajouterMessageDto.getDiscussionId());
		
		Message message = new Message();
		message.setDate(LocalDateTime.now());
		message.setMessage(ajouterMessageDto.getMessage());
		message.setNbReactions(0);
		message.setUtilisateur(utilisateur);
		message.setNbVues(0);
		message.setFilDiscussion(optDiscussion.get());
		messageRepository.save(message);
		return message;
	}

	/**
	 * Récupère tous les messages associés à un fil de discussion spécifié par son identifiant.
	 *
	 * @param idFilDiscussion L'identifiant du fil de discussion pour lequel récupérer les messages.
	 * @return Une liste contenant tous les messages associés au fil de discussion spécifié.
	 * @throws Exception Si le fil de discussion avec l'identifiant spécifié n'existe pas.
	 */
	public List<Message> findAllByFilDiscussion(Integer idFilDiscussion) throws Exception{
		Optional <FilDiscussion> optionalFilDiscussion = discussionRepository.findById(idFilDiscussion);
		if(optionalFilDiscussion.isPresent()){
			return messageRepository.findAllByFilDiscussion(optionalFilDiscussion.get());
		}else{
			throw new Exception("le fil de discussion n'existe pas");
		}
	}

}
