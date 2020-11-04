package DB_Firebase.company;
import BL.src.instaclone.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import java.util.concurrent.ExecutionException;

public class UserOperations implements IUser {
    public User getUser(String userid) throws ExecutionException, InterruptedException //returns User object with key == userid
    {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef  = db.collection("Users").document(userid);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // block on response
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            // convert document to User
            User _user = document.toObject(User.class);
            System.out.println(_user);
            return _user;
        } else {
            System.out.println("No such document!");
            return null;
        }
    }
    /*we actually don't need addUser,we will manually add few user by default
    Firebase will create documentId(userid) ,and we will assign it*/
    public String addUser(User user) throws ExecutionException, InterruptedException   //returns userid of new created user
    {
        Firestore db = FirestoreClient.getFirestore();
        // Add document data after generating an id.
        DocumentReference addedDocRef = db.collection("Users").document();
        user.setUserID(addedDocRef.getId());
        ApiFuture<WriteResult> writeResult = addedDocRef.set(user);
        System.out.println("Successfully updated at: " + writeResult.get().getUpdateTime());
        return  user.getUserID();
    }
    public boolean removeUser(String userid)  //removes user , and returns boolean
    {
        return true;
    }
    public boolean updateUser(String userid,User user) //overwrites the user with key == usserid
    {
        return true;
    }
}
