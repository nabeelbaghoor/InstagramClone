package Models;


import com.google.cloud.Timestamp;

public interface IModel {
    String getID();

    void setID(String id);

    void setTimestamp(Timestamp _timestamp);

    void print();
}
