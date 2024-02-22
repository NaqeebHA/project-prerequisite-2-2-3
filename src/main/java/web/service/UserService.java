package web.service;

import web.model.User;
import java.util.List;

public interface UserService {

    void addUser(String firstName, String lastName, String email);

    List<User> getUserList();

    User getUserById(Long id);

    void updateUserById(Long id, String firstName, String lastName, String email);

    void deleteUserById(Long id);
}
