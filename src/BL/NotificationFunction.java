package BL;

import Models.IDB_Operations;
import Models.Notification;
import Models.User;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class NotificationFunction {

    public NotificationFunction() {
    }

    public boolean removeNotification(String id,String userid) {
        boolean flag = false;
        try {
            flag = Layers.DBLayer.removeObject(id, IDB_Operations.ModelType.Notifications);
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        HashMap<String,String> map = new HashMap<>();
        map.put("notificationList",id);
        Layers.DBLayer.updateArrayObject(userid,map, IDB_Operations.UpdateOperation.Remove, IDB_Operations.ModelType.Users);
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
            temp = (User)Layers.DBLayer.getObject(userid, IDB_Operations.ModelType.Users);
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        assert temp != null;
        if (temp.blockedUsersList.contains(myid))
            obj.shouldShow = false;

        String ans = null;

        try {
            ans = Layers.DBLayer.addObject(obj, IDB_Operations.ModelType.Notifications);
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        HashMap<String,String> map = new HashMap<>();
        map.put("notificationList",ans);
        Layers.DBLayer.updateArrayObject(userid,map, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.Users);

        return ans;
    }
}
