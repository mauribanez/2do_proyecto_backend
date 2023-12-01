package ucb.edu.bo.do_protecto_backend.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.edu.bo.do_protecto_backend.ENTITY.ChatHistoryEntity;


@Repository
public interface ChatHistoryDAO extends JpaRepository<ChatHistoryEntity, Long> {
    // Puedes agregar métodos personalizados si es necesario
}