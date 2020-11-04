package Models;

import java.util.Vector;

public class User implements IModel{
    public String username;
    public String myid;
    public Vector<String> followers;
    public Vector<String> blockedList;
    public Vector<String> followingList;

    public User(){
        username = "";
        myid = "";
        followers = new Vector<>();
        blockedList = new Vector<>();
        followingList = new Vector<>();
    }

    public String getID(){return myid;}

    public void setID(String id){myid = id; }
}
