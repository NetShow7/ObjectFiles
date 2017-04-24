package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import utilities.Read;

public class User extends Person implements Serializable {

    private String username;
    private String password;
    private String email;

    public User() {
        super();
        setUsername();
        setPassword();
        setEmail();

    }

    public User(String s) {
        super(s);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String NewUsername) {
        username = NewUsername;
    }

    public void setUsername() {
        String s = "";
        while (s.isEmpty()) {
            System.out.println("Enter the username: ");
            s = Read.String();
            if (s.contains(" ")) {
                System.out.println("Your username can't contain spaces");
                s = "";
            }
        }
        username = s;
    }

    public void setPassword(String NewPassword) {
        password = NewPassword;
    }

    public void setPassword() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the password: ");
        password = Read.String();
    }

    public void setEmail(String NewEmail) {
        email = NewEmail;
    }

    public void setEmail() {
        boolean ok = false;
        System.out.println("Please, enter your e-mail: ");
        do {

            String s = Read.String();
            String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
            java.util.regex.Matcher m = p.matcher(s);
            if (m.matches()) {
                email = s;
                ok = true;
            } else {
                System.out.println("Please, enter a valid e-mail:");
            }

        } while (!ok);
    }
}
