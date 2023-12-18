package ucb.edu.bo.do_protecto_backend.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.edu.bo.do_protecto_backend.ENTITY.CocktailRandomEntity;

public interface CocktailRandomDAO extends JpaRepository<CocktailRandomEntity, Long> {
    public List<CocktailRandomEntity> findByIdDrink(String drinkId);
    
}
