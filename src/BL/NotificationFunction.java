package BL;

import Models.IDB_Operations;
import Models.Notification;
import Models.User;
import com.google.firebase.database.utilities.Pair;

import java.util.concurrent.ExecutionException;

public class NotificationFunction {
    private final IDB_Operations DB;
    public NotificationFunction(IDB_Operations _obj) {
        DB=_obj;
    }

    public boolean removeNotification(String id, String userid) throws ExecutionException, InterruptedException {
        boolean flag = false;
        try {
            flag = DB.removeObject(id, IDB_Operations.ModelType.Notifications);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        Pair<String, Object> pair = new Pair<String, Object>("notificationList", id);
        DB.updateArrayObject(userid, pair, IDB_Operations.UpdateOperation.Remove, IDB_Operations.ModelType.Users);
        return flag;
    }

    public String sendNotification(String userid, String myid, String postid, String msg) throws ExecutionException, InterruptedException {
        Notification obj = new Notification();
        obj.viewerId = userid;
        obj.sharerId = myid;
        obj.postId = postid;
        obj.msg = msg;
        obj.isViewed = false;
        obj.shouldShow = true;

        User temp = null;
        try {
            temp = (User) DB.getObject(userid, IDB_Operations.ModelType.Users);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        assert temp != null;
        if (temp.blockedUsersList.contains(myid))
            obj.shouldShow = false;

        String ans = null;

        try {
            ans = DB.addObject(obj, IDB_Operations.ModelType.Notifications);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        Pair<String, Object> pair = new Pair<String, Object>("notificationList", ans);
        DB.updateArrayObject(userid, pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.Users);

        return ans;
    }
}
