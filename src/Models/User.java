package Models;

import com.google.cloud.Timestamp;

import java.util.ArrayList;
import java.util.Date;

public class User implements IModel {
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

        notificationList= new ArrayList<String>();
        postList= new ArrayList<String>();
        followingsList= new ArrayList<String>();
        blockedUsersList= new ArrayList<String>();
        followersList = new ArrayList<String>();
    }

    public String getID() {
        return userId;
    }

    public void setID(String _userId) {
        userId = _userId;
    }

    @Override
    public void setTimestamp(com.google.cloud.Timestamp _timestamp) {
        timestamp = _timestamp;
    }

    @Override
    public void print() {

        System.out.println("userId = " + userId);
        System.out.println("username = " + username);
        System.out.println("emailAddress = " + emailAddress);
        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);
        System.out.println("gender = " + gender);
        System.out.println("phoneNumber = " + phoneNumber);
        System.out.println("dateOfBirth = " + dateOfBirth.toString());
        System.out.println("website = " + website);
        System.out.println("dateOfBirth = " + dateOfBirth.toString());
        System.out.println("bio = " + bio);
        System.out.println("timestamp = " + timestamp.toString());
        System.out.println("imagePath = " + imagePath);
        System.out.println("dateOfBirth = " + dateOfBirth.toString());
        System.out.println("followersList = ");
        if (followersList != null) {
            for (String follower : followersList) {
                System.out.println("\t" + follower + " ,");
            }
        }
        System.out.println("blockedUsersList = ");
        if (blockedUsersList != null) {
            for (String blocked : blockedUsersList) {
                System.out.println("\t" + blocked + " ,");
            }
        }
        System.out.println("followingsList = ");
        if (followingsList != null) {
            for (String following : followingsList) {
                System.out.println("\t" + following + " ,");
            }
        }
        System.out.println("postList = ");
        if (postList != null) {
            for (String post : postList) {
                System.out.println("\t" + post + " ,");
            }
        }
        System.out.println("notificationList = ");
        if (notificationList != null) {
            for (String notification : notificationList) {
                System.out.println("\t" + notification + " ,");
            }
        }
        System.out.println("-----------------------------------------------------------------" + "\n");
    }
}
