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

        System.out.println("userId = " + userId + "\n");
        System.out.println("username = " + username + "\n");
        System.out.println("emailAddress = " + emailAddress + "\n");
        System.out.println("firstName = " + firstName + "\n");
        System.out.println("lastName = " + lastName + "\n");
        System.out.println("gender = " + gender + "\n");
        System.out.println("phoneNumber = " + phoneNumber + "\n");
        System.out.println("dateOfBirth = " + dateOfBirth.toString() + "\n");
        System.out.println("website = " + website + "\n");
        System.out.println("dateOfBirth = " + dateOfBirth.toString() + "\n");
        System.out.println("bio = " + bio + "\n");
        System.out.println("timestamp = " + timestamp.toString() + "\n");
        System.out.println("imagePath = " + imagePath + "\n");
        System.out.println("dateOfBirth = " + dateOfBirth.toString() + "\n");
        System.out.println("followersList = " + "\n");
        for(String follower : followersList){
            System.out.println("\t" + follower + " ,\n");
        }
        System.out.println("blockedUsersList = " + "\n");
        for(String blocked : blockedUsersList){
            System.out.println("\t" + blocked + " ,\n");
        }
        System.out.println("followingsList = " + "\n");
        for(String following : followingsList){
            System.out.println("\t" + following + " ,\n");
        }
        System.out.println("postList = " + "\n");
        for(String post : postList){
            System.out.println("\t" + post + " ,\n");
        }
        System.out.println("notificationList = " + "\n");
        for(String notification : notificationList){
            System.out.println("\t" + notification + " ,\n");
        }
        System.out.println("-----------------------------------------------------------------" + "\n");
    }
}
