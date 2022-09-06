package ECommerceSystem.core;

import ECommerceSystem.business.abstracts.VerificationService;

import java.util.ArrayList;
import java.util.List;

public class GoogleLoginAdaptor implements VerificationService {

    List<String> verificatedEmails = new ArrayList<String>();
    @Override
    public void sendToVerifyEmail(String email) {
        System.out.println(email + " A confirmation email has been sent to the user.");
    }

    @Override
    public void verifyEmail(String email) {
        verificatedEmails.add(email);
        System.out.println(email + "successfully verified");
    }

    @Override
    public boolean checkVerifyAccount(String email) {
        if (verificatedEmails.contains(email)) {
            return true;
        }
        return false;
    }
}
