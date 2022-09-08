package fr.diginamic.qualitair.dto;

import fr.diginamic.qualitair.entites.FilDiscussion;

public class AjouterDiscussionDto {

	private String titre;
	private UtilisateurDto utilisateur;
	private ThemeDto theme;
	
	public static AjouterDiscussionDto from(FilDiscussion filDiscussion) {
		return new AjouterDiscussionDto(filDiscussion.getTitre(), UtilisateurDto.from(filDiscussion.getUtilisateur()), ThemeDto.from(filDiscussion.getTheme()));
	}

	public AjouterDiscussionDto(String titre, UtilisateurDto utilisateur, ThemeDto theme) {
		super();
		this.titre = titre;
		this.utilisateur = utilisateur;
		this.theme = theme;
	}

	public AjouterDiscussionDto() {
		super();
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
