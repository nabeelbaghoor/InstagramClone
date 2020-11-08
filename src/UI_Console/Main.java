package UI_Console;

import Models.Factory;
import Models.Operations;
import Models.Post;
import Models.User;

public class Main {
    public static void main(String[] args) throws Exception {
        Factory func = new Factory();
        Operations operations = func.getOperations();

        //add a post

        //get user posts
        User user = operations.getMyProfile();
        for(Post post: operations.getNewsFeedPosts(user.getID())){
            post.print();
        }
    }
}