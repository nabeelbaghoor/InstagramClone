/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class BLOperations implements Operations {
    private final UserOperations uFunc;
    private final PostOperations pOperations;
    private User curruser;

    public BLOperations(IDB_Operations _obj, String id) {
        try {
            _obj.initDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
        uFunc = new UserOperations(_obj);
        pOperations = new PostOperations(_obj);
        curruser = uFunc.getUser(id);
    }

    public boolean removeFollower(String userid) throws Exception { //Remove from my Followers
        if (curruser != null) {
            if (curruser.followersList.contains(userid))
                if (uFunc.removeFromList(curruser.userId, userid, "followersList"))
                    return curruser.followersList.remove(userid);
        }
        return false;
    }

    public boolean unfollowUser(String userid) throws Exception { //Unfollow a user
        if (curruser != null) {
            if (curruser.followingsList.contains(userid))
                if (uFunc.removeFromList(curruser.userId, userid, "followingsList"))
                    return curruser.followingsList.remove(userid);
        }
        return false;
    }

    public boolean followUser(String userid) throws Exception {   //Follow new User
        if (curruser != null) {
            if (!curruser.followingsList.contains(userid))
                if (uFunc.addToList(curruser.userId, userid, "followingsList"))
                    return curruser.followingsList.remove(userid);
        }
        return false;
    }

    public boolean blockUser(String userid) throws Exception {    //Block User
        if (curruser != null) {
            if (!curruser.blockedUsersList.contains(userid))
                if (uFunc.addToList(curruser.userId, userid, "blockedUsersList"))
                    return curruser.blockedUsersList.remove(userid);
        }
        return false;
    }

    public boolean unblockUser(String userid) throws Exception {
        if (curruser != null) {
            if (curruser.blockedUsersList.contains(userid))
                if (uFunc.removeFromList(curruser.userId, userid, "blockedUsersList"))
                    return curruser.blockedUsersList.remove(userid);
        }
        return false;
    }

    public boolean likePost(String postid, String userid) throws Exception {
        if (curruser != null) {
            String id = null;
            id = pOperations.sendNotification(userid, curruser.userId, postid, "Liked");
            if (id != null)
                if (pOperations.addLike(curruser.userId, postid))
                    return true;
                else
                    pOperations.removeNotification(id, curruser.userId);
        }
        return false;
    }

    public boolean unlikePost(String postid, String likeID) throws Exception {
        return pOperations.unLike(likeID, postid);
    }

    public boolean addPost(String posturl, String text) {
        String id = pOperations.addPost(posturl, text, curruser.userId);
        if (!id.equals("")) {
            try {
                return uFunc.addToList(curruser.userId, id, "postList");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean removePost(String postid) {
        if (curruser.postList.contains(postid)) {
            if (pOperations.removePost(postid)) {
                try {
                    uFunc.removeFromList(curruser.userId, postid, "postList");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return curruser.postList.remove(postid);
            }
        }
        return false;
    }

    public boolean sharePost(String postid, String userid) throws Exception {
        String id = "";
        id = pOperations.sendNotification(userid, curruser.userId, postid, "Shared");
        return !id.equals("");
    }

    public boolean addComment(String postid, String comtext) throws Exception {
        return pOperations.addComment(postid, comtext, curruser.userId);
    }

    public boolean editUserData(User data) throws Exception {
        if (uFunc.editUserData(data, curruser)) {
            curruser = uFunc.getUser(data.userId);
            return true;
        }
        return false;
    }

    public ArrayList<Post> getNewsFeedPosts() {
        return uFunc.getPosts(curruser.followingsList);
    }

    public ArrayList<Post> getNewsFeedPosts(String myid) {
        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(curruser.userId);
        return uFunc.getPosts(tempList);
    }

    public User getMyProfile() {
        return uFunc.getUser(curruser.userId);
    }

    public User getProfileInfo(String userid) {
        return uFunc.getUser(userid);
    }

    public HashMap<String, String> getFollowers() { return uFunc.getUserNames(curruser.followersList); }

    public HashMap<String, String> getBlocked() {
        return uFunc.getUserNames(curruser.blockedUsersList);
    }

    public HashMap<String, String> getFollowing() { return uFunc.getUserNames(curruser.followingsList); }

    public ArrayList<Notification> getNotification() {
        ArrayList<Notification> arr = null;
        arr = uFunc.getNotification(curruser.notificationList);
        return arr;
    }

    public boolean addFollowing(String userid) {
        return true;
    } //Admin function to add followers
}