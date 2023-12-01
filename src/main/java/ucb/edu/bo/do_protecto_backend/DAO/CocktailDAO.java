package ucb.edu.bo.do_protecto_backend.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.edu.bo.do_protecto_backend.ENTITY.CocktailEntity;


@Repository
public interface CocktailDAO extends JpaRepository<CocktailEntity, Long> {
    // Puedes agregar métodos personalizados si es necesario
}