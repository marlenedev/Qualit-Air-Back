package fr.diginamic.qualitair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.qualitair.entites.FilDiscussion;

public interface DiscussionRepository extends JpaRepository<FilDiscussion, Integer> {
	
	

}
