package fr.diginamic.qualitair.Api.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//{
//    "coord": {
//        "lon": -1.5541,
//        "lat": 47.2186
//    },
//    "weather": [
//        {
//            "id": 500,
//            "main": "Rain",
//            "description": "light rain",
//            "icon": "10d"
//        }
//    ],
//    "main": {
//        "temp": 21.26,
//        "feels_like": 21.35,
//        "temp_min": 20.1,
//        "temp_max": 22.15,
//        "pressure": 1011,
//        "humidity": 73
//    },
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiMeteoReelDto {
	
	private ApiCoordCommuneDto coord;
	private ApiWeatherDto[] weather;
	private ApiIndicateurMeteoDto main;
	
	public ApiMeteoReelDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiMeteoReelDto(ApiCoordCommuneDto coord, ApiWeatherDto[] weather, ApiIndicateurMeteoDto main ) {
		super();
		this.coord = coord;
		this.weather = weather;
		this.main = main;
	}
	public ApiCoordCommuneDto getCoord() {
		return coord;
	}
	public void setCoord(ApiCoordCommuneDto coord) {
		this.coord = coord;
	}
	public ApiWeatherDto[] getWeather() {
		return weather;
	}
	public void setWeather(ApiWeatherDto[] weather) {
		this.weather = weather;
	}
	
	public ApiIndicateurMeteoDto getMain() {
		return main;
	}
	public void setMain(ApiIndicateurMeteoDto main) {
		this.main = main;
	}
	
	
	

	

}
