
package BL.src.instaclone;

import java.util.Vector;

/**
 *
 * @author inspiron
 */
public class Profile implements Layers{
    private Vector<User> followers;
    private Vector<User> blockedList;
    private Vector<User> followingList;
    
    public Profile(){
      
    }

    
    public boolean removeFollower(String userid, String myid){
        for (int i=0; i < followers.size(); i++)
            if (followers.get(i).equals(userid))
                if(DBUsed.removeFollower(userid)){
                    followers.remove(i);
                    return true;
                }
                    
         
        return false;       
    }
    
//    public String getFollowers(){
//        JsonArrayBuilder kvArrBld = Json.createArrayBuilder();
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        JsonObjectBuilder jBuilder = Json.createObjectBuilder();
//        for (int i = 0; i < followers.size() ; i++)
//            addJObj(followers.get(i), jBuilder);
//        
//        StringWriter str = new StringWriter();
//        JsonObject jobj = jBuilder.build();
//        JsonWriter jstr = Json.createWriter(str);
//        jstr.writeObject(jobj);
//        jstr.close();
//       
//        return str.toString();
//    }
//    
}
