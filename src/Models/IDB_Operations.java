package Models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public interface IDB_Operations {
    void initDB() throws IOException;

    IModel getObject(String objectId, ModelType modelType) throws ExecutionException, InterruptedException; //returns object with key == objectId

    ArrayList<IModel> getObjectsList(ArrayList<String> objectIds, ModelType modelType) throws ExecutionException, InterruptedException; //returns objects list with keys matching objectIds

    String addObject(IModel object, ModelType modelType) throws ExecutionException, InterruptedException;   //returns objectId of new created object

    boolean removeObject(String objectId, ModelType modelType) throws ExecutionException, InterruptedException;  //removes object , and returns boolean

    boolean updateObject(String objectId, HashMap<String, String> attributesToBeUpdated, ModelType modelType); //overwrites the object with key == objectId

    enum ModelType {
        Comments,
        Likes,
        Notifications,
        Posts,
        Users
    }
}