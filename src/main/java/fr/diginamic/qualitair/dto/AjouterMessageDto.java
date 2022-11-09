package fr.diginamic.qualitair.dto;

import fr.diginamic.qualitair.entites.Message;

public class AjouterMessageDto {

	private String message;
	private Integer discussionId;

	public static AjouterMessageDto from(Message message) {
		return new AjouterMessageDto(message.getMessage(), message.getFilDiscussion().getId());
	}

	public AjouterMessageDto() {
		super();
	}

	public AjouterMessageDto(String message, Integer discussionId) {
		super();
		this.message = message;
		this.discussionId = discussionId;
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

}
