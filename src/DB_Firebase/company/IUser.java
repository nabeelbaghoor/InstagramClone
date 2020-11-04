
package DB_Firebase.company;
import BL.src.instaclone.User;

import java.util.concurrent.ExecutionException;

public interface IUser {
    public User getUser(String userid) throws ExecutionException, InterruptedException; //returns User object with key == userid
    public String addUser(User user) throws ExecutionException, InterruptedException;   //returns userid of new created user
    public boolean removeUser(String userid);  //removes user , and returns boolean
    public boolean updateUser(String userid,User user); //overwrites the user with key == usserid
}