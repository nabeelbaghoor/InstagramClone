package BL;
//import com.google.gson.Gson;
//Creating the ObjectMapper object
//ObjectMapper mapper = new ObjectMapper();
//Converting the Object to JSONString
//String jsonString = mapper.writeValueAsString(std);
public interface Operation {
    boolean removeFollower(String userid);
    boolean blockUser(String userid);
    boolean unblockUser(String userid);
    boolean followUser(String userid);
    boolean unfollowUser(String userid);
    boolean likePost(String postid);
    boolean unlikePost(String postid);
    boolean addPost(String postdata);
    boolean removePost(String postid);
    boolean sharePost(String postid, String userid);
    boolean addComment(String postid, String comtext);
    boolean editUserData(String data);
    String getNewsFeedPosts();
    String getMyProfile();
    String getProfileInfo(String userid);
    String getFollowers();
    String getBlocked();
    String getFollowing();
    boolean addFollowing(String userid); //Admin function to add followers
}


