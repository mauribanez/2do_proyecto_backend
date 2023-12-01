package ucb.edu.bo.do_protecto_backend.DTO;

public class IngredientDTO {
    private Long ingredienteId;
    private String nombre;
    private String cantidad;

    
    public Long getIngredienteId() {
        return ingredienteId;
    }
    public void setIngredienteId(Long ingredienteId) {
        this.ingredienteId = ingredienteId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCantidad() {
        return cantidad;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    
}
