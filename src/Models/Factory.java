package Models;

import BL.BLOperations;
import DB_Firebase.DB_FirebaseOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Factory {
    public Factory(){

    }

    public Operations getOperations(){
        IDB_Operations DB = getDB();
        String ID = getID();
        Operations op = new BLOperations(DB,ID);

        return op;
    }

    IDB_Operations getDB(){
        Properties prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("\\..\\Models\\Layer.cfg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (ip != null) {
            try {
                prop.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String DBType = prop.getProperty("Database");
            if (DBType.equals("Firebase"))
                return new DB_FirebaseOperations();
            //else if (DBType.equals("Text"))
            //    return new dbtext();
        }

        return null;
    }

    String getID(){
        Properties prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("\\..\\Models\\Layer.cfg");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (ip != null) {
            try {
                prop.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String id = prop.getProperty("Default_ID");
            return id;
            //else if (DBType.equals("Text"))
            //    return new dbtext();
        }
        return null;
    }

    public IUI getUI(){
        Properties prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("\\..\\Models\\Layer.cfg");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (ip != null) {
            try {
                prop.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String UIType = prop.getProperty("User_Interface");
            //if (UIType.equals("Graphical"))
            //    return new DB_FirebaseOperations();
            //else if (DBType.equals("Console"))
            //    return new dbtext();
        }
        return null;
    }

}

