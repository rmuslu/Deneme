package ECommerceSystem.business.abstracts;

public interface VerificationService {
    void sendToVerifyEmail(String email);
    void verifyEmail(String email);
    boolean checkVerifyAccount(String email);
}
