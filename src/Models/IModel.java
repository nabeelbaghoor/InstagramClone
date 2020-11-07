package Models;

import java.sql.Timestamp;

public interface IModel {
    String getID();

    void setID(String id);

    void setTimestamp(Timestamp _timestamp);
}
