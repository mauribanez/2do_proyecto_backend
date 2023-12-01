package ucb.edu.bo.do_protecto_backend.BL;

import java.util.List;

import org.springframework.stereotype.Service;

import ucb.edu.bo.do_protecto_backend.DAO.CategoryDAO;
import ucb.edu.bo.do_protecto_backend.ENTITY.CategoryEntity;

@Service
public class CategoryBL {
    private final CategoryDAO categoryDAO;

    public CategoryBL(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        if(categoryEntity.getNameCategory() == null || categoryEntity.getNameCategory().isEmpty())
            throw new RuntimeException("El nombre de la categoría no puede estar vacío");
        
            CategoryEntity category = new CategoryEntity();
            category.setNameCategory(categoryEntity.getNameCategory());

            CategoryEntity cargo = categoryDAO.save(category);
            return cargo;
    }


    public CategoryEntity getCategoryById(Long categoryId) {
        return categoryDAO.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("No se encontró ninguna categoría con el ID proporcionado"));
    }

    public List<CategoryEntity> getAllCategories() {
        return categoryDAO.findAll();
    }

    public CategoryEntity updateCategory(Long categoryId, CategoryEntity updatedCategory) {
        if(updatedCategory.getNameCategory() == null || updatedCategory.getNameCategory().isEmpty())
            throw new RuntimeException("El nombre de la categoría no puede estar vacío");
        
        CategoryEntity existingCategory = categoryDAO.findById(categoryId).orElseThrow(() -> new RuntimeException("No se encontró ningúna categoria con el ID proporcionado"));
        existingCategory.setNameCategory(updatedCategory.getNameCategory());
        categoryDAO.save(existingCategory);
        return existingCategory;
    }

    public CategoryEntity deleteCategory(Long categoryId) {
        CategoryEntity category = categoryDAO.findById(categoryId).orElseThrow(() -> new RuntimeException("No se encontró ningúna categoria con el ID proporcionado"));
        categoryDAO.deleteById(categoryId);
        return category;
    }
}