package delegates;

public interface AccountDelegate {
//    void updateAccount(String name, String address, String email, String phone);
void updateCustomer(int id, String[] updateInfo);
    void signupAccount();


}
