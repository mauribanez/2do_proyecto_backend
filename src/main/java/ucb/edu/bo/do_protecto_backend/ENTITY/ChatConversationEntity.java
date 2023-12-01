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
}
