package BL.src.instaclone;

import DB_Firebase.company.IUser;

public class InstaClone {
    public static void main(String[] args) {

        Operations temp = new UserOperations();
        System.out.print(temp.getBlocked());
    }
    
}
