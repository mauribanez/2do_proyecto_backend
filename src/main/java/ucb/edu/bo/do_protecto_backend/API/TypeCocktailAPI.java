package ucb.edu.bo.do_protecto_backend.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.do_protecto_backend.BL.TypeCocktailBL;
import ucb.edu.bo.do_protecto_backend.ENTITY.TypeCocktailEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/typecocktails")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TypeCocktailAPI {

    private final TypeCocktailBL typeCocktailBL;
    private static final Logger LOGGER = Logger.getLogger(TypeCocktailAPI.class.getName());

    public TypeCocktailAPI(TypeCocktailBL typeCocktailBL) {
        this.typeCocktailBL = typeCocktailBL;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createTypeCocktail(@RequestBody Map<String, String> request) {
        String nameType = request.get("nametype");
        LOGGER.log(Level.INFO, "Inicio del método creando TypeCocktail");

        try {
            TypeCocktailEntity createdTypeCocktail = typeCocktailBL.createTypeCocktail(nameType);
            Map<String, Object> response = new HashMap<>();
            response.put("TypeCocktail creado exitosamente", createdTypeCocktail);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al crear TypeCocktail", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al crear TypeCocktail");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método creando TypeCocktail");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllTypeCocktails() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todos los TypeCocktails");
        try {
            List<TypeCocktailEntity> typeCocktails = typeCocktailBL.getAllTypeCocktails();
            Map<String, Object> response = new HashMap<>();
            response.put("Tipos de cócteles", typeCocktails);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todos los TypeCocktails", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener todos los TypeCocktails");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todos los TypeCocktails");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getTypeCocktailById(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo TypeCocktail por ID");
        try {
            TypeCocktailEntity typeCocktail = typeCocktailBL.getTypeCocktailById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("Tipo de cóctel", typeCocktail);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener TypeCocktail por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener TypeCocktail por ID");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo TypeCocktail por ID");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateTypeCocktail(@PathVariable("id") Long id, @RequestBody Map<String, String> request) {
        String nameType = request.get("nameType");
        LOGGER.log(Level.INFO, "Inicio del método actualizando TypeCocktail");

        try {
            TypeCocktailEntity updatedTypeCocktail = typeCocktailBL.updateTypeCocktail(id, nameType);
            Map<String, Object> response = new HashMap<>();
            response.put("TypeCocktail actualizado exitosamente", updatedTypeCocktail);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar TypeCocktail", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al actualizar TypeCocktail");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método actualizando TypeCocktail");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteTypeCocktail(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método eliminando TypeCocktail");
        try {
            typeCocktailBL.deleteTypeCocktail(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "TypeCocktail eliminado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al eliminar TypeCocktail", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al eliminar TypeCocktail");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método eliminando TypeCocktail");
        }
    }
}