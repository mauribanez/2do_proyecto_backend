package ucb.edu.bo.do_protecto_backend.ENTITY;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cocktails")
public class CocktailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cocktail_id")
    private Long cocktailId;

    @Column(name = "name_cocktail", nullable = false)
    private String nameCocktail;

    @Column(name = "preparation", nullable = false, length = 5000)
    private String preparation;

    @ManyToOne
    @JoinColumn(name = "tipococktail_tipococktail_id", nullable = false)
    private TypeCocktailEntity typeCocktail;

    @ManyToOne
    @JoinColumn(name = "type_category_typecategory_id", nullable = false)
    private CategoryEntity category;

    public Long getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(Long cocktailId) {
        this.cocktailId = cocktailId;
    }

    public String getNameCocktail() {
        return nameCocktail;
    }

    public void setNameCocktail(String nameCocktail) {
        this.nameCocktail = nameCocktail;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public TypeCocktailEntity getTypeCocktail() {
        return typeCocktail;
    }

    public void setTypeCocktail(TypeCocktailEntity typeCocktail) {
        this.typeCocktail = typeCocktail;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "CocktailEntity [cocktailId=" + cocktailId + ", nameCocktail=" + nameCocktail + ", preparation="
                + preparation + ", typeCocktail=" + typeCocktail + ", category=" + category  + "]";
    }

    
}
