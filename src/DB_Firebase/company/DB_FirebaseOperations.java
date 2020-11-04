package DB_Firebase.company;

import Models.IModel;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public class DB_FirebaseOperations implements IDB_FirebaseOperations {

    @Override
    public IModel getObject(String objectId,ModelType modelType) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        System.out.println("modelType.toString()"+modelType.toString());
        DocumentReference docRef  = db.collection(modelType.toString()).document(objectId);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            // convert document to User
            IModel _object = document.toObject(IModel.class);//..............ERROR
            System.out.println(_object);
            return _object;
        } else {
            System.out.println("No such document!");
            return null;
        }
    }

    /*Firebase will create documentId(objectId) ,and we will assign it*/
    @Override
    public String addObject(IModel object,ModelType modelType) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        // Add document data after generating an id.
        DocumentReference addedDocRef = db.collection(modelType.toString()).document();
        object.setID(addedDocRef.getId());
        ApiFuture<WriteResult> writeResult = addedDocRef.set(object);
        System.out.println("Successfully updated at: " + writeResult.get().getUpdateTime());
        return  object.getID();
    }

    @Override
    public boolean removeObject(String objectId,ModelType modelType) {

        return false;
    }

    @Override
    public boolean updateObject(String objectId, IModel object,ModelType modelType) {

        return false;
    }
}


 /*   public User getUser(String userid) throws ExecutionException, InterruptedException //returns User object with key == userid
    {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef  = db.collection("Users").document(userid);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            // convert document to User
            User _user = document.toObject(User.class);
            System.out.println(_user);
            return _user;
        } else {
            System.out.println("No such document!");
            return null;
        }
    }
    public String addUser(User user) throws ExecutionException, InterruptedException   //returns userid of new created user
    {
        Firestore db = FirestoreClient.getFirestore();
        // Add document data after generating an id.
        DocumentReference addedDocRef = db.collection("Users").document();
        user.setUserID(addedDocRef.getId());
        ApiFuture<WriteResult> writeResult = addedDocRef.set(user);
        System.out.println("Successfully updated at: " + writeResult.get().getUpdateTime());
        return  user.getUserID();
    }
    public boolean removeUser(String userid)  //removes user , and returns boolean
    {
        return true;
    }
    public boolean updateUser(String userid,User user) //overwrites the user with key == usserid
    {
        return true;
    }*/
