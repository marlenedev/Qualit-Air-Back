package fr.diginamic.qualitair.controller;

import fr.diginamic.qualitair.dto.FavorisDto;
import fr.diginamic.qualitair.dto.ForumUtilisateurDto;
import fr.diginamic.qualitair.entites.Favoris;
import fr.diginamic.qualitair.entites.Utilisateur;
import fr.diginamic.qualitair.exception.NotFoundException;
import fr.diginamic.qualitair.services.FavorisService;
import fr.diginamic.qualitair.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/favoris")
@CrossOrigin
public class FavorisController {

    @Autowired
    private FavorisService favorisService;

    @Autowired
    private UtilisateurService utilisateurService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getOneFavori(@RequestBody @PathVariable("id") Integer id){

        Optional<Favoris> favoriTrouve = this.favorisService.findById(id);

        if (favoriTrouve.isPresent()) {
            return ResponseEntity.ok(favorisService.findById(id));
        } else {
            return ResponseEntity.status(400).body("Le favori n'a pas été trouvé");
        }
    }
    @GetMapping("/list/{id}")
    public List<FavorisDto> listeFavorisByUser(@PathVariable Integer id){
        return this.favorisService.getFavorisByUserId(id).stream().map(FavorisDto::from).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<Favoris> ajoutFavoris(@RequestParam("idUtilisateur") Integer idUtilisateur, @RequestBody FavorisDto favorisDto) throws NotFoundException {
        return ResponseEntity.ok(favorisService.ajoutFavoris(idUtilisateur, favorisDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> supprimerFavori(@PathVariable(value = "id") Integer id) throws NotFoundException {
        Optional<Favoris> suppressionFavoris = this.favorisService.findById(id);
        if (suppressionFavoris.isPresent()) {
            Favoris favorisSupprime = suppressionFavoris.get();
            this.favorisService.delete(favorisSupprime);
            return ResponseEntity.status(200).body("Le favoris avec le numéro " + id + " a été supprimé");
        } else {
            throw new NotFoundException();
        }
    }

}
