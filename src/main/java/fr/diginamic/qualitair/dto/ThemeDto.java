package fr.diginamic.qualitair.dto;

import fr.diginamic.qualitair.entites.Theme;

/**
 * Classe DTO pour l'entité {@link Theme}
 *
 */
public class ThemeDto {

	private String libelle;

	public static ThemeDto from(Theme theme) {
		return new ThemeDto(theme.getLibelle());
	}

	public ThemeDto() {
		super();
	}

	public ThemeDto(String libelle) {
		super();
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
