package ECommerceSystem.dataAccess.abstracts;

import ECommerceSystem.entities.concretes.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    void update(User user);
    void delete(User user);
    boolean getEmail(String email);
    boolean getPassword(String password);
    List<User> getAll();

}
