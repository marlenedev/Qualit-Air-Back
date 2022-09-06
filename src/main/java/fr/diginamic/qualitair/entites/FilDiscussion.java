package fr.diginamic.qualitair.entites;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "fils_discussions")
public class FilDiscussion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dateCreation;
    
    private String titre;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_theme")
    private Theme theme;

    @OneToMany(mappedBy = "filDiscussion")
    private Set<Message> messages;

    public FilDiscussion() {
    }

   

 



	public FilDiscussion(Integer id, LocalDateTime dateCreation, String titre, Utilisateur utilisateur, Theme theme,
			Set<Message> messages) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
		this.titre = titre;
		this.utilisateur = utilisateur;
		this.theme = theme;
		this.messages = messages;
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
    
}
