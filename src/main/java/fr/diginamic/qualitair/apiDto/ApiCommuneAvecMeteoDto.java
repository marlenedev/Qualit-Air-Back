package fr.diginamic.qualitair.apiDto;

public class ApiCommuneAvecMeteoDto {
	private ApiCommuneDto commune;
	private ApiMeteoReelDto meteo;
	
	
	
	
	public ApiCommuneAvecMeteoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiCommuneAvecMeteoDto(ApiCommuneDto commune, ApiMeteoReelDto meteo) {
		super();
		this.commune = commune;
		this.meteo = meteo;
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
	
	

}
