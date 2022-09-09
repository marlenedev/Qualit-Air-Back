package fr.diginamic.qualitair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.diginamic.qualitair.Api.Dto.ApiCommuneDto;
import fr.diginamic.qualitair.Api.Dto.ApiMeteoReelDto;

@Service
public class WebApiService {
	
	@Autowired
	RestTemplate restTemplate;
	public final String appid="a3e4caaaf6336ce42f320a0386192460";
//	http://api.openweathermap.org/geo/1.0/zip?zip=44000,FR&appid=4abb3f9636fd25b43314b2ea0f48c7b6
	
	public ApiCommuneDto getInfoCommune (String codePostal) {
		return restTemplate.getForObject("http://api.openweathermap.org/geo/1.0/zip?zip={zip code},{country code}&appid={API key}", ApiCommuneDto.class,codePostal,"FR",appid);
	}

	
	public ApiMeteoReelDto getInfoMeteoCommune (Double lat, Double lon) {
		return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}&units={units}&lang={lang}", ApiMeteoReelDto.class,lat,lon,appid,"metric","FR");

	}
}
