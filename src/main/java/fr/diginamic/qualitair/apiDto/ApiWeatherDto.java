package fr.diginamic.qualitair.apiDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//"weather": [
//{
//  "id": 500,
//  "main": "Rain",
//  "description": "light rain",
//  "icon": "10d"
//}
//],
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiWeatherDto {
	
	private String description;
	private String icon;
	
	public ApiWeatherDto(String description, String icon) {
		super();
		this.description = description;
		this.icon = icon;
	}
	public ApiWeatherDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	
	

}
