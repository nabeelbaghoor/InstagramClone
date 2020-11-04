package DB_Firebase.company;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseMethods {
    public static void initFirebase() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream(".\\instagramclone-58441-firebase-adminsdk-taebo-2cba3bad0c.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        //.setDatabaseUrl("https://instagramclone-58441.firebaseio.com")

        FirebaseApp.initializeApp(options);
    }
}