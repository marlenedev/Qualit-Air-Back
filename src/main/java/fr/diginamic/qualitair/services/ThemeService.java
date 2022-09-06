package fr.diginamic.qualitair.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.qualitair.dto.ThemeDto;
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
	 * Récupère tous les thèmes
	 * @return une liste de tous les instances de {@link Theme}
	 */
	public List<Theme> findAll() {
		return this.themeRepository.findAll();
	}
	
	/**
	 * Récupère un thème par son id
	 * @param id Integer id du {@link Theme}
	 * @return un thème encapsulé dans un {@link Optional}
	 */
	public Optional<Theme> findById(Integer id) {
		return themeRepository.findById(id);
	}
	
	/**
	 * Ajouter un thème avec libellé
	 * @param themeDto {}{@link ThemeDto}
	 * @return sauvegarde du thème
	 */
	@Transactional
	public Theme creerTheme(ThemeDto themeDto) {
		Theme theme = new Theme();
		theme.setLibelle(themeDto.getLibelle());
		return themeRepository.save(theme);
	}
	
	/**
	 * Supprimer un thème
	 * @param theme
	 */
	public void delete(Theme theme) {
		this.themeRepository.delete(theme);
	}

}
