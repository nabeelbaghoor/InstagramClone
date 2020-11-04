package DB_Firebase.company;

import BL.src.instaclone.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class UserOperations implements IUser {
    private static int userKey;
    public User getUser(String userid) throws ExecutionException, InterruptedException //returns User object with key == userid
    {
        return new User();
    }
    public String addUser(User user) throws ExecutionException, InterruptedException   //returns userid of new created user
    {
        //we actually don't need addUser,we will manully add few user by default
        //so, for now,we will give userID,from BL,and use it as document key(mb)
        Firestore db = FirestoreClient.getFirestore();
        Map<String, Object> _user = new HashMap<>();
        _user.put(user.getUserID(),user);
        ApiFuture<WriteResult> future  = db.collection("Users").document(String.valueOf(_user.keySet())).set(_user);
        System.out.println("Successfully updated at: " + future.get().getUpdateTime());
        return  user.getUserID();
    }
    public boolean removeUser(String userid)  //removes user , and returns boolean
    {
        return true;
    }
    public boolean updateUser(String userid,User user) //overwrites the user with key == usserid
    {
        return true;
    }
}
