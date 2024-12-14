package tn.esprit.springexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springexamen.entity.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
