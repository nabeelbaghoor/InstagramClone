package BL.src.instaclone;

public class User{
    private String username;
    private String myid;
    //private Profile myProfile;

    public User(){
        username = "Anser";
    }
    
    public User(String userid, String user){
        username = user;
        myid = userid;
    }
    
    public String getUserName(){return username;}
    public String getUserID(){return myid;}
    public void setUserName(String _username){
        username = _username;
    }
    public void setUserID(String _userid){
        myid = _userid;
    }


//    public boolean likePost(String postid,String userid){
//        PostOperation temp = new PostOperation();
//        if(temp.sendNotification(myid,postid,userid))
//            if(temp.addLike(postid,myid))
//                return true;
//        return false;
//    }
}