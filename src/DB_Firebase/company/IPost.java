package DB_Firebase.company;

import BL.src.instaclone.Post;

import java.util.concurrent.ExecutionException;

public interface IPost extends IDBOperations {
    public Post getPost(String postId) throws ExecutionException, InterruptedException;
    public String addPost(Post post) throws ExecutionException, InterruptedException;
    public boolean removePost(String postId);
    public boolean updatePost(String postId,Post post);
}
