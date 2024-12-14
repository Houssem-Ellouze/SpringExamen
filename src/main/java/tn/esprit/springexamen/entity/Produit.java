package tn.esprit.springexamen.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomProduit;
    @Enumerated(EnumType.STRING)
    private Etat etat;

    @ManyToMany
    List<Categorie> categories;

}
