package fr.diginamic.qualitair.services;

import fr.diginamic.qualitair.entites.Favoris;
import fr.diginamic.qualitair.entites.Utilisateur;
import fr.diginamic.qualitair.exception.NotFoundException;
import fr.diginamic.qualitair.repository.FavorisRepository;
import fr.diginamic.qualitair.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavorisService {

    @Autowired
    FavorisRepository favorisRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    UtilisateurService utilisateurService;

    public List<Favoris> getFavorisByUserId(Integer id) {

        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        List<Favoris> favorisList = favorisRepository.findAllByUserId(id);

        return favorisList;
    }

    public Favoris ajoutFavoris(Integer idUtilisateur, Favoris favoris) {
        Favoris newFavoris = new Favoris();
        newFavoris.setCodePostal(favoris.getCodePostal());
        newFavoris.setUtilisateur(utilisateurService.findById(idUtilisateur));
    }




}
