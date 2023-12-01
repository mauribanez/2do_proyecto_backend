package ucb.edu.bo.do_protecto_backend.BL;

import org.springframework.stereotype.Service;
import ucb.edu.bo.do_protecto_backend.DAO.CocktailDAO;
import ucb.edu.bo.do_protecto_backend.DAO.CocktailIngredientDAO;
import ucb.edu.bo.do_protecto_backend.DAO.IngredientDAO;
import ucb.edu.bo.do_protecto_backend.ENTITY.Cocktail;
import ucb.edu.bo.do_protecto_backend.ENTITY.CocktailEntity;
import ucb.edu.bo.do_protecto_backend.ENTITY.CocktailIngredientEntity;
import ucb.edu.bo.do_protecto_backend.ENTITY.IngredientEntity;

import java.util.List;

@Service
public class CocktailIngredientBL {

    private final CocktailIngredientDAO cocktailIngredientDAO;
    private final CocktailDAO cocktailDAO;
    private final IngredientDAO ingredientDAO;

    public CocktailIngredientBL(CocktailIngredientDAO cocktailIngredientDAO, CocktailDAO cocktailDAO, IngredientDAO ingredientDAO) {
        this.cocktailIngredientDAO = cocktailIngredientDAO;
        this.cocktailDAO = cocktailDAO;
        this.ingredientDAO = ingredientDAO;
    }

    public CocktailIngredientEntity createCocktailIngredient(Long cocktailId, Long ingredientId) {
        CocktailEntity cocktail = cocktailDAO.findById(cocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cóctel con el ID proporcionado"));
        IngredientEntity ingredient = ingredientDAO.findById(ingredientId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún ingrediente con el ID proporcionado"));

        CocktailIngredientEntity cocktailIngredientEntity = new CocktailIngredientEntity();
        cocktailIngredientEntity.setCocktail(cocktail);
        cocktailIngredientEntity.setIngredient(ingredient);

        return cocktailIngredientDAO.save(cocktailIngredientEntity);
    }

    public List<CocktailIngredientEntity> getAllCocktailIngredients() {
        return cocktailIngredientDAO.findAll();
    }

    public CocktailIngredientEntity getCocktailIngredientById(Long cocktailIngredientId) {
        return cocktailIngredientDAO.findById(cocktailIngredientId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cóctel con el ID proporcionado"));
    }

    public void deleteCocktailIngredient(Long cocktailIngredientId) {
        CocktailIngredientEntity cocktailIngredientEntity = cocktailIngredientDAO.findById(cocktailIngredientId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cóctel con el ID proporcionado"));
        cocktailIngredientDAO.delete(cocktailIngredientEntity);
    }

    public CocktailIngredientEntity updateCocktailIngredient(Long cocktailIngredientId, Long cocktailId, Long ingredientId) {
        CocktailIngredientEntity cocktailIngredientEntity = cocktailIngredientDAO.findById(cocktailIngredientId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cóctel con el ID proporcionado"));

        CocktailEntity cocktail = cocktailDAO.findById(cocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cóctel con el ID proporcionado"));
        IngredientEntity ingredient = ingredientDAO.findById(ingredientId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún ingrediente con el ID proporcionado"));

        cocktailIngredientEntity.setCocktail(cocktail);
        cocktailIngredientEntity.setIngredient(ingredient);

        return cocktailIngredientDAO.save(cocktailIngredientEntity);
    }
}