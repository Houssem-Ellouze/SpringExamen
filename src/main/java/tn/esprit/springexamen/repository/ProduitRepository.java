package tn.esprit.springexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springexamen.entity.Produit;
import tn.esprit.springexamen.entity.TypeUtilisateur;
import tn.esprit.springexamen.entity.Utilisateur;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByNomIn(String noms);

    List<Produit> findByTypeUtilisateur(TypeUtilisateur typeUtilisateur);


}
