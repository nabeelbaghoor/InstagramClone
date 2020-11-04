package Models;

import java.util.Date;
import java.util.Vector;

public class Post implements IModel{
    public String postID;
    public String myID;
    public Vector<String> likedBy;
    public Vector<String> commentID;
    public Date postDate;

    public Post(){
        postID = "";
        myID = "";
        likedBy = new Vector<>();
        commentID = new Vector<>();
        postDate = new Date();
    }

    public String getID(){return postID;}

    public void setID(String id){postID = id; }
}
