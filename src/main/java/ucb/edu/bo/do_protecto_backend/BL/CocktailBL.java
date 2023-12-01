package ucb.edu.bo.do_protecto_backend.BL;

import org.springframework.stereotype.Service;

import ucb.edu.bo.do_protecto_backend.DAO.CategoryDAO;
import ucb.edu.bo.do_protecto_backend.DAO.CocktailDAO;
import ucb.edu.bo.do_protecto_backend.DAO.TypeCocktailDAO;
import ucb.edu.bo.do_protecto_backend.ENTITY.CategoryEntity;
import ucb.edu.bo.do_protecto_backend.ENTITY.CocktailEntity;
import ucb.edu.bo.do_protecto_backend.ENTITY.TypeCocktailEntity;

import java.util.List;

@Service
public class CocktailBL {

    private final CocktailDAO cocktailDAO;
    private final TypeCocktailDAO typeCocktailDAO;
    private final CategoryDAO categoryDAO;

    public CocktailBL(CocktailDAO cocktailDAO, TypeCocktailDAO typeCocktailDAO, CategoryDAO categoryDAO) {
        this.cocktailDAO = cocktailDAO;
        this.typeCocktailDAO = typeCocktailDAO;
        this.categoryDAO = categoryDAO;
    }

    public CocktailEntity createCocktail(String nameCocktail, String preparation, Long typeCocktailId, Long categoryId) {
        if (nameCocktail == null || nameCocktail.isEmpty()) {
            throw new RuntimeException("El nombre del cóctel no puede estar vacío");
        }
        if (preparation == null || preparation.isEmpty()) {
            throw new RuntimeException("La preparación del cóctel no puede estar vacía");
        }
        if (typeCocktailId == null) {
            throw new RuntimeException("El tipo de cóctel no puede estar vacío");
        }
        if (categoryId == null) {
            throw new RuntimeException("La categoría del cóctel no puede estar vacía");
        }

        CocktailEntity cocktailEntity = new CocktailEntity();
        TypeCocktailEntity typeCocktail = typeCocktailDAO.findById(typeCocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún tipo de cóctel con el ID proporcionado"));
        CategoryEntity category = categoryDAO.findById(categoryId).orElseThrow(() -> new RuntimeException("No se encontró ningúna categoria con el ID proporcionado"));
        cocktailEntity.setNameCocktail(nameCocktail);
        cocktailEntity.setPreparation(preparation);
        cocktailEntity.setTypeCocktail(typeCocktail);
        cocktailEntity.setCategory(category);

        return cocktailDAO.save(cocktailEntity);
    }

    public List<CocktailEntity> getAllCocktails() {
        return cocktailDAO.findAll();
    }

    public CocktailEntity getCocktailById(Long cocktailId) {
        return cocktailDAO.findById(cocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cóctel con el ID proporcionado"));
    }

    public CocktailEntity updateCocktail(Long cocktailId, String nameCocktail, String preparation, TypeCocktailEntity typeCocktail, CategoryEntity category) {
        CocktailEntity cocktailEntity = cocktailDAO.findById(cocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cóctel con el ID proporcionado"));

        if (nameCocktail == null || nameCocktail.isEmpty()) {
            throw new RuntimeException("El nombre del cóctel no puede estar vacío");
        }
        if (preparation == null || preparation.isEmpty()) {
            throw new RuntimeException("La preparación del cóctel no puede estar vacía");
        }
        if (typeCocktail == null) {
            throw new RuntimeException("El tipo de cóctel no puede estar vacío");
        }
        if (category == null) {
            throw new RuntimeException("La categoría del cóctel no puede estar vacía");
        }

        cocktailEntity.setNameCocktail(nameCocktail);
        cocktailEntity.setPreparation(preparation);
        cocktailEntity.setTypeCocktail(typeCocktail);
        cocktailEntity.setCategory(category);

        return cocktailDAO.save(cocktailEntity);
    }

    public void deleteCocktail(Long cocktailId) {
        CocktailEntity cocktailEntity = cocktailDAO.findById(cocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cóctel con el ID proporcionado"));
        cocktailDAO.delete(cocktailEntity);
    }
}
