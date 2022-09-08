package fr.diginamic.qualitair.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.qualitair.dto.AjouterDiscussionDto;
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
	 * Récupère tous les fils de discussion
	 */
	public List<FilDiscussion> findAll() {
		return this.discussionRepository.findAll();
	}

	/**
	 * Récupère un fil de discussion par son id
	 * @param id Integer id du {link {@link FilDiscussion}}
	 * @return un fil de discussion encapsulé dans un {@link Optional}
	 */
	public Optional<FilDiscussion> findById(Integer id) {
		return discussionRepository.findById(id);
	}

	/**
	 * Ajouter un fil de discussion avec date de création, titre, utilisateur, thème
	 * @param themeDto {}{@link AjouterDiscussionDto}
	 * @return sauvegarde du fil de discussion
	 */
	@Transactional
	public FilDiscussion creerDiscussion(AjouterDiscussionDto ajouterFilDiscussionDto) {
		FilDiscussion filDiscussion = new FilDiscussion();
		filDiscussion.setDateCreation(LocalDateTime.now());
		filDiscussion.setTitre(ajouterFilDiscussionDto.getTitre());
		filDiscussion.setUtilisateur(ajouterFilDiscussionDto.getUtilisateur());
		filDiscussion.setTheme(ajouterFilDiscussionDto.getTheme());
		return discussionRepository.save(filDiscussion);
	}

}
