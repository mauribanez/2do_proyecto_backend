package ucb.edu.bo.do_protecto_backend.DTO;

public class CategoryDTO {
    private Long categoryId;
    private String strCategory;
    
    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public String getstrCategory() {
        return strCategory;
    }
    public void setstrCategory(String strCategory) {
        this.strCategory = strCategory;
    }
    @Override
    public String toString() {
        return "CategoryDTO [categoryId=" + categoryId + ", nameCategory=" + strCategory + "]";
    }

    
}