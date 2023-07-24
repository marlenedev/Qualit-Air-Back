package fr.diginamic.qualitair.repository;

import fr.diginamic.qualitair.entites.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.qualitair.entites.FilDiscussion;

import java.util.List;

public interface DiscussionRepository extends JpaRepository<FilDiscussion, Integer> {
	
	List<FilDiscussion> findAllByTheme(Theme theme);

}
