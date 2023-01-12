package fr.diginamic.qualitair.apiDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Dto Api Current Weather Data

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiMeteoReelDto {
	
	private ApiCoordCommuneDto coord;
	private ApiWeatherDto[] weather;
	private ApiIndicateurMeteoDto main;
	private ApiSysDto sys;
	
	public ApiMeteoReelDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiMeteoReelDto(ApiCoordCommuneDto coord, ApiWeatherDto[] weather, ApiIndicateurMeteoDto main,
			ApiSysDto sys) {
		super();
		this.coord = coord;
		this.weather = weather;
		this.main = main;
		this.sys = sys;
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

	public ApiSysDto getSys() {
		return sys;
	}

	public void setSys(ApiSysDto sys) {
		this.sys = sys;
	}
	
	
	
	
	

	

}
