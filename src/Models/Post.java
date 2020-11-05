package Models;

import java.util.ArrayList;

public class Post implements IModel{
    public String postID;
    public String myID;
    public ArrayList<String> likedBy;
    public Post(){

    }
    public Post(String _postID,String _myID,ArrayList<String> _likedBy){
        postID = _postID;
        myID = _myID;
        likedBy = _likedBy;
    }

    public String getID(){return postID;}

    public void setID(String id){postID = id; }
}
