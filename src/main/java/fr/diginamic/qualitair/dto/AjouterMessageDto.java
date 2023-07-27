package fr.diginamic.qualitair.dto;

import fr.diginamic.qualitair.entites.Message;

public class AjouterMessageDto {

	private String message;
	private Integer discussionId;

	private UtilisateurDto utilisateur;

	public static AjouterMessageDto from(Message message) {
		return new AjouterMessageDto(message.getMessage(), message.getFilDiscussion().getId(),UtilisateurDto.from(message.getUtilisateur()));
	}

	public AjouterMessageDto() {
		super();
	}

	public AjouterMessageDto(String message, Integer discussionId, UtilisateurDto utilisateur) {
		super();
		this.message = message;
		this.discussionId = discussionId;
		this.utilisateur = utilisateur;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getDiscussionId() {
		return discussionId;
	}

	public void setDiscussionId(Integer discussionId) {
		this.discussionId = discussionId;
	}

	public UtilisateurDto getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDto utilisateur) {
		this.utilisateur = utilisateur;
	}

}
