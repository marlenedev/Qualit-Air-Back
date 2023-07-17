package fr.diginamic.qualitair.services;

import fr.diginamic.qualitair.dto.FavorisDto;
import fr.diginamic.qualitair.entites.Favoris;
import fr.diginamic.qualitair.entites.Utilisateur;
import fr.diginamic.qualitair.exception.NotFoundException;
import fr.diginamic.qualitair.repository.CommuneRepository;
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

    public Optional<Favoris> findById(Integer id) {
        return favorisRepository.findById(id);
    }

    public List<Favoris> getFavorisByUserId(Integer id) {

        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        List<Favoris> favorisList = favorisRepository.findAllByUtilisateurId(id);

        return favorisList;
    }

    public Favoris ajoutFavoris(Integer idUtilisateur, FavorisDto favorisDto) throws NotFoundException {

        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(idUtilisateur);

        if (utilisateurOptional.isPresent()) {
            Utilisateur utilisateur = utilisateurOptional.get();

            Favoris newFavoris = new Favoris();
            newFavoris.setCodePostal(favorisDto.getCodePostal());
            newFavoris.setUtilisateur(utilisateur);

            return favorisRepository.save(newFavoris);
        } else {
            throw new NotFoundException("Utilisateur non trouvé pour l'ID : " + idUtilisateur);
        }
    }

    public void delete(Favoris favoris) {
        this.favorisRepository.delete(favoris);
    }




}
