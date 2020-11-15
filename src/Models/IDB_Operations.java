package Models;


import com.google.firebase.database.utilities.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IDB_Operations {
    public static Boolean PRINTLN_ENABLED = false;

    void initDB() throws IOException;

    IModel getObject(String objectId, ModelType modelType) throws Exception; //returns object with key == objectId

    ArrayList<IModel> getObjectsList(ArrayList<String> objectIds, ModelType modelType) throws Exception; //returns objects list with keys matching objectIds

    ArrayList<IModel> getObjectsList(HashMap<String, Object> attributesToQuery, ModelType modelType) throws Exception; //returns objects list with attributesToQuery Condition


    String addObject(IModel object, ModelType modelType) throws Exception;   //returns objectId of new created object

    boolean removeObject(String objectId, ModelType modelType) throws Exception;  //removes object , and returns boolean

    /*
       updateObject supports any number of Attribute Overwrite operations on a single object at a time
    */
    boolean updateObject(String objectId, HashMap<String, Object> attributesToBeUpdated, ModelType modelType) throws Exception;  //fo update variable(s) operations

    /*
    updateArrayObject supports only one Add/Remove Operation on only one Array (of an object) at a time
     */
    boolean updateArrayObject(String objectId, Pair<String, Object> arrayAttributeToBeUpdated, UpdateOperation updateOperation, ModelType modelType) throws Exception; //for update Array operation

    enum ModelType {
        Comment,
        Like,
        Notification,
        Post,
        User
    }

    enum UpdateOperation {
        Add,
        Remove
    }
}