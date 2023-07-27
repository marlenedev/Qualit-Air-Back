package fr.diginamic.qualitair.controller;

import fr.diginamic.qualitair.entites.Meteo;
import fr.diginamic.qualitair.services.WebApiService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("api/meteo")
public class MeteoController {

    private final WebApiService webApiService;

    public MeteoController(WebApiService webApiService) {
        this.webApiService = webApiService;
    }

    /**
     * Récupère l'historique de météo entre deux dates
     *
     * @param start la date de début de la période de recherche (au format "dd/MM/yyyy")
     * @param end   la date de fin de la période de recherche (au format "dd/MM/yyyy")
     * @return la liste des enregistrements de météo entre les deux dates spécifiées en réponse HTTP
     */
    @GetMapping("/historique")
    public List<Meteo> getHistoriqueMeteoEntreDeuxDates(@RequestParam("start") @DateTimeFormat(pattern = "dd/MM/yyyy") String start,
                                                        @RequestParam("end") @DateTimeFormat(pattern = "dd/MM/yyyy") String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        return webApiService.getHistoriqueMeteo(startDate, endDate);
    }
}
