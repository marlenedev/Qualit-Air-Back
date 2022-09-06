package fr.diginamic.qualitair.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.diginamic.qualitair.entites.Message;
import fr.diginamic.qualitair.repository.MessageRepository;

@Service
public class MessageService {
	
	private MessageRepository messageRepository;
	
	public MessageService(MessageRepository messageRepository) {
		super();
		this.messageRepository = messageRepository;
	}


	/**
	 * Récupère tous les messages 
	 * */
	public List<Message> findAll(){
		return this.messageRepository.findAll();
	}

}
