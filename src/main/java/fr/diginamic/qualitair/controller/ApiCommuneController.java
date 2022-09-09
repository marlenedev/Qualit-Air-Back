package fr.diginamic.qualitair.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.qualitair.ApiDto.ApiCommuneAvecMeteoDto;
import fr.diginamic.qualitair.ApiDto.ApiCommuneDto;
import fr.diginamic.qualitair.ApiDto.ApiMeteoReelDto;
import fr.diginamic.qualitair.services.WebApiService;

@RestController
@RequestMapping("api")
public class ApiCommuneController {
	
	private final WebApiService webApiService;

	public ApiCommuneController(WebApiService webApiService) {
		super();
		this.webApiService = webApiService;
	}

	// Récupère les infos météo d'une commune suivant son code postal 
	@GetMapping("commune")
	public ApiCommuneAvecMeteoDto getInfoCommune (@RequestParam(value="codePostal") String codePostal) {
		var commune = webApiService.getInfoCommune(codePostal);
		var meteo = webApiService.getInfoMeteoCommune(commune.getLat(), commune.getLon());
		return new ApiCommuneAvecMeteoDto(commune, meteo);
	}
	
	
	

}
