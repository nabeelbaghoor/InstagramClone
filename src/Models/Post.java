package Models;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Post implements IModel {
    //postid,userid,imagePath(only one enough),dateTime(timstamp),likesList(ids only),commentsList(ids only),
    //  no tagsList(ids only),as no use case for it, and no search feature,so no tagging
    //post description/text
    public String postId;
    public String userId;
    public String imagePath;    //only one image allowed
    public String postText;
    public ArrayList<String> likesList; //list of likeId's
    public ArrayList<String> commentsList; //list of commentId's
    public Timestamp timestamp;

    public Post() {
    }

    public Post(String _postId, String _userId, String _imagePath, String _postText, ArrayList<String> _likesList,
                ArrayList<String> _commentsList, Timestamp _timestamp) {
        postId = _postId;
        userId = _userId;
        imagePath = _imagePath;
        likesList = _likesList;
        commentsList = _commentsList;
        timestamp = _timestamp;
        postText = _postText;
    }

    public String getID() {
        return postId;
    }

    public void setID(String _postId) {
        postId = _postId;
    }

    @Override
    public void setTimestamp(java.sql.Timestamp _timestamp) {
        timestamp = _timestamp;
    }
}
