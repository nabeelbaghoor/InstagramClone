
package DB_Firebase.company;
import BL.src.instaclone.User;

import java.util.concurrent.ExecutionException;

public interface IUser extends IDBOperations {
    public User getUser(String userId) throws ExecutionException, InterruptedException; //returns User object with key == userid
    public String addUser(User user) throws ExecutionException, InterruptedException;   //returns userid of new created user
    public boolean removeUser(String userId);  //removes user , and returns boolean
    public boolean updateUser(String userId,User user); //overwrites the user with key == usserid
}