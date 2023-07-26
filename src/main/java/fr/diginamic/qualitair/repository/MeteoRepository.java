package fr.diginamic.qualitair.repository;

import fr.diginamic.qualitair.entites.Meteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeteoRepository extends JpaRepository<Meteo, Long> {
}
