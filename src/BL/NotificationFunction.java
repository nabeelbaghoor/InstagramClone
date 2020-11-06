package BL;

import Models.IDB_Operations;
import Models.Notification;
import Models.User;

import java.util.concurrent.ExecutionException;

public class NotificationFunction {
    private final Layers layer = new Layers();

    public NotificationFunction() {
    }

    public boolean removeNotification(String id) {
        boolean flag = false;
        try {
            flag = layer.DBLayer.removeObject(id, IDB_Operations.ModelType.Notifications);
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public String sendNotification(String userid, String myid, String postid, String msg) {
        Notification obj = new Notification();
        obj.viewerId = userid;
        obj.sharerId = myid;
        obj.postId = postid;
        obj.msg = msg;
        obj.isViewed = false;
        obj.shouldShow = true;

        User temp = null;
        try {
            temp = (User)layer.DBLayer.getObject(userid, IDB_Operations.ModelType.Users);
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        assert temp != null;
        if (temp.blockedUsersList.contains(myid))
            obj.shouldShow = false;

        String ans = null;

        try {
            ans = layer.DBLayer.addObject(obj, IDB_Operations.ModelType.Notifications);
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return ans;
    }
}
