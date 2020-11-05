package Models;

import java.util.ArrayList;

public class Post implements IModel{
    //postid,userid,imagePath(only one enough),dateTime(timstamp),likesList(ids only),commentsList(ids only),
    //  no tagsList(ids only),as no use case for it, and no search feature,so no tagging
    //post desvcription/text


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
