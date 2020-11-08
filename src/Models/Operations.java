package Models;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface Operations {
    boolean removeFollower(String userid) throws Exception;  //Done

    boolean blockUser(String userid) throws Exception;       //Done

    boolean unblockUser(String userid) throws Exception;     //Done

    boolean followUser(String userid) throws Exception;      //Done

    boolean unfollowUser(String userid) throws Exception;    //Done

    boolean likePost(String postid, String userid) throws ExecutionException, InterruptedException;     //Done        //PostID and UserID of person who issued post

    boolean unlikePost(String postid, String unlike) throws ExecutionException, InterruptedException;   //Done

    boolean sharePost(String postid, String userid) throws ExecutionException, InterruptedException;

    boolean addComment(String postid, String comtext) throws ExecutionException, InterruptedException;  //Done

    boolean addPost(String posturl, String text);   //Done

    boolean removePost(String postid);      //Done

    boolean editUserData(User data) throws Exception;        //Done

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
