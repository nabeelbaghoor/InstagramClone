package Models;

import com.google.cloud.Timestamp;

import java.util.ArrayList;

public class Post implements IModel {
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
    public void setTimestamp(com.google.cloud.Timestamp _timestamp) {
        timestamp = _timestamp;
    }

    @Override
    public void print() {
        System.out.println("postId = " + postId + "\n");
        System.out.println("userId = " + userId + "\n");
        System.out.println("imagePath = " + imagePath + "\n");
        System.out.println("postText = " + postText + "\n");
        System.out.println("likesList = " + "\n");
        for(String like : likesList){
            System.out.println("\t" + like + " ,\n");
        }
        System.out.println("commentsList = "  + "\n");
        for(String comment : commentsList){
            System.out.println("\t" + comment + " ,\n");
        }
        System.out.println("timestamp = " + timestamp.toString() + "\n");

        System.out.println("-----------------------------------------------------------------" + "\n");
    }
}
