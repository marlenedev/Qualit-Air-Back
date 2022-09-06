package fr.diginamic.qualitair.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.diginamic.qualitair.entites.FilDiscussion;
import fr.diginamic.qualitair.repository.DiscussionRepository;

@Service
public class DiscussionService {
	
	private DiscussionRepository discussionRepository;

	public DiscussionService(DiscussionRepository discussionRepository) {
		super();
		this.discussionRepository = discussionRepository;
	}
	
	
	/**
	 * Récupère tout les fils de discussion 
	 * */
	public List<FilDiscussion> findAll(){
		return this.discussionRepository.findAll();
	}
	
	

}
