package day07.practice;

public class PasswordManager {

    private String password;

    PasswordManager(String password) {
        this.password = password;
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if(oldPassword.equals(this.password)) {
            this.password = newPassword;
            return true;
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        }
    }
}
