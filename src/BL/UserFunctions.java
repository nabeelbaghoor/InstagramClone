package BL;

import Models.IDB_Operations;
import Models.IModel;
import Models.Post;
import Models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import static Models.IDB_Operations.ModelType.Users;

public class UserFunctions {
    private final Layers DB = new Layers();

    public UserFunctions() {
    }

    public boolean followerUser(String userid, String myid, ArrayList<String> followers) {
        if (!followers.contains(userid)) {
            followers.add(userid);
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

    public User getUser(String user1) {
        User temp = null;
        try {
            temp = (User) DB.DBLayer.getObject(user1, Users);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public ArrayList<User> getUserList(ArrayList<String> arr) {
        ArrayList<User> ans = new ArrayList<>();
        ArrayList<IModel> temp = null;

        try {
            temp = DB.DBLayer.getObjectsList(arr, Users);
            for (IModel iModel : temp)
                ans.add((User) iModel);
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public ArrayList<Post> getPosts(ArrayList<String> userList) {
        ArrayList<Post> ans = null;
        ArrayList<String> postList = new ArrayList<>();
        ArrayList<User> Users = getUserList(userList);

        for (User temp : Users) {
            postList.addAll(temp.postList);
        }

        PostOperation temp = new PostOperation();
        ans = temp.getUserPosts(postList);
        return ans;
    }

    public boolean editUserData(User data, User curr) {
        HashMap<String,String> map = new HashMap<>();

        if (!data.emailAddress.equals(curr.emailAddress))
            map.put("emailAddress",data.emailAddress);
        if (!data.bio.equals(curr.bio))
            map.put("bio",data.bio);
        if (!data.dateOfBirth.equals(curr.dateOfBirth))
            map.put("dateOfBirth", String.valueOf(data.dateOfBirth));
        if (!data.firstName.equals(curr.firstName))
            map.put("firstName",data.firstName);
        if (!data.gender.equals(curr.gender))
            map.put("gender",data.gender);
        if (!data.website.equals(curr.website))
            map.put("website", data.website);
        if (!data.imagePath.equals(curr.imagePath))
            map.put("imagePath",data.imagePath);
        if (!data.lastName.equals(curr.lastName))
            map.put("lastName",data.lastName);
        if (!data.phoneNumber.equals(curr.phoneNumber))
            map.put("phoneNumber",data.phoneNumber);

        return DB.DBLayer.updateObject(data.userId,map, Users);
    }

    public boolean removeFromList(String myID, String userid, String key) {
        HashMap<String, String> map = new HashMap<>();
        map.put(key,userid);
        return DB.DBLayer.updateArrayObject(myID,map,IDB_Operations.UpdateOperation.Remove,Users);
    }

    public boolean addToList(String myID, String userid, String key) {
        HashMap<String, String> map = new HashMap<>();
        map.put(key,userid);
        return DB.DBLayer.updateArrayObject(myID,map,IDB_Operations.UpdateOperation.Add,Users);
    }
}
