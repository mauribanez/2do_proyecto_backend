package ucb.edu.bo.do_protecto_backend.ENTITY;

import jakarta.persistence.*;
import java.util.List;

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
    @JoinColumn(name = "tipoCocktail_tipoCocktail_id", nullable = false)
    private TypeCocktailEntity typeCocktail;

    @ManyToOne
    @JoinColumn(name = "Type_Category_typeCategory_id", nullable = false)
    private CategoryEntity category;

    @OneToMany(mappedBy = "cocktail")
    private List<CocktailIngredientEntity> ingredients;

    // Constructor, getters y setters
}
