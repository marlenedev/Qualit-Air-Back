package fr.diginamic.qualitair.dto;

import fr.diginamic.qualitair.entites.Commune;
import fr.diginamic.qualitair.entites.Utilisateur;

public class CommuneDto {

    private String commune;

    private Long nbHabitants;
    private String codeDpt;
    private String nomRegion;

    public static CommuneDto from(Commune commune) {
        return new CommuneDto(commune.getCommune(), commune.getNbHabitants(), commune.getCodeDpt(), commune.getNomRegion());
    }

    public CommuneDto(){}

    public CommuneDto(String commune, Long nbHabitants, String codeDpt, String nomRegion){
        this.commune = commune;
        this.nbHabitants = nbHabitants;
        this.codeDpt = codeDpt;
        this.nomRegion = nomRegion;

    }
}
