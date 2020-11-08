package UI_Console;

import Models.Factory;
import Models.Operations;

public class Main {
    public static void main(String[] args) throws Exception {
        Factory func = new Factory();
        Operations operations = func.getOperations();
        operations.getMyProfile().print();
    }
}