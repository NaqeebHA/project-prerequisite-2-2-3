package web.dao;

import web.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
//        User user = new User(firstName, lastName, email);
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUserList() {
        entityManager.getTransaction().begin();
        List<User> userList = entityManager.createQuery("FROM User").getResultList();
        entityManager.getTransaction().commit();
        return userList;
    }

    @Override
    public User getUserById(Long id) {
        entityManager.getTransaction().begin();
        User userById = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();
        return userById;
    }

    @Override
    public void updateUserById(Long id, String newFirstName, String newLastName, String newEmail) {
        String updateQuery = "UPDATE User SET firstName = :newFirstName, lastName = :newLastName, email = :newEmail WHERE id = :id";
        entityManager.getTransaction().begin();
        entityManager.createQuery(updateQuery)
                .setParameter("id", id)
                .setParameter("newFirstName", newFirstName)
                .setParameter("newLastName", newLastName)
                .setParameter("newEmail", newEmail)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteUserById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM User WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }
}
