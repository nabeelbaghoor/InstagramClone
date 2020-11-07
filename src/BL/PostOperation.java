/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 * @author inspiron
 */
public class PostOperation {

    PostOperation() {
    }

    public String sendNotification(String userid, String myid, String postid, String msg) {
        NotificationFunction temp = new NotificationFunction();
        return temp.sendNotification(userid, myid, postid, msg);
    }

    public boolean addLike(String userid, String postid) {
        Like obj = new Like();
        obj.userId = userid;
        String id = null;

        try {
            id = Layers.DBLayer.addObject(obj, IDB_Operations.ModelType.Likes);
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        if (id != null){
            HashMap <String,Object> map = new HashMap<>();
            map.put("likesList",id);
            boolean flag = false;

            flag = Layers.DBLayer.updateArrayObject(postid,map, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.Likes);

            if(!flag) {
                try {
                    flag = Layers.DBLayer.removeObject(id, IDB_Operations.ModelType.Likes);
                }
                catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return flag;
        }
        return false;
    }

    public boolean removeNotification(String id, String myid) {
        NotificationFunction temp = new NotificationFunction();
        return temp.removeNotification(id,myid);
    }

    public boolean unLike(String likeID, String postid) {
        boolean flag = false;
        try {
         flag = Layers.DBLayer.removeObject(likeID, IDB_Operations.ModelType.Likes);
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        HashMap<String,Object> map = new HashMap<>();
        map.put("likesList",likeID);
        if (flag)
            flag = Layers.DBLayer.updateArrayObject(likeID,map, IDB_Operations.UpdateOperation.Remove, IDB_Operations.ModelType.Posts);

        return flag;
    }

    public boolean addPost(String posturl, String text,String userid) {
        Post obj = new Post("",userid,posturl,text,null,null,null);
        try {
            if (Layers.DBLayer.addObject(obj, IDB_Operations.ModelType.Posts) != null)
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
            temp = Layers.DBLayer.getObjectsList(postList, IDB_Operations.ModelType.Posts);
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
            flag = Layers.DBLayer.removeObject(postid, IDB_Operations.ModelType.Posts);
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean addComment(String postid, String comtext, String userId) {
        String id = "";
        Comment obj = new Comment();
        obj.commentText = comtext;
        obj.userId = userId;

        try {
            id = Layers.DBLayer.addObject(obj, IDB_Operations.ModelType.Comments);
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        if (!id.equals("")) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("commentsList", id);
            return Layers.DBLayer.updateArrayObject(postid, map, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.Posts);
        }
        return false;
    }
}

