package Models;
import java.util.ArrayList;

public class User implements IModel{

    /*
    //as on page,USerOperations
    UserService should implement two functions
    isHeFollower()
    isHeFollowing()
    will help in showing buttons state
     */

    /*
    There should be a model,which stores current user.
    String static userid
    static User ref
    on creating,will load,
    (in contructor)
    {
    read userid from cinfig file
    get user object from memory
    }
    configuration file will contain this userid
     */
//usrid,username,email,Name,gender,phoneNumber,dateOfbirth,profileCreatedDateTime(Timedstamp),website,bio,
    //ImagePath(only one image enough),image name is userid
    //followingList,followersList,blockedUsersList,
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
