package BL.src.instaclone;

import java.util.Vector;
import Models.User;

public class UserFunctions {

    public UserFunctions(){ }

    public boolean removeFollowing(String userid, String myid, Vector<String> followers){
        if (followers.contains(userid)){
            //DB Code
            followers.remove(userid);
            return true;
        }
        return false;
    }
    public boolean followerUser(String userid, String myid, Vector<String> followers) {
        if (!followers.contains(userid)){
            followers.add(userid);
            //DB Code
            return true;
        }
        return false;
    }

    public boolean unfollowerUser(String userid, String myid, Vector<String> followers) {
        if (followers.contains(userid)){
            followers.remove(userid);
            //DB Code
            return true;
        }
        return false;
    }
    public boolean blockFollower(String userid, String myid, Vector<String> blockedList) {
        if (!blockedList.contains(userid)){
            blockedList.add(userid);
            //DB COde
            return true;
        }
        return false;

    }

    public boolean unBlockFollower(String userid, String myid, Vector<String> blockedList) {
        if (blockedList.contains(userid)){
            blockedList.remove(userid);
            //DB COde
            return true;
        }
        return false;
    }


    public User getUser(String user1) {
        //DB Code
        User temp = new User();
        return temp;
    }
}
