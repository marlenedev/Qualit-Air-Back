package fr.diginamic.qualitair.dto;

import fr.diginamic.qualitair.entites.*;

public class ForumUtilisateurDto {

	private Integer id;
	private String nom;
	private String prenom;
	private String pseudo;
	private String email;
	private Commune commune;
	private String codePostal;
	private String dept;
	private String region;
	private String status;

	public static ForumUtilisateurDto from(Utilisateur utilisateur) {
		return new ForumUtilisateurDto(utilisateur.getId(), utilisateur.getNom(), utilisateur.getPrenom(),
				utilisateur.getPseudo(), utilisateur.getEmail(), utilisateur.getCommune(), utilisateur.getCodePostal(),
				utilisateur.getDept(), utilisateur.getRegion(), utilisateur.getStatus());
	}

	public ForumUtilisateurDto() {
	}

	public ForumUtilisateurDto(Integer id, String nom, String prenom, String pseudo, String email, Commune commune,
			String codePostal, String dept, String region, String status) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.email = email;
		this.commune = commune;
		this.codePostal = codePostal;
		this.dept = dept;
		this.region = region;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
