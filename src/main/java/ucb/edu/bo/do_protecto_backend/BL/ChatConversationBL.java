package ucb.edu.bo.do_protecto_backend.BL;

import org.springframework.stereotype.Service;
import ucb.edu.bo.do_protecto_backend.DAO.ChatConversationDAO;
import ucb.edu.bo.do_protecto_backend.DAO.UserDAO;
import ucb.edu.bo.do_protecto_backend.ENTITY.ChatConversationEntity;
import ucb.edu.bo.do_protecto_backend.ENTITY.UserEntity;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ChatConversationBL {

    private final ChatConversationDAO chatConversationDAO;
    private final UserDAO userDAO;

    public ChatConversationBL(ChatConversationDAO chatConversationDAO, UserDAO userDAO) {
        this.chatConversationDAO = chatConversationDAO;
        this.userDAO = userDAO;
    }

    public ChatConversationEntity createChatConversation(String mensaje, String respuestaGpt, Timestamp fecha, Long userId) {
        if (mensaje == null || mensaje.isEmpty()) {
            throw new RuntimeException("El mensaje de la conversación no puede estar vacío");
        }
        if (respuestaGpt == null || respuestaGpt.isEmpty()) {
            throw new RuntimeException("La respuesta GPT de la conversación no puede estar vacía");
        }
        if (fecha == null) {
            throw new RuntimeException("La fecha de la conversación no puede estar vacía");
        }
        if (userId == null) {
            throw new RuntimeException("El usuario de la conversación no puede estar vacío");
        }

        ChatConversationEntity chatConversationEntity = new ChatConversationEntity();
        UserEntity userEntity = userDAO.findById(userId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún usuario con el ID proporcionado"));
        chatConversationEntity.setMensaje(mensaje);
        chatConversationEntity.setRespuestaGpt(respuestaGpt);
        chatConversationEntity.setFecha(fecha);
        chatConversationEntity.setUser(userEntity);

        return chatConversationDAO.save(chatConversationEntity);
    }

    public List<ChatConversationEntity> getAllChatConversations() {
        return chatConversationDAO.findAll();
    }

    public ChatConversationEntity getChatConversationById(Long chatConversationId) {
        return chatConversationDAO.findById(chatConversationId)
                .orElseThrow(() -> new RuntimeException("No se encontró ninguna conversación de chat con el ID proporcionado"));
    }

    public ChatConversationEntity updateChatConversation(Long chatConversationId, String mensaje, String respuestaGpt, Timestamp fecha, Long userId) {
        ChatConversationEntity chatConversationEntity = chatConversationDAO.findById(chatConversationId)
                .orElseThrow(() -> new RuntimeException("No se encontró ninguna conversación de chat con el ID proporcionado"));

        if (mensaje == null || mensaje.isEmpty()) {
            throw new RuntimeException("El mensaje de la conversación no puede estar vacío");
        }
        if (respuestaGpt == null || respuestaGpt.isEmpty()) {
            throw new RuntimeException("La respuesta GPT de la conversación no puede estar vacía");
        }
        if (fecha == null) {
            throw new RuntimeException("La fecha de la conversación no puede estar vacía");
        }
        if (userId == null) {
            throw new RuntimeException("El usuario de la conversación no puede estar vacío");
        }
        UserEntity userEntity = userDAO.findById(userId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún usuario con el ID proporcionado"));
        chatConversationEntity.setMensaje(mensaje);
        chatConversationEntity.setRespuestaGpt(respuestaGpt);
        chatConversationEntity.setFecha(fecha);
        chatConversationEntity.setUser(userEntity);

        return chatConversationDAO.save(chatConversationEntity);
    }


    public void deleteChatConversation(Long chatConversationId) {
        ChatConversationEntity chatConversationEntity = chatConversationDAO.findById(chatConversationId)
                .orElseThrow(() -> new RuntimeException("No se encontró ninguna conversación de chat con el ID proporcionado"));
        chatConversationDAO.delete(chatConversationEntity);
    }
}
