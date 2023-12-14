package ucb.edu.bo.do_protecto_backend.DTO;

import java.util.List;

public class CategoryResponse {
    private List<CategoryData> drinks;

    public static class CategoryData {
        private String strCategory;

        public String getStrCategory() {
            return strCategory;
        }

        public void setStrCategory(String strCategory) {
            this.strCategory = strCategory;
        }

        
    }

    public List<CategoryData> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<CategoryData> drinks) {
        this.drinks = drinks;
    }

    // Getters y setters para 'drinks'
}