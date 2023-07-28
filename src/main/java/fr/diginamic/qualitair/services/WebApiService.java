package fr.diginamic.qualitair.services;

import fr.diginamic.qualitair.entites.Meteo;
import fr.diginamic.qualitair.repository.MeteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.diginamic.qualitair.apiDto.ApiCommuneDto;
import fr.diginamic.qualitair.apiDto.ApiMeteoReelDto;
import fr.diginamic.qualitair.apiDto.ApiPollutionDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WebApiService {
	
	@Autowired
	RestTemplate restTemplate;
	public final String appid="a3e4caaaf6336ce42f320a0386192460";
	private final MeteoRepository meteoRepository;

	public WebApiService(MeteoRepository meteoRepository) {
		this.meteoRepository = meteoRepository;
	}
	
	// Api Geocoding
	/**
	 * Récupère les données de  la commune en fonction de son code postal depuis l'API OpenWeather
	 * @param codePostal
	 * @return url, ApiCommuneDto, codePostal, appid
	 */
	public ApiCommuneDto getInfoCommune (String codePostal) {
		return restTemplate.getForObject("http://api.openweathermap.org/geo/1.0/zip?zip={zip code},{country code}&appid={API key}", ApiCommuneDto.class,codePostal,"FR",appid);
	}

	// Api Current Weather Data
	/**
	 * Récupère les données de  la météo actuelle en fonction de la latitude et la longitude depuis l'API OpenWeather
	 * @param lat
	 * @param lon
	 * @return url, ApiMeteReelDto, lat, lon, appid, metric
	 */
	public ApiMeteoReelDto getInfoMeteoCommune (Double lat, Double lon) {
		return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}&units={units}&lang={lang}", ApiMeteoReelDto.class,lat,lon,appid,"metric","FR");

	}
	
	// Api Air Pollution
	/**
	 * Récupère les données de pollution en fonction de la latitude et la longitude depuis l'API OpenWeather
	 * @param lat
	 * @param lon
	 * @return url, ApiPollutionDto, lat, lon, appid
	 */
	public ApiPollutionDto getInfoPollutionCommune (Double lat, Double lon) {
		return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/air_pollution?lat={lat}&lon={lon}&appid={API key}", ApiPollutionDto.class,lat,lon,appid);
	}


	/**
	 * Permet de sauvegarder la météo en base de données à la date actuelle.
	 * @param meteo
	 */
	public void sauvegardeMeteo(Meteo meteo) {
		meteo.setDate(LocalDate.now());
		meteoRepository.save(meteo);
	}

	/**
	 * Planification de la sauvegarde pour la météo toutes les 24h avec l'annotation @Scheduled
	 * La sauvegarde météo s'effectue seulement pour la ville de Nantes.
	 */
	@Scheduled(fixedRate = 86400000)
	public void planificationSauvegardeMeteo() {
		String codePostal = "44000";
		ApiCommuneDto communeDto = getInfoCommune(codePostal);
		ApiMeteoReelDto meteoReelDto = getInfoMeteoCommune(communeDto.getLat(), communeDto.getLon());

		Meteo meteo = new Meteo();
		meteo.setCodePostal(communeDto.getName());
		meteo.setTemp(meteoReelDto.getMain().getTemp());
		meteo.setHumidity(meteoReelDto.getMain().getHumidity());
		meteo.setPressure(meteoReelDto.getMain().getPressure());

		sauvegardeMeteo(meteo);
	}

	/**
	 * Récupère l'historique de météo entre deux dates à partir de la base de données
	 *
	 * @param start la date de début de la période de recherche
	 * @param end   la date de fin de la période de recherche
	 * @return la liste des enregistrements de météo entre les deux dates spécifiées
	 */
	public List<Meteo> getHistoriqueMeteo(LocalDate start, LocalDate end) {
		return meteoRepository.findByDateBetween(start, end);
	}
	
}
