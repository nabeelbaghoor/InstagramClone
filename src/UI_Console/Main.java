package UI_Console;

import Models.User;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.username = "Ali";
        System.out.println(user.username);
    }
}