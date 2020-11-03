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
public class DBLayer1 implements DBLayer{
    public boolean writeNotification(String myid, String postid, String userid, String msg){
        return true;
    }
    
    public boolean removeFollower(String user){
        return true;
    }
}
