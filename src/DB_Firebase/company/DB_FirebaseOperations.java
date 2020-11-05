package DB_Firebase.company;

import Models.*;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DB_FirebaseOperations implements IDB_FirebaseOperations {

    @Override
    public IModel getObject(String objectId, ModelType modelType) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef  = db.collection(modelType.toString()).document(objectId);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            // convert document to User
            IModel _object = documentToClassType(document,modelType);
            System.out.println(_object);
            return _object;
        } else {
            System.out.println("No such document!");
            return null;
        }
    }
    public IModel documentToClassType(DocumentSnapshot document,ModelType modelType)
    {
        switch (modelType)
        {
            case Likes:
                return document.toObject(Like.class);
            case Posts:
                return document.toObject(Post.class);
            case Users:
                return document.toObject(User.class);
            case Comments:
                return document.toObject(Comment.class);
            case Notifications:
                return document.toObject(Notification.class);
            default:
                return null;
        }
    }
    public ArrayList<IModel> queryDocumentsToClassTypes(List<QueryDocumentSnapshot> documents, ModelType modelType)
    {
        ArrayList<IModel> _objects = new ArrayList<>();
        for (QueryDocumentSnapshot _document : documents) {
            _objects.add(documentToClassType(_document,modelType));
        }
        return _objects;
    }

    /* public Class modelTypeToClassType(ModelType modelType)
    {
        switch (modelType)
        {
            case Likes:
                return Like.class;
            case Posts:
                return Post.class;
            case Users:
                return User.class;
            case Comments:
                return Comment.class;
            case Notifications:
                return Notification.class;
            default:
                return null;
        }
    }*/
    //This function can just return 10 objects at a time
    //will update it later
    @Override
    public ArrayList<IModel> getObjectsList(ArrayList<String> objectIds, ModelType modelType) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        // Create a reference to the cities collection
        CollectionReference docsRef  = db.collection(modelType.toString());
        // Create a query against the collection.
        Query query = docsRef.whereIn(FieldPath.documentId(),objectIds);
        // retrieve  query results asynchronously using query.get()
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        ArrayList<IModel> _objects = queryDocumentsToClassTypes(querySnapshot.get().getDocuments(),modelType);
        if (!_objects.isEmpty()) {
            for (IModel _object : _objects) {
                System.out.println(_object.getID());
            }
            return _objects;
        } else {
            System.out.println("No such documents!");
            return null;
        }
    }

    //see extra id attribute which it is creating                   //..............ERROR
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
    public boolean removeObject(String objectId,ModelType modelType) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        // asynchronously delete a document
        ApiFuture<WriteResult> writeResult = db.collection(modelType.toString()).document(objectId).delete();
        //maybe it works
        if (!writeResult.isCancelled()) {
            System.out.println("Update time : " + writeResult.get().getUpdateTime());
            System.out.println("document removed Successfully");
            return true;
        } else {
            System.out.println("Failed to Remove document!");
            return false;
        }
    }

    @Override
    public boolean updateObject(String objectId,HashMap<String,String> attributesToBeUpdated,ModelType modelType){

        return false;
        //use wherein
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
