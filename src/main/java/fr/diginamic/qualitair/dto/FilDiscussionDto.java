package fr.diginamic.qualitair.dto;

import java.time.LocalDateTime;

import fr.diginamic.qualitair.entites.FilDiscussion;

/**
 * Dto Fil de discussion (date création, titre, pseudo de l'utilisateur, nb de
 * message)
 */
public class FilDiscussionDto {

	private LocalDateTime dateCreation;
	private String titre;
	private String pseudo;
	private Integer nbMessages;

	public static FilDiscussionDto from(FilDiscussion filDiscussion) {
		return new FilDiscussionDto(filDiscussion.getDateCreation(), filDiscussion.getTitre(),
				filDiscussion.getUtilisateur().getPseudo(), filDiscussion.getMessages().size());
	}

	public FilDiscussionDto() {
		super();
	}

	public FilDiscussionDto(LocalDateTime dateCreation, String titre, String pseudo, Integer nbMessages) {
		super();
		this.dateCreation = dateCreation;
		this.titre = titre;
		this.pseudo = pseudo;
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

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Integer getNbMessages() {
		return nbMessages;
	}

	public void setNbMessages(Integer nbMessages) {
		this.nbMessages = nbMessages;
	}

}
