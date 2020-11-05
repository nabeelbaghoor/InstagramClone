package DB_Firebase.company;

import Models.IModel;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public interface IDB_FirebaseOperations {
    public IModel getObject(String objectId, ModelType modelType) throws ExecutionException, InterruptedException; //returns object with key == objectId
    public IModel getObjectsList(HashMap<String,String> objectIds, ModelType modelType) throws ExecutionException, InterruptedException; //returns objects list with keys matching objectIds
    public String addObject(IModel object,ModelType modelType) throws ExecutionException, InterruptedException;   //returns objectId of new created object
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