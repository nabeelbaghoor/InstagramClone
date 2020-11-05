package Models;

public class Comment implements IModel{

    public String commentid;
    public String postID;
    public String userid;
    public String text;

    public Comment(){

    }
    public  Comment(String _commentid,String _postID,String _userid,String _text){
        commentid = _commentid;
        postID = _postID;
        userid = _userid;
        text = _text;
    }

    public String getID(){return commentid;}

    public void setID(String id){
        commentid = id;
    }
}
