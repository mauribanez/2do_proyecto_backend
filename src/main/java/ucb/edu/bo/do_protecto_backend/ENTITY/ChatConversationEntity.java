package ucb.edu.bo.do_protecto_backend.ENTITY;

import java.sql.Timestamp;
import jakarta.persistence.*;


@Entity
@Table(name = "ChatConversations")
public class ChatConversationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conversacion_id")
    private Long conversacionId;

    @Column(name = "mensaje", nullable = false, length = 5000)
    private String mensaje;

    @Column(name = "respuesta_gpt", nullable = false, length = 5000)
    private String respuestaGpt;

    @Column(name = "fecha", nullable = false)
    private Timestamp fecha;

    @ManyToOne
    @JoinColumn(name = "Users_user_id", nullable = false)
    private UserEntity user;

    public Long getConversacionId() {
        return conversacionId;
    }

    public void setConversacionId(Long conversacionId) {
        this.conversacionId = conversacionId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
        return "ChatConversationEntity [conversacionId=" + conversacionId + ", mensaje=" + mensaje + ", respuestaGpt="
                + respuestaGpt + ", fecha=" + fecha + ", user=" + user + "]";
    }

    
}
