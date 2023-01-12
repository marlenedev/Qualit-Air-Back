package fr.diginamic.qualitair.apiDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Api Air Pollution
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiPollutionDto {
//*	{
//	    "coord": {
//	        "lon": 0.704,
//	        "lat": 47.3948
//	    },
//	    "list": [
//	        {
//	            "main": {
//	                "aqi": 2
//	            },
//	            "components": {
//	                "co": 216.96,
//	                "no": 0.41,
//	                "no2": 2.79,
//	                "o3": 62.94,
//	                "so2": 1.34,
//	                "pm2_5": 3.82,
//	                "pm10": 7.4,
//	                "nh3": 0.5
//	            },
//	            "dt": 1673442176
//	        }
//	    ]
//	}
	private ApiCoordCommuneDto coord;
	private ApiListPollutionDto[] list;
	
	
	public ApiPollutionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiPollutionDto(ApiCoordCommuneDto coord, ApiListPollutionDto[] list) {
		super();
		this.coord = coord;
		this.list = list;
	}
	public ApiCoordCommuneDto getCoord() {
		return coord;
	}
	public void setCoord(ApiCoordCommuneDto coord) {
		this.coord = coord;
	}
	public ApiListPollutionDto[] getList() {
		return list;
	}
	public void setList(ApiListPollutionDto[] list) {
		this.list = list;
	}
	
	
}
