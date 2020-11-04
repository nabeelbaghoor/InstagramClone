/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.src.instaclone;

import javax.json.JsonObjectBuilder;

/**
 *
 * @author inspiron
 */
public class Functions {
    public static void addJObj(User obj, JsonObjectBuilder jobj){
        jobj.add("User Name", obj.getUserName());
        jobj.add("User ID",obj.getUserID());
    }
}
