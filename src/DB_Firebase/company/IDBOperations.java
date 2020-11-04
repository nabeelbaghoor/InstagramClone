package DB_Firebase.company;

import BL.src.instaclone.*;
import Models.User;

import java.util.concurrent.ExecutionException;

public interface IDBOperations {
    //IUser
    public User getUser(String userId) throws ExecutionException, InterruptedException; //returns User object with key == userid
    public String addUser(User user) throws ExecutionException, InterruptedException;   //returns userid of new created user
    public boolean removeUser(String userId);  //removes user , and returns boolean
    public boolean updateUser(String userId,User user); //overwrites the user with key == usserid

    //ILike
    public Like getLike(String likeId) throws ExecutionException, InterruptedException;
    public String addLike(Like like) throws ExecutionException, InterruptedException;
    public boolean removeLike(String likeId);
    public boolean updateLike(String likeId,Like like);

    //IPost
    public Post getPost(String postId) throws ExecutionException, InterruptedException;
    public String addPost(Post post) throws ExecutionException, InterruptedException;
    public boolean removePost(String postId);
    public boolean updatePost(String postId,Post post);

    //IProfile
    public Profile getProfile(String profileId) throws ExecutionException, InterruptedException;
    public String addProfile(Profile profile) throws ExecutionException, InterruptedException;
    public boolean removeProfile(String profileId);
    public boolean updateProfile(String profileId,Profile profile);

    //IComment
    public Comment getComment(String commentId) throws ExecutionException, InterruptedException;
    public String addComment(Comment comment) throws ExecutionException, InterruptedException;
    public boolean removeComment(String commentId);
    public boolean updateComment(String commentId,Comment comment);
}