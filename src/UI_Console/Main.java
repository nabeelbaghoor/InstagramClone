package UI_Console;

import Models.Factory;
import Models.Operations;
import Models.User;

public class Main {
    public static void main(String[] args) throws Exception {
        Factory func = new Factory();
        Operations operations = func.getOperations();
        User user = operations.getMyProfile();
        user.username = "changed";
        operations.editUserData(user);
    }
}