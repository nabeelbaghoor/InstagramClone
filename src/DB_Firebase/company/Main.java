package DB_Firebase.company;

import BL.src.instaclone.User;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        FileInputStream serviceAccount =
                new FileInputStream(".\\instagramclone-58441-firebase-adminsdk-taebo-2cba3bad0c.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
                //.setDatabaseUrl("https://instagramclone-58441.firebaseio.com")

        FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore();
        User _user = new User("user1","nabeelbaghoor");
        Map<String, Object> user = new HashMap<>();
        user.put(_user.getUserID(),_user);
        ApiFuture<WriteResult> future  = db.collection("Users").document("user1").set(user, SetOptions.merge());
        System.out.println("Successfully updated at: " + future.get().getUpdateTime());
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