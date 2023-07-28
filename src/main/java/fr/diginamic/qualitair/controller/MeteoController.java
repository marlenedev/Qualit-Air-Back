package fr.diginamic.qualitair.controller;

import fr.diginamic.qualitair.entites.Meteo;
import fr.diginamic.qualitair.services.WebApiService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.csv.CSVPrinter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/meteo")
public class MeteoController {

    private final WebApiService webApiService;

    public MeteoController(WebApiService webApiService) {
        this.webApiService = webApiService;
    }

    /**
     * Récupère l'historique météo entre deux dates spécifiées.
     *
     * @param start la date de début de la période de recherche (au format "dd/MM/yyyy")
     * @param end   la date de fin de la période de recherche (au format "dd/MM/yyyy")
     * @return la liste des enregistrements de météo entre les deux dates spécifiées.
     */
    @GetMapping("/historique")
    public List<Meteo> getHistoriqueMeteo(@RequestParam("start") @DateTimeFormat(pattern = "dd/MM/yyyy") String start,
                                          @RequestParam("end") @DateTimeFormat(pattern = "dd/MM/yyyy") String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        return webApiService.getHistoriqueMeteo(startDate, endDate);
    }

    /**
     * Exporte les données météo au format CSV pour la période donnée.
     *
     * @param start La date de début de la période au format "dd/MM/yyyy".
     * @param end La date de fin de la période au format "dd/MM/yyyy".
     * @param response L'objet HttpServletResponse pour écrire la réponse.
     * @throws IOException Si une erreur survient lors de l'écriture de la réponse.
     */
    @GetMapping("/export-csv")
    public void exportCSV(@RequestParam("start") @DateTimeFormat(pattern = "dd/MM/yyyy") String start,
                          @RequestParam("end") @DateTimeFormat(pattern = "dd/MM/yyyy") String end,
                          HttpServletResponse response) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        List<Meteo> meteoData = this.webApiService.getHistoriqueMeteo(startDate, endDate);

        // Configure le type de contenu de la réponse pour indiquer que c'est un fichier CSV
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=meteo_data.csv");

        PrintWriter writer = response.getWriter();

        // Écrire les données dans la réponse
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                .withDelimiter(',')
                .withQuote('"')
                .withHeader("ID", "Code Postal", "Température", "Pression", "Humidité", "Date"));

            for (Meteo meteo : meteoData) {
                csvPrinter.printRecord(
                        meteo.getId(),
                        meteo.getCodePostal(),
                        meteo.getTemp(),
                        meteo.getPressure(),
                        meteo.getHumidity(),
                        meteo.getDate()
                );
            }
            csvPrinter.flush();
            csvPrinter.close();
    }

}
