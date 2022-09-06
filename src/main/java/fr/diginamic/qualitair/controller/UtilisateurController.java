package fr.diginamic.qualitair.controller;


import fr.diginamic.qualitair.dto.UtilisateurDto;
import fr.diginamic.qualitair.entites.Utilisateur;
import fr.diginamic.qualitair.services.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("utilisateurs")
public class UtilisateurController {

    UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) { this.utilisateurService = utilisateurService; }

    /**
     * Requête pour créer un utilisateur en appelant la méthode créée dans le service
     */
    @PostMapping()
    public ResponseEntity<Utilisateur> enregistrementUtilisateur(@RequestBody UtilisateurDto utilisateurDto){
        return ResponseEntity.ok(utilisateurService.enregistrementUtilisateur(utilisateurDto.getNom(),
                                                                              utilisateurDto.getPrenom(),
                                                                              utilisateurDto.getEmail(),
                                                                              utilisateurDto.getPseudo(),
                                                                              utilisateurDto.getRegion(),
                                                                              utilisateurDto.getCommune(),
                                                                              utilisateurDto.getCodePostal(),
                                                                              utilisateurDto.getMdpHashe()));
    }
}
