package fr.diginamic.qualitair.apiDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiMainPollutionDto {
	
	private Integer aqi;

	public ApiMainPollutionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiMainPollutionDto(Integer aqi) {
		super();
		this.aqi = aqi;
	}

	public Integer getAqi() {
		return aqi;
	}

	public void setAqi(Integer aqi) {
		this.aqi = aqi;
	}
	
	

}
