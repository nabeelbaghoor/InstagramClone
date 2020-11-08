package DB_Text;

import DB_Firebase.DB_FirebaseOperations;
import Models.IDB_Operations;
import Models.IModel;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        IDB_Operations _IDB_Firebase = new DB_FirebaseOperations();
        _IDB_Firebase.initDB();
     /*   User user1 = (User) _IDB.getObject("56t4zAWnB6PetHY4AAgW", IDB_Operations.ModelType.Users);
        User user2 = (User) _IDB.getObject("Pdwqk9Wd8VQoPi5VckiN", IDB_Operations.ModelType.Users);
        HashMap<String, User> map = new HashMap<String, User>();
        map.put(user1.getID(), user1);
        map.put(user2.getID(), user2);
        DB_TextOperations.saveUser(map);*/

         IDB_Operations _IDB_Text = new DB_TextOperations();
        _IDB_Text.initDB();
       /* User user1 =
                (User)_IDB_Firebase.getObject("Pdwqk9Wd8VQoPi5VckiN", IDB_Operations.ModelType.Users);
        _IDB_Text.addObject(
                user1,
                IDB_Operations.ModelType.Users
        );*/

        /*_IDB_Text.addObject(
                (User)_IDB_Firebase.getObject("4Zp5eNKWADOyN37OZ3Rf", IDB_Operations.ModelType.Users) ,
                IDB_Operations.ModelType.Users
        );*/
        ArrayList<String > _objectIds = new ArrayList<String>();
        _objectIds.add("4Zp5eNKWADOyN37OZ3Rf");
        _objectIds.add("BnP05o1SazfKrcNMT2Yb");
        ArrayList<IModel> _objects  = _IDB_Text.getObjectsList(_objectIds,IDB_Operations.ModelType.Users);
        if(_objects!=null) {
            for (IModel user : _objects) {
                user.print();
            }
        }
    }
}