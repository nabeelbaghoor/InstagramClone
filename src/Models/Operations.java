package Models;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface Operations {
    boolean removeFollower(String userid);  //Done

    boolean blockUser(String userid);       //Done

    boolean unblockUser(String userid);     //Done

    boolean followUser(String userid);      //Done

    boolean unfollowUser(String userid);    //Done

    boolean likePost(String postid, String userid);     //Done        //PostID and UserID of person who issued post

    boolean unlikePost(String postid, String unlike);   //Done

    boolean sharePost(String postid, String userid);

    boolean addComment(String postid, String comtext);  //Done

    boolean addPost(String posturl, String text);   //Done

    boolean removePost(String postid);      //Done

    boolean editUserData(User data) throws ExecutionException, InterruptedException;        //Done

    ArrayList<Post> getNewsFeedPosts();     //Done

    ArrayList<Post> getNewsFeedPosts(String myid);  //To get Current User Posts. Done

    User getMyProfile();                    //Done

    User getProfileInfo(String userid);     //Done

    ArrayList<String> getFollowers();       //Done

    ArrayList<String> getBlocked();         //Done

    ArrayList<String> getFollowing();       //Done

    ArrayList<Notification> getNotification();  //Done

    //boolean addFollowing(String userid);    //Admin function to add followers
}
