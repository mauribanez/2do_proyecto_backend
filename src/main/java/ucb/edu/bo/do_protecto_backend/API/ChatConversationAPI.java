package ucb.edu.bo.do_protecto_backend.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.do_protecto_backend.BL.ChatConversationBL;
import ucb.edu.bo.do_protecto_backend.ENTITY.ChatConversationEntity;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/v1/chatconversations")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChatConversationAPI {

    private final ChatConversationBL chatConversationBL;
    private static final Logger LOGGER = Logger.getLogger(ChatConversationAPI.class.getName());

    public ChatConversationAPI(ChatConversationBL chatConversationBL) {
        this.chatConversationBL = chatConversationBL;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createChatConversation(@RequestBody Map<String, Object> request) {
        
        String mensaje = (String) request.get("mensaje");
        String respuestaGpt = (String) request.get("respuestaGpt");
        Timestamp fecha = (Timestamp) request.get("fecha");
        Long userId = (Long) request.get("userId");
        LOGGER.log(Level.INFO, "Inicio del método creando conversación de chat");
        try {
            chatConversationBL.createChatConversation(mensaje, respuestaGpt, fecha, userId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La conversación de chat se ha creado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al crear conversación de chat", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La conversación de chat no se ha creado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método creando conversación de chat");
        }
    }

    @GetMapping()
    public ResponseEntity<List<ChatConversationEntity>> getAllChatConversations() {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo todas las conversaciones de chat");
        try {
            List<ChatConversationEntity> chatConversations = chatConversationBL.getAllChatConversations();
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Se han obtenido todas las conversaciones de chat exitosamente");
            return new ResponseEntity<>(chatConversations, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener todas las conversaciones de chat", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener todas las conversaciones de chat");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo todas las conversaciones de chat");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatConversationEntity> getChatConversationById(@PathVariable Long id) {
        LOGGER.log(Level.INFO, "Inicio del método obteniendo conversación de chat por ID");
        try {
            ChatConversationEntity chatConversation = chatConversationBL.getChatConversationById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Se ha obtenido la conversación de chat exitosamente");
            return new ResponseEntity<>(chatConversation, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al obtener conversación de chat por ID", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al obtener conversación de chat por ID");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método obteniendo conversación de chat por ID");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateChatConversation(@PathVariable("id") Long id, @RequestBody Map<String, Object> request) {
        String mensaje = (String) request.get("mensaje");
        String respuestaGpt = (String) request.get("respuestaGpt");
        Timestamp fecha = (Timestamp) request.get("fecha");
        Long userId = (Long) request.get("userId");

        LOGGER.log(Level.INFO, "Inicio del método actualizando conversación de chat");
        
        try {
            ChatConversationEntity updatedChatConversation = chatConversationBL.updateChatConversation(id, mensaje, respuestaGpt, fecha, userId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La conversación de chat se ha actualizado exitosamente");
            response.put("chatConversation", updatedChatConversation);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al actualizar conversación de chat", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La conversación de chat no se ha actualizado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método actualizando conversación de chat");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteChatConversation(@PathVariable("id") Long id) {
        LOGGER.log(Level.INFO, "Inicio del método eliminando conversación de chat");
        try {
            chatConversationBL.deleteChatConversation(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La conversación de chat se ha eliminado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Error al eliminar conversación de chat", e);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "La conversación de chat no se ha eliminado");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            LOGGER.log(Level.INFO, "Fin del método eliminando conversación de chat");
        }
    }
}
