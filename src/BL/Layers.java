package BL;

import DB_Firebase.company.DB_FirebaseOperations;
import Models.IDB_Operations;

public interface Layers {
    IDB_Operations DBLayer = new DB_FirebaseOperations();
}
