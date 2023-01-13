package fr.diginamic.qualitair.repository;

import fr.diginamic.qualitair.entites.Commune;
import fr.diginamic.qualitair.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CommuneRepository extends JpaRepository<Commune, Integer> {

    Optional<Commune> findByCommune(String commune);

    List<Commune> findTop25ByCommuneStartsWith(String commune);
}
