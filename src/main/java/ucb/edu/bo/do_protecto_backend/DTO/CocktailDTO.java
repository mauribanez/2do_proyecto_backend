package ucb.edu.bo.do_protecto_backend.DTO;

public class CocktailDTO {
    private Long cocktailId;
    private String nameCocktail;
    private String preparation;
    private Long tipoCocktailId; // Puedes usar Long o el tipo de dato adecuado para el tipo de cóctel
    private Long categoryCategoryId; // Puedes usar Long o el tipo de dato adecuado para la categoría
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
    public Long getTipoCocktailId() {
        return tipoCocktailId;
    }
    public void setTipoCocktailId(Long tipoCocktailId) {
        this.tipoCocktailId = tipoCocktailId;
    }
    public Long getCategoryCategoryId() {
        return categoryCategoryId;
    }
    public void setCategoryCategoryId(Long categoryCategoryId) {
        this.categoryCategoryId = categoryCategoryId;
    }

    
}