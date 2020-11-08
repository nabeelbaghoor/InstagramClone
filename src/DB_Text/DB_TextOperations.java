package DB_Text;

import Models.IDB_Operations;
import Models.IModel;
import Models.User;
import com.google.firebase.database.utilities.Pair;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONException;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
//import org.json.simple.JSONObject;

public class DB_TextOperations implements IDB_Operations {

    int currUserId;

    DB_TextOperations() {
        currUserId = 0;
    }

    public boolean saveUser(HashMap<String, User> map) throws IOException, JSONException {
        Gson gson = new Gson();
        String data = gson.toJson(map);
        //Write to JSON file
        try (FileWriter file = new FileWriter(".\\DBText_DATA\\Users.json")) {
            file.write(data);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public HashMap<String, User> loadUser() throws Exception {
        String data = readFileAsString(".\\DBText_DATA\\Users.json");
        Gson gson = new Gson();
        return gson.fromJson(data, new TypeToken<HashMap<String, User>>() {
        }.getType());
    }

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public int documentToClassType(IDB_Operations.ModelType modelType) {
        switch (modelType) {
            case Likes:
                return 3;
            case Posts:
                return 2;
            case Users:
                return 1;//document.toObject(User.class);
            case Comments:
                return 4;//document.toObject(Comment.class);
            case Notifications:
                return 5;//document.toObject(Notification.class);
            default:
                return 0;
        }
    }

    @Override
    public void initDB() throws IOException {

    }

    @Override
    public IModel getObject(String objectId, ModelType modelType) throws Exception {
        return loadUser().get(objectId);
    }

    @Override
    public ArrayList<IModel> getObjectsList(ArrayList<String> objectIds, ModelType modelType) throws Exception {
        Collection<User> _objectsTemp =  loadUser().values();
       /* ArrayList<IModel> _objects = new ArrayList<IModel>();
       for (User user:_objectsTemp){
           _objects.add(((IModel) user));
       }
        if(_objects!=null) {
            for (IModel object : _objects) {
                if (!(objectIds.contains(object.getID()))) {
                    _objects.remove(object);    //make it efficient
                }
            }
        }*/
        for(IModel imodel:_objectsTemp){
            imodel.print();
        }
        return ((ArrayList) _objectsTemp);
    }

    @Override
    public ArrayList<IModel> getObjectsList(HashMap<String, Object> attributesToQuery, ModelType modelType) throws Exception {
        HashMap<String, User> _objects = new HashMap<String, User>();
        ArrayList<IModel> _objectsToQuery = new ArrayList<IModel>();
        _objects = loadUser();  //only user,for now
        if (_objects != null) {
            User user = null;
            for (Map.Entry<String, Object> attributeEntry : attributesToQuery.entrySet()) {
                for (HashMap.Entry<String, User> objEntry : _objects.entrySet()) {
                    for (Field field : objEntry.getValue().getClass().getFields()) {
                        if (attributeEntry.getKey() == field.getName() && attributeEntry.getValue() == field.get(objEntry)) {
                            _objectsToQuery.add(objEntry.getValue());
                            _objects.remove(objEntry.getKey()); //maybe it will work
                        }
                    }
                }
            }
            if (_objectsToQuery != null) {
                System.out.println("Objects found Successfully");
                return _objectsToQuery;
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
        HashMap<String, User> _objects = loadUser();
        if(_objects == null){
            _objects = new HashMap<String, User>();
        }
        //object.setID(String.valueOf(currUserId));
        //object.print();
        currUserId++;
        _objects.put(object.getID(), (User) object);
        saveUser(_objects);
        System.out.println("Object Added Successfully!");
        return object.getID();
    }

    @Override
    public boolean removeObject(String objectId, ModelType modelType) throws Exception {
        HashMap<String, User> _objects = new HashMap<String, User>();
        _objects = loadUser();
        _objects.remove(objectId);
        //make it better
        if (saveUser(_objects) == true) {
            System.out.println("Object removed Successfully");
            return true;
        } else {
            System.out.println("Failed to Remove Object!");
            return false;
        }
    }

    @Override
    public boolean updateObject(String objectId, HashMap<String, Object> attributesToBeUpdated, ModelType modelType) throws Exception {
        HashMap<String, User> _objects = new HashMap<String, User>();
        _objects = loadUser();
        if (_objects != null) {
            User user = _objects.get(objectId);
            if (user != null) {
                for (Map.Entry<String, Object> entry : attributesToBeUpdated.entrySet()) {
                    for (Field field : user.getClass().getFields()) {
                        if (entry.getKey() == field.getName()) {
                            user.getClass().getField(field.getName()).set(user, entry.getValue());   //make it better
                        }
                    }
                }
                _objects.replace(user.getID(), user);
                if (saveUser(_objects) == true) {
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
        HashMap<String, User> _objects = new HashMap<String, User>();
        _objects = loadUser();
        User user = _objects.get(objectId);
        if (user != null) {
            for (Field field : user.getClass().getFields()) {
                if (arrayAttributeToBeUpdated.getFirst() == field.getName()) {
                    Object value = user.getClass().getField(field.getName()).get(user);   //make it better
                    if (updateOperation == UpdateOperation.Add) {
                        ((ArrayList) value).add(arrayAttributeToBeUpdated.getSecond());
                    } else {
                        ((ArrayList) value).remove(((ArrayList) value).size() - 1);
                    }
                    user.getClass().getField(field.getName()).set(user, value);
                    break;  //only one update operation allowed at a time, just copying Firebase (forNow)
                }
            }
            _objects.replace(user.getID(), user);
            if (saveUser(_objects) == true) {
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