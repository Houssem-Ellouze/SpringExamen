package tn.esprit.springexamen.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private Date dateInscri;
    @Enumerated(EnumType.STRING)
    private TypeUtilisateur typeUtilisateur;

    @OneToMany
    List<Produit> produits;
}
