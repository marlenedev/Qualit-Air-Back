package fr.diginamic.qualitair.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.qualitair.Api.Dto.ApiCommuneDto;
import fr.diginamic.qualitair.Api.Dto.ApiMeteoReelDto;
import fr.diginamic.qualitair.services.WebApiService;

@RestController
@RequestMapping("api")
public class ApiCommuneController {
	
	private final WebApiService webApiService;

	public ApiCommuneController(WebApiService webApiService) {
		super();
		this.webApiService = webApiService;
	}
	
	@GetMapping("commune")
	public ApiCommuneDto getInfoCommune (@RequestParam(value="codePostal") String codePostal) {
		return webApiService.getInfoCommune(codePostal);
	}
	
	@GetMapping("communeMeteo")
	public ApiMeteoReelDto getInfoMeteoCommune(@RequestParam(value="lat") Double lat, @RequestParam (value="lon")Double lon) {
		return webApiService.getInfoMeteoCommune(lat, lon);
	}

}
