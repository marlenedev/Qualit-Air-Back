package fr.diginamic.qualitair.controller;

import fr.diginamic.qualitair.services.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CommuneController {

    @Autowired
    CommuneService communeService;

    @GetMapping("/csv")
    public void communeCsv(){
        communeService.csvReader();
    }
}
