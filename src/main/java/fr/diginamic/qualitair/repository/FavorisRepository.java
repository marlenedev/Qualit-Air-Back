package fr.diginamic.qualitair.repository;

import fr.diginamic.qualitair.entites.Favoris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavorisRepository extends JpaRepository<Favoris, Integer> {

    List<Favoris> findAllByUtilisateurId(Integer id);

    Optional<Favoris> findByCodePostal(String codePostal);


}
