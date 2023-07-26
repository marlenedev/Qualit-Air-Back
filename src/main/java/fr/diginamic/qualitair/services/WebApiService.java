package fr.diginamic.qualitair.services;

import fr.diginamic.qualitair.models.HistoriqueMeteo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.diginamic.qualitair.apiDto.ApiCommuneDto;
import fr.diginamic.qualitair.apiDto.ApiMeteoReelDto;
import fr.diginamic.qualitair.apiDto.ApiPollutionDto;

@Service
public class WebApiService {
	
	@Autowired
	RestTemplate restTemplate;
	public final String appid="a3e4caaaf6336ce42f320a0386192460";
//	public final String appid2="355e2b11d06f6173e04883b948d6af0a";
	
	// Api Geocoding 
	public ApiCommuneDto getInfoCommune (String codePostal) {
		return restTemplate.getForObject("http://api.openweathermap.org/geo/1.0/zip?zip={zip code},{country code}&appid={API key}", ApiCommuneDto.class,codePostal,"FR",appid);
	}

	// Api Current Weather Data
	public ApiMeteoReelDto getInfoMeteoCommune (Double lat, Double lon) {
		return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}&units={units}&lang={lang}", ApiMeteoReelDto.class,lat,lon,appid,"metric","FR");

	}
	
	// Api Air Pollution
	public ApiPollutionDto getInfoPollutionCommune (Double lat, Double lon) {
		return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/air_pollution?lat={lat}&lon={lon}&appid={API key}", ApiPollutionDto.class,lat,lon,appid);
	}

	// Données de l'historique météo pour Nantes stockées sur PlanetHoster
	public HistoriqueMeteo getHistoriqueMeteo(String start, String end) {
		HistoriqueMeteo historiqueMeteo = restTemplate.getForObject("https://frugysoft.fr/meteo?start={start}&end={end}", HistoriqueMeteo.class, start, end);
		return historiqueMeteo;
	}
	
}
