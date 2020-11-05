package DB_Firebase;

import Models.IDB_Operations;
import Models.IModel;
import Models.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        IDB_Operations _IDB = new DB_FirebaseOperations();
        _IDB.initDB();
        //  _IDB.addObject(new User(null,"Sarim",null,null,null), IDB_FirebaseOperations.ModelType.Users);
        // _IDB.addObject(new User(null,"Ali",null,null,null),IDB_FirebaseOperations.ModelType.Users);
        // _IDB.addObject(new User(null,"Faizan",null, null,null),IDB_FirebaseOperations.ModelType.Users);
        // _IDB.addObject(new User(null,"Faris",null,null, null),IDB_FirebaseOperations.ModelType.Users);

        /*_IDB.addObject(new Comment(null,"CLOvb3RxrWp8Ue0nfCmM","TmfogDtTYA4kk5SF5gZv","Hahahahahhhahahah"),IDB_FirebaseOperations.ModelType.Comments);*/

       /* Vector<String> _likedBy =  new Vector<String>();
        _likedBy.add("TmfogDtTYA4kk5SF5gZv");
        _likedBy.add("pUf8yYkacNgeRufL8v8O");
        _IDB.addObject(new Post(null,"TmfogDtTYA4kk5SF5gZv",_likedBy),IDB_FirebaseOperations.ModelType.Posts);*/

        //add object
       /* IModel _object =  _IDB.getObject("TmfogDtTYA4kk5SF5gZv", IDB_FirebaseOperations.ModelType.Users);
        System.out.println(_object.getID());*/

        //get list of objects
        ArrayList<String> objectIds = new ArrayList<String>();
        objectIds.add("TmfogDtTYA4kk5SF5gZv");
        objectIds.add("UBlkTuejFwjTJavHRSi3");
        ArrayList<IModel> _objects = _IDB.getObjectsList(objectIds, IDB_Operations.ModelType.Users);
        for (IModel _object : _objects) {
            System.out.println(((User) _object).username);
        }

        //remove object
        /*_IDB.removeObject("TmfogDtTYA4kk5SF5gZv", IDB_FirebaseOperations.ModelType.Users);*/
    }
}