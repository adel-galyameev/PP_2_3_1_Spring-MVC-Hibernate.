package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> listUsers();
    public void save (User user);
    public User getUser(int id);
    public void update (User user);
    public void delete(int id);


}
