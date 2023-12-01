package ucb.edu.bo.do_protecto_backend.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.do_protecto_backend.BL.CocktailBL;
import ucb.edu.bo.do_protecto_backend.ENTITY.CocktailEntity;
import ucb.edu.bo.do_protecto_backend.ENTITY.CategoryEntity;
import ucb.edu.bo.do_protecto_backend.ENTITY.TypeCocktailEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/cocktails")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CocktailAPI {

    private final CocktailBL cocktailBL;
    private static final Logger LOGGER = Logger.getLogger(CocktailAPI.class.getName());

    public CocktailAPI(CocktailBL cocktailBL) {
        this.cocktailBL = cocktailBL;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createCocktail(@RequestBody Map<String, Object> request) {
        String nameCocktail = (String) request.get("nameCocktail");
        String preparation = (String) request.get("preparation");
        Integer typeCocktailInt = (Integer) request.get("typeCocktail");
        Long typeCocktail = typeCocktailInt.longValue();
        Integer categoryInt = (Integer) request.get("category");
        Long category = categoryInt.longValue();

        LOGGER.log(Level.INFO, "Inicio del método creando Cocktail");

        try {
            CocktailEntity createdCocktail = cocktailBL.createCocktail(nameCocktail, preparation, typeCocktail, category);
            Map<String, Object> response = new HashMap<>();
            response.put("Cocktail creado exitosamente", createdCocktail);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al crear Cocktail", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al crear Cocktail");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método creando Cocktail");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllCocktails() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todos los Cocktails");
        try {
            List<CocktailEntity> cocktails = cocktailBL.getAllCocktails();
            Map<String, Object> response = new HashMap<>();
            response.put("Cócteles", cocktails);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todos los Cocktails", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener todos los Cocktails");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todos los Cocktails");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCocktailById(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo Cocktail por ID");
        try {
            CocktailEntity cocktail = cocktailBL.getCocktailById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("Cóctel", cocktail);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener Cocktail por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener Cocktail por ID");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo Cocktail por ID");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateCocktail(@PathVariable("id") Long id, @RequestBody Map<String, Object> request) {
        String nameCocktail = (String) request.get("nameCocktail");
        String preparation = (String) request.get("preparation");
        TypeCocktailEntity typeCocktail = (TypeCocktailEntity) request.get("typeCocktail");
        CategoryEntity category = (CategoryEntity) request.get("category");

        LOGGER.log(Level.INFO, "Inicio del método actualizando Cocktail");

        try {
            CocktailEntity updatedCocktail = cocktailBL.updateCocktail(id, nameCocktail, preparation, typeCocktail, category);
            Map<String, Object> response = new HashMap<>();
            response.put("Cocktail actualizado exitosamente", updatedCocktail);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar Cocktail", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al actualizar Cocktail");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método actualizando Cocktail");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteCocktail(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método eliminando Cocktail");
        try {
            cocktailBL.deleteCocktail(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Cocktail eliminado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al eliminar Cocktail", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al eliminar Cocktail");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método eliminando Cocktail");
        }
    }
}
