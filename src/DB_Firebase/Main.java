package DB_Firebase;

import Models.IDB_Operations;
import Models.IModel;
import Models.Like;

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
        IModel _object =  _IDB.getObject("ApxgTOfsNLVzHENkx6pl", IDB_Operations.ModelType.Likes);
        System.out.println(((Like)_object).timestamp);

        //get list of objects
  /*      ArrayList<String> objectIds = new ArrayList<String>();
        objectIds.add("xECfetjpysBxJilVLyf4");
        objectIds.add("sD3TyX1DPGXnI7QmYODc");
        objectIds.add("GqTxH2YqK96iiM1Yy8TR");
        //HashMap<String, Object> map = new HashMap<String, Object>();
        //map.put("phoneNumber", "03001234456");
        ArrayList<IModel> _objects = _IDB.getObjectsList(objectIds, IDB_Operations.ModelType.Users);
        if (_objects != null) {
            for (IModel _object : _objects) {
                User user = ((User) _object);
                if (user != null) {
                    System.out.println(user.username);
                }
            }
        }*/
        //remove object
        /*_IDB.removeObject("TmfogDtTYA4kk5SF5gZv", IDB_FirebaseOperations.ModelType.Users);*/
    }
}