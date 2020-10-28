//import com.google.gson.Gson;
//Creating the ObjectMapper object
//ObjectMapper mapper = new ObjectMapper();
//Converting the Object to JSONString
//String jsonString = mapper.writeValueAsString(std);

interface Operation{
    boolean removeFollower(String myid,String userid);
    boolean blockUser(String myid,String userid);
    boolean unblockUser(String myid,String userid);
    boolean followUser(String myid, String userid);
    boolean unfollowUser(String myid, String userid);
    boolean likePost(String myid,String postid);
    boolean unlikePost(String myid,String postid);
    boolean addPost(String myid,String postdata);
    boolean removePost(String myid,String postid);
    boolean sharePost(String myid, String postid, String userid);
    boolean addComment(String myid, String postid, String comtext);
    boolean editUserData(String myid,String data);
    String getNewsFeedPosts(String myid);
    String getMyProfile(String myid);
    String getProfileInfo(String myid,String userid);
    String getFollowers(String myid);
    String getBlocked(String myid);
    String getFollowing(String myid);
    boolean addFollowing(String myid, String userid); //Admin function to add followers
}