package BL;

import Models.IModel;
import Models.User;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static Models.IDB_Operations.ModelType.Users;

public class UserFunctions {
    private final Layers DB = new Layers();

    public UserFunctions() {
    }

    public boolean removeFollowing(String userid, String myid, ArrayList<String> followers) {
        if (followers.contains(userid)) {
            //DB Code
            followers.remove(userid);
            return true;
        }
        return false;
    }

    public boolean followerUser(String userid, String myid, ArrayList<String> followers) {
        if (!followers.contains(userid)) {
            followers.add(userid);
            //DB Code
            return true;
        }
        return false;
    }

    public boolean unfollowerUser(String userid, String myid, ArrayList<String> followers) {
        if (followers.contains(userid)) {
            followers.remove(userid);
            //DB Code
            return true;
        }
        return false;
    }

    public boolean blockFollower(String userid, String myid, ArrayList<String> blockedList) {
        if (!blockedList.contains(userid)) {
            blockedList.add(userid);
            //DB COde
            return true;
        }
        return false;

    }

    public boolean unBlockFollower(String userid, String myid, ArrayList<String> blockedList) {
        if (blockedList.contains(userid)) {
            blockedList.remove(userid);
            //DB COde
            return true;
        }
        return false;
    }


    public User getUser(String user1) {
        User temp = null;
        try {
            temp = (User) DB.DBLayer.getObject(user1, Users);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public ArrayList<User> getUserList(ArrayList<String> arr) {
        ArrayList<IModel> temp = null;
        ArrayList<User> ans = new ArrayList<>();
        try {
            temp = DB.DBLayer.getObjectsList(arr, Users);
            for (int i = 0; i < temp.size(); i++)
                ans.add((User) temp.get(i));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return ans;
    }
}
