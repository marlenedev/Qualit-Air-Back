package fr.diginamic.qualitair.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String codePostal;
    private String dept;
    private String region;
    private String email;
    private String mdpHashe;
    private String pseudo;
    private boolean alertes;
    private String role;
    private String status;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Favoris> favoris;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_commune")
    private Commune commune;

    @OneToMany(mappedBy = "utilisateur")
    private Set<FilDiscussion> filDiscussion;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Message> message;

    @OneToMany(mappedBy = "utilisateur")
    private Set<ReactionUtilisateur> reactionUtilisateur;

    @ManyToMany(mappedBy = "utilisateurs")
    private Set<AlerteMail> alertesMails;

    public Utilisateur() {
    }

    public Utilisateur(Integer id, String nom, String prenom, String codePostal, String dept, String region, String email, String mdpHashe, String pseudo, boolean alertes, String role, String status, Commune commune) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.codePostal = codePostal;
        this.dept = dept;
        this.region = region;
        this.email = email;
        this.mdpHashe = mdpHashe;
        this.pseudo = pseudo;
        this.alertes = alertes;
        this.role = role;
        this.status = status;
        this.commune = commune;
    }

    public Utilisateur(String nom, String prenom, String email, String pseudo, String region, Commune commune, String codePostal, String mdpHashe){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pseudo = pseudo;
        this.region = region;
        this.commune = commune;
        this.codePostal = codePostal;
        this.mdpHashe = mdpHashe;
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

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdpHashe() {
        return mdpHashe;
    }

    public void setMdpHashe(String pwdHashe) {
        this.mdpHashe = pwdHashe;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public boolean isAlertes() {
        return alertes;
    }

    public void setAlertes(boolean alertes) {
        this.alertes = alertes;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
