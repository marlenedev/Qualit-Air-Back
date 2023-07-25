package fr.diginamic.qualitair.services;

import fr.diginamic.qualitair.entites.*;
import fr.diginamic.qualitair.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.diginamic.qualitair.dto.ModificationUserDto;
import fr.diginamic.qualitair.dto.UtilisateurDto;
import fr.diginamic.qualitair.entites.Utilisateur;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UtilisateurService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	public Optional<Utilisateur> findByEmail(String email) {
		return utilisateurRepository.findByEmail(email);
	}

	public Utilisateur findByPseudo(String pseudo) {
		return utilisateurRepository.findByPseudo(pseudo);
	}

	/**
	 * Méthode qui créé un nouvel utilisateur si sont email n'est pas trouvé en base
	 */
	public Utilisateur enregistrementUtilisateur(UtilisateurDto utilisateurDto) {

		Utilisateur utilisateurEnregistre = new Utilisateur();

		utilisateurEnregistre.setNom(utilisateurDto.getNom());
		utilisateurEnregistre.setPrenom(utilisateurDto.getPrenom());
		utilisateurEnregistre.setEmail(utilisateurDto.getEmail());
		utilisateurEnregistre.setPseudo(utilisateurDto.getPseudo());
		utilisateurEnregistre.setRegion(utilisateurDto.getRegion());
		utilisateurEnregistre.setCommune(utilisateurDto.getCommune());
		utilisateurEnregistre.setCodePostal(utilisateurDto.getCodePostal());
		utilisateurEnregistre.setMdpHashe(passwordEncoder.encode(utilisateurDto.getMdpHashe()));
		utilisateurEnregistre.setRole(RolesEnum.USER);

		return utilisateurRepository.save(utilisateurEnregistre);
	}

	public Optional<Utilisateur> findById(Integer id) {
		return utilisateurRepository.findById(id);
	}

	public void delete(Utilisateur utilisateur) {
		this.utilisateurRepository.delete(utilisateur);
	}

	public List<Utilisateur> findAll() {
		return this.utilisateurRepository.findAll();
	}

	/**
	 * Récupère les utilisateurs avec les données pour le forum
	 * @return
	 */
	public List<Utilisateur> findForumUtilisateurs() {
		return this.utilisateurRepository.findAll();
	}

	/**
	 * Modifie les informations d'un utilisateur
	 * 
	 * @param modificationUserDto
	 * @param id
	 * @return
	 */
	public Utilisateur modifierUtilisateur(ModificationUserDto modificationUserDto, Integer id) {

		Optional<Utilisateur> utilisateurModifie = findById(id);

		Utilisateur utilisateur = utilisateurModifie.get();

		utilisateur.setNom(modificationUserDto.getNom());
		utilisateur.setPrenom(modificationUserDto.getPrenom());
		utilisateur.setEmail(modificationUserDto.getEmail());
		utilisateur.setPseudo(modificationUserDto.getPseudo());
		utilisateur.setRegion(modificationUserDto.getRegion());
		utilisateur.setCommune(modificationUserDto.getCommune());
		utilisateur.setCodePostal(modificationUserDto.getCodePostal());

		return utilisateurRepository.save(utilisateur);

	}

	public Utilisateur suspendreUtilisateur(Integer id, LocalDateTime dateFinSuspension) {
		Optional<Utilisateur> utilisateurOptional = findById(id);
		if(utilisateurOptional.isPresent()) {
			Utilisateur utilisateur = utilisateurOptional.get();
			utilisateur.setSuspended(true);
			utilisateur.setDateFinSuspension(dateFinSuspension);

			return utilisateurRepository.save(utilisateur);
		}
		return null;
	}
}
