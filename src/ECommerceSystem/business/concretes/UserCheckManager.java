package ECommerceSystem.business.concretes;

import ECommerceSystem.business.abstracts.UserCheckService;
import ECommerceSystem.entities.concretes.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserCheckManager implements UserCheckService {
    List<String> listOfEmail = new ArrayList<String>();

    @Override
    public boolean checkPassword(User user) {
        if (user.getPassword().isEmpty()) {
            System.out.println("Password is not null");
            return false;
        } else {
            if (user.getPassword().length() < 6) {
                System.out.println("Password is not less then 6 characters");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkEmail(User user) {
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        if (user.getEmail().isEmpty()) {
            System.out.println("Email field is not null");
            return false;
        } else {
            if (pattern.matcher(user.getEmail()).find() == false) {
                System.out.println("The email address entered is not in accordance with the format. Example: example@example.com");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkName(User user) {
        if (user.getName().isEmpty()) {
            System.out.println("Name is not null");
            return false;
        } else {
            if (user.getPassword().length() < 3) {
                System.out.println("Name is not less then 2 characters");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkSurname(User user) {
        if (user.getSurname().isEmpty()) {
            System.out.println("Surname is not null");
            return false;
        } else {
            if (user.getPassword().length() < 3) {
                System.out.println("Surname is not less then 2 characters");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean uniqueEmail(User user) {
        boolean result=true;
        if (listOfEmail.contains(user.getEmail())) {
            System.out.println("The email was used before");
            result=false;
        }else{
            result=true;
            listOfEmail.add(user.getEmail());
        }
        return result;
    }

    @Override
    public boolean isValid(User user) {
        if (checkName(user) && checkSurname(user) && checkEmail(user) && checkPassword(user)
                && uniqueEmail(user) == true) {
            return true;
        }
        return false;
    }
}