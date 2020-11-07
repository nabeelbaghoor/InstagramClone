package Combination;

import Models.Factory;
import Models.IUI;
import Models.Operations;

public class Main {
    public static void main(String[] args) {
        Factory func = new Factory();
        Operations BLOp = func.getOperations();

        IUI UI;
        //UI = func.getUI();
        //UI.setOperations(BLOp);
        //UI.start();
    }
}
