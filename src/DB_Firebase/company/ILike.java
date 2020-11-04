package DB_Firebase.company;

import BL.src.instaclone.Like;

import java.util.concurrent.ExecutionException;

public interface ILike extends IDBOperations {
    public Like getLike(String likeId) throws ExecutionException, InterruptedException;
    public String addLike(Like like) throws ExecutionException, InterruptedException;
    public boolean removeLike(String likeId);
    public boolean updateLike(String likeId,Like like);
}
