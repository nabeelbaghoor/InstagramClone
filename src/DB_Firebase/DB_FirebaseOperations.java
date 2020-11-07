package DB_Firebase;

import Models.*;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.utilities.Pair;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class DB_FirebaseOperations implements IDB_Operations {

    @Override
    public void initDB() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream(".\\instagramclone-58441-firebase-adminsdk-taebo-2cba3bad0c.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        //.setDatabaseUrl("https://instagramclone-58441.firebaseio.com")
        FirebaseApp.initializeApp(options);
    }

    @Override
    public IModel getObject(String objectId, ModelType modelType) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection(modelType.toString()).document(objectId);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            // convert document to User
            IModel _object = documentToClassType(document, modelType);
            System.out.println(_object);
            return _object;
        } else {
            System.out.println("No such document!");
            return null;
        }
    }

    public IModel documentToClassType(DocumentSnapshot document, ModelType modelType) {
        switch (modelType) {
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

    public ArrayList<IModel> queryDocumentsToClassTypes(List<QueryDocumentSnapshot> documents, ModelType modelType) {
        ArrayList<IModel> _objects = new ArrayList<>();
        for (QueryDocumentSnapshot _document : documents) {
            _objects.add(documentToClassType(_document, modelType));
        }
        return _objects;
    }

    public ArrayList<IModel> getObjectsList(ArrayList<String> objectIds, ModelType modelType) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        // Create a reference to the collection
        CollectionReference docsRef = db.collection(modelType.toString());
        // Create a query against the collection.
        Query query = docsRef.whereIn(FieldPath.documentId(), objectIds);
        // retrieve  query results asynchronously using query.get()
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        ArrayList<IModel> _objects = queryDocumentsToClassTypes(querySnapshot.get().getDocuments(), modelType);
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
    //will update it later to support more
    @Override
    public ArrayList<IModel> getObjectsList(HashMap<String, Object> attributesToQuery, ModelType modelType) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        // Create a reference to the cities collection
        CollectionReference docsRef = db.collection(modelType.toString());
        // Create a query against the collection.
        Iterator entries = attributesToQuery.entrySet().iterator();
        HashMap.Entry<String, Object> thisEntry = (HashMap.Entry) entries.next();
        ;
        Query query = docsRef.whereEqualTo(thisEntry.getKey(), thisEntry.getValue());
        while (entries.hasNext()) {
            thisEntry = (HashMap.Entry) entries.next();
            query = query.whereEqualTo(thisEntry.getKey(), thisEntry.getValue());
        }
        // retrieve  query results asynchronously using query.get()
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        ArrayList<IModel> _objects = queryDocumentsToClassTypes(querySnapshot.get().getDocuments(), modelType);
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
    public String addObject(IModel object, ModelType modelType) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        // Add document data after generating an id.
        DocumentReference addedDocRef = db.collection(modelType.toString()).document();
        object.setID(addedDocRef.getId());
        //set timestamp of creation of the object
        object.setTimestamp(new Timestamp(System.currentTimeMillis()));
        ApiFuture<WriteResult> writeResult = addedDocRef.set(object);
        System.out.println("Successfully updated at: " + writeResult.get().getUpdateTime());
        return object.getID();
    }

    @Override
    public boolean removeObject(String objectId, ModelType modelType) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        // asynchronously delete a document
        ApiFuture<WriteResult> writeResult = db.collection(modelType.toString()).document(objectId).delete();
        //check it again
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
    public boolean updateObject(String objectId, HashMap<String, Object> attributesToBeUpdated, ModelType modelType) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        // Create a reference to the cities collection
        DocumentReference docRef = db.collection(modelType.toString()).document(objectId);
        // Async update document
        ApiFuture<WriteResult> writeResult = docRef.update(attributesToBeUpdated);
        //check it again
        if (!writeResult.isCancelled()) {
            System.out.println("Update time : " + writeResult.get().getUpdateTime());
            System.out.println("document updated Successfully");
            return true;
        } else {
            System.out.println("Failed to update document!");
            return false;
        }
    }

    @Override
    public boolean updateArrayObject(String objectId, Pair<String, Object> arrayAttributeToBeUpdated, UpdateOperation updateOperation, ModelType modelType) throws ExecutionException, InterruptedException {

        Firestore db = FirestoreClient.getFirestore();
        // Create a reference to the cities collection
        DocumentReference docRef = db.collection(modelType.toString()).document(objectId);
        // Async update document
        ApiFuture<WriteResult> writeResult = null;
        if (updateOperation == UpdateOperation.Add) {
            writeResult = docRef.update(arrayAttributeToBeUpdated.getFirst(), FieldValue.arrayUnion(arrayAttributeToBeUpdated.getSecond()));
        } else if (updateOperation == UpdateOperation.Remove) {

            writeResult = docRef.update(arrayAttributeToBeUpdated.getFirst(), FieldValue.arrayRemove(arrayAttributeToBeUpdated.getSecond()));
        }
        //check it again
        if (writeResult != null && !writeResult.isCancelled()) {
            System.out.println("Update time : " + writeResult.get().getUpdateTime());
            System.out.println("document updated Successfully");
            return true;
        } else {
            System.out.println("Failed to update document!");
            return false;
        }
    }
}