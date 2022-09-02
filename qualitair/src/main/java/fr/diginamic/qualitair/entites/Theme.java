package fr.diginamic.qualitair.entites;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "themes")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String libelle;

    @OneToMany(mappedBy = "theme")
    private Set<FilDiscussion> filDiscussion;

    public Theme() {
    }

    public Theme(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
