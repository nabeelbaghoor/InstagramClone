/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.concurrent.ExecutionException;

public class PostOperation {
    private final IDB_Operations DB;

    PostOperation(IDB_Operations _obj) {
        DB = _obj;
    }

    public String sendNotification(String userid, String myid, String postid, String msg) throws Exception {
        NotificationFunction temp = new NotificationFunction(DB);
        return temp.sendNotification(userid, myid, postid, msg);
    }

    public boolean addLike(String userid, String postid) throws Exception {
        Like obj = new Like();
        obj.userId = userid;
        String id = null;

        try {
            id = DB.addObject(obj, IDB_Operations.ModelType.Likes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (id != null) {
            Pair<String, Object> pair = new Pair<String, Object>("likesList", id);
            boolean flag = false;

            flag = DB.updateArrayObject(postid, pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.Likes);

            if (!flag) {
                try {
                    flag = DB.removeObject(id, IDB_Operations.ModelType.Likes);
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return flag;
        }
        return false;
    }

    public boolean removeNotification(String id, String myid) throws Exception {
        NotificationFunction temp = new NotificationFunction(DB);
        return temp.removeNotification(id, myid);
    }

    public boolean unLike(String likeID, String postid) throws Exception {
        boolean flag = false;
        try {
            flag = DB.removeObject(likeID, IDB_Operations.ModelType.Likes);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        Pair<String, Object> pair = new Pair<String, Object>("likesList", likeID);
        if (flag)
            flag = DB.updateArrayObject(postid, pair, IDB_Operations.UpdateOperation.Remove, IDB_Operations.ModelType.Posts);

        return flag;
    }

    public String addPost(String posturl, String text, String userid, Integer num) {
        URL imageURL = null;
        try {
            imageURL = new URL("file:///"+posturl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        BufferedImage bi = null;
        try {
            bi = ImageIO.read(imageURL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String newURL = "\\Images\\" + userid + "-" +num.toString();
        try {
            ImageIO.write(bi, "jpg", new File(newURL));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Post obj = new Post("", userid, newURL, text, null, null, null);
        String id = "";
        try {
            id = DB.addObject(obj, IDB_Operations.ModelType.Posts);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public ArrayList<Post> getUserPosts(ArrayList<String> postList) {
        ArrayList<Post> ans = new ArrayList<>();
        ArrayList<IModel> temp = null;

        try {
            temp = DB.getObjectsList(postList, IDB_Operations.ModelType.Posts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert temp != null;
        for (IModel iModel : temp)
            ans.add((Post) iModel);

        ans.sort((p1, p2) -> {
            return p2.timestamp.toString().compareTo(p1.timestamp.toString());  //Code chnaged from timestamp.getTimestamp() to timestamp.toString()
        });
        return ans;
    }

    public boolean removePost(String postid) {
        boolean flag = false;
        try {
            flag = DB.removeObject(postid, IDB_Operations.ModelType.Posts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean addComment(String postid, String comtext, String userId) throws Exception {
        String id = "";
        Comment obj = new Comment();
        obj.commentText = comtext;
        obj.userId = userId;

        try {
            id = DB.addObject(obj, IDB_Operations.ModelType.Comments);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!id.equals("")) {
            Pair<String, Object> pair = new Pair<String, Object>("commentsList", id);
            return DB.updateArrayObject(postid, pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.Posts);
        }
        return false;
    }
}

