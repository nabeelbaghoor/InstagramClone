/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.google.cloud.Timestamp;

/**
 * @author inspiron
 */
public class Notification implements IModel {
    public String notificationId;
    public String postId;
    public String sharerId;
    public String viewerId;
    public String msg;
    /*isViewed:
    Notification badge will be shown on it, if not yet viewed
     */
    public boolean isViewed;
    /*shouldShow:
    if this sharer is blocked by this viewer, this notification will not be shown in Activity Panel*/
    public boolean shouldShow;
    Timestamp timestamp;

    public Notification() {
    }

    public Notification(String _notificationId, String _postId, String _sharerId, String _viewerId, String _msg,
                        boolean _isViewed, boolean _shouldShow, Timestamp _timestamp) {
        notificationId = _notificationId;
        postId = _postId;
        sharerId = _sharerId;
        viewerId = _viewerId;
        isViewed = _isViewed;
        shouldShow = _shouldShow;
        timestamp = _timestamp;
        msg = _msg;
    }

    public String getID() {
        return notificationId;
    }

    public void setID(String _notificationId) {
        notificationId = _notificationId;
    }

    @Override
    public void setTimestamp(com.google.cloud.Timestamp _timestamp) {
        timestamp = _timestamp;
    }

    @Override
    public void print() {
        System.out.println("notificationId = " + notificationId);
        System.out.println("postId = " + postId);
        System.out.println("sharerId = " + sharerId);
        System.out.println("viewerId = " + viewerId);
        System.out.println("msg = " + msg);
        System.out.println("isViewed = " + isViewed);
        System.out.println("shouldShow = " + shouldShow);
        System.out.println("timestamp = " + timestamp.toString());

        System.out.println("-----------------------------------------------------------------" + "\n");
    }
}
