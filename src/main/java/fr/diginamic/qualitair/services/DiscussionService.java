package fr.diginamic.qualitair.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.qualitair.dto.AjouterDiscussionDto;
import fr.diginamic.qualitair.entites.FilDiscussion;
import fr.diginamic.qualitair.entites.Theme;
import fr.diginamic.qualitair.entites.Utilisateur;
import fr.diginamic.qualitair.repository.DiscussionRepository;
import fr.diginamic.qualitair.repository.UtilisateurRepository;

@Service
public class DiscussionService {

	private DiscussionRepository discussionRepository;
	private UtilisateurRepository utilisateurRepository;
	private ThemeService themeService;

	public DiscussionService(DiscussionRepository discussionRepository, UtilisateurRepository utilisateurRepository, ThemeService themeService) {
		super();
		this.discussionRepository = discussionRepository;
		this.utilisateurRepository = utilisateurRepository;
		this.themeService = themeService;
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
	 * @param ajouterDiscussionDto {@link AjouterDiscussionDto}
	 * @return sauvegarde du fil de discussion
	 */
	@Transactional
	public FilDiscussion creerDiscussion(AjouterDiscussionDto ajouterFilDiscussionDto) {
		// TODO à remplacer par Spring Security config
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(ajouterFilDiscussionDto.getUtilisateur().getEmail());
		//TODO récupérer theme de l'uri pas du corps de la requête
		Optional<Theme> theme = themeService.findById(ajouterFilDiscussionDto.getTheme().getId());
		
		FilDiscussion filDiscussion = new FilDiscussion();
		filDiscussion.setDateCreation(LocalDateTime.now());
		filDiscussion.setTitre(ajouterFilDiscussionDto.getTitre());
		filDiscussion.setUtilisateur(utilisateur.get());
		filDiscussion.setTheme(theme.get());
		discussionRepository.save(filDiscussion);
		return filDiscussion;
	}

}
