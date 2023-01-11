package fr.diginamic.qualitair.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "communes")
public class Commune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    private String commune;
    
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

    public Commune(Integer id, String commune, Long nbHabitants, String codeDpt, String nomRegion) {
        this.id = id;
        this.commune = commune;
        this.nbHabitants = nbHabitants;
        this.codeDpt = codeDpt;
        this.nomRegion = nomRegion;
    }

    public Commune(String commune, Long nbHabitants, String codeDpt, String nomRegion) {
        this.commune = commune;
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

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
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
