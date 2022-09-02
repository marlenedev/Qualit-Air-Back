package fr.diginamic.qualitair.entites;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "alertes_mail")
public class AlerteMail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String localisation;

    @ManyToMany
    @JoinTable(name = "alerte_utilisateur",
               joinColumns = @JoinColumn(name = "id_alerte", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
    )
    private Set<Utilisateur> utilisateurs;

    public AlerteMail() {
    }

    public AlerteMail(Integer id, String localisation) {
        this.id = id;
        this.localisation = localisation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
