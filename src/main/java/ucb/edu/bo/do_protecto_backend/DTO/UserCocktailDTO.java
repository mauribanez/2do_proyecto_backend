package ucb.edu.bo.do_protecto_backend.DTO;

public class UserCocktailDTO {
    private Long userCocktailId;
    private Long cocktailId; // Puedes usar Long o el tipo de dato adecuado para el cóctel
    private Long userId; // Puedes usar Long o el tipo de dato adecuado para el usuario
    public Long getUserCocktailId() {
        return userCocktailId;
    }
    public void setUserCocktailId(Long userCocktailId) {
        this.userCocktailId = userCocktailId;
    }
    public Long getCocktailId() {
        return cocktailId;
    }
    public void setCocktailId(Long cocktailId) {
        this.cocktailId = cocktailId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
}