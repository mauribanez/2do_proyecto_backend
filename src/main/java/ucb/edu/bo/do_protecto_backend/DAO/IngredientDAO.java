package ucb.edu.bo.do_protecto_backend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.edu.bo.do_protecto_backend.ENTITY.IngredientEntity;


@Repository
public interface IngredientDAO extends JpaRepository<IngredientEntity, Long> {
    // Puedes agregar métodos personalizados si es necesario
}