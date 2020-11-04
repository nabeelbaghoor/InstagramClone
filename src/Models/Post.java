package Models;

import java.util.Vector;

public class Post implements IModel{
    public String postID;
    public String myID;
    public Vector<String> likedBy;

    public Post(){
        postID = "";
        myID = "";
        likedBy = new Vector<>();
    }

    public String getID(){return postID;}

    public void setID(String id){postID = id; }
}
