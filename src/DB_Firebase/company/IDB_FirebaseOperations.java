package DB_Firebase.company;

import Models.IModel;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public interface IDB_FirebaseOperations {
    public static void initFirebase() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream(".\\instagramclone-58441-firebase-adminsdk-taebo-2cba3bad0c.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        //.setDatabaseUrl("https://instagramclone-58441.firebaseio.com")

        FirebaseApp.initializeApp(options);
    }
    public IModel getObject(String objectId, ModelType modelType) throws ExecutionException, InterruptedException; //returns object with key == objectId
    public ArrayList<IModel> getObjectsList(ArrayList<String> objectIds, ModelType modelType) throws ExecutionException, InterruptedException; //returns objects list with keys matching objectIds
    public String addObject(IModel object,ModelType modelType) throws ExecutionException, InterruptedException;   //returns objectId of new created object
    public boolean removeObject(String objectId,ModelType modelType) throws ExecutionException, InterruptedException;  //removes object , and returns boolean
    public boolean updateObject(String objectId,HashMap<String,String> attributesToBeUpdated,ModelType modelType); //overwrites the object with key == objectId

    enum ModelType {
        Comments,
        Likes,
        Notifications,
        Posts,
        Users
    }
}