package fr.diginamic.qualitair.repository;

import fr.diginamic.qualitair.entites.Meteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MeteoRepository extends JpaRepository<Meteo, Long> {

    List<Meteo> findByDateBetween(LocalDate start, LocalDate end);
}
