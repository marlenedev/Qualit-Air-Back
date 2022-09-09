package fr.diginamic.qualitair.Api.Dto;
//{
//    "zip": "44000",
//    "name": "Nantes",
//    "lat": 47.2173,
//    "lon": -1.5534,
//    "country": "FR"
//}

public class ApiCommuneDto {
	
	private String zip;
	private String name;
	private Double lat;
	private Double lon;
	private String country;
	
	
	public ApiCommuneDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ApiCommuneDto(String zip, String name, Double lat, Double lon, String country) {
		super();
		this.zip = zip;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.country = country;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getLat() {
		return lat;
	}


	public void setLat(Double lat) {
		this.lat = lat;
	}


	public Double getLon() {
		return lon;
	}


	public void setLon(Double lon) {
		this.lon = lon;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
