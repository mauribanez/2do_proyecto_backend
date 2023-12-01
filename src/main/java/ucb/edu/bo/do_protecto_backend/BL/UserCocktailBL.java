package ucb.edu.bo.do_protecto_backend.BL;

import org.springframework.stereotype.Service;
import ucb.edu.bo.do_protecto_backend.DAO.CocktailDAO;
import ucb.edu.bo.do_protecto_backend.DAO.UserCocktailDAO;
import ucb.edu.bo.do_protecto_backend.DAO.UserDAO;
import ucb.edu.bo.do_protecto_backend.ENTITY.CocktailEntity;
import ucb.edu.bo.do_protecto_backend.ENTITY.UserCocktailEntity;
import ucb.edu.bo.do_protecto_backend.ENTITY.UserEntity;

import java.util.List;
import java.util.Optional;

@Service
public class UserCocktailBL {
    private final UserCocktailDAO userCocktailDAO;
    private final UserDAO userDAO;
    private final CocktailDAO cocktailDAO;

    public UserCocktailBL(UserCocktailDAO userCocktailDAO, UserDAO userDAO, CocktailDAO cocktailDAO) {
        this.userCocktailDAO = userCocktailDAO;
        this.userDAO = userDAO;
        this.cocktailDAO = cocktailDAO;
    }

    public UserCocktailEntity createUserCocktail(Long userId, Long cocktailId) {
        UserEntity user = userDAO.findById(userId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún usuario con el ID proporcionado"));
        CocktailEntity cocktail = cocktailDAO.findById(cocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún cóctel con el ID proporcionado"));

        UserCocktailEntity userCocktail = new UserCocktailEntity();
        userCocktail.setUser(user);
        userCocktail.setCocktail(cocktail);

        return userCocktailDAO.save(userCocktail);
    }

    public List<UserCocktailEntity> getAllUserCocktails() {
        return userCocktailDAO.findAll();
    }

    public UserCocktailEntity getUserCocktailById(Long userCocktailId) {
        Optional<UserCocktailEntity> userCocktail = userCocktailDAO.findById(userCocktailId);
        return userCocktail.orElseThrow(() -> new RuntimeException("No se encontró ningún UserCocktail con el ID proporcionado"));
    }

    public void deleteUserCocktail(Long userCocktailId) {
        UserCocktailEntity userCocktail = userCocktailDAO.findById(userCocktailId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún UserCocktail con el ID proporcionado"));
        userCocktailDAO.delete(userCocktail);
    }
}
