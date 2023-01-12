package fr.diginamic.qualitair.apiDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Sys de l'Api Current Weather Data
//"sys": {
//    "type": 2,
//    "id": 2075663,
//    "country": "IT",
//    "sunrise": 1661834187,
//    "sunset": 1661882248
//  },

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiSysDto {
	
	private Double sunrise;
	private Double sunset;
	
	
	public ApiSysDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ApiSysDto(Double sunrise, Double sunset) {
		super();
		this.sunrise = sunrise;
		this.sunset = sunset;
	}


	public Double getSunrise() {
		return sunrise;
	}


	public void setSunrise(Double sunrise) {
		this.sunrise = sunrise;
	}


	public Double getSunset() {
		return sunset;
	}


	public void setSunset(Double sunset) {
		this.sunset = sunset;
	}
	
	

}
