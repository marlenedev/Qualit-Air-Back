package fr.diginamic.qualitair.controller;

import fr.diginamic.qualitair.dto.CommuneDto;
import fr.diginamic.qualitair.dto.UtilisateurDto;
import fr.diginamic.qualitair.entites.Commune;
import fr.diginamic.qualitair.entites.Utilisateur;
import fr.diginamic.qualitair.services.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class CommuneController {

    @Autowired
    CommuneService communeService;

    @GetMapping("/csv")
    public void communeCsv(){
        communeService.csvReader();
    }

    @GetMapping("/communes")
    public List<CommuneDto> listeCommunes(){
        return this.communeService.findAll().stream().map(CommuneDto::from).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneCommune(@RequestBody @PathVariable("id") Integer id){

        Optional<Commune> communeTrouvee = this.communeService.findById(id);

        if (communeTrouvee.isPresent()) {
            return ResponseEntity.ok(communeService.findById(id));
        } else {
            return ResponseEntity.status(400).body("La commune n'a pas été trouvé");
        }
    }

    @GetMapping("/name")
    public ResponseEntity<?> getCommuneByNom(@RequestParam(value = "commune") String commune){
        List<Commune> communeCheck = this.communeService.findByCommuneStartsWith(commune);

        return ResponseEntity.ok(communeCheck);

    }


}
