package Models;

import java.util.Vector;

public class Post implements IModel{
    public String postID;
    public String myID;
    public Vector<String> likedBy;
    public Post(){

    }
    public Post(String _postID,String _myID,Vector<String> _likedBy){
        postID = _postID;
        myID = _myID;
        likedBy = _likedBy;
    }

    public String getID(){return postID;}

    public void setID(String id){postID = id; }
}
