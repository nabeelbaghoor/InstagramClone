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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
//import org.json.simple.JSONObject;

public class DB_TextOperations implements IDB_Operations{
    public static void saveUser(HashMap<String,Object> map) throws IOException, JSONException {
        Gson gson = new Gson();
        String data = gson.toJson(map);
        //Write to JSON file
        try  (FileWriter file = new FileWriter(".\\DBText_DATA\\Users.json")) {
            file.write(data);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public static HashMap<String, User> loadUser() throws Exception {
        String data = readFileAsString(".\\DBText_DATA\\Users.json");
        Gson gson = new Gson();
        return gson.fromJson(data, new TypeToken<HashMap<String, User>>() {}.getType());
    }
    public static String readFileAsString(String fileName)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
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
        return loadUser();
    }

    @Override
    public ArrayList<IModel> getObjectsList(HashMap<String, Object> attributesToQuery, ModelType modelType) throws ExecutionException, InterruptedException {
        return null;
    }

    @Override
    public String addObject(IModel object, ModelType modelType) throws ExecutionException, InterruptedException {
        return null;
    }

    @Override
    public boolean removeObject(String objectId, ModelType modelType) throws ExecutionException, InterruptedException {
        return false;
    }

    @Override
    public boolean updateObject(String objectId, HashMap<String, Object> attributesToBeUpdated, ModelType modelType) throws ExecutionException, InterruptedException {
        return false;
    }

    @Override
    public boolean updateArrayObject(String objectId, Pair<String, Object> arrayAttributeToBeUpdated, UpdateOperation updateOperation, ModelType modelType) throws ExecutionException, InterruptedException {
        return false;
    }
}



 /*File myObj = new File(".\\DBText_DATA\\Users.json");
        Scanner myReader = new Scanner(myObj);
        String data = myReader.nextLine();
        myReader.hasNextLine();
        myReader.close();
        */