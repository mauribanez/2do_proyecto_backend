package ucb.edu.bo.do_protecto_backend.DAO;

import java.util.List;

public class TypeCocktailResponse {
    private List<TypeCocktailData> drinks;

    public static class TypeCocktailData {
        private String strAlcoholic;

        public String getStrAlcoholic() {
            return strAlcoholic;
        }

        public void setStrAlcoholic(String strAlcoholic) {
            this.strAlcoholic = strAlcoholic;
        }

        
    }

    public List<TypeCocktailData> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<TypeCocktailData> drinks) {
        this.drinks = drinks;
    }

    // Getters y setters para 'drinks'
}