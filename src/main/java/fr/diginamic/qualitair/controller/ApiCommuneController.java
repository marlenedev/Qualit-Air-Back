package fr.diginamic.qualitair.controller;

import fr.diginamic.qualitair.apiDto.ApiMeteoReelDto;
import fr.diginamic.qualitair.apiDto.ApiPollutionDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import fr.diginamic.qualitair.apiDto.ApiCommuneIndicateursDto;
import fr.diginamic.qualitair.services.WebApiService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ApiCommuneController {
	
	private final WebApiService webApiService;

	public ApiCommuneController(WebApiService webApiService) {
		super();
		this.webApiService = webApiService;
	}

	// Récupère les infos météo d'une commune suivant son code postal 
	@GetMapping("indicateurs")
	public ApiCommuneIndicateursDto getInfoCommune (@RequestParam(value="codePostal") String codePostal) {
		var commune = webApiService.getInfoCommune(codePostal);
		var meteo = webApiService.getInfoMeteoCommune(commune.getLat(), commune.getLon());
		var pollution = webApiService.getInfoPollutionCommune(commune.getLat(), commune.getLon());
		return new ApiCommuneIndicateursDto(commune, meteo, pollution);
	}

	@GetMapping("indicateurs/meteo")
	public ApiCommuneIndicateursDto getInfoMeteo (@RequestParam(value="codePostal") String codePostal) {
		var commune = webApiService.getInfoCommune(codePostal);
		var meteo = webApiService.getInfoMeteoCommune(commune.getLat(), commune.getLon());
		var emptyPollution = new ApiPollutionDto();
		return new ApiCommuneIndicateursDto(commune, meteo, emptyPollution);
	}

	@GetMapping("indicateurs/pollution")
	public ApiCommuneIndicateursDto getInfoPollution (@RequestParam(value="codePostal") String codePostal) {
		var commune = webApiService.getInfoCommune(codePostal);
		var pollution = webApiService.getInfoPollutionCommune(commune.getLat(), commune.getLon());
		var emptyPollution = new ApiMeteoReelDto();
		return new ApiCommuneIndicateursDto(commune, emptyPollution, pollution);
	}

}
