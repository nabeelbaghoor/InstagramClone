package BL;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import Models.IDB_Operations;
import Models.User;

public class UserFunctions implements Layers{

    public UserFunctions(){ }

    public boolean removeFollowing(String userid, String myid, ArrayList<String> followers){
        if (followers.contains(userid)){
            //DB Code
            followers.remove(userid);
            return true;
        }
        return false;
    }
    public boolean followerUser(String userid, String myid, ArrayList<String> followers) {
        if (!followers.contains(userid)){
            followers.add(userid);
            //DB Code
            return true;
        }
        return false;
    }

    public boolean unfollowerUser(String userid, String myid, ArrayList<String> followers) {
        if (followers.contains(userid)){
            followers.remove(userid);
            //DB Code
            return true;
        }
        return false;
    }
    public boolean blockFollower(String userid, String myid, ArrayList<String> blockedList) {
        if (!blockedList.contains(userid)){
            blockedList.add(userid);
            //DB COde
            return true;
        }
        return false;

    }

    public boolean unBlockFollower(String userid, String myid, ArrayList<String> blockedList) {
        if (blockedList.contains(userid)){
            blockedList.remove(userid);
            //DB COde
            return true;
        }
        return false;
    }


    public User getUser(String user1) {
        User temp = null;
        try{
            temp = (User) DBLayer.getObject(user1, IDB_Operations.ModelType.Users);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
