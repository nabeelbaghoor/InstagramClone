package Models;

import java.util.Vector;

public class User implements IModel{

    public String myid;
    public String username;
    public Vector<String> followers;
    public Vector<String> blockedList;
    public Vector<String> followingList;
    public User(){

    }
    public User(String _myid,String _username,Vector<String> _followers,Vector<String> _blockedList,Vector<String> _followingList){
        myid = _myid;
        username = _username;
        followers = _followers;
        blockedList = _blockedList;
        followingList = _followingList;
    }

    public String getID(){return myid;}
    public void setID(String id){myid = id; }
}
