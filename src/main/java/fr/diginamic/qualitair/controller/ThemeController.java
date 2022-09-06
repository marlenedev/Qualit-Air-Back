package fr.diginamic.qualitair.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.qualitair.dto.ThemeDto;
import fr.diginamic.qualitair.entites.Theme;
import fr.diginamic.qualitair.services.ThemeService;

@RestController
public class ThemeController {

	private ThemeService themeService;

	public ThemeController(ThemeService themeService) {
		super();
		this.themeService = themeService;
	}

	/**
	 * S001 GET/themes
	 * Lister tous les thèmes
	 * @return liste de thèmes (dto)
	 */
	@GetMapping("themes")
	public List<ThemeDto> listAll() {
		return this.themeService.findAll().stream().map(ThemeDto::from).toList();
	}
		
	/**
	 * S017 DELETE/themes/{id}
	 * Supprimer un theme
	 * @param id Integer id du {@link Theme} à supprimer
	 */
	@DeleteMapping("themes/{id}")
	public ResponseEntity<?> supprimerTheme(@PathVariable(value = "id") Integer id) {
		Optional<Theme> optTheme = this.themeService.findById(id);
		if (optTheme.isPresent()) {
			Theme themeASupprimer = optTheme.get();
			this.themeService.delete(themeASupprimer);
			return ResponseEntity.status(200).body("Le thème no." + id + " a été supprimé");
		} else {
			return ResponseEntity.status(400).body("Le thème no." + id + " n'a pas pu être supprimé");
		}
	}
}
