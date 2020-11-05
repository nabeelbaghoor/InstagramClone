package BL;

import DB_Firebase.company.DB_FirebaseOperations;
import DB_Firebase.company.IDB_FirebaseOperations;

public interface Layers {
    IDB_FirebaseOperations DBLayer = new DB_FirebaseOperations();
}
