package fr.diginamic.qualitair.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.qualitair.dto.AjouterDiscussionDto;
import fr.diginamic.qualitair.dto.ThemeDto;
import fr.diginamic.qualitair.entites.FilDiscussion;
import fr.diginamic.qualitair.entites.Theme;
import fr.diginamic.qualitair.exception.CreerDiscussionException;
import fr.diginamic.qualitair.exception.CreerThemeException;
import fr.diginamic.qualitair.services.DiscussionService;
import fr.diginamic.qualitair.services.ThemeService;

@RestController
@CrossOrigin
@RequestMapping("themes")
public class ThemeController {

	private ThemeService themeService;
	private DiscussionService discussionService;

	public ThemeController(ThemeService themeService, DiscussionService discussionService) {
		super();
		this.themeService = themeService;
		this.discussionService = discussionService;
	}

	/**
	 * S001 GET/themes
	 * Lister tous les thèmes
	 * @return liste de thèmes (dto)
	 */
	@GetMapping
	public List<ThemeDto> listAll() {
		return this.themeService.findAll().stream().map(ThemeDto::from).toList();
	}

	/**
	 * S018 POST/themes 
	 * Ajouter un thème avec un libellé
	 * @param themeDto
	 * @return si réussi : nouveau instance de {@link ThemeDto} / sinon erreur 400
	 */
	@PostMapping
	public ResponseEntity<?> creerTheme(@RequestBody ThemeDto themeDto) {
		try {
			Theme nouveauTheme = themeService.creerTheme(themeDto);
			return ResponseEntity.status(200).body(nouveauTheme);
		} catch (CreerThemeException e) {
			return ResponseEntity.status(400).body("Le thème n'a pas pu être créé");
		}
	}

	/**
	 * S017 DELETE/themes/{id} 
	 * Supprimer un theme
	 * @param id Integer id du {@link Theme} à supprimer
	 */
	@DeleteMapping("/{id}")
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
