package fr.diginamic.qualitair.ApiDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//"main": {
//"temp": 21.26,
//"feels_like": 21.35,
//"temp_min": 20.1,
//"temp_max": 22.15,
//"pressure": 1011,
//"humidity": 73
//},
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiIndicateurMeteoDto {
	
	private String temp;
	private String pressure;
	private String humidity;
	
	
	public ApiIndicateurMeteoDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ApiIndicateurMeteoDto(String temp, String pressure, String humidity) {
		super();
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
	}


	public String getTemp() {
		return temp;
	}


	public void setTemp(String temp) {
		this.temp = temp;
	}


	public String getPressure() {
		return pressure;
	}


	public void setPressure(String pressure) {
		this.pressure = pressure;
	}


	public String getHumidity() {
		return humidity;
	}


	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	
	

}
