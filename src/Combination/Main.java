package Combination;

import Models.Factory;
import Models.IUI;
import Models.Operations;
import Models.User;
import UI_Swing.GUI;

public class Main {
    public static void main(String[] args) {
        Factory func = new Factory();
        Operations BLOp = func.getOperations();

        //BLOp.addPost("C:\\1.jpeg","Testing Add Post");
        //BLOp.removePost("DHpxRsyjT2M4heFBN6UL");
        User temp = BLOp.getMyProfile();
        //temp.imagePath = "file:"+temp.imagePath;
/*        temp.imagePath = ".\\Images\\brackeys.png";
        try {
            BLOp.editUserData(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        System.out.println("Done");
        IUI UI;
        UI = new GUI();
        UI.start(BLOp);
        //UI = func.getUI();
        //UI.setOperations(BLOp);
        //UI.start();
    }
}
