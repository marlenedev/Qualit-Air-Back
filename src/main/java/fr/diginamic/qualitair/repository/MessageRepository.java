package fr.diginamic.qualitair.repository;

import fr.diginamic.qualitair.entites.FilDiscussion;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.qualitair.entites.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findAllByFilDiscussion (FilDiscussion filDiscussion);

}
