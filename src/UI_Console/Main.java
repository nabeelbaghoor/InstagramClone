package UI_Console;

import Models.Factory;
import Models.Operations;

public class Main {
    public static void main(String[] args) {
        /*User user = new User();
        user.username = "Ali";
        System.out.println(user.username);*/
        Factory func = new Factory();
        Operations BLOp = func.getOperations();
        System.out.println(BLOp.getMyProfile().username);
    }
}