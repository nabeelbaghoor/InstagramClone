package DB_Text;

import Models.IDB_Operations;
import Models.Post;
import Models.User;
import java.sql.Timestamp;
import java.util.Date;    import java.io.IOException;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;public class Main {


    public static void main(String[] args) throws IOException {
        dbtext obj = new dbtext();
        ArrayList<String> followers = new ArrayList<String>();
        followers.add("maza");
        followers.add("xyz");
        ArrayList<String> blocklist = new ArrayList<String>();
        followers.add("kas");
        followers.add("asad");
        ArrayList<String> following_list = new ArrayList<String>();
        followers.add("fatoo");
        followers.add("imrankhan");
        Post post = new Post();

//        Timestamp timestamp = new com.google.cloud.Timestamp _timestamp;
        //User us = new User("aa",
        User u = new User("99", "mazanaqvi", "ahmadhamzanaqvi@gmail.com", "ahmad", "hamza", "male", "03333839512", null, "mm", "klkklkkl", null, "f:\\");
        User ucc = new User("99", "mazanaqvi", "ahmadhamzanaqvi@gmail.com", "ahmad", "hamza", "male", "03333839512", null, "mm", "klkklkkl", null, "f:\\");
        IDB_Operations.ModelType modelType;//= new IDB_Operations.ModelType();
        //modelType.

        dbtext dbt = new dbtext();
        dbt.saveuser(u);
        dbt.loaduser();

        dbt.saveuser(ucc);
        dbt.loaduser();


    }

}
