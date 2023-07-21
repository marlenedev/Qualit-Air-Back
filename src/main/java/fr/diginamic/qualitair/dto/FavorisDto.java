package fr.diginamic.qualitair.dto;

import fr.diginamic.qualitair.entites.Favoris;
import fr.diginamic.qualitair.entites.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
public class FavorisDto {

    private Integer id;
    private String codePostal;
    private Integer idUtilisateur;

    public FavorisDto() {

    }
    public FavorisDto(String codePostal, Integer idUtilisateur) {
        this.codePostal = codePostal;
    }

    public static FavorisDto from(Favoris favoris) {
        return new FavorisDto(favoris.getId(), favoris.getCodePostal(), favoris.getUtilisateur().getId());
    }

}
