package fr.diginamic.qualitair.controller;


import fr.diginamic.qualitair.dto.UtilisateurDto;
import fr.diginamic.qualitair.entites.FilDiscussion;
import fr.diginamic.qualitair.entites.Theme;
import fr.diginamic.qualitair.entites.Utilisateur;
import fr.diginamic.qualitair.services.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
     * Récupère la liste de tous les utilisateurs en base
     * @return
     */
    @GetMapping()
	public List<UtilisateurDto> listeUtilisateurs(){
		return this.utilisateurService.findAll().stream().map(UtilisateurDto::from).collect(Collectors.toList());
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

    /**
     * Supprime un utilisateur selon son id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerUtilisateur(@PathVariable(value = "id") Integer id) {
        Optional<Utilisateur> suppressionUtilisateur = this.utilisateurService.findById(id);
        if (suppressionUtilisateur.isPresent()) {
            Utilisateur utilisateurSupprime = suppressionUtilisateur.get();
            this.utilisateurService.delete(utilisateurSupprime);
            return ResponseEntity.status(200).body("L'utilisateur numéro " + id + " a été supprimé");
        } else {
            return ResponseEntity.status(400).body("L'utilisateur numéro" + id + " n'a pas pu être supprimé");
        }
    }
}
