package fr.diginamic.qualitair.entites;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "indicateurs")
public class Indicateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String unite;

    @OneToMany(mappedBy = "indicateur")
    private Set<Mesure> mesures;

    public Indicateur() {
    }

    public Indicateur(Integer id, String nom, String unite) {
        this.id = id;
        this.nom = nom;
        this.unite = unite;
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

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
}
