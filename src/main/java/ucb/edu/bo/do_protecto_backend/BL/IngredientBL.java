package ucb.edu.bo.do_protecto_backend.BL;

import org.springframework.stereotype.Service;

import ucb.edu.bo.do_protecto_backend.DAO.CocktailDAO;
import ucb.edu.bo.do_protecto_backend.DAO.IngredientDAO;
import ucb.edu.bo.do_protecto_backend.ENTITY.CocktailEntity;
import ucb.edu.bo.do_protecto_backend.ENTITY.IngredientEntity;

import java.util.List;

@Service
public class IngredientBL {

    private final IngredientDAO ingredientDAO;
    private final CocktailDAO   cocktailDAO;

    public IngredientBL(IngredientDAO ingredientDAO, CocktailDAO cocktailDAO) {
        this.ingredientDAO = ingredientDAO;
        this.cocktailDAO = cocktailDAO;
    }

    public IngredientEntity createIngredient(String nombre, String cantidad, Long cocktailId) {
        if (nombre == null || nombre.isEmpty()) {
            throw new RuntimeException("El nombre del ingrediente no puede estar vacío");
        }
        if (cantidad == null || cantidad.isEmpty()) {
            throw new RuntimeException("La cantidad del ingrediente no puede estar vacía");
        }
        if (cocktailId == null) {
            throw new RuntimeException("El cóctel no puede estar vacío");
        }

        IngredientEntity ingredientEntity = new IngredientEntity();
        CocktailEntity cocktail = cocktailDAO.findById(cocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cóctel con el ID proporcionado"));
        ingredientEntity.setNombre(nombre);
        ingredientEntity.setCantidad(cantidad);
        ingredientEntity.setCocktailId(cocktail);;
        return ingredientDAO.save(ingredientEntity);
    }

    public List<IngredientEntity> getAllIngredients() {
        return ingredientDAO.findAll();
    }

    public IngredientEntity getIngredientById(Long id) {
        return ingredientDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún ingrediente con el ID proporcionado"));
    }

    public IngredientEntity updateIngredient(Long id, String nombre, String cantidad) {
        IngredientEntity ingredientEntity = ingredientDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún ingrediente con el ID proporcionado"));

        if (nombre == null || nombre.isEmpty()) {
            throw new RuntimeException("El nombre del ingrediente no puede estar vacío");
        }
        if (cantidad == null || cantidad.isEmpty()) {
            throw new RuntimeException("La cantidad del ingrediente no puede estar vacía");
        }

        ingredientEntity.setNombre(nombre);
        ingredientEntity.setCantidad(cantidad);
        return ingredientDAO.save(ingredientEntity);
    }

    public void deleteIngredient(Long id) {
        IngredientEntity ingredientEntity = ingredientDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún ingrediente con el ID proporcionado"));
        ingredientDAO.delete(ingredientEntity);
    }
}
