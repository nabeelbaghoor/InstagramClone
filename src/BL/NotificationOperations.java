package BL;

import Models.IDB_Operations;
import Models.Notification;
import Models.User;
import com.google.firebase.database.utilities.Pair;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class NotificationOperations {
    private final IDB_Operations DB;

    public NotificationOperations(IDB_Operations _obj) {
        DB = _obj;
    }

    public boolean removeNotification(String id, String userid) throws Exception {
        boolean flag = false;
        try {
            flag = DB.removeObject(id, IDB_Operations.ModelType.Notification);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        Pair<String, Object> pair = new Pair<String, Object>("notificationList", id);
        DB.updateArrayObject(userid, pair, IDB_Operations.UpdateOperation.Remove, IDB_Operations.ModelType.User);
        return flag;
    }

    public String sendNotification(String userid, String myid, String postid, String msg) throws Exception {
        Notification obj = new Notification();
        obj.viewerId = userid;
        obj.sharerId = myid;
        obj.postId = postid;
        obj.msg = msg;
        obj.isViewed = false;
        obj.shouldShow = true;

        User temp = null;
        try {
            temp = (User) DB.getObject(userid, IDB_Operations.ModelType.User);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        assert temp != null;
        if (temp.blockedUsersList.contains(myid))
            obj.shouldShow = false;

        String ans = null;

        try {
            ans = DB.addObject(obj, IDB_Operations.ModelType.Notification);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        Pair<String, Object> pair = new Pair<String, Object>("notificationList", ans);
        DB.updateArrayObject(userid, pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.User);

        return ans;
    }

    public boolean setIsViewwed(String notifid) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("isViewed",true);
        try {
            return DB.updateObject(notifid,map, IDB_Operations.ModelType.Notification);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
