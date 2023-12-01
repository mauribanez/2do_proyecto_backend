package ucb.edu.bo.do_protecto_backend.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.do_protecto_backend.BL.IngredientBL;
import ucb.edu.bo.do_protecto_backend.ENTITY.IngredientEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/ingredients")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IngredientAPI {

    private final IngredientBL ingredientBL;
    private static final Logger LOGGER = Logger.getLogger(IngredientAPI.class.getName());

    public IngredientAPI(IngredientBL ingredientBL) {
        this.ingredientBL = ingredientBL;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createIngredient(@RequestBody Map<String, String> request) {
        String nombre = request.get("nombre");
        String cantidad = request.get("cantidad");
        LOGGER.log(Level.INFO, "Inicio del método creando ingrediente");

        try {
            IngredientEntity createdIngredient = ingredientBL.createIngredient(nombre, cantidad);
            Map<String, Object> response = new HashMap<>();
            response.put("Ingrediente creado exitosamente", createdIngredient);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al crear ingrediente", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al crear ingrediente");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método creando ingrediente");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllIngredients() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todos los ingredientes");
        try {
            List<IngredientEntity> ingredients = ingredientBL.getAllIngredients();
            Map<String, Object> response = new HashMap<>();
            response.put("Ingredientes creados", ingredients);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todos los ingredientes", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener todos los ingredientes");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todos los ingredientes");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getIngredientById(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo ingrediente por ID");
        try {
            IngredientEntity ingredient = ingredientBL.getIngredientById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("Ingrediente creado", ingredient);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener ingrediente por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener ingrediente por ID");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo ingrediente por ID");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateIngredient(@PathVariable("id") Long id, @RequestBody Map<String, String> request) {
        String nombre = request.get("nombre");
        String cantidad = request.get("cantidad");

        LOGGER.log(Level.INFO, "Inicio del método actualizando ingrediente");
        try {
            IngredientEntity updatedIngredient = ingredientBL.updateIngredient(id, nombre, cantidad);
            Map<String, Object> response = new HashMap<>();
            response.put("Ingrediente actualizado exitosamente", updatedIngredient);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar ingrediente", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al actualizar ingrediente");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método actualizando ingrediente");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteIngredient(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método eliminando ingrediente");
        try {
            ingredientBL.deleteIngredient(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Ingrediente eliminado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al eliminar ingrediente", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al eliminar ingrediente");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método eliminando ingrediente");
        }
    }
}
