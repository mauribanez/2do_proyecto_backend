package ucb.edu.bo.do_protecto_backend.BL;

import org.springframework.stereotype.Service;
import ucb.edu.bo.do_protecto_backend.DAO.TypeCocktailDAO;
import ucb.edu.bo.do_protecto_backend.ENTITY.TypeCocktailEntity;

import java.util.List;

@Service
public class TypeCocktailBL {

    private final TypeCocktailDAO typeCocktailDAO;

    public TypeCocktailBL(TypeCocktailDAO typeCocktailDAO) {
        this.typeCocktailDAO = typeCocktailDAO;
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
}
