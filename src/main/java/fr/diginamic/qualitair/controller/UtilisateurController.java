package fr.diginamic.qualitair.controller;


import fr.diginamic.qualitair.dto.UtilisateurDto;
import fr.diginamic.qualitair.entites.Theme;
import fr.diginamic.qualitair.entites.Utilisateur;
import fr.diginamic.qualitair.services.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    /**
     * Récupère un utilisateur selon son id
     * @param id
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneUtilisateur(@RequestBody @PathVariable("id") Integer id){

        Optional<Utilisateur> utilisateurTrouve = this.utilisateurService.findById(id);

        if (utilisateurTrouve.isPresent()) {
            return ResponseEntity.ok(utilisateurService.findById(id));
        } else {
            return ResponseEntity.status(400).body("L'utilisateur n'a pas été trouvé");
        }
    }
}
