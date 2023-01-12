package fr.diginamic.qualitair.apiDto;

public class ApiCommuneIndicateursDto {
	private ApiCommuneDto commune;
	private ApiMeteoReelDto meteo;
	private ApiPollutionDto pollution;
	public ApiCommuneIndicateursDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiCommuneIndicateursDto(ApiCommuneDto commune, ApiMeteoReelDto meteo, ApiPollutionDto pollution) {
		super();
		this.commune = commune;
		this.meteo = meteo;
		this.pollution = pollution;
	}
	public ApiCommuneDto getCommune() {
		return commune;
	}
	public void setCommune(ApiCommuneDto commune) {
		this.commune = commune;
	}
	public ApiMeteoReelDto getMeteo() {
		return meteo;
	}
	public void setMeteo(ApiMeteoReelDto meteo) {
		this.meteo = meteo;
	}
	public ApiPollutionDto getPollution() {
		return pollution;
	}
	public void setPollution(ApiPollutionDto pollution) {
		this.pollution = pollution;
	}
	
	
}
