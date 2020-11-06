package BL;

import Models.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import static Models.IDB_Operations.ModelType.Users;

public class UserFunctions {

    public UserFunctions() {
    }

    public User getUser(String user1) {
        User temp = null;
        try {
            temp = (User) Layers.DBLayer.getObject(user1, Users);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public ArrayList<User> getUserList(ArrayList<String> arr) {
        ArrayList<User> ans = new ArrayList<>();
        ArrayList<IModel> temp = null;

        try {
            temp = Layers.DBLayer.getObjectsList(arr, Users);
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

        return Layers.DBLayer.updateObject(data.userId,map, Users);
    }

    public boolean removeFromList(String myID, String userid, String key) {
        HashMap<String, String> map = new HashMap<>();
        map.put(key,userid);
        return Layers.DBLayer.updateArrayObject(myID,map,IDB_Operations.UpdateOperation.Remove,Users);
    }

    public boolean addToList(String myID, String userid, String key) {
        HashMap<String, String> map = new HashMap<>();
        map.put(key,userid);
        return Layers.DBLayer.updateArrayObject(myID,map,IDB_Operations.UpdateOperation.Add,Users);
    }

    public ArrayList<Notification> getNotification(ArrayList<String> notificationList) {
        ArrayList<Notification> ans = new ArrayList<>();
        ArrayList<IModel> temp;
        try {
            temp = Layers.DBLayer.getObjectsList(notificationList, IDB_Operations.ModelType.Notifications);
            for (IModel iModel : temp)
                ans.add((Notification) iModel);
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return ans;
    }
}
