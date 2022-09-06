package ECommerceSystem.business.concretes;

import ECommerceSystem.business.abstracts.UserCheckService;
import ECommerceSystem.business.abstracts.UserService;
import ECommerceSystem.business.abstracts.VerificationService;
import ECommerceSystem.dataAccess.abstracts.UserDao;
import ECommerceSystem.entities.concretes.User;

public class UserManager implements UserService {

    private UserCheckService userCheckService;
    private VerificationService verificationService;
    private UserDao userDao;

    public UserManager(UserCheckService userCheckService, VerificationService verificationService, UserDao userDao) {
        this.userCheckService = userCheckService;
        this.verificationService = verificationService;
        this.userDao = userDao;
    }

    @Override
    public void signUp(User user) {
        if (userCheckService.isValid(user) == true) {
            System.out.print(user.getName() + " user added successfully.\n");
            verificationService.sendToVerifyEmail(user.getEmail());
            userDao.add(user);
        }
    }


    @Override
    public void signIn(User user) {
        verificationService.verifyEmail(user.getEmail());
            if (verificationService.checkVerifyAccount(user.getEmail()) == true){

                System.out.println("User login successfully done.");
            } else if (verificationService.checkVerifyAccount(user.getEmail()) == false) {
                System.out.println("User information is correct. But the login is not possible because the e-mail address is not verified.");
            } else {
                System.out.println("User information is incorrect, please check.");
            }
        }
    }

