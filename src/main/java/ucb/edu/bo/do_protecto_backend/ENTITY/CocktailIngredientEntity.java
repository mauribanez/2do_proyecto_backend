package ucb.edu.bo.do_protecto_backend.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.*;

@Entity
@Table(name = "CocktailIngredients")
public class CocktailIngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cocktail_ingredient_id")
    private Long cocktailIngredientId;

    @ManyToOne
    @JoinColumn(name = "Cocktails_cocktail_id", nullable = false)
    private Cocktail cocktail;

    @ManyToOne
    @JoinColumn(name = "Ingredients_ingrediente_id", nullable = false)
    private IngredientEntity ingredient;
    
}
