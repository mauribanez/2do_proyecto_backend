package ucb.edu.bo.do_protecto_backend.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.do_protecto_backend.BL.ChatHistoryBL;
import ucb.edu.bo.do_protecto_backend.ENTITY.ChatHistoryEntity;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/v1/chathistory")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChatHistoryAPI {

    private final ChatHistoryBL chatHistoryBL;
    private static final Logger LOGGER = Logger.getLogger(ChatHistoryAPI.class.getName());

    @Autowired
    public ChatHistoryAPI(ChatHistoryBL chatHistoryBL) {
        this.chatHistoryBL = chatHistoryBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createChatHistory(@RequestBody Map<String, Object> request) {
        String consulta = (String) request.get("consulta");
        String respuestaGpt = (String) request.get("respuestaGpt");
        Timestamp fecha = (Timestamp) request.get("fecha");
        Long userId = (Long) request.get("userId");
        LOGGER.log(Level.INFO, "Inicio del método creando historial de chat");
        try {
            chatHistoryBL.createChatHistory(consulta, respuestaGpt, fecha, userId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El historial de chat se ha creado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al crear historial de chat", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El historial de chat no se ha creado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método creando historial de chat");
        }
    }

    @GetMapping()
    public ResponseEntity<List<ChatHistoryEntity>> getAllChatHistory() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todos los historiales de chat");
        try {
            List<ChatHistoryEntity> chatHistory = chatHistoryBL.getAllChatHistories();
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Se han obtenido todos los historiales de chat exitosamente");
            return new ResponseEntity<>(chatHistory, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todos los historiales de chat", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener todos los historiales de chat");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todos los historiales de chat");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatHistoryEntity> getChatHistoryById(@PathVariable Long id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo historial de chat por ID");
        try {
            ChatHistoryEntity chatHistory = chatHistoryBL.getChatHistoryById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Se ha obtenido el historial de chat exitosamente");
            return new ResponseEntity<>(chatHistory, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener historial de chat por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener historial de chat por ID");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo historial de chat por ID");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateChatHistory(@PathVariable("id") Long id, @RequestBody Map<String, Object> request) {
        String consulta = (String) request.get("consulta");
        String respuestaGpt = (String) request.get("respuestaGpt");
        Timestamp fecha = (Timestamp) request.get("fecha");
        Long userId = (Long) request.get("userId");

        LOGGER.log(Level.INFO, "Inicio del método actualizando historial de chat");
        
        try {
            ChatHistoryEntity updatedChatHistory = chatHistoryBL.updateChatHistory(id, consulta, respuestaGpt, fecha, userId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El historial de chat se ha actualizado exitosamente");
            response.put("chatHistory", updatedChatHistory);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar historial de chat", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El historial de chat no se ha actualizado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método actualizando historial de chat");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteChatHistory(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método eliminando historial de chat");
        try {
            chatHistoryBL.deleteChatHistory(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El historial de chat se ha eliminado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al eliminar historial de chat", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "El historial de chat no se ha eliminado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método eliminando historial de chat");
        }
    }
}
