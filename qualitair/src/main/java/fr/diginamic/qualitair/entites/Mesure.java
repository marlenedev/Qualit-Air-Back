package fr.diginamic.qualitair.entites;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name= "mesures")
public class Mesure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private float valeur;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "id_indicateur")
    private Indicateur indicateur;

    @ManyToOne
    @JoinColumn(name = "id_commune")
    private Commune commune;

    public Mesure() {
    }

    public Mesure(Integer id, float valeur, LocalDateTime date) {
        this.id = id;
        this.valeur = valeur;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
