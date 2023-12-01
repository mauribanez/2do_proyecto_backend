package ucb.edu.bo.do_protecto_backend.DTO;

public class CategoryDTO {
    private Long categoryId;
    private String nameCategory;
    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public String getNameCategory() {
        return nameCategory;
    }
    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
    @Override
    public String toString() {
        return "CategoryDTO [categoryId=" + categoryId + ", nameCategory=" + nameCategory + "]";
    }

    
}