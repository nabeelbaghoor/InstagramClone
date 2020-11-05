package Models;

import java.sql.Timestamp;

//Yaar isko delete kr lete. Iski zrorat nhi.
public class Like implements IModel {

    //userid,likeid,datetime(timestamp mb by firebase),no postid
    public String likeId;
    public String userId;
    public Timestamp timestamp; //db will initialize it,when creating

    public Like() {
    }

    public Like(String _likeId, String _userId, Timestamp _timestamp) {
        likeId = _likeId;
        userId = _userId;
        timestamp = _timestamp;
    }

    public String getID() {
        return likeId;
    }

    public void setID(String id) {
        likeId = id;
    }
}
