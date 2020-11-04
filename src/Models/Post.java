package Models;

import java.util.Vector;

public class Post {
    public String postID;
    public String myID;
    public Vector<String> likedBy;

    public Post(){
        postID = "";
        myID = "";
        likedBy = new Vector<>();
    }
}
