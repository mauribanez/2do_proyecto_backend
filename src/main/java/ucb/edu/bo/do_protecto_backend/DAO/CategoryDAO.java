package ucb.edu.bo.do_protecto_backend.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.edu.bo.do_protecto_backend.ENTITY.CategoryEntity;

@Repository
public interface CategoryDAO extends JpaRepository<CategoryEntity, Long> {

}