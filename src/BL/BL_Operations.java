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

public class BL_Operations implements Operations {
    private final UserOperations uFunc;
    private final PostOperations pOperations;
    private User currUser;

    public BL_Operations(IDB_Operations _obj, String id) {
        try {
            _obj.initDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
        uFunc = new UserOperations(_obj);
        pOperations = new PostOperations(_obj);
        currUser = uFunc.getUser(id);
    }

    public boolean removeFollower(String userid) throws Exception { //Remove from my Followers
        if (currUser != null) {
            if (currUser.followersList.contains(userid))
                if (uFunc.removeFromList(currUser.userId, userid, "followersList"))
                    return currUser.followersList.remove(userid);
        }
        return false;
    }

    public boolean unfollowUser(String userid) throws Exception { //Unfollow a user
        if (currUser != null) {
            if (currUser.followingsList.contains(userid))
                if (uFunc.removeFromList(currUser.userId, userid, "followingsList"))
                    return currUser.followingsList.remove(userid);
        }
        return false;
    }

    public boolean followUser(String userid) throws Exception {   //Follow new User
        if (currUser != null) {
            if (!currUser.followingsList.contains(userid))
                if (uFunc.addToList(currUser.userId, userid, "followingsList"))
                    return currUser.followingsList.remove(userid);
        }
        return false;
    }

    public boolean blockUser(String userid) throws Exception {    //Block User
        if (currUser != null) {
            if (!currUser.blockedUsersList.contains(userid))
                if (uFunc.addToList(currUser.userId, userid, "blockedUsersList"))
                    return currUser.blockedUsersList.remove(userid);
        }
        return false;
    }

    public boolean unblockUser(String userid) throws Exception {
        if (currUser != null) {
            if (currUser.blockedUsersList.contains(userid))
                if (uFunc.removeFromList(currUser.userId, userid, "blockedUsersList"))
                    return currUser.blockedUsersList.remove(userid);
        }
        return false;
    }

    public boolean likePost(String postid, String userid) throws Exception {
        if (currUser != null) {
            String id = null;
            id = pOperations.sendNotification(userid, currUser.userId, postid, currUser.username+" Liked");
            if (id != null)
                if (pOperations.addLike(currUser.userId, postid))
                    return true;
                else
                    pOperations.removeNotification(id, currUser.userId);
        }
        return false;
    }

    public boolean unlikePost(String postid, String likeID) throws Exception {
        return pOperations.unLike(likeID, postid);
    }

    public boolean addPost(String posturl, String text) {
        String id = pOperations.addPost(posturl, text, currUser.userId);
        if (!id.equals("")) {
            try {
                return uFunc.addToList(currUser.userId, id, "postList");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean removePost(String postid) {
        if (currUser.postList.contains(postid)) {
            if (pOperations.removePost(postid)) {
                try {
                    uFunc.removeFromList(currUser.userId, postid, "postList");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return currUser.postList.remove(postid);
            }
        }
        return false;
    }

    public boolean sharePost(String postid, String userid) throws Exception {
        String id = "";
        id = pOperations.sendNotification(userid, currUser.userId, postid, currUser.username+" Shared");
        return !id.equals("");
    }

    public boolean addComment(String postid, String comtext) throws Exception {
        return pOperations.addComment(postid, comtext, currUser.userId);
    }

    public boolean editUserData(User data) throws Exception {
        if (uFunc.editUserData(data, currUser)) {
            currUser = uFunc.getUser(data.userId);
            return true;
        }
        return false;
    }

    public ArrayList<Post> getNewsFeedPosts() {
        return uFunc.getPosts(currUser.followingsList);
    }

    public ArrayList<Post> getNewsFeedPosts(String myid) {
        return pOperations.getUserPosts(currUser.postList);
    }

    public User getMyProfile() {
        return uFunc.getUser(currUser.userId);
    }

    public User getProfileInfo(String userid) {
        return uFunc.getUser(userid);
    }

    public HashMap<String, String> getFollowers() { return uFunc.getUserNames(currUser.followersList); }

    public HashMap<String, String> getBlocked() {
        return uFunc.getUserNames(currUser.blockedUsersList);
    }

    public HashMap<String, String> getFollowing() {
        return uFunc.getUserNames(currUser.followingsList);
    }

    public ArrayList<Notification> getNotification() {
        ArrayList<Notification> arr = null;
        arr = uFunc.getNotification(currUser.notificationList);
        return arr;
    }

    public boolean notifIsViewed(String notifid){
        return uFunc.setIsViewed(notifid);
    }

    public Post getPost(String postID){ return  pOperations.getPost(postID);}
}