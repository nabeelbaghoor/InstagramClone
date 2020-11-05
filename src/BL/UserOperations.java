/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Models.User;

import java.util.ArrayList;

/**
 *
 * @author inspiron
 */

public class UserOperations implements Operations{
    private User curruser;

    public UserOperations(){
        UserFunctions temp = new UserFunctions();
        curruser = temp.getUser("User1");
    }

    public boolean removeFollower(String userid){ //Remove from my Followers
        UserFunctions temp = new UserFunctions();
        if (curruser != null)
            return temp.removeFollowing(userid,curruser.userId,curruser.followingsList);
        return false;
    }

    public boolean unfollowUser(String userid){ //Unfollow a user
        UserFunctions temp = new UserFunctions();
        if (curruser != null)
            return temp.unfollowerUser(userid,curruser.userId,curruser.followersList);
        return false;
    }

    public boolean followUser(String userid){   //Follow new User
        UserFunctions temp = new UserFunctions();
        if (curruser != null)
        return temp.followerUser(userid,curruser.userId,curruser.followersList);
        return false;
    }

    public boolean blockUser(String userid){    //Block User
        UserFunctions temp = new UserFunctions();
        if (curruser != null)
            return temp.blockFollower(userid,curruser.userId,curruser.blockedUsersList);
        return false;
    }

    public boolean unblockUser(String userid){
        UserFunctions temp = new UserFunctions();
        if (curruser != null)
            return temp.unBlockFollower(userid,curruser.userId,curruser.blockedUsersList);
        return false;
    }

    public boolean likePost(String postid,String userid){
        if (curruser != null){
            PostOperation temp = new PostOperation();
            if(temp.sendNotification(userid,curruser.userId,postid,"Liked"))
                if(temp.addLike(curruser.userId,postid))
                    return true;
                else
                    temp.removeNotification(userid,curruser.userId,postid,"Liked");
        }
        return false;
    }

    public boolean unlikePost(String postid){
        if (curruser != null){
            PostOperation temp = new PostOperation();
            if(temp.unLike(curruser.userId,postid))
                return true;
        }
        return false;
    }
    public boolean addPost(String postdata){return true;}
    public boolean removePost(String postid){return true;}
    public boolean sharePost(String postid, String userid){return true;}
    public boolean addComment(String postid, String comtext){return true;}
    public boolean editUserData(String data){return true;}

    public String getNewsFeedPosts(){
        String ans = "Hello"; 
        return ans;
    }
    public User getMyProfile(){
       return curruser;
    }
    public User getProfileInfo(String userid){
        UserFunctions temp = new UserFunctions();
        return temp.getUser(userid);
    }
    
    public ArrayList<String> getFollowers(){
        return curruser.followersList;
    }
    
    public ArrayList<String> getBlocked(){
        return curruser.blockedUsersList;
    }
    public ArrayList<String> getFollowing(){
        return curruser.followingsList;
    }
    public boolean addFollowing(String userid){return true;} //Admin function to add followers
}