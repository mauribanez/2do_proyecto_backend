package ucb.edu.bo.do_protecto_backend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.edu.bo.do_protecto_backend.ENTITY.UserEntity;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Long> {
    
}
