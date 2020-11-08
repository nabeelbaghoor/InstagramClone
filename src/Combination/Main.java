package Combination;

import Models.Factory;
import Models.IUI;
import Models.Operations;

public class Main {
    public static void main(String[] args) {
        Factory func = new Factory();
        Operations BLOp = func.getOperations();
//        User curr = BLOp.getMyProfile();
//        curr.lastName = "Hassan";
//
//        try {
//            BLOp.editUserData(curr);
//        } catch (ExecutionException | InterruptedException e) {
//            e.printStackTrace();
//        }

        //BLOp.addPost("C:\\1.jpeg","Testing Add Post");
        //BLOp.removePost("DHpxRsyjT2M4heFBN6UL");
        System.out.println("Done");
        IUI UI;
        //UI = func.getUI();
        //UI.setOperations(BLOp);
        //UI.start();
    }
}
