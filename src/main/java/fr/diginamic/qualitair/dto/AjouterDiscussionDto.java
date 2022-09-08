package fr.diginamic.qualitair.dto;

import java.time.LocalDateTime;

import fr.diginamic.qualitair.entites.FilDiscussion;
import fr.diginamic.qualitair.entites.Theme;
import fr.diginamic.qualitair.entites.Utilisateur;

public class AjouterDiscussionDto {

	private LocalDateTime dateCreation;
	private String titre;
	private UtilisateurDto utilisateur;
	private ThemeDto theme;
	
	public static AjouterDiscussionDto from(FilDiscussion filDiscussion) {
		return new AjouterDiscussionDto(filDiscussion.getDateCreation(), filDiscussion.getTitre(), UtilisateurDto.from(filDiscussion.getUtilisateur()), ThemeDto.from(filDiscussion.getTheme()));
	}

	public AjouterDiscussionDto(LocalDateTime dateCreation, String titre, UtilisateurDto utilisateur, ThemeDto theme) {
		super();
		this.dateCreation = dateCreation;
		this.titre = titre;
		this.utilisateur = utilisateur;
		this.theme = theme;
	}

	public AjouterDiscussionDto() {
		super();
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public UtilisateurDto getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDto utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ThemeDto getTheme() {
		return theme;
	}

	public void setTheme(ThemeDto theme) {
		this.theme = theme;
	}

}
