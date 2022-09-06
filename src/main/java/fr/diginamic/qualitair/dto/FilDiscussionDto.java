package fr.diginamic.qualitair.dto;

import java.time.LocalDateTime;



import fr.diginamic.qualitair.entites.FilDiscussion;

/**
 * Dto Fil de discussion (date création, titre, nom de l'utilisateur, nb de message)
 * */
public class FilDiscussionDto {

	 private LocalDateTime dateCreation;
	 private String titre;
	 private String utilisateurNom;
	 private Integer nbMessages;

	 
	 public static FilDiscussionDto from (FilDiscussion filDiscussion) {
		 return new FilDiscussionDto(filDiscussion.getDateCreation(),filDiscussion.getTitre(),filDiscussion.getUtilisateur().getNom(),filDiscussion.getMessages().size());
	 }
	 
	 
	public FilDiscussionDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FilDiscussionDto(LocalDateTime dateCreation, String titre, String utilisateurNom, Integer nbMessages) {
		super();
		this.dateCreation = dateCreation;
		this.titre = titre;
		this.utilisateurNom = utilisateurNom;
		this.nbMessages = nbMessages;
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


	public String getUtilisateurNom() {
		return utilisateurNom;
	}


	public void setUtilisateurNom(String utilisateurNom) {
		this.utilisateurNom = utilisateurNom;
	}


	public Integer getNbMessages() {
		return nbMessages;
	}


	public void setNbMessages(Integer nbMessages) {
		this.nbMessages = nbMessages;
	}



	 
	 

}
