/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import BL.src.instaclone.Layers;

import java.security.PublicKey;

/**
 *
 * @author inspiron
 */
public class Notification implements IModel{
    public String NotifID;
    public String msg;
    public String sender;
    public String receiver;

    public Notification(){
        NotifID = "";
        msg = "";
        sender = "";
        receiver = "";
    }

    public String getID(){return NotifID;}

    public void setID(String id){NotifID = id;}

}
