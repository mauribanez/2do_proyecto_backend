package ucb.edu.bo.do_protecto_backend.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.do_protecto_backend.BL.CocktailIngredientBL;
import ucb.edu.bo.do_protecto_backend.ENTITY.CocktailIngredientEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/cocktailingredients")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CocktailIngredientAPI {

    private final CocktailIngredientBL cocktailIngredientBL;
    private static final Logger LOGGER = Logger.getLogger(CocktailIngredientAPI.class.getName());

    public CocktailIngredientAPI(CocktailIngredientBL cocktailIngredientBL) {
        this.cocktailIngredientBL = cocktailIngredientBL;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createCocktailIngredient(@RequestBody Map<String, Long> request) {
        Long cocktailId = request.get("cocktailId");
        Long ingredientId = request.get("ingredientId");
        LOGGER.log(Level.INFO, "Inicio del método creando CocktailIngredient");

        try {
            CocktailIngredientEntity createdCocktailIngredient = cocktailIngredientBL.createCocktailIngredient(cocktailId, ingredientId);
            Map<String, Object> response = new HashMap<>();
            response.put("CocktailIngredient creado exitosamente", createdCocktailIngredient);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al crear CocktailIngredient", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al crear CocktailIngredient");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método creando CocktailIngredient");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllCocktailIngredients() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todos los CocktailIngredients");
        try {
            List<CocktailIngredientEntity> cocktailIngredients = cocktailIngredientBL.getAllCocktailIngredients();
            Map<String, Object> response = new HashMap<>();
            response.put("CocktailIngredients", cocktailIngredients);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todos los CocktailIngredients", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener todos los CocktailIngredients");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todos los CocktailIngredients");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCocktailIngredientById(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo CocktailIngredient por ID");
        try {
            CocktailIngredientEntity cocktailIngredient = cocktailIngredientBL.getCocktailIngredientById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("CocktailIngredient", cocktailIngredient);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener CocktailIngredient por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener CocktailIngredient por ID");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo CocktailIngredient por ID");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteCocktailIngredient(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método eliminando CocktailIngredient");
        try {
            cocktailIngredientBL.deleteCocktailIngredient(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "CocktailIngredient eliminado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al eliminar CocktailIngredient", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al eliminar CocktailIngredient");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método eliminando CocktailIngredient");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateCocktailIngredient(
            @PathVariable("id") Long id,
            @RequestBody Map<String, Long> request) {
        Long cocktailId = request.get("cocktailId");
        Long ingredientId = request.get("ingredientId");
        LOGGER.log(Level.INFO, "Inicio del método actualizando CocktailIngredient");

        try {
            CocktailIngredientEntity updatedCocktailIngredient = cocktailIngredientBL.updateCocktailIngredient(id, cocktailId, ingredientId);
            Map<String, Object> response = new HashMap<>();
            response.put("CocktailIngredient actualizado exitosamente", updatedCocktailIngredient);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar CocktailIngredient", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al actualizar CocktailIngredient");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método actualizando CocktailIngredient");
        }
    }
}
