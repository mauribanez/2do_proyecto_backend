package ucb.edu.bo.do_protecto_backend.BL;

import org.springframework.stereotype.Service;
import ucb.edu.bo.do_protecto_backend.DAO.TypeCocktailDAO;
import ucb.edu.bo.do_protecto_backend.DAO.TypeCocktailResponse;
import ucb.edu.bo.do_protecto_backend.DTO.CategoryResponse;
import ucb.edu.bo.do_protecto_backend.ENTITY.CategoryEntity;
import ucb.edu.bo.do_protecto_backend.ENTITY.TypeCocktailEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TypeCocktailBL {

    private final TypeCocktailDAO typeCocktailDAO;
    private RestTemplate restTemplate;

    public TypeCocktailBL(TypeCocktailDAO typeCocktailDAO, RestTemplate restTemplate) {
        this.typeCocktailDAO = typeCocktailDAO;
        this.restTemplate = restTemplate;
    }

    public TypeCocktailEntity createTypeCocktail(String nameType) {
        if (nameType == null || nameType.isEmpty()) {
            throw new RuntimeException("El nombre del tipo de cóctel no puede estar vacío");
        }

        TypeCocktailEntity typeCocktailEntity = new TypeCocktailEntity();
        typeCocktailEntity.setNameType(nameType);

        return typeCocktailDAO.save(typeCocktailEntity);
    }

    public List<TypeCocktailEntity> getAllTypeCocktails() {
        return typeCocktailDAO.findAll();
    }

    public TypeCocktailEntity getTypeCocktailById(Long typeCocktailId) {
        return typeCocktailDAO.findById(typeCocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún tipo de cóctel con el ID proporcionado"));
    }

    public TypeCocktailEntity updateTypeCocktail(Long typeCocktailId, String nameType) {
        TypeCocktailEntity typeCocktailEntity = typeCocktailDAO.findById(typeCocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún tipo de cóctel con el ID proporcionado"));

        if (nameType == null || nameType.isEmpty()) {
            throw new RuntimeException("El nombre del tipo de cóctel no puede estar vacío");
        }

        typeCocktailEntity.setNameType(nameType);

        return typeCocktailDAO.save(typeCocktailEntity);
    }

    public void deleteTypeCocktail(Long typeCocktailId) {
        TypeCocktailEntity typeCocktailEntity = typeCocktailDAO.findById(typeCocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún tipo de cóctel con el ID proporcionado"));
        typeCocktailDAO.delete(typeCocktailEntity);
    }

    public void fetchAndStoreTypeCocktails() {
            TypeCocktailResponse response = restTemplate.getForObject("https://www.thecocktaildb.com/api/json/v1/1/list.php?a=list", TypeCocktailResponse.class);

            if (response != null && response.getDrinks() != null) {
                for (TypeCocktailResponse.TypeCocktailData data : response.getDrinks()) {
                    TypeCocktailEntity typeCocktail = new TypeCocktailEntity();
                    typeCocktail.setNameType(data.getStrAlcoholic());
                    typeCocktailDAO.save(typeCocktail);
                }
            }
        } 
}
