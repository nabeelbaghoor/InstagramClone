package Models;

import com.google.cloud.Timestamp;

public class Comment implements IModel {
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

    @Override
    public void setTimestamp(com.google.cloud.Timestamp _timestamp) {
        timestamp = _timestamp;
    }
}
