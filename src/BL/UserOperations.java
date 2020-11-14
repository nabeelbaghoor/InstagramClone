package BL;

import Models.*;
import com.google.firebase.database.utilities.Pair;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import static Models.IDB_Operations.ModelType.User;

public class UserOperations {
    private final IDB_Operations DB;

    public UserOperations(IDB_Operations _obj) {
        DB = _obj;
    }

    public User getUser(String user1) {
        User temp = null;
        try {
            temp = (User) DB.getObject(user1, User);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public ArrayList<User> getUserList(ArrayList<String> arr) {
        ArrayList<User> ans = new ArrayList<>();
        ArrayList<IModel> temp = null;

        try {
            temp = DB.getObjectsList(arr, User);
            for (IModel iModel : temp)
                ans.add((User) iModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    public ArrayList<Post> getPosts(ArrayList<String> userList) {
        ArrayList<Post> ans = null;
        ArrayList<String> postList = new ArrayList<>();
        ArrayList<User> Users = getUserList(userList);
        ArrayList<String> tempUsers = new ArrayList<>();

        for (User temp : Users) {
            if (temp.postList != null)
                postList.addAll(temp.postList);
            if (temp.followingsList != null)
                tempUsers.addAll(temp.followingsList);
        }

        Users.clear();
        Users = getUserList(tempUsers);

        for (User temp : Users) {
            if (temp.postList != null)
                postList.addAll(temp.postList);
        }

        postList.sort(Comparator.naturalOrder());

        for (int i = 1; i < postList.size(); i++)
            if (postList.get(i).equals(postList.get(i-1)))
                postList.remove(i);

        PostOperations temp = new PostOperations(DB);
        ans = temp.getUserPosts(postList);
        return ans;
    }

    public boolean editUserData(User data, User curr) throws Exception {
        HashMap<String, Object> map = new HashMap<>();

        if (!data.emailAddress.equals(curr.emailAddress))
            map.put("emailAddress", data.emailAddress);
        if (!data.bio.equals(curr.bio))
            map.put("bio", data.bio);
        if (!data.dateOfBirth.equals(curr.dateOfBirth))
            map.put("dateOfBirth", String.valueOf(data.dateOfBirth));
        if (!data.firstName.equals(curr.firstName))
            map.put("firstName", data.firstName);
        if (!data.gender.equals(curr.gender))
            map.put("gender", data.gender);
        if (!data.website.equals(curr.website))
            map.put("website", data.website);
        if (!data.imagePath.equals(curr.imagePath)) {
            URL imageURL = null;
            try {
                imageURL = new URL(data.imagePath);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            BufferedImage bi = null;
            try {
                bi = ImageIO.read(imageURL);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String newURL = ".\\Images\\" + data.userId + ".png";
            try {
                ImageIO.write(bi, "png", new File(newURL));
            } catch (IOException e) {
                e.getCause();
            }

            map.put("imagePath", newURL);
            //map.put("imagePath", data.imagePath);
        }
        if (!data.lastName.equals(curr.lastName))
            map.put("lastName", data.lastName);
        if (!data.phoneNumber.equals(curr.phoneNumber))
            map.put("phoneNumber", data.phoneNumber);

        if (!map.isEmpty())
            return DB.updateObject(data.userId, map, User);
        return true;
    }

    public boolean removeFromList(String myID, String id, String key) throws Exception {
        Pair<String, Object> pair = new Pair<String, Object>(key, id);
        return DB.updateArrayObject(myID, pair, IDB_Operations.UpdateOperation.Remove, User);
    }

    public boolean addToList(String myID, Object id, String key) throws Exception {
        Pair<String, Object> pair = new Pair<String, Object>(key, id);
        return DB.updateArrayObject(myID, pair, IDB_Operations.UpdateOperation.Add, User);
    }

    public ArrayList<Notification> getNotification(ArrayList<String> notificationList) {
        ArrayList<Notification> ans = new ArrayList<>();
        ArrayList<IModel> temp;
        try {
            temp = DB.getObjectsList(notificationList, IDB_Operations.ModelType.Notification);
            for (IModel iModel : temp)
                ans.add((Notification) iModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    public HashMap<String, String> getUserNames(ArrayList<String> uList) {

        ArrayList<User> users;
        HashMap<String, String> map = new HashMap<>();
        users = getUserList(uList);

        for (User user : users) map.put(user.userId, user.username);

        return map;
    }

    public boolean setIsViewed(String notifid) {
        NotificationOperations temp = new NotificationOperations(DB);
        return temp.setIsViewwed(notifid);
    }
}
