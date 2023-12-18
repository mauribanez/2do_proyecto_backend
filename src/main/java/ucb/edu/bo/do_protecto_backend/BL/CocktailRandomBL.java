package ucb.edu.bo.do_protecto_backend.BL;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ucb.edu.bo.do_protecto_backend.DAO.CocktailRandomDAO;
import ucb.edu.bo.do_protecto_backend.DTO.CocktailRandomDTO;
import ucb.edu.bo.do_protecto_backend.ENTITY.CocktailRandomEntity;

@Service
public class CocktailRandomBL {

    private final CocktailRandomDAO cocktailRandomDAO;
    private RestTemplate restTemplate;


    public CocktailRandomBL(CocktailRandomDAO cocktailRandomDAO, RestTemplate restTemplate) {
        this.cocktailRandomDAO = cocktailRandomDAO;
        this.restTemplate = restTemplate;
    }

    public void fetchAndStoreCocktailsFromAPI() {
        CocktailRandomDTO response = restTemplate.getForObject("https://www.thecocktaildb.com/api/json/v1/1/random.php", CocktailRandomDTO.class);
    
        if (response != null && response.getDrinks() != null) {
            for (CocktailRandomDTO.CocktailData data : response.getDrinks()) {
                String drinkId = data.getIdDrink();
                // verificar que no exista el cóctel en la base de datos
                List<CocktailRandomEntity> existingCocktails = cocktailRandomDAO.findByIdDrink(drinkId);
                if (existingCocktails == null || existingCocktails.isEmpty()) {
                    CocktailRandomEntity entity = mapDataToEntity(data);
                    cocktailRandomDAO.save(entity);
                }
            }
        }
    }

    private CocktailRandomEntity mapDataToEntity(CocktailRandomDTO.CocktailData data) {
        // Implementa el mapeo desde el DTO (Cocktail.CocktailData) a la entidad (CocktailApiEntity)
        CocktailRandomEntity entity = new CocktailRandomEntity();
        entity.setIdDrink(data.getIdDrink());
        entity.setNameDrink(data.getStrDrink());
        entity.setCategory(data.getStrCategory());
        entity.setTypeDrink(data.getStrAlcoholic());
        entity.setGlass(data.getStrGlass());
        entity.setInstructions(data.getStrInstructions());
        entity.setImagenURL(data.getStrDrinkThumb());
        entity.setIngredientName1(data.getStrIngredient1() != null ? data.getStrIngredient1() : "");
        entity.setIngredientQuantity1(data.getStrMeasure1() != null ? data.getStrMeasure1() : "");
        
        entity.setIngredientName2(data.getStrIngredient2() != null ? data.getStrIngredient2() : "");
        entity.setIngredientQuantity2(data.getStrMeasure2() != null ? data.getStrMeasure2() : "");
        
        entity.setIngredientName3(data.getStrIngredient3() != null ? data.getStrIngredient3() : "");
        entity.setIngredientQuantity3(data.getStrMeasure3() != null ? data.getStrMeasure3() : "");
        
        entity.setIngredientName4(data.getStrIngredient4() != null ? data.getStrIngredient4() : "");
        entity.setIngredientQuantity4(data.getStrMeasure4() != null ? data.getStrMeasure4() : "");
        
        entity.setIngredientName5(data.getStrIngredient5() != null ? data.getStrIngredient5() : "");
        entity.setIngredientQuantity5(data.getStrMeasure5() != null ? data.getStrMeasure5() : "");
        
        entity.setIngredientName6(data.getStrIngredient6() != null ? data.getStrIngredient6() : "");
        entity.setIngredientQuantity6(data.getStrMeasure6() != null ? data.getStrMeasure6() : "");
        
        entity.setIngredientName7(data.getStrIngredient7() != null ? data.getStrIngredient7() : "");
        entity.setIngredientQuantity7(data.getStrMeasure7() != null ? data.getStrMeasure7() : "");
        
        entity.setIngredientName8(data.getStrIngredient8() != null ? data.getStrIngredient8() : "");
        entity.setIngredientQuantity8(data.getStrMeasure8() != null ? data.getStrMeasure8() : "");
        
        entity.setIngredientName9(data.getStrIngredient9() != null ? data.getStrIngredient9() : "");
        entity.setIngredientQuantity9(data.getStrMeasure9() != null ? data.getStrMeasure9() : "");
        
        entity.setIngredientName10(data.getStrIngredient10() != null ? data.getStrIngredient10() : "");
        entity.setIngredientQuantity10(data.getStrMeasure10() != null ? data.getStrMeasure10() : "");
        
        entity.setIngredientName11(data.getStrIngredient11() != null ? data.getStrIngredient11() : "");
        entity.setIngredientQuantity11(data.getStrMeasure11() != null ? data.getStrMeasure11() : "");
        
        entity.setIngredientName12(data.getStrIngredient12() != null ? data.getStrIngredient12() : "");
        entity.setIngredientQuantity12(data.getStrMeasure12() != null ? data.getStrMeasure12() : "");
        
        entity.setIngredientName13(data.getStrIngredient13() != null ? data.getStrIngredient13() : "");
        entity.setIngredientQuantity13(data.getStrMeasure13() != null ? data.getStrMeasure13() : "");
        
        entity.setIngredientName14(data.getStrIngredient14() != null ? data.getStrIngredient14() : "");
        entity.setIngredientQuantity14(data.getStrMeasure14() != null ? data.getStrMeasure14() : "");
        
        entity.setIngredientName15(data.getStrIngredient15() != null ? data.getStrIngredient15() : "");
        entity.setIngredientQuantity15(data.getStrMeasure15() != null ? data.getStrMeasure15() : "");

        return entity;
    }

    public List<CocktailRandomEntity> getAllCocktails() {
        return cocktailRandomDAO.findAll();
    }

    public CocktailRandomEntity getCocktailById(Long cocktailapiId) {
        return cocktailRandomDAO.findById(cocktailapiId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cóctel con el ID proporcionado"));
    }


    
}
