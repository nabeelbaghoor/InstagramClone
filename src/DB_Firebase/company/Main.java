package DB_Firebase.company;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
       FirebaseMethods.initFirebase();
       IDBOperations _IUser = new UserOperations();
        //_IUser.addUser(new User(null,"Sarim"));
        //_IUser.addUser(new User(null,"Ali"));
        //_IUser.addUser(new User(null,"Faizan"));
        //_IUser.addUser(new User(null,"Faris"));
        String currentUserId = "8X0FIpj5qBeKk5gbRxTf";
        System.out.println("User Data:\t" + _IUser.getUser(currentUserId).getUserName());
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