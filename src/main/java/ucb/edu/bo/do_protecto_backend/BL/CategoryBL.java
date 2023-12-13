package ucb.edu.bo.do_protecto_backend.BL;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ucb.edu.bo.do_protecto_backend.DAO.CategoryDAO;
import ucb.edu.bo.do_protecto_backend.DTO.CategoryResponse;
import ucb.edu.bo.do_protecto_backend.ENTITY.CategoryEntity;

@Service
public class CategoryBL {
    private final CategoryDAO categoryDAO;
    private RestTemplate restTemplate;

    public CategoryBL(CategoryDAO categoryDAO, RestTemplate restTemplate) {
        this.categoryDAO = categoryDAO;
        this.restTemplate = restTemplate;
    }

    public CategoryEntity createCategory(String nameCategory) {

        if(nameCategory == null || nameCategory.isEmpty())
            throw new RuntimeException("El nombre de la categoría no puede estar vacío");
        
        CategoryEntity category = new CategoryEntity();
        category.setNameCategory(nameCategory);
        return categoryDAO.save(category);
        
    }


    public CategoryEntity getCategoryById(Long categoryId) {
        return categoryDAO.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("No se encontró ninguna categoría con el ID proporcionado"));
    }

    public List<CategoryEntity> getAllCategories() {
        return categoryDAO.findAll();
    }

    public CategoryEntity updateCategory(Long categoryId, String nameCategory) {
        CategoryEntity category = categoryDAO.findById(categoryId).orElseThrow(() -> new RuntimeException("No se encontró ninguna categoría con el ID proporcionado"));
        if (nameCategory == null || nameCategory.isEmpty()) {
            throw new RuntimeException("El nombre de la categoria debe estar completo");
        }
        category.setNameCategory(nameCategory);
        return categoryDAO.save(category);

    }

    public CategoryEntity deleteCategory(Long categoryId) {
        CategoryEntity category = categoryDAO.findById(categoryId).orElseThrow(() -> new RuntimeException("No se encontró ningúna categoria con el ID proporcionado"));
        categoryDAO.deleteById(categoryId);
        return category;
    }

    public void fetchAndStoreCategoriesFromAPI() {
        CategoryResponse response = restTemplate.getForObject("https://www.thecocktaildb.com/api/json/v1/1/list.php?c=list", CategoryResponse.class);
    
        if (response != null && response.getDrinks() != null) {
            for (CategoryResponse.CategoryData data : response.getDrinks()) {
                String categoryName = data.getStrCategory();
                // Verificar si la categoría ya existe
                List<CategoryEntity> existingCategories = categoryDAO.findByNameCategory(categoryName);
                if (existingCategories.isEmpty()) {
                    createCategory(categoryName);
                }
            }
        }
    }
}