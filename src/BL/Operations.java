package BL;


import Models.User;

import java.util.ArrayList;

public interface Operations {
    boolean removeFollower(String userid);

    boolean blockUser(String userid);

    boolean unblockUser(String userid);

    boolean followUser(String userid);

    boolean unfollowUser(String userid);

    boolean likePost(String postid, String userid);   //PostID and UserID of person who issued post

    boolean unlikePost(String postid);

    boolean addPost(String postdata);

    boolean removePost(String postid);

    boolean sharePost(String postid, String userid);

    boolean addComment(String postid, String comtext);

    boolean editUserData(String data);

    String getNewsFeedPosts();

    User getMyProfile();

    User getProfileInfo(String userid);

    ArrayList<String> getFollowers();

    ArrayList<String> getBlocked();

    ArrayList<String> getFollowing();

    boolean addFollowing(String userid); //Admin function to add followers
}
