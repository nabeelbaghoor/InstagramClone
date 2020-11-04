
package BL.src.instaclone;


import Models.User;

import java.util.Vector;

public interface Operations{
    public boolean removeFollower(String userid);
    public boolean blockUser(String userid);
    public boolean unblockUser(String userid);
    public boolean followUser(String userid);
    public boolean unfollowUser(String userid);
    public boolean likePost(String postid,String userid);   //PostID and UserID of person who issued post
    public boolean unlikePost(String postid);
    public boolean addPost(String postdata);
    public boolean removePost(String postid);
    public boolean sharePost(String postid, String userid);
    public boolean addComment(String postid, String comtext);
    public boolean editUserData(String data);
    public String getNewsFeedPosts();
    public User getMyProfile();
    public User getProfileInfo(String userid);
    public Vector<String> getFollowers();
    public Vector<String> getBlocked();
    public Vector<String> getFollowing();
    public boolean addFollowing(String userid); //Admin function to add followers
}
