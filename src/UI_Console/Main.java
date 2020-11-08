package UI_Console;

import Models.Factory;
import Models.Operations;
import Models.Post;
import Models.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Factory func = new Factory();
        Operations operations = func.getOperations();

        //get User Object, user's Info
        User user = operations.getMyProfile();
        user.print();

        /*Caution:
        Please add meaningful and valid Posts :))   */

        //add a post by current(Logged in) user
        operations.addPost(".\\Images\\s.png",
                "Always bear in mind that your own resolution to succeed is more important than any other.");


        //get current(Logged in) user posts
        ArrayList<Post> posts = operations.getNewsFeedPosts(user.getID());
        for(Post post: posts){
            post.print();
        }

        //edit current(Logged in) user's Profile
        user.print();   //user data before edit
        user.phoneNumber = "00000000000";
        user.username = "nabeelhassan";
        operations.editUserData(user);

        user = operations.getMyProfile();
        user.print();   //user data after edit

    }
}