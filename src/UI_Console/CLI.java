package UI_Console;

import Models.IUI;
import Models.Operations;
import Models.Post;
import Models.User;

import java.text.SimpleDateFormat;
import java.util.*;

public class CLI implements IUI {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public void start(Operations operations) throws Exception {

        Scanner scanner = new Scanner(System.in);
        //get User Object, user's Info
        User user = operations.getMyProfile();

        System.out.println("Welcome to Instagram");
        System.out.println();
        //System.out.println("Enter 1 or 2");
        System.out.println("1. Command Line Interface");
        //System.out.println("2. Select Option Interface");
        //String input = scanner.nextLine();
        String input = "1";

        if (input.equals("1")) {
            System.out.println("You choose Command Line Interface");

            System.out.println("Type in a command or to get help about command use 'man cli'");

            while (!input.equals("exit")) {
                System.out.print(">>");

                input = scanner.nextLine();

                if (input.equals("man cli")) {

                    System.out.println("List of Possible commands");
                    System.out.println();


                    //1
                    System.out.println("removefollower <UserId> ");
                    System.out.println();

                    //2
                    System.out.println("viewfollowlist ");
                    System.out.println();

                    //3
                    System.out.println("likepost <PostId> ");
                    //3.1
                    System.out.println("unlikepost <PostId> ");
                    System.out.println();


                    //4
                    System.out.println("sharepost <PostId> <UserId> ");
                    System.out.println();

                    //5
                    System.out.println("editprofile username");
                    System.out.println("editprofile emailaddress");
                    System.out.println("editprofile firstname");
                    System.out.println("editprofile lastname");
                    System.out.println("editprofile gender");
                    System.out.println("editprofile phonenumber");
                    System.out.println("editprofile dateofbirth");
                    System.out.println("editprofile website");
                    System.out.println("editprofile bio");
                    //5.1
                    System.out.println("viewprofile ");
                    System.out.println();

                    //6
                    System.out.println("blockuser <UserId> ");
                    //6.1
                    System.out.println("unblockuser <UserId> ");
                    //6.2
                    System.out.println("viewblocklist ");
                    System.out.println();

                    //7
                    System.out.println("removepost <PostId> ");
                    System.out.println();

                    //8
                    System.out.println("addpost ");
                    System.out.println();

                    //9
                    System.out.println("follow <UserId> ");
                    System.out.println();

                    //10
                    System.out.println("unfollow <UserId> ");
                    System.out.println();

                    //11
                    System.out.println("viewnewsfeed ");
                    //11.1
                    System.out.println("viewmyposts ");
                    System.out.println();

                    //12
                    System.out.println("comment <PostId> ");
                    System.out.println();

                    System.out.println("exit");

                } else if (input.equals("removefollower")) {
                    System.out.print("Enter UserID : ");
                    input = scanner.nextLine();
                    if(operations.removeFollower(input)) {
                        System.out.println(ANSI_GREEN + "User Removed!" + ANSI_RESET);

                    }else {
                        System.out.println(ANSI_RED + "UserId Incorrect or Does not Exist in Follow List" + ANSI_RESET);
                    }
                } else if (input.equals("viewfollowlist")) {
                    System.out.print("Your Followers : ");
                    HashMap<String,String> followlist = operations.getFollowers();
                    if(followlist == null)
                    {
                        System.out.println("0");
                    }
                    else {
                        System.out.println(followlist.size());
                        System.out.println(Collections.singletonList(followlist));
                    }

                } else if (input.equals("likepost")){
                    System.out.print("Enter PostId : ");
                    input = scanner.nextLine();
                    System.out.print("Author UserId : ");
                    String otheruser = scanner.nextLine();

                    if(operations.likePost(input,otheruser)){
                        System.out.println(ANSI_GREEN + "Liked" + ANSI_RESET);

                    }else {
                        System.out.println(ANSI_RED + "PostID Incorrect or Does not Exist" + ANSI_RESET);
                    }
                } else if (input.equals("unlikepost")){
                    System.out.print("Enter PostId : ");
                    input = scanner.nextLine();
                    System.out.print("Author UserId : ");
                    String otheruser = scanner.nextLine();
                    if(operations.unlikePost(input,otheruser)){
                        System.out.println(ANSI_GREEN + "UnLiked" + ANSI_RESET);

                    }else {
                        System.out.println(ANSI_RED + "PostID Incorrect or Does not Exist" + ANSI_RESET);
                    }
                } else if (input.equals("sharepost")){
                    System.out.print("Enter PostId : ");
                    input = scanner.nextLine();
                    System.out.print("Enter UserId to Share : ");
                    String shareto;
                    shareto = scanner.nextLine();
                    if(operations.likePost(input,shareto)){
                        System.out.println(ANSI_GREEN + "Shared" + ANSI_RESET);

                    }else {
                        System.out.println(ANSI_RED + "PostID/UserId Incorrect or Does not Exist" + ANSI_RESET);
                    }
                } else if (input.equals("editprofile")) {

                    System.out.println(ANSI_RED + "Argument not found (required field argument for editing profile)" + ANSI_RESET);

                } else if (input.equals("editprofile username")) {
                    System.out.println("Current username = " + user.username);
                    System.out.print("Enter new username : ");
                    input = scanner.nextLine();
                    user.username = input;
                    operations.editUserData(user);

                } else if (input.equals("editprofile emailaddress")) {
                    System.out.println("Current emailAddress = " + user.emailAddress);
                    System.out.print("Enter new emailAddress : ");
                    input = scanner.nextLine();
                    user.emailAddress = input;
                    operations.editUserData(user);

                } else if (input.equals("editprofile firstname")) {
                    System.out.println("Current firstName = " + user.firstName);
                    System.out.print("Enter new firstName : ");
                    input = scanner.nextLine();
                    user.firstName = input;
                    operations.editUserData(user);

                } else if (input.equals("editprofile lastname")) {
                    System.out.println("Current lastName = " + user.lastName);
                    System.out.print("Enter new lastName : ");
                    input = scanner.nextLine();
                    user.lastName = input;
                    operations.editUserData(user);

                } else if (input.equals("editprofile gender")) {
                    System.out.println("Current gender = " + user.gender);
                    System.out.print("Enter new gender : ");
                    input = scanner.nextLine();
                    user.gender = input;
                    operations.editUserData(user);

                } else if (input.equals("editprofile phonenumber")) {
                    System.out.println("Current phoneNumber = " + user.phoneNumber);
                    System.out.print("Enter new phoneNumber : ");
                    input = scanner.nextLine();
                    user.phoneNumber = input;
                    operations.editUserData(user);

                } else if (input.equals("editprofile dateofbirth")) {
                    System.out.println("Current dateOfBirth = " + user.dateOfBirth);
                    System.out.print("Enter new dateOfBirth ");
                    System.out.print("dd-mm-yyyy :");
                    input = scanner.nextLine();
                    Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(input);
                    user.dateOfBirth=date1;
                    operations.editUserData(user);

                } else if (input.equals("editprofile website")) {
                    System.out.println("Current website = " + user.website);
                    System.out.print("Enter new website : ");
                    input = scanner.nextLine();
                    user.website = input;
                    operations.editUserData(user);

                } else if (input.equals("editprofile bio")) {
                    System.out.println("Current bio = " + user.bio);
                    System.out.print("Enter new bio : ");
                    input = scanner.nextLine();
                    user.bio = input;
                    operations.editUserData(user);

                } else if (input.equals("viewprofile")) {
                    user.print();

                } else if (input.equals("blockuser")){
                    System.out.print("Enter UserId : ");
                    input = scanner.nextLine();
                    if(operations.blockUser(input)){
                        System.out.println(ANSI_GREEN + "Blocked!" + ANSI_RESET);

                    }else {
                        System.out.println(ANSI_RED + "UserId Incorrect or Does not Exist" + ANSI_RESET);
                    }
                } else if (input.equals("unblockuser")){
                    System.out.print("Enter UserId : ");
                    input = scanner.nextLine();
                    if(operations.unblockUser(input)){
                        System.out.println(ANSI_GREEN + "UnBlocked!" + ANSI_RESET);

                    }else {
                        System.out.println(ANSI_RED + "UserId Incorrect or Does not Exist" + ANSI_RESET);
                    }
                } else if (input.equals("viewblocklist")) {
                    System.out.print("Your BlockList : ");
                    HashMap<String,String> blocklist = operations.getBlocked();
                    if(blocklist == null)
                    {
                        System.out.println("0");
                    }
                    else {
                        System.out.println(blocklist.size());
                        System.out.println(Collections.singletonList(blocklist));
                    }

                } else if (input.equals("removepost")){
                    System.out.print("Enter PostId : ");
                    input = scanner.nextLine();
                    if(operations.removePost(input)){
                        System.out.println(ANSI_GREEN + "Post Deleted!" + ANSI_RESET);

                    }else {
                        System.out.println(ANSI_RED + "PostId Incorrect or Does not Exist or You are not the Author" + ANSI_RESET);
                    }
                } else if (input.equals("addpost")) {
                    System.out.println("Enter absolute path of image in localhost");
                    System.out.print("Enter Post text : ");
                    input = scanner.nextLine();
                    System.out.print("Enter image URL : ");
                    String input2 = scanner.nextLine();
                    operations.addPost(input2, input);

                } else if (input.equals("follow")){
                    System.out.print("Enter UserId : ");
                    input = scanner.nextLine();
                    if(operations.followUser(input)){
                        System.out.println(ANSI_GREEN + "User Followed!" + ANSI_RESET);

                    }else {
                        System.out.println(ANSI_RED + "UserId Incorrect or Does not Exist" + ANSI_RESET);
                    }
                } else if (input.equals("unfollow")){
                    System.out.print("Enter UserId : ");
                    input = scanner.nextLine();
                    if(operations.unblockUser(input)){
                        System.out.println(ANSI_GREEN + "User UnFollowed!" + ANSI_RESET);

                    }else {
                        System.out.println(ANSI_RED + "UserId Incorrect or Does not Exist" + ANSI_RESET);
                    }
                } else if (input.equals("viewnewsfeed")) {

                    ArrayList<Post> feed = operations.getNewsFeedPosts();
                    for(int i=0;i<feed.size();i++){
                        System.out.println("User: "+ feed.get(i).userId);
                        System.out.println("Time: "+ feed.get(i).timestamp);
                        System.out.println("postId: "+ feed.get(i).postId);
                        System.out.println("Image: "+ feed.get(i).imagePath);
                        System.out.println("Text: "+ feed.get(i).postText);
                        System.out.print("Likes: ");
                        if(feed.get(i).likesList==null){
                            System.out.print("0");
                        }
                        else {
                            System.out.print(feed.get(i).likesList.size());
                        }

                        System.out.print("       Comments: ");
                        if(feed.get(i).commentsList==null) {
                            System.out.print("0");

                        }
                        else {
                            System.out.print(feed.get(i).commentsList.size());
                        }
                        System.out.println("\n\n");

                    }


                } else if (input.equals("comment")){
                    System.out.print("Enter PostId : ");
                    input = scanner.nextLine();
                    System.out.print("Enter Text : ");
                    String comtext;
                    comtext = scanner.nextLine();
                    if(operations.addComment(input,comtext)){
                        System.out.println(ANSI_GREEN + "Your Comment is Posted" + ANSI_RESET);

                    }else {
                        System.out.println(ANSI_RED + "PostId Incorrect or Does not Exist" + ANSI_RESET);
                    }
                } else if (input.equals("exit")) {
                    System.out.println(ANSI_GREEN + "Thank You for using our Service" + ANSI_RESET);
                    System.out.println(ANSI_RED + "Exiting Instagram!" + ANSI_RESET);


                } else {
                    System.out.println(ANSI_RED + "Invalid Command!" + ANSI_RESET);

                }

            }

        } else if (input.equals("2")) {
            System.out.println("your choose Select Option Interface");

        } else {
            System.out.println("Wrong Input");

        }


    }


}
