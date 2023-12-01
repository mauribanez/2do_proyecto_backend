package ucb.edu.bo.do_protecto_backend.BL;

import org.springframework.stereotype.Service;
import ucb.edu.bo.do_protecto_backend.DAO.CocktailDAO;
import ucb.edu.bo.do_protecto_backend.ENTITY.CategoryEntity;
import ucb.edu.bo.do_protecto_backend.ENTITY.CocktailEntity;
import ucb.edu.bo.do_protecto_backend.ENTITY.TypeCocktailEntity;

import java.util.List;

@Service
public class CocktailBL {

    private final CocktailDAO cocktailDAO;

    public CocktailBL(CocktailDAO cocktailDAO) {
        this.cocktailDAO = cocktailDAO;
    }

    public CocktailEntity createCocktail(String nameCocktail, String preparation, TypeCocktailEntity typeCocktail, CategoryEntity category) {
        if (nameCocktail == null || nameCocktail.isEmpty()) {
            throw new RuntimeException("El nombre del cóctel no puede estar vacío");
        }
        if (preparation == null || preparation.isEmpty()) {
            throw new RuntimeException("La preparación del cóctel no puede estar vacía");
        }

        CocktailEntity cocktailEntity = new CocktailEntity();
        cocktailEntity.setNameCocktail(nameCocktail);
        cocktailEntity.setPreparation(preparation);
        cocktailEntity.setTypeCocktail(typeCocktail);
        cocktailEntity.setCategory(category);

        return cocktailDAO.save(cocktailEntity);
    }

    public List<CocktailEntity> getAllCocktails() {
        return cocktailDAO.findAll();
    }

    public CocktailEntity getCocktailById(Long cocktailId) {
        return cocktailDAO.findById(cocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cóctel con el ID proporcionado"));
    }

    public CocktailEntity updateCocktail(Long cocktailId, String nameCocktail, String preparation, TypeCocktailEntity typeCocktail, CategoryEntity category) {
        CocktailEntity cocktailEntity = cocktailDAO.findById(cocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cóctel con el ID proporcionado"));

        if (nameCocktail == null || nameCocktail.isEmpty()) {
            throw new RuntimeException("El nombre del cóctel no puede estar vacío");
        }
        if (preparation == null || preparation.isEmpty()) {
            throw new RuntimeException("La preparación del cóctel no puede estar vacía");
        }

        cocktailEntity.setNameCocktail(nameCocktail);
        cocktailEntity.setPreparation(preparation);
        cocktailEntity.setTypeCocktail(typeCocktail);
        cocktailEntity.setCategory(category);

        return cocktailDAO.save(cocktailEntity);
    }

    public void deleteCocktail(Long cocktailId) {
        CocktailEntity cocktailEntity = cocktailDAO.findById(cocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cóctel con el ID proporcionado"));
        cocktailDAO.delete(cocktailEntity);
    }
}
