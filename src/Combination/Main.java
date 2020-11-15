package Combination;

import BL.FactoryBL;
import Models.IFactoryBL;
import Models.IUI;
import Models.Operations;
import UI_Console.CLI;
import UI_Swing.GUI;

import java.io.*;
import java.util.Properties;

public class Main {
    public static IUI getUI() {
        Properties prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream(".\\src\\Models\\Layer.cfg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (ip != null) {
            try {
                prop.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String UIType = prop.getProperty("User_Interface");
            if (UIType.equals("Graphical"))
                return new GUI();
            else if (UIType.equals("Console"))
                return new CLI();
        }
        return null;
    }
    //use it to disable *every* System.out print output
    /*public static void disablePrintLN(){
        System.setOut(new PrintStream(new OutputStream() {
            public void write(int b) {
                // NO-OP
            }
        }));
    }*/
    public static void main(String[] args) throws Exception {
        IFactoryBL func = new FactoryBL();
        Operations BLOp = func.getOperations();


        //old commented Code
        /*BLOp.removePost("fFvhHPIKbEjZXDyZcqbp");
        BLOp.addPost("C:\\1.jpeg","Testing Add Post");
        BLOp.removePost("DHpxRsyjT2M4heFBN6UL");
        User temp = BLOp.getMyProfile();
        temp.imagePath = "file:"+temp.imagePath;
        temp.imagePath = ".\\Images\\brackeys.png";
        try {
            BLOp.editUserData(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(BLOp.getFollowers());
        System.out.println("Test");
        System.out.println(BLOp.getFollowers());*/
        //BLOp.getNewsFeedPosts();
        //BLOp.removePost("ZSs2xCqBUiCcclmPtqYD");
        //BLOp.removePost("XQNyb6pnBYs9Uxy4ye2L");
        IUI UI = getUI();

        System.out.println("Done");
        //UI = new GUI();
        if (UI != null) {
            UI.start(BLOp);
        }
        //UI = func.getUI();
        //UI.setOperations(BLOp);
        //UI.start();
    }
}
