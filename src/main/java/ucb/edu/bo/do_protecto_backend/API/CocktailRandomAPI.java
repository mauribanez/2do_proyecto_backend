package ucb.edu.bo.do_protecto_backend.API;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucb.edu.bo.do_protecto_backend.BL.CocktailRandomBL;
import ucb.edu.bo.do_protecto_backend.ENTITY.CocktailRandomEntity;

@RestController
@RequestMapping("/api/v1/cocktailapi")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CocktailRandomAPI {

    private CocktailRandomBL cocktailApiBL;
    private static final Logger LOGGER = Logger.getLogger(CocktailRandomAPI.class.getName());

    public CocktailRandomAPI(CocktailRandomBL cocktailApiBL) {
        this.cocktailApiBL = cocktailApiBL;
    }

    @GetMapping("/fetch")
    public ResponseEntity<String> fetchAndStoreCocktailsFromApi() {
        cocktailApiBL.fetchAndStoreCocktailsFromAPI();
        return ResponseEntity.ok("Coctel random importado con éxito");
    }

    @GetMapping()
    public ResponseEntity<List<CocktailRandomEntity>> getAllCategories() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todos los cocteles randoms");
        try {
            List<CocktailRandomEntity> categories = cocktailApiBL.getAllCocktails();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todos los cocteles randoms", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener todos los cocteles randoms");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todos los cocteles randoms");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CocktailRandomEntity> findCategoryById(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo coctel random por ID");
        try {
            CocktailRandomEntity coctel = cocktailApiBL.getCocktailById(id);
            return new ResponseEntity<>(coctel, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener coctel random por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener coctel random por ID");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo coctel random por ID");
        }
    }
    
}
