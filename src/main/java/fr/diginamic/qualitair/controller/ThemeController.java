package fr.diginamic.qualitair.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.qualitair.dto.ThemeDto;
import fr.diginamic.qualitair.services.ThemeService;

@RestController
public class ThemeController {

	private ThemeService themeService;

	public ThemeController(ThemeService themeService) {
		super();
		this.themeService = themeService;
	}

	@GetMapping("themes")
	public List<ThemeDto> listAll() {
		return this.themeService.findAll().stream().map(ThemeDto::from).toList();
	}
	
}
