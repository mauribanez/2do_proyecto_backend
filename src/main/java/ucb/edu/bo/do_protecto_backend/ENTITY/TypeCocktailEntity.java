package ucb.edu.bo.do_protecto_backend.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

@Entity
@Table(name = "TypeCocktail")
public class TypeCocktailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typeCocktail_id")
    private Long typeCocktailId;

    @Column(name = "nameType", nullable = false)
    private String nameType;

    
}
