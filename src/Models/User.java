package Models;

import java.util.ArrayList;

public class User implements IModel{

    public String myid;
    public String username;
    public ArrayList<String> followers;
    public ArrayList<String> blockedList;
    public ArrayList<String> followingList;
    public User(){

    }
    public User(String _myid, String _username, ArrayList<String> _followers, ArrayList<String> _blockedList, ArrayList<String> _followingList){
        myid = _myid;
        username = _username;
        followers = _followers;
        blockedList = _blockedList;
        followingList = _followingList;
    }

    public String getID(){return myid;}
    public void setID(String id){myid = id; }

}
