package BL;

import DB_Firebase.DB_FirebaseOperations;
import Models.IDB_Operations;

import java.io.IOException;

public class Layers {
    public static IDB_Operations DBLayer = new DB_FirebaseOperations();

    public Layers() {
        try {
            DBLayer.initDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
