package ECommerceSystem.business.abstracts;

import ECommerceSystem.entities.concretes.User;

public interface UserCheckService {
    boolean checkPassword(User user);
    boolean checkEmail(User user);
    boolean checkName(User user);
    boolean checkSurname(User user);
    boolean uniqueEmail(User user);
     boolean isValid(User user);
}
