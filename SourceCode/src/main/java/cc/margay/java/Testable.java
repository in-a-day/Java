package cc.margay.java;

import java.util.List;

public class Testable {
    public void execute() {
        System.out.println("Executing");
    }
    @Test(id = 47, description = "11")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }
    @Test(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
    @Test(id = 49)
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }

    public static void main(String[] args) {
        Testable t = new Testable();
    }
}
