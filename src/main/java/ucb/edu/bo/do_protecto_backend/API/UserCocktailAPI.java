package ucb.edu.bo.do_protecto_backend.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.do_protecto_backend.BL.UserCocktailBL;
import ucb.edu.bo.do_protecto_backend.ENTITY.UserCocktailEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/usercocktails")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserCocktailAPI {

    private final UserCocktailBL userCocktailBL;
    private static final Logger LOGGER = Logger.getLogger(UserCocktailAPI.class.getName());

    public UserCocktailAPI(UserCocktailBL userCocktailBL) {
        this.userCocktailBL = userCocktailBL;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createUserCocktail(@RequestBody Map<String, Long> request) {
        Long userId = request.get("userId");
        Long cocktailId = request.get("cocktailId");
        LOGGER.log(Level.INFO, "Inicio del método creando UserCocktail");

        try {
            UserCocktailEntity createdUserCocktail = userCocktailBL.createUserCocktail(userId, cocktailId);
            Map<String, Object> response = new HashMap<>();
            response.put("UserCocktail creado exitosamente", createdUserCocktail    );
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al crear UserCocktail", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al crear UserCocktail");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método creando UserCocktail");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllUserCocktails() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todos los UserCocktails");
        try {
            List<UserCocktailEntity> userCocktails = userCocktailBL.getAllUserCocktails();
            Map<String, Object> response = new HashMap<>();
            response.put("Usuario y coctel creado",userCocktails);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todos los UserCocktails", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener todos los UserCocktails");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todos los UserCocktails");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserCocktailById(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo UserCocktail por ID");
        try {
            UserCocktailEntity userCocktail = userCocktailBL.getUserCocktailById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("Ususaruio y coctel creado",userCocktail);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener UserCocktail por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener UserCocktail por ID");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo UserCocktail por ID");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteUserCocktail(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método eliminando UserCocktail");
        try {
            userCocktailBL.deleteUserCocktail(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "UserCocktail eliminado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al eliminar UserCocktail", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al eliminar UserCocktail");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método eliminando UserCocktail");
        }
    }
}
