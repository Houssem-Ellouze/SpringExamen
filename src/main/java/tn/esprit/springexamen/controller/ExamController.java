package tn.esprit.springexamen.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.springexamen.entity.Produit;
import tn.esprit.springexamen.entity.TypeUtilisateur;
import tn.esprit.springexamen.entity.Utilisateur;
import tn.esprit.springexamen.service.IService;
import java.util.List;

@RestController
@RequestMapping("/controller")

public class ExamController {
    @Autowired
    private IService service;


    @PostMapping("/ajouterProduitEtCategories")
    public Produit ajouterProduitEtCategories(@RequestBody Produit p){
        return service.ajouterProduitEtCategories(p);
    }
    @PostMapping("/ajouterUtilisateur")
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur p){
        return service.ajouterUtilisateur(p);
    }
    @GetMapping("/utilisateursParCriteres")
    public List<Utilisateur> getUtilisateursParCriteres() {
        String categorie = "Nourriture";
        String date =  "2024-01-01" ;
        TypeUtilisateur type = TypeUtilisateur.ADMIN;

        return service.recupererUtilisateursParCriteres ( categorie, date, type );
    }


}
