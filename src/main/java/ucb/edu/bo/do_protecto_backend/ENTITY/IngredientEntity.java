package ucb.edu.bo.do_protecto_backend.ENTITY;

import jakarta.persistence.*;

@Entity
@Table(name = "Ingredients")
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingrediente_id")
    private Long ingredienteId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "cantidad", nullable = false)
    private String cantidad;

    @ManyToOne
    @JoinColumn(name = "cocktails_cocktail_id", nullable = false)
    private CocktailEntity cocktailId;

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

    public CocktailEntity getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(CocktailEntity cocktailId) {
        this.cocktailId = cocktailId;
    }
    


    @Override
    public String toString() {
        return "IngredientEntity [ingredienteId=" + ingredienteId + ", nombre=" + nombre + ", cantidad=" + cantidad
                + "]";
    }




    
}
