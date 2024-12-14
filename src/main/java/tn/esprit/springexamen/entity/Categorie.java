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
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomCategorie;

    @ManyToMany(mappedBy = "categories",cascade = CascadeType.ALL)
    List<Produit> produits;
}
