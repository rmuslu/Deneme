import ECommerceSystem.business.concretes.UserCheckManager;
import ECommerceSystem.business.concretes.UserManager;
import ECommerceSystem.business.concretes.VerificationManager;
import ECommerceSystem.dataAccess.concretes.HibernateUserDao;
import ECommerceSystem.entities.concretes.User;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setId(1);
        user1.setName("Rumeysa");
        user1.setSurname("Muslu");
        user1.setEmail("rumeysamuslu11@gmail.com");
        user1.setPassword("1234567");

        User user2 = new User();
        user2.setId(2);
        user2.setName("Rumeysa");
        user2.setSurname("Muslu");
        user2.setEmail("rumeysamuslu11@gmail.com");
        user2.setPassword("1234567");

        UserManager customerManager = new UserManager(new UserCheckManager(),new VerificationManager(),new HibernateUserDao());

        customerManager.signUp(user1);
        customerManager.signUp(user2);
    }
}
