package fr.diginamic.qualitair.dto;

import java.time.LocalDateTime;

import fr.diginamic.qualitair.entites.FilDiscussion;
import fr.diginamic.qualitair.entites.Theme;
import fr.diginamic.qualitair.entites.Utilisateur;

public class AjouterDiscussionDto {

	private LocalDateTime dateCreation;
	private String titre;
	private Utilisateur utilisateur;
	private Theme theme;
	
	public static AjouterDiscussionDto from(FilDiscussion filDiscussion) {
		return new AjouterDiscussionDto(filDiscussion.getDateCreation(), filDiscussion.getTitre(), filDiscussion.getUtilisateur(), filDiscussion.getTheme());
	}

	public AjouterDiscussionDto(LocalDateTime dateCreation, String titre, Utilisateur utilisateur, Theme theme) {
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

}
