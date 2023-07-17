package fr.diginamic.qualitair.dto;

import fr.diginamic.qualitair.entites.Favoris;
import fr.diginamic.qualitair.entites.Utilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class FavorisDto {

    private String codePostal;

    public FavorisDto() {

    }
    public FavorisDto(String codePostal, Integer idUtilisateur) {
        this.codePostal = codePostal;
    }

    public static FavorisDto from(Favoris favoris) {
        return new FavorisDto(favoris.getCodePostal(), favoris.getUtilisateur().getId());
    }

}
