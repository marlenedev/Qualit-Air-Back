package fr.diginamic.qualitair.dto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import fr.diginamic.qualitair.entites.FilDiscussion;

/**
 * Dto Fil de discussion (date création, titre, pseudo de l'utilisateur, nb de
 * message)
 */
public class FilDiscussionDto {

	private Integer id;
	private LocalDateTime dateCreation;
	private String titre;
	private String pseudo;
	private Integer themeId;
	private Set<MessageDto> messages;
	private Integer nbMessages;

	public static FilDiscussionDto from(FilDiscussion filDiscussion) {
		
		
		return new FilDiscussionDto(filDiscussion.getId(), filDiscussion.getDateCreation(), filDiscussion.getTitre(),
				filDiscussion.getUtilisateur().getPseudo(), filDiscussion.getTheme().getId(), filDiscussion.getMessages().stream().map(
						(msg) -> MessageDto.from(msg)).collect(Collectors.toSet()),
				filDiscussion.getMessages().size());
	}

	public FilDiscussionDto() {
		super();
	}

	public FilDiscussionDto(Integer id, LocalDateTime dateCreation, String titre, String pseudo, Integer themeId, Set<MessageDto> messages,
			Integer nbMessages) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
		this.titre = titre;
		this.pseudo = pseudo;
		this.themeId = themeId;
		this.messages = messages;
		this.nbMessages = nbMessages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getThemeId() {
		return themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}

	public Integer getNbMessages() {
		return nbMessages;
	}

	public void setNbMessages(Integer nbMessages) {
		this.nbMessages = nbMessages;
	}

	public Set<MessageDto> getMessages() {
		return messages;
	}

	public void setMessages(Set<MessageDto> messages) {
		this.messages = messages;
	}

}
