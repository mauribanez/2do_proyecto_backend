package ucb.edu.bo.do_protecto_backend.ENTITY;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "ChatHistory")
public class ChatHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_history_id")
    private Long chatHistoryId;

    @Column(name = "consulta", nullable = false, length = 5000)
    private String consulta;

    @Column(name = "respuesta_gpt", nullable = false, length = 5000)
    private String respuestaGpt;

    @Column(name = "fecha", nullable = false)
    private Timestamp fecha;

    @ManyToOne
    @JoinColumn(name = "Users_user_id", nullable = false)
    private UserEntity user;

    public Long getChatHistoryId() {
        return chatHistoryId;
    }

    public void setChatHistoryId(Long chatHistoryId) {
        this.chatHistoryId = chatHistoryId;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getRespuestaGpt() {
        return respuestaGpt;
    }

    public void setRespuestaGpt(String respuestaGpt) {
        this.respuestaGpt = respuestaGpt;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ChatHistoryEntity [chatHistoryId=" + chatHistoryId + ", consulta=" + consulta + ", respuestaGpt="
                + respuestaGpt + ", fecha=" + fecha + ", user=" + user + "]";
    }

    
}
