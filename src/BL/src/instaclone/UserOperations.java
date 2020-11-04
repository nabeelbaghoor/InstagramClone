/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.src.instaclone;

import Models.User;

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
        return temp.removeFollowing(userid,curruser.myid,curruser.followingList);
    }

    public boolean unfollowUser(String userid){ //Unfollow a user
        UserFunctions temp = new UserFunctions();
        return temp.unfollowerUser(userid,curruser.myid,curruser.followers);
    }

    public boolean followUser(String userid){   //Follow new User
        UserFunctions temp = new UserFunctions();
        return temp.followerUser(userid,curruser.myid,curruser.followers);
    }

    public boolean blockUser(String userid){    //Block User
        UserFunctions temp = new UserFunctions();
        return temp.blockFollower(userid,curruser.myid,curruser.blockedList);
    }

    public boolean unblockUser(String userid){
        UserFunctions temp = new UserFunctions();
        return temp.unBlockFollower(userid,curruser.myid,curruser.blockedList);
    }

    public boolean likePost(String postid,String userid){
    if (curruser != null)
        //return curruser.likePost(postid,userid);
        return true;
    return false;
    }

    public boolean unlikePost(String postid){return true;}
    public boolean addPost(String postdata){return true;}
    public boolean removePost(String postid){return true;}
    public boolean sharePost(String postid, String userid){return true;}
    public boolean addComment(String postid, String comtext){return true;}
    public boolean editUserData(String data){return true;}
    public String getNewsFeedPosts(){
        String ans = "Hello"; 
        return ans;
    }
    public String getMyProfile(){
        String ans = "Hello"; 
        return ans;
    }
    public String getProfileInfo(String userid){
        String ans = "Hello"; 
        return ans;
    }
    
    public String getFollowers(){
        //return currprofile.getFollowers();
        String ans = "";
        return ans;
    }
    
    public String getBlocked(){
        String ans = "Hello"; 
        return ans;
    }
    public String getFollowing(){
        String ans = "Hello"; 
        return ans;
    }
    public boolean addFollowing(String userid){return true;} //Admin function to add followers
}