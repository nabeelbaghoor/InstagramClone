/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Models.*;
import com.google.firebase.database.utilities.Pair;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * @author inspiron
 */
public class PostOperation {

    PostOperation() {
    }

    public String sendNotification(String userid, String myid, String postid, String msg) throws ExecutionException, InterruptedException {
        NotificationFunction temp = new NotificationFunction();
        return temp.sendNotification(userid, myid, postid, msg);
    }

    public boolean addLike(String userid, String postid) throws ExecutionException, InterruptedException {
        Like obj = new Like();
        obj.userId = userid;
        String id = null;

        try {
            id = Layers.DBLayer.addObject(obj, IDB_Operations.ModelType.Likes);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        if (id != null) {
            Pair<String, Object> pair = new Pair<String, Object>("likesList", id);
            boolean flag = false;

            flag = Layers.DBLayer.updateArrayObject(postid, pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.Likes);

            if (!flag) {
                try {
                    flag = Layers.DBLayer.removeObject(id, IDB_Operations.ModelType.Likes);
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return flag;
        }
        return false;
    }

    public boolean removeNotification(String id, String myid) throws ExecutionException, InterruptedException {
        NotificationFunction temp = new NotificationFunction();
        return temp.removeNotification(id, myid);
    }

    public boolean unLike(String likeID, String postid) throws ExecutionException, InterruptedException {
        boolean flag = false;
        try {
            flag = Layers.DBLayer.removeObject(likeID, IDB_Operations.ModelType.Likes);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        Pair<String, Object> pair = new Pair<String, Object>("likesList", likeID);
        if (flag)
            flag = Layers.DBLayer.updateArrayObject(likeID, pair, IDB_Operations.UpdateOperation.Remove, IDB_Operations.ModelType.Posts);

        return flag;
    }

    public boolean addPost(String posturl, String text, String userid) {
        Post obj = new Post("", userid, posturl, text, null, null, null);
        try {
            if (Layers.DBLayer.addObject(obj, IDB_Operations.ModelType.Posts) != null)
                return true;
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Post> getUserPosts(ArrayList<String> postList) {
        ArrayList<Post> ans = new ArrayList<>();
        ArrayList<IModel> temp = null;

        try {
            temp = Layers.DBLayer.getObjectsList(postList, IDB_Operations.ModelType.Posts);
        } catch (ExecutionException | InterruptedException e) {
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
            flag = Layers.DBLayer.removeObject(postid, IDB_Operations.ModelType.Posts);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean addComment(String postid, String comtext, String userId) throws ExecutionException, InterruptedException {
        String id = "";
        Comment obj = new Comment();
        obj.commentText = comtext;
        obj.userId = userId;

        try {
            id = Layers.DBLayer.addObject(obj, IDB_Operations.ModelType.Comments);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        if (!id.equals("")) {
            Pair<String, Object> pair = new Pair<String, Object>("commentsList", id);
            return Layers.DBLayer.updateArrayObject(postid, pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.Posts);
        }
        return false;
    }
}

