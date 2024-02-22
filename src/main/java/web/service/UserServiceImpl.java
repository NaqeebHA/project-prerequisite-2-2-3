package web.service;

import web.model.User;
import web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(String firstName, String lastName, String email) {
        userDao.addUser(firstName, lastName, email);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateUserById(Long id, String firstName, String lastName, String email) {
        userDao.updateUserById(id, firstName, lastName, email);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }
}
