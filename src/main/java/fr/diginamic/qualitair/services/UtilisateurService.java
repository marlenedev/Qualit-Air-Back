package fr.diginamic.qualitair.services;

import fr.diginamic.qualitair.entites.Commune;
import fr.diginamic.qualitair.entites.FilDiscussion;
import fr.diginamic.qualitair.entites.Theme;
import fr.diginamic.qualitair.entites.Utilisateur;
import fr.diginamic.qualitair.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository){ this.utilisateurRepository = utilisateurRepository; }

    public Optional<Utilisateur> findByEmail(String email){ return utilisateurRepository.findByEmail(email); }

    /**
     * Méthode qui créé un nouvel utilisateur si sont email n'est pas trouvé en base
     */
    public Utilisateur enregistrementUtilisateur(String nom, String prenom, String email, String pseudo, String region, Commune commune, String codePostal, String mdpHashe){

        Utilisateur utilisateurEnregistre = findByEmail(email).orElse(new Utilisateur(nom, prenom, email, pseudo, region, commune, codePostal, mdpHashe ));
        return utilisateurRepository.save(utilisateurEnregistre);
    }

    public Optional<Utilisateur> findById(Integer id) {
        return utilisateurRepository.findById(id);
    }

    public void delete(Utilisateur utilisateur) {
        this.utilisateurRepository.delete(utilisateur);
    }

    public List<Utilisateur> findAll(){
        return this.utilisateurRepository.findAll();
    }


}
