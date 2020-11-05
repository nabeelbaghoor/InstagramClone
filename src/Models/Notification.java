/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author inspiron
 */
public class Notification extends Model{
    public String NotifID;
    public String msg;
    public String sender;
    public String receiver;

    public Notification(){

    }
    public  Notification(String _NotifID,String _msg,String _sender,String _receiver){
        NotifID = _NotifID;
        msg = _msg;
        sender = _sender;
        receiver = _receiver;
    }
    public String getID(){return NotifID;}

    public void setID(String id){NotifID = id;}

}
