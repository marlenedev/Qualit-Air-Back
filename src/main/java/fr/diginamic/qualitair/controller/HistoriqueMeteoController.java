package fr.diginamic.qualitair.controller;

import fr.diginamic.qualitair.services.WebApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/meteo")
public class HistoriqueMeteoController {

    private final WebApiService webApiService;

    public HistoriqueMeteoController(WebApiService webApiService) {
        this.webApiService = webApiService;
    }

    @GetMapping("/historique")
    public ResponseEntity<?> getHistoriqueMeteo(@RequestParam(value = "start") String start,
                                                @RequestParam(value = "end") String end) {
        return ResponseEntity.ok(webApiService.getHistoriqueMeteo(start, end));
    }
}
