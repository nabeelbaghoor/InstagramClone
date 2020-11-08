package DB_Text;

import Models.*;
import com.google.firebase.database.utilities.Pair;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
//import org.json.simple.JSONObject;

public class DB_TextOperations implements IDB_Operations {

    int currUserId;

    DB_TextOperations() {
        currUserId = 0;
    }
    public boolean saveObject(HashMap<String, IModel> map,ModelType modelType) throws IOException, JSONException {
        String data = convertToJson(map,modelType);
        //make filename
        String filename = ".\\DBText_DATA\\";
        filename+=modelType.toString();
        filename+=".json";
        //Write to JSON file
        try (FileWriter file = new FileWriter(filename)) {
            file.write(data);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private String convertToJson(HashMap<String, IModel> map,ModelType modelType) {
        Gson gson = new Gson();

        switch (modelType) {
            case Likes:
                HashMap<String,Like> likeHashMap = new HashMap<String,Like>();
                for (HashMap.Entry<String,IModel> entry : map.entrySet()){
                    likeHashMap.put(entry.getKey(),((Like) entry.getValue()));
                }
                return gson.toJson(likeHashMap);
            case Posts:
                HashMap<String,Post> postHashMap = new HashMap<String,Post>();
                for (HashMap.Entry<String,IModel> entry : map.entrySet()){
                    postHashMap.put(entry.getKey(),((Post) entry.getValue()));
                }
                return gson.toJson(postHashMap);
            case Users:
                HashMap<String,User> userHashMap = new HashMap<String,User>();
                for (HashMap.Entry<String,IModel> entry : map.entrySet()){
                    userHashMap.put(entry.getKey(),((User) entry.getValue()));
                }
                return gson.toJson(userHashMap);
            case Comments:
                HashMap<String,Comment> commentHashMap = new HashMap<String,Comment>();
                for (HashMap.Entry<String,IModel> entry : map.entrySet()){
                    commentHashMap.put(entry.getKey(),((Comment) entry.getValue()));
                }
                return gson.toJson(commentHashMap);
            case Notifications:
                HashMap<String,Notification> notificationHashMap = new HashMap<String,Notification>();
                for (HashMap.Entry<String,IModel> entry : map.entrySet()){
                    notificationHashMap.put(entry.getKey(),((Notification) entry.getValue()));
                }
                return gson.toJson(notificationHashMap);
            default:
                return "";
        }
    }

    public HashMap<String, IModel> loadObject(ModelType modelType) throws Exception {
        //make filename
        String filename = ".\\DBText_DATA\\";
        filename+=modelType.toString();
        filename+=".json";

        String data = readFileAsString(filename);
        Gson gson = new Gson();
        switch (modelType) {
            case Likes:
                HashMap<String, IModel> map1 = gson.fromJson(data, new TypeToken<HashMap<String, Post>>() {
                }.getType());
                return map1;
            case Posts:
                HashMap<String, IModel> map2 = gson.fromJson(data, new TypeToken<HashMap<String, Post>>() {
                }.getType());
                return map2;
            case Users:
                HashMap<String, IModel> map3 = gson.fromJson(data, new TypeToken<HashMap<String, User>>() {
                }.getType());
                return map3;
            case Comments:
                HashMap<String, IModel> map4 = gson.fromJson(data, new TypeToken<HashMap<String, Comment>>() {
                }.getType());
                return map4;
            case Notifications:
                HashMap<String, IModel> map5 = gson.fromJson(data, new TypeToken<HashMap<String, Notification>>() {
                }.getType());
                return map5;
            default:
                return null;
        }
    }
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

    public static String readFileAsString(String fileName) throws Exception {
        File f = new File(fileName);
        if(f.exists() && !f.isDirectory()) {
            String data = "";
            data = new String(Files.readAllBytes(Paths.get(fileName)));
            return data;
        }else{
            return "";
        }
    }

    @Override
    public void initDB() throws IOException {

    }

    @Override
    public IModel getObject(String objectId, ModelType modelType) throws Exception {
        return loadObject(modelType).get(objectId);
    }

    @Override
    public ArrayList<IModel> getObjectsList(ArrayList<String> objectIds, ModelType modelType) throws Exception {
        Collection<IModel> _objectsCollection =loadObject(modelType).values();
        ArrayList<IModel> _objects = new ArrayList<IModel>();
        for (IModel iModel:_objectsCollection) {
            if(objectIds.contains(iModel.getID())) {
                _objects.add(iModel);
            }
        }
        return _objects;
    }

    @Override
    public ArrayList<IModel> getObjectsList(HashMap<String, Object> attributesToQuery, ModelType modelType) throws Exception {
        HashMap<String, IModel> _objects = new HashMap<String, IModel>();
        ArrayList<String> _objectsToRemove = new ArrayList<String>();
        _objects = loadObject(modelType);  //only user,for now
        if (_objects != null) {
            for (Map.Entry<String, Object> attributeEntry : attributesToQuery.entrySet()){
                for (Map.Entry<String, IModel> objEntry : _objects.entrySet()){
                    for (Field field : objEntry.getValue().getClass().getFields()) {
                        if(attributeEntry.getKey() == field.getName()) {
                            String attributeValue = attributeEntry.getValue().toString();
                            String fieldValue = field.get(objEntry.getValue()).toString();
                            if (!attributeValue.equals(fieldValue)) {
                                _objectsToRemove.add(objEntry.getKey());
                            }
                        }
                    }
                }
                for (String key:_objectsToRemove){
                    _objects.remove(key);
                }
            }
            ArrayList<IModel> _queriedObjects = new ArrayList<IModel>();
            for (IModel iModel:_objects.values()) {
                _queriedObjects.add(iModel);
            }
            if (_queriedObjects != null) {
                System.out.println("Objects found Successfully");
                return _queriedObjects;
            } else {
                System.out.println("No objects Found!");
                return null;
            }
        } else {
            System.out.println("No objects Found!");
            return null;
        }
    }

    @Override
    public String addObject(IModel object, ModelType modelType) throws Exception {
        HashMap<String, IModel> _objects = loadObject(modelType);
        if(_objects == null){
            _objects = new HashMap<String, IModel>();
        }
        String uniqueKey = UUID.randomUUID().toString();
        object.setID(uniqueKey);
        //System.out.println(object.getID());
        currUserId++;
        _objects.put(object.getID(), object);
        saveObject(_objects,modelType);
        System.out.println("Object Added Successfully!");
        return object.getID();
    }

    @Override
    public boolean removeObject(String objectId, ModelType modelType) throws Exception {
        HashMap<String, IModel> _objects = new HashMap<String, IModel>();
        _objects = loadObject(modelType);
        _objects.remove(objectId);
        //make it better
        if (saveObject(_objects,modelType) == true) {
            System.out.println("Object removed Successfully");
            return true;
        } else {
            System.out.println("Failed to Remove Object!");
            return false;
        }
    }

    @Override
    public boolean updateObject(String objectId, HashMap<String, Object> attributesToBeUpdated, ModelType modelType) throws Exception {
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
                if (saveObject(_objects,modelType) == true) {
                    System.out.println("Object updated Successfully");
                    return true;
                } else {
                    System.out.println("Failed to update Object!");
                    return false;
                }
            } else {
                System.out.println("Failed to update Object!"); //for now, making it same as firebase
                return false;
            }
        } else {
            System.out.println("Failed to update Object!"); //for now, making it same as firebase
            return false;
        }
    }

    @Override
    public boolean updateArrayObject(String objectId, Pair<String, Object> arrayAttributeToBeUpdated, UpdateOperation updateOperation, ModelType modelType) throws Exception {
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
            System.out.println(((Post)_objects.get(object.getID())).commentsList.toString());
            if (saveObject(_objects,modelType) == true) {
                System.out.println("Object updated Successfully");
                return true;
            } else {
                System.out.println("Failed to update Object!");
                return false;
            }
        } else {
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