package fr.diginamic.qualitair.dto;

import java.util.List;

import fr.diginamic.qualitair.entites.FilDiscussion;
import fr.diginamic.qualitair.entites.Theme;

/**
 * Classe DTO pour l'entité {@link Theme}
 *
 */
public class ThemeDto {

	private String libelle;
	private List<FilDiscussion> filDiscussion;

	public static ThemeDto from(Theme theme) {
		return new ThemeDto(theme.getLibelle(), theme.getFilDiscussion());
	}

	public ThemeDto() {
		super();
	}

	public ThemeDto(String libelle, List<FilDiscussion> filDiscussion) {
		super();
		this.libelle = libelle;
		this.filDiscussion = filDiscussion;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<FilDiscussion> getFilDiscussion() {
		return filDiscussion;
	}

	public void setFilDiscussion(List<FilDiscussion> filDiscussion) {
		this.filDiscussion = filDiscussion;
	}
	
}
