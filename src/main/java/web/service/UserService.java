package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    public void save (User user);
    public User getUser(int id);
    public void update (User user);
    public void delete(int id);

}
