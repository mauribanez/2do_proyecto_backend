package ucb.edu.bo.do_protecto_backend.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.do_protecto_backend.BL.UserBL;
import ucb.edu.bo.do_protecto_backend.ENTITY.UserEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/v1/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserAPI {

    private final UserBL userBL;
    private static final Logger LOGGER = Logger.getLogger(UserAPI.class.getName());

    public UserAPI(UserBL userBL) {
        this.userBL = userBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody Map<String, Object> request) {
        String nombre = (String) request.get("nombre");
        String correoElectronico = (String) request.get("correoElectronico");
        String contrasena = (String) request.get("contrasena");
        LOGGER.log(Level.INFO, "Inicio del método creando usuario");
        try {
            userBL.createUser(nombre, correoElectronico, contrasena);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El usuario se ha creado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al crear usuario", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El usuario no se ha creado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método creando usuario");
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todos los usuarios");
        try {
            List<UserEntity> users = userBL.getAllUsers();
            Map<String, Object> response = new HashMap<>();
            response.put("Usuario creado",users);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todos los usuarios", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener todos los usuarios");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todos los usuarios");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable Long id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo usuario por ID");
        try {
            UserEntity user = userBL.getUserById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("Usuario", user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener usuario por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener usuario por ID");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo usuario por ID");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable("id") Long id, @RequestBody Map<String, Object> request) {
        String nombre = (String) request.get("nombre");
        String correoElectronico = (String) request.get("correoElectronico");
        String contrasena = (String) request.get("contrasena");
        LOGGER.log(Level.INFO, "Inicio del método actualizando usuario");
        try {
            UserEntity updatedUser = userBL.updateUser(id, nombre, correoElectronico, contrasena);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El usuario se ha actualizado exitosamente");
            response.put("user", updatedUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar usuario", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El usuario no se ha actualizado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método actualizando usuario");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método eliminando usuario");
        try {
            userBL.deleteUser(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El usuario se ha eliminado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al eliminar usuario", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El usuario no se ha eliminado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método eliminando usuario");
        }
    }
}
