package DB_Firebase;

import Models.IDB_Operations;
import Models.IModel;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.utilities.Pair;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DB_FirebaseOperations implements IDB_Operations {

    private String modelsPackagePath;

    @Override
    public void initDB() throws IOException {
        modelsPackagePath = "Models.";
        FileInputStream serviceAccount =
                new FileInputStream(".\\instagramclone-58441-firebase-adminsdk-taebo-2cba3bad0c.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        //.setDatabaseUrl("https://instagramclone-58441.firebaseio.com")
        FirebaseApp.initializeApp(options);
    }

    @Override
    public IModel getObject(String objectId, ModelType modelType) throws ExecutionException, InterruptedException, ClassNotFoundException {
        if (objectId == null) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectId String Parameter is Null!");
            return null;
        }else if(objectId.isEmpty()){
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectId String is Empty!");
            return null;
        }

        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection(modelType.toString()).document(objectId);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            IModel _object = (IModel) document.toObject(Class.forName(modelsPackagePath + modelType.toString()));//documentToClassType(document, modelType);
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println(_object);
            return _object;
        } else {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("No such document!");
            return null;
        }
    }

    public ArrayList<IModel> queryDocumentsToClassTypes(List<QueryDocumentSnapshot> documents, ModelType modelType) throws ClassNotFoundException {
        ArrayList<IModel> _objects = new ArrayList<>();
        for (QueryDocumentSnapshot _document : documents) {
            IModel _object = (IModel) _document.toObject(Class.forName(modelsPackagePath + modelType.toString()));//documentToClassType(document, modelType);
            _objects.add(_object);
        }
        return _objects;
    }

    public ArrayList<IModel> getObjectsList(ArrayList<String> objectIdsTemp, ModelType modelType) throws ExecutionException, InterruptedException, ClassNotFoundException {
        if (objectIdsTemp == null) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectIds List Parameter is Null!");
            return new ArrayList<IModel>();
        }else if(objectIdsTemp.isEmpty()){
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectIds List is Empty!");
            return new ArrayList<IModel>();
        }

        ArrayList<String> objectIds = new ArrayList<>(objectIdsTemp);

        Firestore db = FirestoreClient.getFirestore();
        // Create a reference to the collection
        CollectionReference docsRef = db.collection(modelType.toString());
        // Create a query against the collection.
        int documentsQueried = 0;
        Query query = null;
        ApiFuture<QuerySnapshot> querySnapshot;
        ArrayList<IModel> _objects = new ArrayList<IModel>();
        List<String> _objectsIdsToQuery = new ArrayList<String>();
        int numberOfObjectIdsToQuery = 0;
        while(!objectIds.isEmpty()) {
            numberOfObjectIdsToQuery = objectIds.size() > 10 ? 10 : objectIds.size();
            _objectsIdsToQuery = objectIds.subList(0, numberOfObjectIdsToQuery);
            query = docsRef.whereIn(FieldPath.documentId(), _objectsIdsToQuery);
            querySnapshot = query.get();
            _objects.addAll(queryDocumentsToClassTypes(querySnapshot.get().getDocuments(), modelType));
            objectIds.removeAll(_objectsIdsToQuery);
        }
        if (!_objects.isEmpty()) {
            if (IDB_Operations.PRINTLN_ENABLED) {
                for (IModel _object : _objects) {
                    System.out.println(_object.getID());
                }
            }
            return _objects;
        } else {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("No such documents!");
            return new ArrayList<IModel>();
        }
    }

    //This function can just return 10 objects at a time
    //will update it later to support more
    @Override
    public ArrayList<IModel> getObjectsList(HashMap<String, Object> attributesToQuery, ModelType modelType) throws ExecutionException, InterruptedException, ClassNotFoundException {
        if (attributesToQuery == null) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("attributesToQuery HashMap Parameter is Null!");
            return new ArrayList<IModel>();
        }else if(attributesToQuery.isEmpty()){
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("No attributes Specified in attributesToQuery HashMap!");
            return new ArrayList<IModel>();
        }

        Firestore db = FirestoreClient.getFirestore();
        // Create a reference to the cities collection
        CollectionReference docsRef = db.collection(modelType.toString());
        // Create a query against the collection.
        Iterator entries = attributesToQuery.entrySet().iterator();
        HashMap.Entry<String, Object> thisEntry = (HashMap.Entry) entries.next();
        Query query = docsRef.whereEqualTo(thisEntry.getKey(), thisEntry.getValue());
        while (entries.hasNext()) {
            thisEntry = (HashMap.Entry) entries.next();
            query = query.whereEqualTo(thisEntry.getKey(), thisEntry.getValue());
        }
        // retrieve  query results asynchronously using query.get()
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        ArrayList<IModel> _objects = queryDocumentsToClassTypes(querySnapshot.get().getDocuments(), modelType);
        if (!_objects.isEmpty()) {
            if (IDB_Operations.PRINTLN_ENABLED) {
                for (IModel _object : _objects) {
                    System.out.println(_object.getID());
                }
            }
            return _objects;
        } else {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("No such documents!");
            return new ArrayList<IModel>();
        }
    }
    /*Firebase will create documentId(objectId) ,and we will assign it*/
    @Override
    public String addObject(IModel object, ModelType modelType) throws ExecutionException, InterruptedException {
        if (object == null) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("Object Parameter is Null!");
            return "";
        }

        Firestore db = FirestoreClient.getFirestore();
        DocumentReference addedDocRef = db.collection(modelType.toString()).document();
        object.setID(addedDocRef.getId());
        //set timestamp of creation of the object
        object.setTimestamp(Timestamp.now());
        ApiFuture<WriteResult> writeResult = addedDocRef.set(object);

        if (!writeResult.isCancelled()) {
            if (IDB_Operations.PRINTLN_ENABLED) {
                System.out.println("Update time : " + writeResult.get().getUpdateTime());
                System.out.println("document added Successfully");
            }
            return object.getID();
        } else {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("Failed to Add document!");
            return "";
        }
    }

    @Override
    public boolean removeObject(String objectId, ModelType modelType) throws ExecutionException, InterruptedException {
        if (objectId == null) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectId String Parameter is Null!");
            return false;
        }else if(objectId.isEmpty()){
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectId String is Empty!");
            return false;
        }

        Firestore db = FirestoreClient.getFirestore();
        // asynchronously delete a document
        ApiFuture<WriteResult> writeResult = db.collection(modelType.toString()).document(objectId).delete();
        if (!writeResult.isCancelled()) {
            if (IDB_Operations.PRINTLN_ENABLED) {
                System.out.println("Update time : " + writeResult.get().getUpdateTime());
                System.out.println("document removed Successfully");
            }
            return true;
        } else {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("Failed to Remove document!");
            return false;
        }
    }

    @Override
    public boolean updateObject(String objectId, HashMap<String, Object> attributesToBeUpdated, ModelType modelType) throws ExecutionException, InterruptedException {
        if (objectId == null) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectId String Parameter is Null!");
            return false;
        }else if(objectId.isEmpty()){
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectId String is Empty!");
            return false;
        }
        if (attributesToBeUpdated == null) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("attributesToBeUpdated HashMap Parameter is Null!");
            return false;
        }else if(attributesToBeUpdated.isEmpty()){
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("No attributes Specified in attributesToBeUpdated HashMap!");
            return false;
        }

        Firestore db = FirestoreClient.getFirestore();
        // Create a reference to the document
        DocumentReference docRef = db.collection(modelType.toString()).document(objectId);
        // Async update document
        ApiFuture<WriteResult> writeResult = docRef.update(attributesToBeUpdated);
        if (!writeResult.isCancelled()) {
            if (IDB_Operations.PRINTLN_ENABLED) {
                System.out.println("Update time : " + writeResult.get().getUpdateTime());
                System.out.println("document updated Successfully");
            }
            return true;
        } else {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("Failed to update document!");
            return false;
        }
    }

    @Override
    public boolean updateArrayObject(String objectId, Pair<String, Object> arrayAttributeToBeUpdated, UpdateOperation updateOperation, ModelType modelType) throws ExecutionException, InterruptedException {
        if (objectId == null) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectId String Parameter is Null!");
            return false;
        }else if(objectId.isEmpty()){
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectId String is Empty!");
            return false;
        }

        if (arrayAttributeToBeUpdated == null) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("arrayAttributeToBeUpdated HashMap Parameter is Null!");
            return false;
        }else if(arrayAttributeToBeUpdated.getFirst().isEmpty()){
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("First Attribute of attributesToBeUpdated Pair is Empty!");
            return false;
        }else if(arrayAttributeToBeUpdated.getSecond() == null){
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("Second Attribute of attributesToBeUpdated Pair is null!");
            return false;
        }

        Firestore db = FirestoreClient.getFirestore();
        // Create a reference to the document
        DocumentReference docRef = db.collection(modelType.toString()).document(objectId);
        // Async update document
        ApiFuture<WriteResult> writeResult = null;
        if (updateOperation == UpdateOperation.Add) {
            writeResult = docRef.update(arrayAttributeToBeUpdated.getFirst(), FieldValue.arrayUnion(arrayAttributeToBeUpdated.getSecond()));
        } else if (updateOperation == UpdateOperation.Remove) {

            writeResult = docRef.update(arrayAttributeToBeUpdated.getFirst(), FieldValue.arrayRemove(arrayAttributeToBeUpdated.getSecond()));
        }
        if (writeResult != null && !writeResult.isCancelled()) {
            if (IDB_Operations.PRINTLN_ENABLED) {
                System.out.println("Update time : " + writeResult.get().getUpdateTime());
                System.out.println("document updated Successfully");
            }
            return true;
        } else {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("Failed to update document!");
            return false;
        }
    }
}


//old

/* public IModel documentToClassType(DocumentSnapshot document, ModelType modelType) {
        switch (modelType) {
            case Like:
                return document.toObject(Like.class);
            case Post:
                return document.toObject(Post.class);
            case User:
                return document.toObject(User.class);
            case Comment:
                return document.toObject(Comment.class);
            case Notification:
                return document.toObject(Notification.class);
            default:
                return null;
        }
    }*/

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
