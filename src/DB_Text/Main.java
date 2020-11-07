package DB_Text;

import DB_Firebase.DB_FirebaseOperations;
import Models.IDB_Operations;
import Models.User;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        IDB_Operations _IDB = new DB_FirebaseOperations();
        _IDB.initDB();
        User user1 = (User)_IDB.getObject("56t4zAWnB6PetHY4AAgW",IDB_Operations.ModelType.Users);
        User user2 = (User)_IDB.getObject("Pdwqk9Wd8VQoPi5VckiN",IDB_Operations.ModelType.Users);
        HashMap<String ,Object> map = new HashMap<String ,Object>();
        map.put(user1.getID(),user1);
        map.put(user2.getID(),user2);
        DB_TextOperations.loadUser().get("56t4zAWnB6PetHY4AAgW");
    }
}