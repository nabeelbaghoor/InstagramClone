/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Models.Notification;
import Models.Operations;
import Models.Post;
import Models.User;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * @author inspiron
 */

public class UserOperations implements Operations {
    private User curruser;
    private UserFunctions uFunc;
    private PostOperation pOperations;
    private Layers dTemp = new Layers();

    public UserOperations() {
        uFunc = new UserFunctions();
        pOperations = new PostOperation();
        curruser = uFunc.getUser("dLus5uS81GWRv5dT3Ve1");
    }

    public boolean removeFollower(String userid) { //Remove from my Followers
        if (curruser != null){
            if (curruser.followersList.contains(userid))
                if (uFunc.removeFromList(curruser.userId,userid,"followersList"))
                    return curruser.followersList.remove(userid);
        }
            return false;
    }

    public boolean unfollowUser(String userid) { //Unfollow a user
        if (curruser != null){
            if (curruser.followingsList.contains(userid))
                if (uFunc.removeFromList(curruser.userId,userid,"followingsList"))
                    return curruser.followingsList.remove(userid);
        }
        return false;
    }

    public boolean followUser(String userid) {   //Follow new User
        if (curruser != null){
            if (!curruser.followingsList.contains(userid))
                if (uFunc.addToList(curruser.userId,userid,"followingsList"))
                    return curruser.followingsList.remove(userid);
        }
        return false;
    }

    public boolean blockUser(String userid) {    //Block User
        if (curruser != null){
            if (!curruser.blockedUsersList.contains(userid))
                if (uFunc.addToList(curruser.userId,userid,"blockedUsersList"))
                    return curruser.blockedUsersList.remove(userid);
        }
        return false;
    }

    public boolean unblockUser(String userid) {
        if (curruser != null){
            if (curruser.blockedUsersList.contains(userid))
                if (uFunc.removeFromList(curruser.userId,userid,"blockedUsersList"))
                    return curruser.blockedUsersList.remove(userid);
        }
        return false;
    }

    public boolean likePost(String postid, String userid) {
        if (curruser != null) {
            String id = null;
            id = pOperations.sendNotification(userid, curruser.userId, postid, "Liked");
            if (id != null)
                if (pOperations.addLike(curruser.userId, postid))
                    return true;
                else
                    pOperations.removeNotification(id,curruser.userId);
        }
        return false;
    }

    public boolean unlikePost(String postid,String likeID) {
        return pOperations.unLike(likeID, postid);
    }

    public boolean addPost(String posturl, String text) {
        return pOperations.addPost(posturl,text,curruser.userId);
    }

    public boolean removePost(String postid) {
        if (curruser.postList.contains(postid)){
            if(pOperations.removePost(postid))
                return curruser.postList.remove(postid);
        }
        return false;
    }

    public boolean sharePost(String postid, String userid) {
        String id = "";
        id = pOperations.sendNotification(userid, curruser.userId, postid, "Shared");
        return !id.equals("");
    }

    public boolean addComment(String postid, String comtext) {
        return pOperations.addComment(postid,comtext,curruser.userId);
    }

    public boolean editUserData(User data) throws ExecutionException, InterruptedException {
         if(uFunc.editUserData(data, curruser)){
             curruser = uFunc.getUser(data.userId);
             return true;
         }
         return false;
    }

    public ArrayList<Post> getNewsFeedPosts() {
        return uFunc.getPosts(curruser.followingsList);
    }

    public ArrayList<Post> getNewsFeedPosts(String myid){
        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(curruser.userId);
        return uFunc.getPosts(tempList);
    }

    public User getMyProfile() {
        return curruser;
    }

    public User getProfileInfo(String userid) {
        return uFunc.getUser(userid);
    }

    public ArrayList<String> getFollowers() {
        return curruser.followersList;
    }

    public ArrayList<String> getBlocked() {
        return curruser.blockedUsersList;
    }

    public ArrayList<String> getFollowing() {
        return curruser.followingsList;
    }

    public ArrayList<Notification> getNotification(){
        ArrayList<Notification> arr = null;
        arr = uFunc.getNotification(curruser.notificationList);
        return arr;
    }

    public boolean addFollowing(String userid) {
        return true;
    } //Admin function to add followers
}