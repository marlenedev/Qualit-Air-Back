package fr.diginamic.qualitair.services;

import java.util.List;
import org.springframework.stereotype.Service;

import fr.diginamic.qualitair.entites.Theme;
import fr.diginamic.qualitair.repository.ThemeRepository;

@Service
public class ThemeService {

	private ThemeRepository themeRepository;

	public ThemeService(ThemeRepository themeRepository) {
		super();
		this.themeRepository = themeRepository;
	}
	
	public List<Theme> findAll() {
		return this.themeRepository.findAll();
	}

}
