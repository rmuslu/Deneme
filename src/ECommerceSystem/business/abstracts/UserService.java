package ECommerceSystem.business.abstracts;

import ECommerceSystem.entities.concretes.User;

public interface UserService {

    void signUp(User user);
    void signIn(User user);
}
