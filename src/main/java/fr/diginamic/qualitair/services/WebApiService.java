package fr.diginamic.qualitair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.diginamic.qualitair.apiDto.ApiCommuneDto;
import fr.diginamic.qualitair.apiDto.ApiMeteoReelDto;

@Service
public class WebApiService {
	
	@Autowired
	RestTemplate restTemplate;
	public final String appid="a3e4caaaf6336ce42f320a0386192460";
	
	// Api Geocoding 
	public ApiCommuneDto getInfoCommune (String codePostal) {
		return restTemplate.getForObject("http://api.openweathermap.org/geo/1.0/zip?zip={zip code},{country code}&appid={API key}", ApiCommuneDto.class,codePostal,"FR",appid);
	}

	// Api Current Weather Data
	public ApiMeteoReelDto getInfoMeteoCommune (Double lat, Double lon) {
		return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}&units={units}&lang={lang}", ApiMeteoReelDto.class,lat,lon,appid,"metric","FR");

	}
	
}
