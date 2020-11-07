package DB_Text;
import Models.IDB_Operations;
import Models.User;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//import org.json.simple.JSONObject;

public class dbtext {
    private Object JSONObject;

    public dbtext() throws FileNotFoundException {
    }

    void saveuser( User u) throws IOException, JSONException {

        ArrayList<String> listdata = new ArrayList<String>();
        JSONArray jArray = (JSONArray) JSONObject;
        if (jArray != null) {
            for (int i=0;i<jArray.length();i++){
                listdata.add(jArray.getString(i));
            }
        }
        String s=u.toString();

        Gson gson=new Gson();

        String ss=gson.toJson(u);
        //Write JSON file
        try (FileWriter file = new FileWriter("E:\\j.json")) {

            file.write(ss);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public int documentToClassType( IDB_Operations.ModelType modelType) {
        switch (modelType) {
            case Likes:
                return 3;
            case Posts:
                return 2;
            case Users:
                return 1;//document.toObject(User.class);
            case Comments:
                return 4;//document.toObject(Comment.class);
            case Notifications:
                return 5;//document.toObject(Notification.class);
            default:
                return 0;
        }
    }
    void loaduser() throws FileNotFoundException {

        File myObj = new File("E:\\j.json");
        Scanner myReader = new Scanner(myObj);

        String data = myReader.nextLine();
        System.out.println("\n"+data);
        myReader.hasNextLine();
        myReader.close();
        Gson deseri=new Gson();
        User u3=deseri.fromJson(data,User.class);
        System.out.println("User Details\n");
        System.out.println("\n"+u3.getID());
        System.out.println("\n"+u3.firstName);
    }

}






