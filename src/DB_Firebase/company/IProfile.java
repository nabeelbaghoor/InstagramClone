package DB_Firebase.company;

import BL.src.instaclone.Profile;

import java.util.concurrent.ExecutionException;

public interface IProfile extends IDBOperations {
    public Profile getProfile(String profileId) throws ExecutionException, InterruptedException;
    public String addProfile(Profile profile) throws ExecutionException, InterruptedException;
    public boolean removeProfile(String profileId);
    public boolean updateProfile(String profileId,Profile profile);
}
