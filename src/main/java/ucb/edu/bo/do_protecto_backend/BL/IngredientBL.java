package ucb.edu.bo.do_protecto_backend.BL;

import org.springframework.stereotype.Service;
import ucb.edu.bo.do_protecto_backend.DAO.IngredientDAO;
import ucb.edu.bo.do_protecto_backend.ENTITY.IngredientEntity;

import java.util.List;

@Service
public class IngredientBL {

    private final IngredientDAO ingredientDAO;

    public IngredientBL(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    public IngredientEntity createIngredient(String nombre, String cantidad) {
        if (nombre == null || nombre.isEmpty()) {
            throw new RuntimeException("El nombre del ingrediente no puede estar vacío");
        }
        if (cantidad == null || cantidad.isEmpty()) {
            throw new RuntimeException("La cantidad del ingrediente no puede estar vacía");
        }

        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setNombre(nombre);
        ingredientEntity.setCantidad(cantidad);
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
