package ucb.edu.bo.do_protecto_backend.DTO;

public class CocktailIngredientDTO {
    private Long cocktailIngredientId;
    private Long cocktailId; // Puedes usar Long o el tipo de dato adecuado para el cóctel
    private Long ingredienteId; // Puedes usar Long o el tipo de dato adecuado para el ingrediente

    public Long getCocktailIngredientId() {
        return cocktailIngredientId;
    }

    public void setCocktailIngredientId(Long cocktailIngredientId) {
        this.cocktailIngredientId = cocktailIngredientId;
    }

    public Long getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(Long cocktailId) {
        this.cocktailId = cocktailId;
    }

    public Long getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(Long ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    @Override
    public String toString() {
        return "CocktailIngredientDTO [cocktailIngredientId=" + cocktailIngredientId + ", cocktailId=" + cocktailId
                + ", ingredienteId=" + ingredienteId + "]";
    }
}
