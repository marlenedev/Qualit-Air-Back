package fr.diginamic.qualitair.entites;

import javax.persistence.*;

@Entity
@Table(name = "reactions_utilisateurs")
public class ReactionUtilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_message")
    private Message message;

    public ReactionUtilisateur() {
    }

    public ReactionUtilisateur(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
