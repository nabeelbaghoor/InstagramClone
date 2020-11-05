/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.security.Timestamp;

/**
 * @author inspiron
 */
public class Notification implements IModel {
    //We call it as ACtivity
    //viewed(booleean),notifID,postId,sharerID,viewerID,dateTime(Timestamp)
    //no msg text feature
    //tobeshown(boolean),if blocked ,make query on blockuser action,
    public String notificationId;
    public String postId;
    public String sharerId;
    public String viewerId;
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

    public Notification(String _notificationId, String _postId, String _sharerId, String _viewerId,
                        boolean _isViewed, boolean _shouldShow, Timestamp _timestamp) {
        notificationId = _notificationId;
        postId = _postId;
        sharerId = _sharerId;
        viewerId = _viewerId;
        isViewed = _isViewed;
        shouldShow = _shouldShow;
        timestamp = _timestamp;
    }

    public String getID() {
        return notificationId;
    }

    public void setID(String _notificationId) {
        notificationId = _notificationId;
    }
}
