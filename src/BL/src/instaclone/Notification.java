/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaclone;

/**
 *
 * @author inspiron
 */
public class Notification implements Layers{
    private String msg;
    
    public Notification(String m){
        msg = m;
    }
    
    public boolean sendNotification(String myid,String postid, String userid){
        return DBUsed.writeNotification(myid, postid, userid, msg);
    }
}
