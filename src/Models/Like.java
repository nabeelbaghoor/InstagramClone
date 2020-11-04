package Models;

public class Like implements IModel{
    public String likeID;
    public String postID;
    public String userID;

    public Like(){
        postID = "";
        likeID = "";
        userID = "";
    }

    public void setID(String id){likeID = id; }

    public String getID(){return likeID; }
}
