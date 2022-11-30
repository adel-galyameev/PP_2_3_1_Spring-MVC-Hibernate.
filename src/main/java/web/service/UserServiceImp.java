package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Transactional
    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Transactional
    @Override
    public void update(int id, User user) {
        userDAO.update(id, user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }
}
