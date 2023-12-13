package ucb.edu.bo.do_protecto_backend.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.do_protecto_backend.BL.CategoryBL;
import ucb.edu.bo.do_protecto_backend.ENTITY.CategoryEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/v1/category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryAPI {

    private final CategoryBL categoryBL;
    private static final Logger LOGGER = Logger.getLogger(CategoryAPI.class.getName());


    public CategoryAPI(CategoryBL categoryBL) {
        this.categoryBL = categoryBL;
    }

    @PostMapping("/create")
     public ResponseEntity<Map<String, Object>> createCategory(@RequestBody Map<String, Object> request) {
        String nameCategory = (String) request.get("namecategory");
        LOGGER.log(Level.INFO, "Inicio del método creando categoría");
        try {
            categoryBL.createCategory(nameCategory);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La categoría ha sido creada con éxito");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al crear categoría", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al crear categoría");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método creando categoría");
        }
    }

    @GetMapping()
    public ResponseEntity<List<CategoryEntity>> getAllCategories() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todas las categorías");
        try {
            List<CategoryEntity> categories = categoryBL.getAllCategories();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todas las categorías", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener todas las categorías");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todas las categorías");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> findCategoryById(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo categoría por ID");
        try {
            CategoryEntity category = categoryBL.getCategoryById(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener categoría por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener categoría por ID");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo categoría por ID");
        }
    }

    @GetMapping("/fetch")
    public ResponseEntity<String> fetchAndStoreCategories() {
        categoryBL.fetchAndStoreCategoriesFromAPI();
        return ResponseEntity.ok("Categorías importadas con éxito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable("id") Long id, @RequestBody Map<String, Object> request) {
        String nameCategory = (String) request.get("nameCategory");
        LOGGER.log(Level.INFO, "Inicio del método actualizando categoría");
        try {
            CategoryEntity category = categoryBL.updateCategory(id, nameCategory);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La categoría ha sido actualizada con éxito");
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar categoría", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al actualizar categoría");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método actualizando categoría");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryEntity> deleteCategory(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método eliminando categoría");
        try {
            CategoryEntity deletedCategory = categoryBL.deleteCategory(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La categoría ha sido eliminada con éxito");
            return new ResponseEntity<>(deletedCategory, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al eliminar categoría", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al eliminar categoría");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método eliminando categoría");
        }
    }
}
