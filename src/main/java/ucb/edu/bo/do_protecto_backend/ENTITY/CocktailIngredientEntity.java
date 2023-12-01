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
    private CocktailEntity cocktail;

    @ManyToOne
    @JoinColumn(name = "Ingredients_ingrediente_id", nullable = false)
    private IngredientEntity ingredient;

    public Long getCocktailIngredientId() {
        return cocktailIngredientId;
    }

    public void setCocktailIngredientId(Long cocktailIngredientId) {
        this.cocktailIngredientId = cocktailIngredientId;
    }

    public CocktailEntity getCocktail() {
        return cocktail;
    }

    public void setCocktail(CocktailEntity cocktail) {
        this.cocktail = cocktail;
    }

    public IngredientEntity getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientEntity ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return "CocktailIngredientEntity [cocktailIngredientId=" + cocktailIngredientId + ", cocktail=" + cocktail
                + ", ingredient=" + ingredient + "]";
    }
    
    
}
