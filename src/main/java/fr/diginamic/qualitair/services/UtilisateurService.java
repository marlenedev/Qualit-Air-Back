package fr.diginamic.qualitair.services;

import fr.diginamic.qualitair.entites.*;
import fr.diginamic.qualitair.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.diginamic.qualitair.dto.ModificationUserDto;
import fr.diginamic.qualitair.dto.UtilisateurDto;
import fr.diginamic.qualitair.entites.Utilisateur;
import org.springframework.stereotype.Service;

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


	/**
	 * Recherche un utilisateur par son adresse e-mail.
	 *
	 * @param email L'adresse e-mail de l'utilisateur à rechercher.
	 * @return L'utilisateur associé à l'adresse e-mail spécifiée, s'il existe dans un {@link Optional}
	 */
	public Optional<Utilisateur> findByEmail(String email) {
		return utilisateurRepository.findByEmail(email);
	}

	public Utilisateur findByPseudo(String pseudo) {
		return utilisateurRepository.findByPseudo(pseudo);
	}

	/**
	 * Enregistre un nouvel utilisateur avec les informations fournies dans l'objet UtilisateurDto.
	 *
	 * @param utilisateurDto L'objet UtilisateurDto contenant les informations de l'utilisateur à enregistrer. {@link UtilisateurDto}
	 * @return L'utilisateur enregistré.
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
		utilisateurEnregistre.setRole(RolesEnum.ROLE_USER);

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
	 * Modifie les informations d'un utilisateur existant identifié par son identifiant.
	 *
	 * @param modificationUserDto L'objet ModificationUserDto contenant les nouvelles informations de l'utilisateur. {@link ModificationUserDto}
	 * @param id L'identifiant de l'utilisateur à modifier.
	 * @return L'utilisateur modifié.
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
}
