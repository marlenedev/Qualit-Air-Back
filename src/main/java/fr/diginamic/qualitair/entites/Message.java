package fr.diginamic.qualitair.entites;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime date;
    private String message;
    private Integer nbVues;
    private Integer nbReactions;


    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_fil_discussion")
    private FilDiscussion filDiscussion;

    @OneToMany(mappedBy = "message")
    private Set<ReactionUtilisateur> reactionsUtilisateurs;

    public Message() {
    }

    public Message(Integer id, LocalDateTime date, String message, Integer nbVues, Integer nbReactions) {
        this.id = id;
        this.date = date;
        this.message = message;
        this.nbVues = nbVues;
        this.nbReactions = nbReactions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getNbVues() {
        return nbVues;
    }

    public void setNbVues(Integer nbVues) {
        this.nbVues = nbVues;
    }

    public Integer getNbReactions() {
        return nbReactions;
    }

    public void setNbReactions(Integer nbReactions) {
        this.nbReactions = nbReactions;
    }
}
