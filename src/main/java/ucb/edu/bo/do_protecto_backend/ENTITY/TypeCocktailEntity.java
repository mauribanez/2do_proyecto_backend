package ucb.edu.bo.do_protecto_backend.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

@Entity
@Table(name = "typecocktail")
public class TypeCocktailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typecocktail_id")
    private Long typeCocktailId;

    @Column(name = "nametype", nullable = false)
    private String nameType;

    public Long getTypeCocktailId() {
        return typeCocktailId;
    }

    public void setTypeCocktailId(Long typeCocktailId) {
        this.typeCocktailId = typeCocktailId;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    @Override
    public String toString() {
        return "TypeCocktailEntity [typeCocktailId=" + typeCocktailId + ", nameType=" + nameType + "]";
    }

    
}
