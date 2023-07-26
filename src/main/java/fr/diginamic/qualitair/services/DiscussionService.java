package fr.diginamic.qualitair.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import fr.diginamic.qualitair.dto.FilDiscussionDto;
import fr.diginamic.qualitair.dto.UtilisateurDto;
import fr.diginamic.qualitair.repository.ThemeRepository;
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

	private ThemeRepository themeRepository;
	private ThemeService themeService;

	public DiscussionService(DiscussionRepository discussionRepository, UtilisateurRepository utilisateurRepository, ThemeService themeService, ThemeRepository themeRepository) {
		super();
		this.discussionRepository = discussionRepository;
		this.utilisateurRepository = utilisateurRepository;
		this.themeRepository = themeRepository;
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
	 * @param  {@link AjouterDiscussionDto}
	 * @return sauvegarde du fil de discussion
	 */
	@Transactional
	public FilDiscussion creerDiscussion(AjouterDiscussionDto ajouterFilDiscussionDto) {
		// TODO à remplacer par Spring Security config
		Utilisateur utilisateur = utilisateurRepository.findByPseudo(ajouterFilDiscussionDto.getUtilisateur().getPseudo());
		//TODO récupérer theme de l'uri pas du corps de la requête
		Optional<Theme> theme = themeService.findById(ajouterFilDiscussionDto.getTheme().getId());
		
		FilDiscussion filDiscussion = new FilDiscussion();
		filDiscussion.setDateCreation(LocalDateTime.now());
		filDiscussion.setTitre(ajouterFilDiscussionDto.getTitre());
		filDiscussion.setUtilisateur(utilisateur);
		filDiscussion.setTheme(theme.get());
		discussionRepository.save(filDiscussion);
		return filDiscussion;
	}

	/**
	 * Récupère les fils de discussion lié à un id theme
	 * */
	public List<FilDiscussion> findAllByTheme(Integer idTheme) throws Exception {
		Optional<Theme> optionalTheme = themeRepository.findById(idTheme);
		if(optionalTheme.isPresent()){
			return discussionRepository.findAllByTheme(optionalTheme.get());
		}else{
			throw new Exception("le theme n'existe pas");
		}
	}


}
