package DB_Firebase;

import Models.IDB_Operations;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        IDB_Operations _IDB = new DB_FirebaseOperations();
        _IDB.initDB();
        //added all group members
       /* _IDB.addObject(new User(null,
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
                null), IDB_Operations.ModelType.Users);*/

        //add object
       /* IModel _object =  _IDB.getObject("TmfogDtTYA4kk5SF5gZv", IDB_FirebaseOperations.ModelType.Users);
        System.out.println(_object.getID());*/

        //get list of objects
        /*ArrayList<String> objectIds = new ArrayList<String>();
        objectIds.add("TmfogDtTYA4kk5SF5gZv");
        objectIds.add("UBlkTuejFwjTJavHRSi3");
        ArrayList<IModel> _objects = _IDB.getObjectsList(objectIds, IDB_Operations.ModelType.Users);
        if(_objects!=null) {
            for (IModel _object : _objects) {
                User user = ((User) _object);
                if(user!=null) {
                    System.out.println(user.username);
                }
            }
        }*/

        //remove object
        /*_IDB.removeObject("TmfogDtTYA4kk5SF5gZv", IDB_FirebaseOperations.ModelType.Users);*/
    }
}