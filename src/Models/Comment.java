package Models;

import java.sql.Timestamp;

public class Comment implements IModel {
//text,userid,commentid,datetime(timestamp mb by firebase),no postId

    public String commentId;
    public String userId;
    public String commentText;
    public Timestamp timestamp; //db will initialize it,when creating

    public Comment() {
    }

    public Comment(String _commentId, String _userId, String _commentText, Timestamp _timestamp) {
        commentId = _commentId;
        userId = _userId;
        commentText = _commentText;
        timestamp = _timestamp;
    }

    public String getID() {
        return commentId;
    }

    public void setID(String _commentId) {
        commentId = _commentId;
    }
}
