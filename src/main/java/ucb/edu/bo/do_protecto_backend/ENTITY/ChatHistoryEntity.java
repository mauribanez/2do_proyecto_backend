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

    // Constructor, getters y setters
}
