package fr.diginamic.qualitair.apiDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiComponentsPollutionDto {
//	   "components": {
//           "co": 216.96,
//           "no": 0.41,
//           "no2": 2.79,
//           "o3": 62.94,
//           "so2": 1.34,
//           "pm2_5": 3.82,
//           "pm10": 7.4,
//           "nh3": 0.5
//       },
	private Double co;
	private Double no;
	private Double no2;
	private Double o3;
	private Double so2;
	private Double pm2_5;
	private Double pm10;
	private Double nh3;
	
	public ApiComponentsPollutionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiComponentsPollutionDto(Double co, Double no, Double no2, Double o3, Double so2, Double pm2_5, Double pm10,
			Double nh3) {
		super();
		this.co = co;
		this.no = no;
		this.no2 = no2;
		this.o3 = o3;
		this.so2 = so2;
		this.pm2_5 = pm2_5;
		this.pm10 = pm10;
		this.nh3 = nh3;
	}

	public Double getCo() {
		return co;
	}

	public void setCo(Double co) {
		this.co = co;
	}

	public Double getNo() {
		return no;
	}

	public void setNo(Double no) {
		this.no = no;
	}

	public Double getNo2() {
		return no2;
	}

	public void setNo2(Double no2) {
		this.no2 = no2;
	}

	public Double getO3() {
		return o3;
	}

	public void setO3(Double o3) {
		this.o3 = o3;
	}

	public Double getSo2() {
		return so2;
	}

	public void setSo2(Double so2) {
		this.so2 = so2;
	}

	public Double getPm2_5() {
		return pm2_5;
	}

	public void setPm2_5(Double pm2_5) {
		this.pm2_5 = pm2_5;
	}

	public Double getPm10() {
		return pm10;
	}

	public void setPm10(Double pm10) {
		this.pm10 = pm10;
	}

	public Double getNh3() {
		return nh3;
	}

	public void setNh3(Double nh3) {
		this.nh3 = nh3;
	}
	
	

}
