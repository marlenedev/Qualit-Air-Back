package fr.diginamic.qualitair.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.qualitair.dto.ApiCommuneDto;
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

}
