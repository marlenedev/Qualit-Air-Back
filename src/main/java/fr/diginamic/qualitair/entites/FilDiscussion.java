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

    public FilDiscussion(Integer id, LocalDateTime dateCreation) {
        this.id = id;
        this.dateCreation = dateCreation;
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
}
