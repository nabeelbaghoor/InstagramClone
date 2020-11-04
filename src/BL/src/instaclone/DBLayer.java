/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.src.instaclone;

/**
 *
 * @author inspiron
 */
public interface DBLayer {
    public boolean writeNotification(String myid, String postid, String userid, String msg);
    public boolean removeFollower(String user);
    
}