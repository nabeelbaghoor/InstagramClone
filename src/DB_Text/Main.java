package DB_Text;

import DB_Firebase.DB_FirebaseOperations;
import Models.IDB_Operations;
import com.google.firebase.database.utilities.Pair;

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

        Pair<String, Object> pair = new Pair<String, Object>("commentsList", "WKhmPAS8GPB1RrZHXYCz");
        _IDB_Text.updateArrayObject("H0L4e918lZp5ugEEciCo",pair, IDB_Operations.UpdateOperation.Remove, IDB_Operations.ModelType.Posts);
         }
}