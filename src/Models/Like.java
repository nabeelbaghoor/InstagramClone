package Models;

import com.google.cloud.Timestamp;

public class Like implements IModel {
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

    @Override
    public void setTimestamp(com.google.cloud.Timestamp _timestamp) {
        timestamp = _timestamp;
    }

    @Override
    public void print() {
        System.out.println("likeId = " + likeId + "\n");
        System.out.println("userId = " + userId + "\n");
        System.out.println("timestamp = " + timestamp.toString() + "\n");

        System.out.println("-----------------------------------------------------------------" + "\n");
    }

}
