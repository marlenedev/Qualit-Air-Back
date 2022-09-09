package fr.diginamic.qualitair.ApiDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//"coord": {
//"lon": -1.5541,
//"lat": 47.2186
//},
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiCoordCommuneDto {

	private Double lon;
	private Double lat;
	

	public ApiCoordCommuneDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ApiCoordCommuneDto(Double lon, Double lat) {
		super();
		this.lon = lon;
		this.lat = lat;
	}


	public Double getLon() {
		return lon;
	}


	public void setLon(Double lon) {
		this.lon = lon;
	}


	public Double getLat() {
		return lat;
	}


	public void setLat(Double lat) {
		this.lat = lat;
	}
	
	
}
