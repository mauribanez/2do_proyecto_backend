package ucb.edu.bo.do_protecto_backend.DTO;

import java.sql.Timestamp;

public class ChatHistoryDTO {
    private Long chatHistoryId;
    private String consulta;
    private String respuestaGpt;
    private Timestamp fecha;
    private Long userId; // Puedes usar Long o el tipo de dato adecuado para el usuario

    
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
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
}