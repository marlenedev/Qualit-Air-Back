package fr.diginamic.qualitair.dto;

import fr.diginamic.qualitair.entites.*;

import java.time.LocalDateTime;

public class UtilisateurDto {

    private String nom;
    private String prenom;
    private String email;
    private String pseudo;
    private String region;
    private Commune commune;
    private String codePostal;
    private String mdpHashe;
    private RolesEnum role;
    private LocalDateTime dateFinSuspension;
    private boolean suspended;


    public static UtilisateurDto from(Utilisateur utilisateur) {
        return new UtilisateurDto(utilisateur.getNom(),utilisateur.getPrenom(),utilisateur.getEmail(),utilisateur.getPseudo(),utilisateur.getRegion(), utilisateur.getCommune(), utilisateur.getCodePostal(), utilisateur.getMdpHashe(), utilisateur.getRole());
    }

    public UtilisateurDto() {
    }

    public UtilisateurDto(String nom, String prenom, String email, String pseudo, String region, Commune commune, String codePostal, String mdpHashe, RolesEnum role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pseudo = pseudo;
        this.region = region;
        this.commune = commune;
        this.codePostal = codePostal;
        this.mdpHashe = mdpHashe;
        this.role = role;
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

    public LocalDateTime getDateFinSuspension() {
        return dateFinSuspension;
    }

    public void setDateFinSuspension(LocalDateTime dateFinSuspension) {
        this.dateFinSuspension = dateFinSuspension;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
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

    public String getMdpHashe() {
        return mdpHashe;
    }

    public void setMdpHashe(String mdpHashe) {
        this.mdpHashe = mdpHashe;
    }

    public RolesEnum getRole() {
        return role;
    }

    public void setRole(RolesEnum role) {
        this.role = role;
    }

}
