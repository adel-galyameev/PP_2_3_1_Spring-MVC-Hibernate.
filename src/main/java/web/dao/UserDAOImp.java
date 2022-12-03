package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {

        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.createQuery("select u from User u where u.id = :id", User.class).
                setParameter("id", id).getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(int id, User user) {
        String UPDATE = "UPDATE User u SET u.name = :name, u.surname = :surname, " +
                    "u.email = :email WHERE u.id = :id";
        entityManager.createQuery(UPDATE).setParameter("id", id).
                setParameter("name", user.getName()).setParameter("surname", user.getSurname()).
                setParameter("email", user.getEmail()).executeUpdate();
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }
}
