package fr.diginamic.qualitair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.qualitair.entites.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
