package tn.esprit.springexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springexamen.entity.TypeUtilisateur;
import tn.esprit.springexamen.entity.Utilisateur;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    List<Utilisateur> findByEmail(String email);

    @Query("SELECT DISTINCT u FROM Utilisateur u JOIN u.produits p JOIN p.categorie c WHERE u.typeUtilisateur = :typeUtilisateur AND u.dateInscri > :dateInscri AND c.nomCategorie = :nomCategorie")
    List<Utilisateur> recupererUtilisateursParCriteres(String nomCategorie, Date d, TypeUtilisateur tu);









}
