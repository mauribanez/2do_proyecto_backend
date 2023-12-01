package ucb.edu.bo.do_protecto_backend.BL;

import org.springframework.stereotype.Service;
import ucb.edu.bo.do_protecto_backend.DAO.UserDAO;
import ucb.edu.bo.do_protecto_backend.ENTITY.UserEntity;

import java.util.List;

@Service
public class UserBL {

    private final UserDAO userDAO;

    public UserBL(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserEntity createUser(String nombre, String correoElectronico, String contrasena) {
        if (nombre == null || nombre.isEmpty()) {
            throw new RuntimeException("El nombre del usuario no puede estar vacío");
        }
        if (correoElectronico == null || correoElectronico.isEmpty()) {
            throw new RuntimeException("El correo electrónico del usuario no puede estar vacío");
        }
        if (contrasena == null || contrasena.isEmpty()) {
            throw new RuntimeException("La contraseña del usuario no puede estar vacía");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setNombre(nombre);
        userEntity.setCorreoElectronico(correoElectronico);
        userEntity.setContrasena(contrasena);

        return userDAO.save(userEntity);
    }

    public List<UserEntity> getAllUsers() {
        return userDAO.findAll();
    }

    public UserEntity getUserById(Long userId) {
        return userDAO.findById(userId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún usuario con el ID proporcionado"));
    }

    public UserEntity updateUser(Long userId, String nombre, String correoElectronico, String contrasena) {
        UserEntity userEntity = userDAO.findById(userId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún usuario con el ID proporcionado"));

        if (nombre == null || nombre.isEmpty()) {
            throw new RuntimeException("El nombre del usuario no puede estar vacío");
        }
        if (correoElectronico == null || correoElectronico.isEmpty()) {
            throw new RuntimeException("El correo electrónico del usuario no puede estar vacío");
        }
        if (contrasena == null || contrasena.isEmpty()) {
            throw new RuntimeException("La contraseña del usuario no puede estar vacía");
        }

        userEntity.setNombre(nombre);
        userEntity.setCorreoElectronico(correoElectronico);
        userEntity.setContrasena(contrasena);

        return userDAO.save(userEntity);
    }

    public void deleteUser(Long userId) {
        UserEntity userEntity = userDAO.findById(userId)
                .orElseThrow(() -> new RuntimeException("No se encontró ningún usuario con el ID proporcionado"));
        userDAO.delete(userEntity);
    }
}
