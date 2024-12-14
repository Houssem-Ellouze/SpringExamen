package tn.esprit.springexamen.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springexamen.entity.Etat;
import tn.esprit.springexamen.entity.Produit;
import tn.esprit.springexamen.entity.TypeUtilisateur;
import tn.esprit.springexamen.entity.Utilisateur;
import tn.esprit.springexamen.repository.CategorieRepository;
import tn.esprit.springexamen.repository.ProduitRepository;
import tn.esprit.springexamen.repository.UtilisateurRepository;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ServiceImpl implements IService {

    private CategorieRepository categorieRepository;
    private UtilisateurRepository utilisateurRepository;
    private ProduitRepository produitRepository;

    public Utilisateur ajouterUtilisateur(Utilisateur u) {
        return utilisateurRepository.save(u);
    }

    public Produit ajouterProduitEtCategories(Produit p) {
        return produitRepository.save(p);
    }

    public void affecterProdAUser(List<String> nomProuit, String email) {

        List<Utilisateur> u_email = utilisateurRepository.findByEmail(email);
        List<Produit> products = produitRepository.findByNomIn ( nomProuit.toString () );
            for (Produit p : products) {
                u_email.get().getProduits ().add(p);
            }

    }

    public boolean chercherProduit(String nomProduit) {

        List<Produit> produits = produitRepository.findByNomIn ( nomProduit );

        for (Produit p : produits) {
            if(p.getEtat () == Etat.BOYCOTT) {
                return true;
            }
        }
        return false;
    }
    public List<Utilisateur> recupererUtilisateursParCriteres(String nomCategorie, String d, TypeUtilisateur tu){
        return recupererUtilisateursParCriteres ( nomCategorie,d,tu );
    }

    @Scheduled(cron = "*/40 * * * * *")
    public void afficherEtMettreAJourProduits() {

        List<Produit> produits = produitRepository.findByTypeUtilisateur (TypeUtilisateur.ADMIN);
        for (Produit p : produits) {
            p.setEtat ( Etat.BOYCOTT );
            produitRepository.save(p);
        }
        List<Produit> allproducts = produitRepository.findAll();
        for (Produit p : allproducts) {
            System.out.println("ID: " + p.getId() + ", Nom: " + p.getNomProduit() + ", Etat: " + p.getEtat());
        }

    }


}
