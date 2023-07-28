package fr.diginamic.qualitair.services;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import fr.diginamic.qualitair.entites.Commune;
import fr.diginamic.qualitair.entites.Utilisateur;
import fr.diginamic.qualitair.repository.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommuneService {

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    CommuneRepository communeRepository;

    /**
     * Permet de rentrer toutes les communes en base de données en passant par le fichier "donnees_communes.csv"
     * présent dans le répertoire resources.
     */
    public void csvReader(){
        Resource resource = resourceLoader.getResource("classpath:/donnees_communes.csv");
        try (Reader reader = Files.newBufferedReader(Paths.get(resource.getURI()));
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .withCSVParser(new CSVParserBuilder()
                             .withSeparator(';')
                             .build()
                     ).build()) {

            // read one record at a time
            String[] record;
            List<Commune> listeCommunes = new ArrayList<>();
            csvReader.readNext();
            while ((record = csvReader.readNext()) != null) {

                System.out.println(record);
                Commune donneesCommune = new Commune(record[6], Long.parseLong(record[9]), record[2], record[1]);
                listeCommunes.add(donneesCommune);
            }
            communeRepository.saveAll(listeCommunes);

        } catch (IOException | CsvValidationException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Méthode findById récupéré depuis le repository CommuneRepository
     * @param id
     * @return une commune par son id
     */
    public Optional<Commune> findById(Integer id) {
        return communeRepository.findById(id);
    }

    /**
     * Méthode findAll récupéré depuis le repository CommuneRepository
     * @return une liste des communes présentes en base de donénes {@link CommuneRepository}
     */
    public List<Commune> findAll(){
        return this.communeRepository.findAll();
    }

    /**
     * Recherche les 25 premiers résultats de communes dont le nom commence par la chaîne renseignée.
     * en base de données.
     * @param commune Chaîne de caractères à rechercher
     * @return Les 25 premières occurrences dont le nom de commune commence par la chaîne renseignée. {@link CommuneRepository}
     */
    public List<Commune> findByCommuneStartsWith(String commune) { return communeRepository.findTop25ByCommuneStartsWith(commune); }

}
