package Models;

public class Comment implements IModel{
    public String text;
    public String postID;
    public String userid;
    public String commentid;

    public  Comment(){
        text = "";
        postID = "";
        userid = "";
        commentid = "";
    }

    public String getID(){return commentid;}

    public void setID(String id){commentid = id; }
}
