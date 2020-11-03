package instaclone;

import java.util.Vector;
import java.rmi.server.Operation;
import javax.json.JsonObjectBuilder;

public class InstaClone {
    public static void main(String[] args) {
        
        //Profile temp2 = new Profile();
        //temp2.getFollowers();
        Operations temp = new UserOperations();
        System.out.print(temp.getBlocked());

    }
    
}
