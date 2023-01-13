package fr.diginamic.qualitair.dto;

import fr.diginamic.qualitair.entites.Theme;

/**
 * Classe DTO pour l'entité {@link Theme}
 *
 */
public class ThemeDto {

	private Integer id;
	private String libelle;

	public static ThemeDto from(Theme theme) {
		return new ThemeDto(theme.getId(), theme.getLibelle());
	}

	public ThemeDto() {
		super();
	}

	public ThemeDto(Integer id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


}
