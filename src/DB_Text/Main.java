package DB_Text;

import DB_Firebase.DB_FirebaseOperations;
import Models.IDB_Operations;
import Models.IModel;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        IDB_Operations _IDB_Firebase = new DB_FirebaseOperations();
        _IDB_Firebase.initDB();
         IDB_Operations _IDB_Text = new DB_TextOperations();
        _IDB_Text.initDB();

        /*_IDB_Text.addObject(
                _IDB_Firebase.getObject("ClenGXKpdw6JCEJ1ZKLk", IDB_Operations.ModelType.Posts) ,
            IDB_Operations.ModelType.Posts
        );*/
        /*_IDB_Text.getObject("9pn3HOdtQ2ZAEYcCumKs", IDB_Operations.ModelType.Posts).print()*/;
        //_IDB_Text.removeObject("MWAy2U6SGdbfwjcptrwa", IDB_Operations.ModelType.Users);


        HashMap<String,Object > attributesToQuery = new HashMap<String ,Object>();
        attributesToQuery.put("postId","ClenGXKpdw6JCEJ1ZKLk");
        ArrayList<IModel> _objects  = _IDB_Text.getObjectsList(attributesToQuery,IDB_Operations.ModelType.Posts);
        if(_objects!=null) {
            for (IModel object : _objects) {
                object.print();
            }
        }
    }
}