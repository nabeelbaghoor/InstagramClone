/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Models.Notification;

/**
 *
 * @author inspiron
 */
public class PostOperation {

    PostOperation(){ }

    public boolean sendNotification(String userid, String myid, String postid,String msg) {
        Notification obj = new Notification();
        obj.receiver = userid;
        obj.msg = msg;
        obj.sender = myid;
        obj.postID = postid;

        NotificationFunction temp = new NotificationFunction();
        return temp.sendNotification(obj);
    }

    public boolean addLike(String userid, String postid){
        //DB Code
        return true;
    }

    public boolean removeNotification(String userid, String myid, String postid,String msg) {
        Notification obj = new Notification();
        obj.receiver = userid;
        obj.sender = msg;
        obj.sender = myid;
        obj.postID = postid;

        NotificationFunction temp = new NotificationFunction();
        return temp.removeNotification(obj);
    }

    public boolean unLike(String myid, String postid){
        //DB Code
        return true;
    }
}

