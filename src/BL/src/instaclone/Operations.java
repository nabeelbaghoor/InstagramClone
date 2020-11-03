
package instaclone;


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
    public String getMyProfile();
    public String getProfileInfo(String userid);
    public String getFollowers();
    public String getBlocked();
    public String getFollowing();
    public boolean addFollowing(String userid); //Admin function to add followers
}
