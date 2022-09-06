package fr.diginamic.qualitair.dto;


import java.time.LocalDateTime;

import fr.diginamic.qualitair.entites.Message;

/**
 * Dto Messages (date , titre fil de discussion, pseudo de l'utilisateur, nb de vue, message)
 * */

public class MessageDto {
	
	private String titre;
	private LocalDateTime date;
	private String message;
	private Integer nbVue;
	private String pseudo;
	
	
	public static MessageDto from (Message message) {
		return new MessageDto(message.getFilDiscussion().getTitre(), message.getDate(), message.getMessage(), message.getNbVues(), message.getUtilisateur().getPseudo());
	}
	
	
	public MessageDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MessageDto(String titre, LocalDateTime date, String message, Integer nbVue, String pseudo) {
		super();
		this.titre = titre;
		this.date = date;
		this.message = message;
		this.nbVue = nbVue;
		this.pseudo = pseudo;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}



	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Integer getNbVue() {
		return nbVue;
	}


	public void setNbVue(Integer nbVue) {
		this.nbVue = nbVue;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	
	
	
	

}
