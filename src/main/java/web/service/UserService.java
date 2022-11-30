package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> listUsers();
    public User getUser(int id);
    public void update(int id, User user);
    public void delete(int id);
    public void add(User user);
}
