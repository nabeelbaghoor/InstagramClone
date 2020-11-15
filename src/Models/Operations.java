package Models;

import java.util.ArrayList;
import java.util.HashMap;

public interface Operations {

    boolean removeFollower(String userid) throws Exception;  //Done

    boolean blockUser(String userid) throws Exception;       //Done

    boolean unblockUser(String userid) throws Exception;     //Done

    boolean followUser(String userid) throws Exception;      //Done

    boolean unfollowUser(String userid) throws Exception;    //Done

    boolean likePost(String postid, String userid) throws Exception;     //Done        //PostID and UserID of person who issued post

    boolean unlikePost(String postid, String unlike) throws Exception;   //Done

    boolean sharePost(String postid, String userid) throws Exception;

    boolean addComment(String postid, String comtext) throws Exception;  //Done

    boolean addPost(String posturl, String text);   //Done

    boolean removePost(String postid);      //Done

    boolean editUserData(User data) throws Exception;        //Done

    boolean notifIsViewed(String notifid);

    Post getPost(String postID);

    ArrayList<Post> getNewsFeedPosts();     //Done

    ArrayList<Post> getNewsFeedPosts(String myid);  //To get Current User Posts. Done

    User getMyProfile();                    //Done

    User getProfileInfo(String userid);     //Done

    HashMap<String, String> getFollowers();       //Done //User ID and User Name - Order to Follow

    HashMap<String, String> getBlocked();         //Done //User ID and User Name - Order to Follow

    HashMap<String, String> getFollowing();       //Done //User ID and User Name - Order to Follow

    ArrayList<Notification> getNotification();  //Done

    //boolean addFollowing(String userid);    //Admin function to add followers
}
