package BL;

import Models.Operations;
import Models.User;

public class Main {
    public static void main(String[] args) {
        Operations obj = new UserOperations();
        User curr = obj.getMyProfile();
        System.out.println(curr);
    }
}
