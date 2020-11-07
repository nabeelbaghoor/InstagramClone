package DB_Firebase;

import Models.IDB_Operations;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        IDB_Operations _IDB = new DB_FirebaseOperations();
        _IDB.initDB();
        //added all group members
        /*_IDB.addObject(new User(null,
                "nabeelbaghoor",
                "nabeelbaghoor@gmail.com",
                "Nabeel",
                "Hassan",
                "Male",
                "03001234456",
                new Date(),
                "studios.com",
                "bio",
                null,
                null), IDB_Operations.ModelType.Users);
        _IDB.addObject(new User(null,
                "anserbutt",
                "anserbutt@gmail.com",
                "Anser",
                "Butt",
                "Male",
                "03001235644",
                new Date(),
                "studios.com",
                "bio",
                null,
                null), IDB_Operations.ModelType.Users);
        _IDB.addObject(new User(null,
                "alihumza",
                "alihumza@gmail.com",
                "Ali",
                "Humza",
                "Male",
                "03001234456",
                new Date(),
                "studios.com",
                "bio",
                null,
                null), IDB_Operations.ModelType.Users);
        _IDB.addObject(new User(null,
                "rehmanbutt",
                "rehmanbutt@gmail.com",
                "Rehman",
                "Butt",
                "Male",
                "03001234456",
                new Date(),
                "studios.com",
                "bio",
                null,
                null), IDB_Operations.ModelType.Users);
        _IDB.addObject(new User(null,
                "usamazahid",
                "usamazahid@gmail.com",
                "Usama",
                "Zahid",
                "Male",
                "03001234456",
                new Date(),
                "studios.com",
                "bio",
                null,
                null), IDB_Operations.ModelType.Users);
        _IDB.addObject(new User(null,
                "haseebahmed",
                "haseebahmed@gmail.com",
                "Haseeb",
                "Ahmed",
                "Male",
                "03001234456",
                new Date(),
                "studios.com",
                "bio",
                null,
                null), IDB_Operations.ModelType.Users);
*/

        //add object
        //_IDB.addObject(new Like(null,"TD4mSFzDUBJXas7Emj0N",null), IDB_Operations.ModelType.Likes);
      /*  IModel _object =  _IDB.getObject("vK0qiLVNh3CA7c66QlCh", IDB_Operations.ModelType.Likes);
        System.out.println(((Like)_object).userId);*/

        //get list of objects
        /*ArrayList<String> objectIds = new ArrayList<String>();
        objectIds.add("7FaaX7kg8M8lRIqfYzMh");
        objectIds.add("E0zzH66ulW3GEoevTgmx");
        objectIds.add("atvNZf2Hi0rbwJrjJHVc");*/
       /* HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("phoneNumber", "03001234456");
        map.put("gender","Male");
        map.put("website","1studios.com");
        map.put("lastName","Hassan");
        ArrayList<IModel> _objects = _IDB.getObjectsList(map, IDB_Operations.ModelType.Users);
        if (_objects != null) {
            for (IModel _object : _objects) {
                User user = ((User) _object);
                if (user != null) {
                    System.out.println(user.username);
                }
            }
        }*/
        //remove object
        /*HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("phoneNumber", "03001234456");
        map.put("gender","gender");
        map.put("website","2studios.com");
        map.put("lastName","Hassan");*/
        /*Pair<String ,Object> pair = new Pair<String, Object>("blockedUsersList", "atvNZf2Hi0rbwJrjJHVc");
        _IDB.updateArrayObject("buxocf1ivbTgdcroluOn",pair,IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.Users);

        Pair<String ,Object> pair2 = new Pair<String, Object>("blockedUsersList", "7FaaX7kg8M8lRIqfYzMh ");
        _IDB.updateArrayObject("buxocf1ivbTgdcroluOn",pair2,IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.Users);

        Pair<String ,Object> pair3 = new Pair<String, Object>("blockedUsersList", "buxocf1ivbTgdcroluOn");
        _IDB.updateArrayObject("buxocf1ivbTgdcroluOn",pair3, IDB_Operations.UpdateOperation.Add,IDB_Operations.ModelType.Users);*/
    }
}