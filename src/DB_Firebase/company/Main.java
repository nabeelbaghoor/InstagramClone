package DB_Firebase.company;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
       FirebaseMethods.initFirebase();
       IDB_FirebaseOperations _IDB = new DB_FirebaseOperations();
        //  _IDB.addObject(new User(null,"Sarim",null,null,null), IDB_FirebaseOperations.ModelType.Users);
        // _IDB.addObject(new User(null,"Ali",null,null,null),IDB_FirebaseOperations.ModelType.Users);
        // _IDB.addObject(new User(null,"Faizan",null, null,null),IDB_FirebaseOperations.ModelType.Users);
        // _IDB.addObject(new User(null,"Faris",null,null, null),IDB_FirebaseOperations.ModelType.Users);

        /*_IDB.addObject(new Comment(null,"CLOvb3RxrWp8Ue0nfCmM","TmfogDtTYA4kk5SF5gZv","Hahahahahhhahahah"),IDB_FirebaseOperations.ModelType.Comments);*/

       /* Vector<String> _likedBy =  new Vector<String>();
        _likedBy.add("TmfogDtTYA4kk5SF5gZv");
        _likedBy.add("pUf8yYkacNgeRufL8v8O");
        _IDB.addObject(new Post(null,"TmfogDtTYA4kk5SF5gZv",_likedBy),IDB_FirebaseOperations.ModelType.Posts);*/

       /* IModel _object =  _IDB.getObject("TmfogDtTYA4kk5SF5gZv", IDB_FirebaseOperations.ModelType.Users);
        System.out.println(_object.getID());*/

        /*ArrayList<String> objectIds = new  ArrayList<String>();
        objectIds.add("TmfogDtTYA4kk5SF5gZv");
        objectIds.add("UBlkTuejFwjTJavHRSi3");
        for (String _object : objectIds) {
            System.out.println(_object);
        }
        ArrayList<IModel> _objects =  _IDB.getObjectsList(objectIds, IDB_FirebaseOperations.ModelType.Users);
        for (IModel _object : _objects) {
            System.out.println(((User)_object).username);
        }*/

        /*_IDB.removeObject("TmfogDtTYA4kk5SF5gZv", IDB_FirebaseOperations.ModelType.Users);*/
    }
}


 /*// As an admin, the app has access to read and write all data, regardless of Security Rules
        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference("restricted_access/secret_document");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object document = dataSnapshot.getValue();
                System.out.println(document);
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });*/