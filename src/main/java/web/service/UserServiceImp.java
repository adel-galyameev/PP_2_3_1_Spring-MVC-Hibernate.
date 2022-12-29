package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{


    private UserDAO userDAO;
    @Autowired
    public UserServiceImp (UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    
    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }


}
