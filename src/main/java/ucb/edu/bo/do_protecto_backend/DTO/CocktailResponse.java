package ucb.edu.bo.do_protecto_backend.DTO;
import java.util.List;

import ucb.edu.bo.do_protecto_backend.ENTITY.Cocktail;

public class CocktailResponse {

    private List<Cocktail> drinks;


    public CocktailResponse() {
    }

    public List<Cocktail> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Cocktail> drinks) {
        this.drinks = drinks;
    }
  
}

