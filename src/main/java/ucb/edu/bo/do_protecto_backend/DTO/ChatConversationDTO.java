package ucb.edu.bo.do_protecto_backend.DTO;

import java.sql.Timestamp;

public class ChatConversationDTO {
    private Long conversacionId;
    private String mensaje;
    private String respuestaGpt;
    private Timestamp fecha;
    private Long userId; // Puedes usar Long o el tipo de dato adecuado para el usuario
    
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
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
}
