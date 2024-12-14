package tn.esprit.springexamen.service;

import tn.esprit.springexamen.entity.Produit;
import tn.esprit.springexamen.entity.TypeUtilisateur;
import tn.esprit.springexamen.entity.Utilisateur;

import java.util.List;

public interface IService {
    Utilisateur ajouterUtilisateur (Utilisateur u);
    Produit ajouterProduitEtCategories (Produit p);
    void affecterProdAUser(List<String> nomProuit, String email);
    boolean chercherProduit (String nomProduit);
    List<Utilisateur> recupererUtilisateursParCriteres(String nomCategorie, String d, TypeUtilisateur tu);
    void afficherEtMettreAJourProduits ();
}
