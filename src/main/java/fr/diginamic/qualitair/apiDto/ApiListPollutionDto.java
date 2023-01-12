package fr.diginamic.qualitair.apiDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiListPollutionDto {
	
	private ApiMainPollutionDto main;
	private ApiComponentsPollutionDto components;
	
	public ApiListPollutionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiListPollutionDto(ApiMainPollutionDto main, ApiComponentsPollutionDto components) {
		super();
		this.main = main;
		this.components = components;
	}

	public ApiMainPollutionDto getMain() {
		return main;
	}

	public void setMain(ApiMainPollutionDto main) {
		this.main = main;
	}

	public ApiComponentsPollutionDto getComponents() {
		return components;
	}

	public void setComponents(ApiComponentsPollutionDto components) {
		this.components = components;
	}
	


	

}
