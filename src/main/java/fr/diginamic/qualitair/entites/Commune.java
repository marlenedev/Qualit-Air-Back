package fr.diginamic.qualitair.entites;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "communes")
public class Commune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private Long nbHabitants;
    private String codeDpt;
    private String nomRegion;

    @OneToMany(mappedBy = "commune")
    private Set<Mesure> mesures;

    @OneToMany(mappedBy = "commune")
    private Set<Favoris> favoris;

    @OneToMany(mappedBy = "commune")
    private Set<Utilisateur> utilisateur;

    public Commune() {
    }

    public Commune(Integer id, String nom, Long nbHabitants, String codeDpt, String nomRegion) {
        this.id = id;
        this.nom = nom;
        this.nbHabitants = nbHabitants;
        this.codeDpt = codeDpt;
        this.nomRegion = nomRegion;
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

    public Long getNbHabitants() {
        return nbHabitants;
    }

    public void setNbHabitants(Long nbHabitants) {
        this.nbHabitants = nbHabitants;
    }

    public String getCodeDpt() {
        return codeDpt;
    }

    public void setCodeDpt(String codeDpt) {
        this.codeDpt = codeDpt;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }
}