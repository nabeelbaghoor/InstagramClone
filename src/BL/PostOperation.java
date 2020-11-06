/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Models.IDB_Operations;
import Models.IModel;
import Models.Notification;
import Models.Post;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * @author inspiron
 */
public class PostOperation {
    private final Layers DB = new Layers();

    PostOperation() {
    }

    public boolean sendNotification(String userid, String myid, String postid) {
        Notification obj = new Notification();
        obj.viewerId = userid;
        obj.sharerId = myid;
        obj.postId = postid;

        NotificationFunction temp = new NotificationFunction();
        return temp.sendNotification(obj);
    }

    public boolean addLike(String userid, String postid) {
        //DB Code
        return true;
    }

    public boolean removeNotification(String userid, String myid, String postid) {
        Notification obj = new Notification();
        obj.viewerId = userid;
        obj.sharerId = myid;
        obj.postId = postid;

        NotificationFunction temp = new NotificationFunction();
        return temp.removeNotification(obj);
    }

    public boolean unLike(String myid, String postid) {
        //DB Code
        return true;
    }

    public boolean addPost(String posturl, String text,String userid) {
        Post obj = new Post("",userid,posturl,text,null,null,null);
        try {
            if (DB.DBLayer.addObject(obj, IDB_Operations.ModelType.Posts) != null)
                return true;
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Post> getUserPosts(ArrayList<String> postList) {
        ArrayList<Post> ans = new ArrayList<>();
        ArrayList<IModel> temp = null;

        try {
            temp = DB.DBLayer.getObjectsList(postList, IDB_Operations.ModelType.Posts);
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        assert temp != null;
        for (IModel iModel : temp)
            ans.add((Post) iModel);

        ans.sort((p1,p2)->{return p2.timestamp.getTimestamp().compareTo(p1.timestamp.getTimestamp()); });
        return ans;
    }

    public boolean removePost(String postid) {
        boolean flag = false;
        try {
            flag = DB.DBLayer.removeObject(postid, IDB_Operations.ModelType.Posts);
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return flag;
    }
}

