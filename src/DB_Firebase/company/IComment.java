package DB_Firebase.company;

import BL.src.instaclone.Comment;

import java.util.concurrent.ExecutionException;

public interface IComment extends IDBOperations {
    public Comment getComment(String commentId) throws ExecutionException, InterruptedException;
    public String addComment(Comment comment) throws ExecutionException, InterruptedException;
    public boolean removeComment(String commentId);
    public boolean updateComment(String commentId,Comment comment);
}
