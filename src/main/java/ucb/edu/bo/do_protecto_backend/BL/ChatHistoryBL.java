package ucb.edu.bo.do_protecto_backend.BL;

import org.springframework.stereotype.Service;
import ucb.edu.bo.do_protecto_backend.DAO.ChatHistoryDAO;
import ucb.edu.bo.do_protecto_backend.DAO.UserDAO;
import ucb.edu.bo.do_protecto_backend.ENTITY.ChatHistoryEntity;
import ucb.edu.bo.do_protecto_backend.ENTITY.UserEntity;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ChatHistoryBL {

    private final ChatHistoryDAO chatHistoryDAO;
    private final UserDAO userDAO;

    public ChatHistoryBL(ChatHistoryDAO chatHistoryDAO, UserDAO userDAO) {
        this.chatHistoryDAO = chatHistoryDAO;
        this.userDAO = userDAO;
    }

    public ChatHistoryEntity createChatHistory(String consulta, String respuestaGpt, Timestamp fecha, Long userId) {
        if (consulta == null || consulta.isEmpty()) {
            throw new RuntimeException("La consulta de la conversación no puede estar vacía");
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

        ChatHistoryEntity chatHistoryEntity = new ChatHistoryEntity();
        UserEntity userEntity = userDAO.findById(userId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún usuario con el ID proporcionado"));
        chatHistoryEntity.setConsulta(consulta);
        chatHistoryEntity.setRespuestaGpt(respuestaGpt);
        chatHistoryEntity.setFecha(fecha);
        chatHistoryEntity.setUser(userEntity);

        return chatHistoryDAO.save(chatHistoryEntity);
    }

    public List<ChatHistoryEntity> getAllChatHistories() {
        return chatHistoryDAO.findAll();
    }

    public ChatHistoryEntity getChatHistoryById(Long chatHistoryId) {
        return chatHistoryDAO.findById(chatHistoryId)
                .orElseThrow(() -> new RuntimeException("No se encontró ninguna conversación de chat con el ID proporcionado"));
    }

    public ChatHistoryEntity updateChatHistory(Long chatHistoryId, String consulta, String respuestaGpt, Timestamp fecha, Long userId) {
        ChatHistoryEntity chatHistoryEntity = chatHistoryDAO.findById(chatHistoryId)
                .orElseThrow(() -> new RuntimeException("No se encontró ninguna conversación de chat con el ID proporcionado"));

        if (consulta == null || consulta.isEmpty()) {
            throw new RuntimeException("La consulta de la conversación no puede estar vacía");
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
        chatHistoryEntity.setConsulta(consulta);
        chatHistoryEntity.setRespuestaGpt(respuestaGpt);
        chatHistoryEntity.setFecha(fecha);
        chatHistoryEntity.setUser(userEntity);

        return chatHistoryDAO.save(chatHistoryEntity);
    }

    public void deleteChatHistory(Long chatHistoryId) {
        ChatHistoryEntity chatHistoryEntity = chatHistoryDAO.findById(chatHistoryId)
                .orElseThrow(() -> new RuntimeException("No se encontró ninguna conversación de chat con el ID proporcionado"));
        chatHistoryDAO.delete(chatHistoryEntity);
    }
}
