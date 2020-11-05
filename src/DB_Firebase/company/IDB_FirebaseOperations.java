package DB_Firebase.company;

import Models.Model;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public interface IDB_FirebaseOperations {
    public Model getObject(String objectId, ModelType modelType) throws ExecutionException, InterruptedException; //returns object with key == objectId
    public Model getObjectsList(HashMap<String,String> objectIds, ModelType modelType) throws ExecutionException, InterruptedException; //returns objects list with keys matching objectIds
    public String addObject(Model object,ModelType modelType) throws ExecutionException, InterruptedException;   //returns objectId of new created object
    public boolean removeObject(String objectId,ModelType modelType);  //removes object , and returns boolean
    public boolean updateObject(String objectId,HashMap<String,String> attributesToBeUpdated,ModelType modelType); //overwrites the object with key == objectId

    enum ModelType {
        Comments,
        Likes,
        Notifications,
        Posts,
        Users
    }
}