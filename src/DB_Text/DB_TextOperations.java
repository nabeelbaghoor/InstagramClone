package DB_Text;

import Models.*;
import com.google.cloud.Timestamp;
import com.google.firebase.database.utilities.Pair;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DB_TextOperations implements IDB_Operations {
    //Semaphore mutex;
    public DB_TextOperations() {
        //mutex = new Semaphore(1);
    }

    public static String readFileAsString(String fileName) throws Exception {
        File file = new File(fileName);
        if (file.exists() && !file.isDirectory()) {
            String data = "";
            data = new String(Files.readAllBytes(Paths.get(fileName)));
            return data;
        } else {
            return "";
        }
    }

    @Override
    public void initDB() throws IOException {
    }

    public boolean saveObject(HashMap<String, IModel> map, ModelType modelType) throws IOException, JSONException, InterruptedException {
        /*mutex.acquire();*/
        Gson gson = new Gson();
        String data = gson.toJson(map);
        //make filename
        String filename = ".\\DBText_DATA\\";
        filename += modelType.toString();
        filename += ".json";
        //Write to JSON file
        try (FileWriter file = new FileWriter(filename)) {
            file.write(data);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*mutex.release();*/
        return true;
    }

    public HashMap<String, IModel> loadObject(ModelType modelType) throws Exception {
        //make filename
         /*mutex.acquire();*/
        String filename = ".\\DBText_DATA\\";
        filename += modelType.toString();
        filename += ".json";
        String data = readFileAsString(filename);
        Gson gson = new Gson();
        /*mutex.release();*/
        return gson.fromJson(data, getObjectType(modelType));//getClassType(modelType));
    }

    private Type getObjectType(ModelType modelType) {
        switch (modelType) {
            case Like:
                return new TypeToken<HashMap<String, Like>>() {
                }.getType();
            case Post:
                return new TypeToken<HashMap<String, Post>>() {
                }.getType();
            case User:
                return new TypeToken<HashMap<String, User>>() {
                }.getType();
            case Comment:
                return new TypeToken<HashMap<String, Comment>>() {
                }.getType();
            case Notification:
                return new TypeToken<HashMap<String, Notification>>() {
                }.getType();
            default:
                return null;
        }
    }

    @Override
    public IModel getObject(String objectId, ModelType modelType) throws Exception {
        if (objectId == null) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectId String Parameter is Null!");
            return null;
        }else if(objectId.isEmpty()){
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectId String is Empty!");
            return null;
        }

        return loadObject(modelType).get(objectId);
    }

    @Override
    public ArrayList<IModel> getObjectsList(ArrayList<String> objectIdsTemp, ModelType modelType) throws Exception {
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

        Collection<IModel> _objectsCollection = loadObject(modelType).values();
        ArrayList<IModel> _objects = new ArrayList<IModel>();
        for (IModel iModel : _objectsCollection) {
            if (objectIds.contains(iModel.getID())) {
                _objects.add(iModel);
            }
        }
        return _objects;
    }

    @Override
    public ArrayList<IModel> getObjectsList(HashMap<String, Object> attributesToQuery, ModelType modelType) throws Exception {
        if (attributesToQuery == null) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("attributesToQuery HashMap Parameter is Null!");
            return new ArrayList<IModel>();
        }else if(attributesToQuery.isEmpty()){
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("No attributes Specified in attributesToQuery HashMap!");
            return new ArrayList<IModel>();
        }

        HashMap<String, IModel> _objects = new HashMap<String, IModel>();
        ArrayList<String> _objectsToRemove = new ArrayList<String>();
        _objects = loadObject(modelType);  //only user,for now
        if (_objects != null) {
            for (Map.Entry<String, Object> attributeEntry : attributesToQuery.entrySet()) {
                for (Map.Entry<String, IModel> objEntry : _objects.entrySet()) {
                    for (Field field : objEntry.getValue().getClass().getFields()) {
                        if (attributeEntry.getKey() == field.getName()) {
                            String attributeValue = attributeEntry.getValue().toString();
                            String fieldValue = field.get(objEntry.getValue()).toString();
                            if (!attributeValue.equals(fieldValue)) {
                                _objectsToRemove.add(objEntry.getKey());
                            }
                        }
                    }
                }
                for (String key : _objectsToRemove) {
                    _objects.remove(key);
                }
            }
            ArrayList<IModel> _queriedObjects = new ArrayList<IModel>();
            for (IModel iModel : _objects.values()) {
                _queriedObjects.add(iModel);
            }
            if (_queriedObjects != null) {
                if (IDB_Operations.PRINTLN_ENABLED)
                    System.out.println("Objects found Successfully");
                return _queriedObjects;
            } else {
                if (IDB_Operations.PRINTLN_ENABLED)
                    System.out.println("No objects Found!");
                return null;
            }
        } else {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("No objects Found!");
            return null;
        }
    }

    @Override
    public String addObject(IModel object, ModelType modelType) throws Exception {
        if (object == null) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("Object Parameter is Null!");
            return "";
        }
        /*mutex.acquire();*/

        HashMap<String, IModel> _objects = loadObject(modelType);
        if (_objects == null) {
            _objects = new HashMap<String, IModel>();
        }
        String uniqueKey = UUID.randomUUID().toString();
        object.setID(uniqueKey);
        object.setTimestamp(Timestamp.now());
        _objects.put(object.getID(), object);
        saveObject(_objects, modelType);
        if (IDB_Operations.PRINTLN_ENABLED)
            System.out.println("Object Added Successfully!");
        /*mutex.release();*/
        return object.getID();
    }

    @Override
    public boolean removeObject(String objectId, ModelType modelType) throws Exception {
        if (objectId == null) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectId String Parameter is Null!");
            return false;
        }else if(objectId.isEmpty()){
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectId String is Empty!");
            return false;
        }
        /*mutex.acquire();*/

        HashMap<String, IModel> _objects = new HashMap<String, IModel>();
        _objects = loadObject(modelType);
        _objects.remove(objectId);
        //make it better

        boolean isSaved = saveObject(_objects, modelType);
        /*mutex.release();*/
        if (isSaved == true) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("Object removed Successfully");
            return true;
        } else {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("Failed to Remove Object!");
            return false;
        }
    }

    @Override
    public boolean updateObject(String objectId, HashMap<String, Object> attributesToBeUpdated, ModelType modelType) throws Exception {

        if (objectId == null) {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectId String Parameter is Null!");
            return false;
        }else if(objectId.isEmpty()){
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("ObjectId String is Empty!");
            return false;
        }


        /*mutex.acquire();*/
        HashMap<String, IModel> _objects = new HashMap<String, IModel>();
        _objects = loadObject(modelType);
        if (_objects != null) {
            IModel object = _objects.get(objectId);
            if (object != null) {
                for (Map.Entry<String, Object> entry : attributesToBeUpdated.entrySet()) {
                    for (Field field : object.getClass().getFields()) {
                        if (entry.getKey() == field.getName()) {
                            object.getClass().getField(field.getName()).set(object, entry.getValue());   //make it better
                        }
                    }
                }
                _objects.replace(object.getID(), object);

                boolean isSaved = saveObject(_objects, modelType);
                /*mutex.release();*/

                if ( isSaved== true) {
                    if (IDB_Operations.PRINTLN_ENABLED)
                        System.out.println("Object updated Successfully");
                    return true;
                } else {
                    if (IDB_Operations.PRINTLN_ENABLED)
                        System.out.println("Failed to update Object!");
                    return false;
                }
            } else {
                if (IDB_Operations.PRINTLN_ENABLED)
                    System.out.println("Failed to update Object!"); //for now, making it same as firebase
                return false;
            }
        } else {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("Failed to update Object!"); //for now, making it same as firebase
            return false;
        }
    }

    @Override
    public boolean updateArrayObject(String objectId, Pair<String, Object> arrayAttributeToBeUpdated, UpdateOperation updateOperation, ModelType modelType) throws Exception {

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

        /*mutex.acquire();*/

        HashMap<String, IModel> _objects = new HashMap<String, IModel>();
        _objects = loadObject(modelType);
        IModel object = _objects.get(objectId);
        if (object != null) {
            for (Field field : object.getClass().getFields()) {
                if (arrayAttributeToBeUpdated.getFirst() == field.getName()) {
                    Object value = object.getClass().getField(field.getName()).get(object);   //make it better

                    if (updateOperation == UpdateOperation.Add) {
                        ((ArrayList) value).add(arrayAttributeToBeUpdated.getSecond());
                    } else {
                        ((ArrayList) value).remove(arrayAttributeToBeUpdated.getSecond());
                    }
                    object.getClass().getField(field.getName()).set(object, value);

                    break;  //only one update operation allowed at a time, just copying Firebase (forNow)
                }
            }
            _objects.replace(object.getID(), object);
            boolean isSaved = saveObject(_objects, modelType);
            /*mutex.release();*/
            if (isSaved == true) {
                if (IDB_Operations.PRINTLN_ENABLED)
                    System.out.println("Object updated Successfully");
                return true;
            } else {
                if (IDB_Operations.PRINTLN_ENABLED)
                    System.out.println("Failed to update Object!");
                return false;
            }
        } else {
            if (IDB_Operations.PRINTLN_ENABLED)
                System.out.println("Failed to update Object!"); //for now, making it same as firebase
            return false;
        }
    }
}



 /*File myObj = new File(".\\DBText_DATA\\Users.json");
        Scanner myReader = new Scanner(myObj);
        String data = myReader.nextLine();
        myReader.hasNextLine();
        myReader.close();
        */


 /*public HashMap<String, IModel> IModelToClassTypeLoad(Gson gson,String data,IDB_Operations.ModelType modelType) {
        switch (modelType) {
            case Likes:
                return gson.fromJson(data, new TypeToken<HashMap<String, Like>>() {
            }.getType());
            case Posts:
                return gson.fromJson(data, new TypeToken<HashMap<String, Post>>() {
                }.getType());
            case Users:
                return gson.fromJson(data, new TypeToken<HashMap<String, User>>() {
                }.getType());
            case Comments:
                return gson.fromJson(data, new TypeToken<HashMap<String, Comment>>() {
                }.getType());
            case Notifications:
                return gson.fromJson(data, new TypeToken<HashMap<String, Notification>>() {
                }.getType());
            default:
                return null;
        }
    }*/


/* private String convertToJson(HashMap<String, IModel> map,ModelType modelType) {
    Gson gson = new Gson();

    switch (modelType) {
        case Like:
            HashMap<String,Like> likeHashMap = new HashMap<String,Like>();
            for (HashMap.Entry<String,IModel> entry : map.entrySet()){
                likeHashMap.put(entry.getKey(),((Like) entry.getValue()));
            }
            return gson.toJson(likeHashMap);
        case Post:
            HashMap<String,Post> postHashMap = new HashMap<String,Post>();
            for (HashMap.Entry<String,IModel> entry : map.entrySet()){
                postHashMap.put(entry.getKey(),((Post) entry.getValue()));
            }
            return gson.toJson(postHashMap);
        case User:
            HashMap<String,User> userHashMap = new HashMap<String,User>();
            for (HashMap.Entry<String,IModel> entry : map.entrySet()){
                userHashMap.put(entry.getKey(),((User) entry.getValue()));
            }
            return gson.toJson(userHashMap);
        case Comment:
            HashMap<String,Comment> commentHashMap = new HashMap<String,Comment>();
            for (HashMap.Entry<String,IModel> entry : map.entrySet()){
                commentHashMap.put(entry.getKey(),((Comment) entry.getValue()));
            }
            return gson.toJson(commentHashMap);
        case Notification:
            HashMap<String,Notification> notificationHashMap = new HashMap<String,Notification>();
            for (HashMap.Entry<String,IModel> entry : map.entrySet()){
                notificationHashMap.put(entry.getKey(),((Notification) entry.getValue()));
            }
            return gson.toJson(notificationHashMap);
        default:
            return "";
    }
}*/
