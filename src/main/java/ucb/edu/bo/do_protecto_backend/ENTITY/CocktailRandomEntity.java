package ucb.edu.bo.do_protecto_backend.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
@Table(name = "cocktailapi")
public class CocktailRandomEntity {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cocktailapi_id")
    private Long cocktailapiId;

    @Column(name = "iddrink", nullable = false)
    private String idDrink;

    @Column(name = "namedrink", nullable = false)
    private String nameDrink;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "typedrink", nullable = false)
    private String typeDrink;

    @Column(name = "glass")
    private String glass;

    @Column(name = "instructions", nullable = false, length = 5000)
    private String instructions;

    @Column(name = "imagenurl", length = 1000)
    private String imagenURL;

    @Column(name = "ingredient_name1", nullable = false)
    private String ingredientName1;

    @Column(name = "ingredient_quantity1", nullable = false)
    private String ingredientQuantity1;

    @Column(name = "ingredient_name2", nullable = false)
    private String ingredientName2;

    @Column(name = "ingredient_quantity2", nullable = false)
    private String ingredientQuantity2;

    @Column(name = "ingredient_name3")
    private String ingredientName3;

    @Column(name = "ingredient_quantity3")
    private String ingredientQuantity3;

    @Column(name = "ingredient_name4")
    private String ingredientName4;

    @Column(name = "ingredient_quantity4")
    private String ingredientQuantity4;

    @Column(name = "ingredient_name5")
    private String ingredientName5;

    @Column(name = "ingredient_quantity5")
    private String ingredientQuantity5;

    @Column(name = "ingredient_name6")
    private String ingredientName6;

    @Column(name = "ingredient_quantity6")
    private String ingredientQuantity6;

    @Column(name = "ingredient_name7")
    private String ingredientName7;

    @Column(name = "ingredient_quantity7")
    private String ingredientQuantity7;

    @Column(name = "ingredient_name8")
    private String ingredientName8;

    @Column(name = "ingredient_quantity8")
    private String ingredientQuantity8;

    @Column(name = "ingredient_name9")
    private String ingredientName9;

    @Column(name = "ingredient_quantity9")
    private String ingredientQuantity9;

    @Column(name = "ingredient_name10")
    private String ingredientName10;

    @Column(name = "ingredient_quantity10")
    private String ingredientQuantity10;

    @Column(name = "ingredient_name11")
    private String ingredientName11;

    @Column(name = "ingredient_quantity11")
    private String ingredientQuantity11;

    @Column(name = "ingredient_name12")
    private String ingredientName12;

    @Column(name = "ingredient_quantity12")
    private String ingredientQuantity12;

    @Column(name = "ingredient_name13")
    private String ingredientName13;

    @Column(name = "ingredient_quantity13")
    private String ingredientQuantity13;

    @Column(name = "ingredient_name14")
    private String ingredientName14;

    @Column(name = "ingredient_quantity14")
    private String ingredientQuantity14;

    @Column(name = "ingredient_name15")
    private String ingredientName15;

    @Column(name = "ingredient_quantity15")
    private String ingredientQuantity15;

    public Long getCocktailapiId() {
        return cocktailapiId;
    }

    public void setCocktailapiId(Long cocktailapiId) {
        this.cocktailapiId = cocktailapiId;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    public String getNameDrink() {
        return nameDrink;
    }

    public void setNameDrink(String nameDrink) {
        this.nameDrink = nameDrink;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTypeDrink() {
        return typeDrink;
    }

    public void setTypeDrink(String typeDrink) {
        this.typeDrink = typeDrink;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public String getIngredientName1() {
        return ingredientName1;
    }

    public void setIngredientName1(String ingredientName1) {
        this.ingredientName1 = ingredientName1;
    }

    public String getIngredientQuantity1() {
        return ingredientQuantity1;
    }

    public void setIngredientQuantity1(String ingredientQuantity1) {
        this.ingredientQuantity1 = ingredientQuantity1;
    }

    public String getIngredientName2() {
        return ingredientName2;
    }

    public void setIngredientName2(String ingredientName2) {
        this.ingredientName2 = ingredientName2;
    }

    public String getIngredientQuantity2() {
        return ingredientQuantity2;
    }

    public void setIngredientQuantity2(String ingredientQuantity2) {
        this.ingredientQuantity2 = ingredientQuantity2;
    }

    public String getIngredientName3() {
        return ingredientName3;
    }

    public void setIngredientName3(String ingredientName3) {
        this.ingredientName3 = ingredientName3;
    }

    public String getIngredientQuantity3() {
        return ingredientQuantity3;
    }

    public void setIngredientQuantity3(String ingredientQuantity3) {
        this.ingredientQuantity3 = ingredientQuantity3;
    }

    public String getIngredientName4() {
        return ingredientName4;
    }

    public void setIngredientName4(String ingredientName4) {
        this.ingredientName4 = ingredientName4;
    }

    public String getIngredientQuantity4() {
        return ingredientQuantity4;
    }

    public void setIngredientQuantity4(String ingredientQuantity4) {
        this.ingredientQuantity4 = ingredientQuantity4;
    }

    public String getIngredientName5() {
        return ingredientName5;
    }

    public void setIngredientName5(String ingredientName5) {
        this.ingredientName5 = ingredientName5;
    }

    public String getIngredientQuantity5() {
        return ingredientQuantity5;
    }

    public void setIngredientQuantity5(String ingredientQuantity5) {
        this.ingredientQuantity5 = ingredientQuantity5;
    }

    public String getIngredientName6() {
        return ingredientName6;
    }

    public void setIngredientName6(String ingredientName6) {
        this.ingredientName6 = ingredientName6;
    }

    public String getIngredientQuantity6() {
        return ingredientQuantity6;
    }

    public void setIngredientQuantity6(String ingredientQuantity6) {
        this.ingredientQuantity6 = ingredientQuantity6;
    }

    public String getIngredientName7() {
        return ingredientName7;
    }

    public void setIngredientName7(String ingredientName7) {
        this.ingredientName7 = ingredientName7;
    }

    public String getIngredientQuantity7() {
        return ingredientQuantity7;
    }

    public void setIngredientQuantity7(String ingredientQuantity7) {
        this.ingredientQuantity7 = ingredientQuantity7;
    }

    public String getIngredientName8() {
        return ingredientName8;
    }

    public void setIngredientName8(String ingredientName8) {
        this.ingredientName8 = ingredientName8;
    }

    public String getIngredientQuantity8() {
        return ingredientQuantity8;
    }

    public void setIngredientQuantity8(String ingredientQuantity8) {
        this.ingredientQuantity8 = ingredientQuantity8;
    }

    public String getIngredientName9() {
        return ingredientName9;
    }

    public void setIngredientName9(String ingredientName9) {
        this.ingredientName9 = ingredientName9;
    }

    public String getIngredientQuantity9() {
        return ingredientQuantity9;
    }

    public void setIngredientQuantity9(String ingredientQuantity9) {
        this.ingredientQuantity9 = ingredientQuantity9;
    }

    public String getIngredientName10() {
        return ingredientName10;
    }

    public void setIngredientName10(String ingredientName10) {
        this.ingredientName10 = ingredientName10;
    }

    public String getIngredientQuantity10() {
        return ingredientQuantity10;
    }

    public void setIngredientQuantity10(String ingredientQuantity10) {
        this.ingredientQuantity10 = ingredientQuantity10;
    }

    public String getIngredientName11() {
        return ingredientName11;
    }

    public void setIngredientName11(String ingredientName11) {
        this.ingredientName11 = ingredientName11;
    }

    public String getIngredientQuantity11() {
        return ingredientQuantity11;
    }

    public void setIngredientQuantity11(String ingredientQuantity11) {
        this.ingredientQuantity11 = ingredientQuantity11;
    }

    public String getIngredientName12() {
        return ingredientName12;
    }

    public void setIngredientName12(String ingredientName12) {
        this.ingredientName12 = ingredientName12;
    }

    public String getIngredientQuantity12() {
        return ingredientQuantity12;
    }

    public void setIngredientQuantity12(String ingredientQuantity12) {
        this.ingredientQuantity12 = ingredientQuantity12;
    }

    public String getIngredientName13() {
        return ingredientName13;
    }

    public void setIngredientName13(String ingredientName13) {
        this.ingredientName13 = ingredientName13;
    }

    public String getIngredientQuantity13() {
        return ingredientQuantity13;
    }

    public void setIngredientQuantity13(String ingredientQuantity13) {
        this.ingredientQuantity13 = ingredientQuantity13;
    }

    public String getIngredientName14() {
        return ingredientName14;
    }

    public void setIngredientName14(String ingredientName14) {
        this.ingredientName14 = ingredientName14;
    }

    public String getIngredientQuantity14() {
        return ingredientQuantity14;
    }

    public void setIngredientQuantity14(String ingredientQuantity14) {
        this.ingredientQuantity14 = ingredientQuantity14;
    }

    public String getIngredientName15() {
        return ingredientName15;
    }

    public void setIngredientName15(String ingredientName15) {
        this.ingredientName15 = ingredientName15;
    }

    public String getIngredientQuantity15() {
        return ingredientQuantity15;
    }

    public void setIngredientQuantity15(String ingredientQuantity15) {
        this.ingredientQuantity15 = ingredientQuantity15;
    }

    @Override
    public String toString() {
        return "CocktailApiEntity [cocktailapiId=" + cocktailapiId + ", idDrink=" + idDrink + ", nameDrink=" + nameDrink
                + ", category=" + category + ", typeDrink=" + typeDrink + ", glass=" + glass + ", instructions="
                + instructions + ", imagenURL=" + imagenURL + ", ingredientName1=" + ingredientName1
                + ", ingredientQuantity1=" + ingredientQuantity1 + ", ingredientName2=" + ingredientName2
                + ", ingredientQuantity2=" + ingredientQuantity2 + ", ingredientName3=" + ingredientName3
                + ", ingredientQuantity3=" + ingredientQuantity3 + ", ingredientName4=" + ingredientName4
                + ", ingredientQuantity4=" + ingredientQuantity4 + ", ingredientName5=" + ingredientName5
                + ", ingredientQuantity5=" + ingredientQuantity5 + ", ingredientName6=" + ingredientName6
                + ", ingredientQuantity6=" + ingredientQuantity6 + ", ingredientName7=" + ingredientName7
                + ", ingredientQuantity7=" + ingredientQuantity7 + ", ingredientName8=" + ingredientName8
                + ", ingredientQuantity8=" + ingredientQuantity8 + ", ingredientName9=" + ingredientName9
                + ", ingredientQuantity9=" + ingredientQuantity9 + ", ingredientName10=" + ingredientName10
                + ", ingredientQuantity10=" + ingredientQuantity10 + ", ingredientName11=" + ingredientName11
                + ", ingredientQuantity11=" + ingredientQuantity11 + ", ingredientName12=" + ingredientName12
                + ", ingredientQuantity12=" + ingredientQuantity12 + ", ingredientName13=" + ingredientName13
                + ", ingredientQuantity13=" + ingredientQuantity13 + ", ingredientName14=" + ingredientName14
                + ", ingredientQuantity14=" + ingredientQuantity14 + ", ingredientName15=" + ingredientName15
                + ", ingredientQuantity15=" + ingredientQuantity15 + "]";
    }
    
}
