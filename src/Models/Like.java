package Models;

public class Like implements IModel{
    public String likeID;
    public String postID;
    public String userID;

    public Like(){

    }
    public Like(String _likeID,String _postID,String _userID){
        postID = _likeID;
        likeID = _postID;
        userID = _userID;
    }

    public void setID(String id){likeID = id; }

    public String getID(){return likeID; }
}
