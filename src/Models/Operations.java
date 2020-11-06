package Models;

import java.util.ArrayList;

public interface Operations {
    boolean removeFollower(String userid);

    boolean blockUser(String userid);

    boolean unblockUser(String userid);

    boolean followUser(String userid);

    boolean unfollowUser(String userid);

    boolean likePost(String postid, String userid);             //PostID and UserID of person who issued post

    boolean unlikePost(String postid);

    boolean addPost(String posturl, String text);               //Parameter Post URL and Text. Done

    boolean removePost(String postid);

    boolean sharePost(String postid, String userid);

    boolean addComment(String postid, String comtext);

    boolean editUserData(User data);        //Done

    ArrayList<Post> getNewsFeedPosts();     //Done

    ArrayList<Post> getNewsFeedPosts(String myid);  //To get Current User Posts. Done

    User getMyProfile();                    //Done

    User getProfileInfo(String userid);     //Done

    ArrayList<String> getFollowers();       //Done

    ArrayList<String> getBlocked();         //Done

    ArrayList<String> getFollowing();       //Done

    boolean addFollowing(String userid);    //Admin function to add followers
}
