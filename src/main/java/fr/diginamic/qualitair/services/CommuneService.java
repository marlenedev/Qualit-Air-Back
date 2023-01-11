package fr.diginamic.qualitair.services;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import fr.diginamic.qualitair.entites.Commune;
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

@Service
public class CommuneService {

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    CommuneRepository communeRepository;

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
}
