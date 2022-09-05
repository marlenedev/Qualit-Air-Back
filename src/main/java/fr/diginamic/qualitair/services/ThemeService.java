package fr.diginamic.qualitair.services;

import java.util.List;
import org.springframework.stereotype.Service;

import fr.diginamic.qualitair.entites.Theme;
import fr.diginamic.qualitair.repository.ThemeRepository;

/**
 * Récupère les thèmes
 *
 */
@Service
public class ThemeService {

	private ThemeRepository themeRepository;

	public ThemeService(ThemeRepository themeRepository) {
		super();
		this.themeRepository = themeRepository;
	}
	
	/**
	 * Récupère tous les thèmes de la table 'themes'
	 * @return List<Theme> une liste de tous les thèmes
	 */
	public List<Theme> findAll() {
		return this.themeRepository.findAll();
	}

}
