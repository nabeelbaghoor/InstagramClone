package UI_Console;

import Models.IUI;
import Models.Operations;
import Models.User;

import java.util.Scanner;

public class CLI implements IUI {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public void start(Operations operations){

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

        if(input.equals("1"))
        {
            System.out.println("You choose Command Line Interface");

            System.out.println("Type in a command or to get help about command use 'man cli'");

            while(!input.equals("exit")){
                System.out.print(">>");

                input = scanner.nextLine();

                if(input.equals("man cli")){

                    System.out.println("List of Possible commands");
                    System.out.println();
                    System.out.println("Edit Profile:");

                    System.out.println("editprofile username");
                    System.out.println("editprofile emailAddress");
                    System.out.println("editprofile firstName");
                    System.out.println("editprofile lastName");
                    System.out.println("editprofile gender");
                    System.out.println("editprofile phoneNumber");
                    System.out.println("editprofile dateOfBirth");
                    System.out.println("editprofile website");
                    System.out.println("editprofile bio");
                    System.out.println();
                    System.out.println("Add Post:");
                    System.out.println("addpost ");
                    System.out.println();
                    System.out.println("View Your Profile: ");

                    System.out.println("viewprofile ");
                    System.out.println();
                    System.out.println("Exit Instagram:");

                    System.out.println("exit");

                }
                else if(input.equals("editprofile")){

                    System.out.println(ANSI_RED + "Argument not found (required field argument for editing profile)" + ANSI_RESET);

                }
                else if(input.equals("editprofile username")){
                    System.out.println("Current username = " + user.username);
                    System.out.print("Enter new username : ");
                    input = scanner.nextLine();
                    user.username = input;


                }else if(input.equals("editprofile emailAddress")){
                    System.out.println("Current emailAddress = " + user.emailAddress);
                    System.out.print("Enter new emailAddress : ");
                    input = scanner.nextLine();
                    user.emailAddress = input;

                }else if(input.equals("editprofile firstName")){
                    System.out.println("Current firstName = " + user.firstName);
                    System.out.print("Enter new firstName : ");
                    input = scanner.nextLine();
                    user.firstName = input;

                }else if(input.equals("editprofile lastName")){
                    System.out.println("Current lastName = " + user.lastName);
                    System.out.print("Enter new lastName : ");
                    input = scanner.nextLine();
                    user.lastName = input;

                }else if(input.equals("editprofile gender")){
                    System.out.println("Current gender = " + user.gender);
                    System.out.print("Enter new gender : ");
                    input = scanner.nextLine();
                    user.gender = input;

                }else if(input.equals("editprofile phoneNumber")){
                    System.out.println("Current phoneNumber = " + user.phoneNumber);
                    System.out.print("Enter new phoneNumber : ");
                    input = scanner.nextLine();
                    user.phoneNumber = input;

                }else if(input.equals("editprofile dateOfBirth")){
                    System.out.println("Current dateOfBirth = " + user.dateOfBirth);
                    System.out.print("Enter new dateOfBirth : ");
                    input = scanner.nextLine();
                    //user.dateOfBirth = input;

                }else if(input.equals("editprofile website")){
                    System.out.println("Current website = " + user.website);
                    System.out.print("Enter new website : ");
                    input = scanner.nextLine();
                    user.website = input;

                }else if(input.equals("editprofile bio")){
                    System.out.println("Current bio = " + user.bio);
                    System.out.print("Enter new bio : ");
                    input = scanner.nextLine();
                    user.bio = input;

                }else if(input.equals("addpost")){
                    System.out.println("Default Photo location = "+user.imagePath);
                    System.out.print("Enter Post text : ");
                    input = scanner.nextLine();
                    System.out.print("Enter Post URL : ");
                    String input2 = scanner.nextLine();
                    operations.addPost(input2,input);

                }else if(input.equals("viewprofile")){
                    user.print();

                }else if(input.equals("exit")){
                    System.out.println(ANSI_GREEN + "Thank You for using our Service" + ANSI_RESET);
                    System.out.println(ANSI_RED + "Exiting Instagram!" + ANSI_RESET);


                }else{
                    System.out.println(ANSI_RED + "Invalid Command!" + ANSI_RESET);

                }

            }

        }
        else if (input.equals("2"))
        {
            System.out.println("your choose Select Option Interface");

        }
        else{
            System.out.println("Wrong Input");

        }



    }


}
