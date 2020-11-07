package Models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class User implements IModel {

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
    //userid,username,email,Name,gender,phoneNumber,dateOfBirth,profileCreatedDateTime(Timedstamp),website,bio,
    //ImagePath(only one image enough),image name is userid
    //followingList,followersList,blockedUsersList,
    public String userId;
    public String username;
    public String emailAddress;
    public String firstName;
    public String lastName;
    public String gender;
    public String phoneNumber;
    public Date dateOfBirth;
    public String website;
    public String bio;
    public Timestamp timestamp; //profileCreatedTimestamp
    public String imagePath;    //image Name will basically be the userId

    public ArrayList<String> followersList;
    public ArrayList<String> blockedUsersList;
    public ArrayList<String> followingsList;
    public ArrayList<String> postList;
    public ArrayList<String> notificationList;

    public User() {
    }

    public User(
            String userId,
            String _username,
            String _emailAddress,
            String _firstName,
            String _lastName,
            String _gender,
            String _phoneNumber,
            Date _dateOfBirth,
            String _website,
            String _bio,
            Timestamp _timestamp,
            String _imagePath
    ) {
        username = _username;
        emailAddress = _emailAddress;
        firstName = _firstName;
        lastName = _lastName;
        gender = _gender;
        phoneNumber = _phoneNumber;
        dateOfBirth = _dateOfBirth;
        website = _website;
        bio = _bio;
        timestamp = _timestamp;
        imagePath = _imagePath;
    }

    public String getID() {
        return userId;
    }

    public void setID(String _userId) {
        userId = _userId;
    }

    @Override
    public void setTimestamp(java.sql.Timestamp _timestamp) {
        timestamp = _timestamp;
    }
}
