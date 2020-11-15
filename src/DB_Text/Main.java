package DB_Text;

import Models.*;
import com.google.firebase.database.utilities.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws Exception {

    }

    public static void CreateDummyDB() throws Exception {
        IDB_Operations _IDB = new DB_TextOperations();
        _IDB.initDB();
        //add users
        for (User user : Arrays.asList(new User(null, "nabeelbaghoor", "nabeelbaghoor@gmail.com", "Nabeel", "Hassan", "Male", "03001234456", new Date(), "nabeelbaghoor.me", "Trying to remember who I was before the world told me who to be.", null, ".\\Images\\brackeys.png"), new User(null, "anserbutt", "anserbutt@gmail.com", "Anser", "Butt", "Male", "03001235644", new Date(), "anserbutt.com", "We have tomorrows for a reason.", null, ".\\Images\\brackeys.png"), new User(null, "alihumza", "alihumza@gmail.com", "Ali", "Humza", "Male", "03001234456", new Date(), "alihumza.bio", "Trying to remember who I was before the world told me who to be.", null, ".\\Images\\brackeys.png"), new User(null, "rehmanbutt", "rehmanbutt@gmail.com", "Rehman", "Butt", "Male", "03001759445", new Date(), "rehmanbutt.bio", "Just making sure to love life.", null, ".\\Images\\brackeys.png"), new User(null, "usamazahid", "usamazahid@gmail.com", "Usama", "Zahid", "Male", "03001234466", new Date(), "usamazahid.me", "When it rains look for rainbows when it’s dark I look for stars.", null, ".\\Images\\brackeys.png"), new User(null, "haseebahmed", "haseebahmed@gmail.com", "Haseeb", "Ahmed", "Male", "03001233341", new Date(), "studios.com", "We have tomorrows for a reason.", null, ".\\Images\\brackeys.png"), new User(null, "alitaimur", "alitaimur@gmail.com", "Ali", "Taimur", "Male", "03006050500", new Date(), "alitaimur.me", "I don’t want to forget something that once made us smile", null, ".\\Images\\brackeys.png"), new User(null, "Ahsanzafar", "Ahsanzafar@gmail.com", "Ahsan", "Zafar", "Male", "03001235634", new Date(), "Ahsanzafar.me", "Don’t ever be afraid to shine.", null, ".\\Images\\brackeys.png"), new User(null, "HassanFarooq", "HassanFarooq@gmail.com", "Hassan", "Farooq", "Male", "03001234477", new Date(), "HassanFarooq.me", "Creating my own sunshine.", null, ".\\Images\\brackeys.png"), new User(null, "MudassirWaheed", "MudassirWaheed@gmail.com", "Mudassir", "Waheed", "Male", "03001232400", new Date(), "MudassirWaheed.me", "Going where I feel most alive.", null, ".\\Images\\brackeys.png"), new User(null, "Ahmedmukhtar", "Ahmedmukhtar@gmail.com", "Ahmed", "Mukhtar", "Male", "03001254432", new Date(), "Ahmedmukhtar.com", "Die having memories don’t die with just dreams.", null, ".\\Images\\brackeys.png"), new User(null, "SuffianSheikh", "SuffianSheikh@gmail.com", "Suffian", "Sheikh", "Male", "03001234445", new Date(), "SuffianSheikh.me", "You is kind, you is smart, you is important.", null, ".\\Images\\brackeys.png"), new User(null, "AhmedNoor", "AhmedNoor@gmail.com", "Ahmed", "Noor", "Male", "03006060234", new Date(), "AhmedNoor.me", " survived because the fire inside me burned brighter than the fire around me.", null, ".\\Images\\brackeys.png"), new User(null, "HassanRaza", "HassanRaza@gmail.com", "Hassan", "Raza", "Male", "03001235234", new Date(), "HassanRaza.me", "Life is what happens to you while you scroll through Instagram.", null, ".\\Images\\brackeys.png"), new User(null, "FahadAhmed", "FahadAhmed@gmail.com", "Fahad", "Ahmed", "Male", "03001234546", new Date(), "FahadAhmed.com", "It won’t always be easy, but always try to do what’s right.", null, ".\\Images\\brackeys.png"), new User(null, "AqibAmir", "AqibAmir@gmail.com", "Aqib", "Amir", "Male", "03001234789", new Date(), "AqibAmir.com", "Just make sure to love your life.", null, ".\\Images\\brackeys.png"), new User(null, "FaisalLatif", "FaisalLatif@gmail.com", "Faisal", "Latif", "Male", "03001234666", new Date(), "FaisalLatif.me", "A warrior in a world of worriers.", null, ".\\Images\\brackeys.png"), new User(null, "AbidAli", "AbidAli@gmail.com", "Abid", "Ali", "Male", "03001234879", new Date(), "AbidAli.com", "These are the days we live for.", null, ".\\Images\\brackeys.png"), new User(null, "FaizaAhmed", "FaizaAhmed@gmail.com", "Faiza", "Ahmed", "Female", "03001231112", new Date(), "FaizaAhmed.com", "I'm not perfect, but stories are always better with a touch of imperfection..", null, ".\\Images\\brackeys.png"), new User(null, "NaziaButt", "NaziaButt@gmail.com", "Nazia", "Butt", "Female", "03001233332", new Date(), "NaziaButt.com", "Just make sure to love your life.", null, ".\\Images\\brackeys.png"), new User(null, "SidraFarooq", "SidraFarooq@gmail.com", "Sidra", "Farooq", "Female", "03002324666", new Date(), "SidraFarooq.com", "Turned my dreams into my vision and my vision into my reality..", null, ".\\Images\\brackeys.png"), new User(null, "ShafaqNaz", "ShafaqNaz@gmail.com", "Shafaq", "Naz", "Female", "03001234345", new Date(), "ShafaqNaz.me", "Leaving a bit of sparkle everywhere I go", null, ".\\Images\\brackeys.png"))) {
            _IDB.addObject(user, IDB_Operations.ModelType.User);
        }
        //get those users
        ArrayList<String> userIds = new ArrayList<>();
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("gender","Female");
        map.put("gender","Male");
        ArrayList<IModel> models = _IDB.getObjectsList(
                map,
                IDB_Operations.ModelType.User);
        //follow,following,block....
        for (IModel model:models) {
            userIds.add(model.getID());
            if (userIds.size() > 1) {
                //follow,following
                for (int i = 0; i < userIds.size(); i++) {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, userIds.size());
                    Pair<String, Object> pair = new Pair<String, Object>("followersList", userIds.get(randomNum));
                    _IDB.updateArrayObject(userIds.get(userIds.size() - 1), pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.User);
                    Pair<String, Object> pair2 = new Pair<String, Object>("followingsList", userIds.get(userIds.size() - 1));
                    _IDB.updateArrayObject(userIds.get(randomNum), pair2, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.User);
                }
                //block
                int outRandomNum = ThreadLocalRandom.current().nextInt(0, 2);
                for (int i = 0; i < outRandomNum; i++) {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, userIds.size());
                    Pair<String, Object> pair = new Pair<String, Object>("blockedUsersList", userIds.get(randomNum));
                    _IDB.updateArrayObject(userIds.get(userIds.size() - 1), pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.User);
                }
            }
        }

        ArrayList<String> postIds = new ArrayList<>();
        ArrayList<String> likeIds = new ArrayList<>();
        ArrayList<String> commentIds = new ArrayList<>();
        userIds.clear();

        //previous Users
        for (int userIdIndex = 0; userIdIndex <models.size() ; userIdIndex++) {
            userIds.add(models.get(userIdIndex).getID());
            //post
            for (int i = 0; i < 5; i++) {

                int postRandomNum = ThreadLocalRandom.current().nextInt(2, 5);
                if (postRandomNum > 3) {
                    int postTextRandomNum = ThreadLocalRandom.current().nextInt(0, 9);
                    postIds.add(_IDB.addObject(new Post(
                            null,
                            userIds.get(userIds.size() - 1),
                            ".\\Images\\s.png",
                            Arrays.asList(
                                    "Winter is not a season; it's a celebration.",
                                    "Live in the sunshine. Swim in the sea. Drink in the wild air.",
                                    "A little bit of summer is what the whole year is all about",
                                    "Live in the sunshine. Swim in the sea. Drink in the wild air.",
                                    "Happy Sunday! There may be no excuse for laziness, but [I'm/we're] still looking",
                                    "It is better to fail in originality than to succeed in imitation",
                                    "Always bear in mind that your own resolution to succeed is more important than any other.",
                                    "Diversity isn't a recruitment metric — it's an ingredient for success. At VagueStudios, we thrive on the unique backgrounds, experiences, and perspectives of our people",
                                    "For those of you who cannot be with family this Thanksgiving, please resist the urge to brag",
                                    "I live for the nights that I can't remember, with the people that I won't forget."
                            ).get(postTextRandomNum),
                            null,
                            null,
                            null
                    ), IDB_Operations.ModelType.Post));
                    Pair<String, Object> pair = new Pair<String, Object>("postList", postIds.get(postIds.size() - 1));
                    _IDB.updateArrayObject(userIds.get(userIds.size() - 1), pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.User);
                }
            }
            //comments
            for (int i = 0; i < userIds.size(); i++) {
                String randomPostId = postIds.get(ThreadLocalRandom.current().nextInt(0, postIds.size()));
                int userIdRandomNum = ThreadLocalRandom.current().nextInt(0, userIds.size());
                int commentTextRandomNum = ThreadLocalRandom.current().nextInt(0, 9);
                String commentId = _IDB.addObject(new Comment(
                        null,
                        userIds.get(userIdRandomNum),
                        Arrays.asList(
                                "Wow did I get so lucky to have such a cool best friend?",
                                "The world wanted me to let you know that it’s so grateful for you blessing us with this selfie.",
                                "A little bit of summer is what the whole year is all about",
                                "Live in the sunshine. Swim in the sea. Drink in the wild air.",
                                "Happy Sunday! There may be no excuse for laziness, but [I'm/we're] still looking",
                                "So you've been the coolest kid since day one? Knew it.",
                                "This is exactly why we're best friends.",
                                "Diversity isn't a recruitment metric — it's an ingredient for success. At VagueStudios, we thrive on the unique backgrounds, experiences, and perspectives of our people",
                                "LOL, can I have this picture framed?",
                                "I live for the nights that I can't remember, with the people that I won't forget."
                        ).get(commentTextRandomNum),
                        null
                ), IDB_Operations.ModelType.Comment);

                Pair<String, Object> pair = new Pair<String, Object>("commentsList", commentId);
                _IDB.updateArrayObject(randomPostId, pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.Post);
            }
            ArrayList<String> usersWhoLiked = new ArrayList<>();
            ArrayList<String> postsGotLiked = new ArrayList<>();

            //likes
            for (int i = 0; i < userIds.size(); i++) {
                String randomPostId = postIds.get(ThreadLocalRandom.current().nextInt(0, postIds.size()));
                int userIdRandomNum = ThreadLocalRandom.current().nextInt(0, userIds.size());
                String randomUserId = userIds.get(userIdRandomNum);
                if (!(usersWhoLiked.contains(randomUserId) && postsGotLiked.contains(randomPostId))) {
                    String likeId = _IDB.addObject(new Like(
                            null,
                            randomUserId,
                            null
                    ), IDB_Operations.ModelType.Like);

                    Pair<String, Object> pair = new Pair<String, Object>("likesList", likeId);
                   _IDB.updateArrayObject(randomPostId, pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.Post);
                    postsGotLiked.add(randomPostId);
                    usersWhoLiked.add(randomUserId);
                }
            }

            //share/notification
            for (int i = 0; i < userIds.size(); i++) {
                String randomPostId = postIds.get(ThreadLocalRandom.current().nextInt(0, postIds.size()));
                int userIdRandomNum = ThreadLocalRandom.current().nextInt(0, userIds.size());
                String randomUserId = userIds.get(userIdRandomNum);
                int commentTextRandomNum = ThreadLocalRandom.current().nextInt(0, 9);
                //is blocked
                boolean _shouldShow = true;
                User _user = (User) _IDB.getObject(randomUserId, IDB_Operations.ModelType.User);
                _shouldShow = !(_user.blockedUsersList != null && _user.blockedUsersList.contains(userIds.get(userIds.size() - 1)));
                ///**************

                String notificationId = _IDB.addObject(new Notification(
                        null,
                        randomPostId,
                        userIds.get(userIds.size() - 1),
                        randomUserId,
                        Arrays.asList(
                                "Wow did I get so lucky to have such a cool best friend?",
                                "The world wanted me to let you know that it’s so grateful for you blessing us with this selfie.",
                                "A little bit of summer is what the whole year is all about",
                                "Live in the sunshine. Swim in the sea. Drink in the wild air.",
                                "Happy Sunday! There may be no excuse for laziness, but [I'm/we're] still looking",
                                "So you've been the coolest kid since day one? Knew it.",
                                "This is exactly why we're best friends.",
                                "Diversity isn't a recruitment metric — it's an ingredient for success. At VagueStudios, we thrive on the unique backgrounds, experiences, and perspectives of our people",
                                "LOL, can I have this picture framed?",
                                "I live for the nights that I can't remember, with the people that I won't forget."
                        ).get(commentTextRandomNum),
                        false,
                        _shouldShow,
                        null
                ), IDB_Operations.ModelType.Notification);

                Pair<String, Object> pair = new Pair<String, Object>("notificationList", notificationId);
                _IDB.updateArrayObject(randomUserId, pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.User);

            }
        }
    }
    //old
    /*public static void CreateDummyDB() throws Exception {
        IDB_Operations _IDB = new DB_TextOperations();
        _IDB.initDB();

        ArrayList<String> userIds = new ArrayList<>();
        ArrayList<String> postIds = new ArrayList<>();
        ArrayList<String> likeIds = new ArrayList<>();
        ArrayList<String> commentIds = new ArrayList<>();

        //Random Users
        for (User user : Arrays.asList(new User(null, "nabeelbaghoor", "nabeelbaghoor@gmail.com", "Nabeel", "Hassan", "Male", "03001234456", new Date(), "nabeelbaghoor.me", "Trying to remember who I was before the world told me who to be.", null, ".\\Images\\brackeys.png"), new User(null, "anserbutt", "anserbutt@gmail.com", "Anser", "Butt", "Male", "03001235644", new Date(), "anserbutt.com", "We have tomorrows for a reason.", null, ".\\Images\\brackeys.png"), new User(null, "alihumza", "alihumza@gmail.com", "Ali", "Humza", "Male", "03001234456", new Date(), "alihumza.bio", "Trying to remember who I was before the world told me who to be.", null, ".\\Images\\brackeys.png"), new User(null, "rehmanbutt", "rehmanbutt@gmail.com", "Rehman", "Butt", "Male", "03001759445", new Date(), "rehmanbutt.bio", "Just making sure to love life.", null, ".\\Images\\brackeys.png"), new User(null, "usamazahid", "usamazahid@gmail.com", "Usama", "Zahid", "Male", "03001234466", new Date(), "usamazahid.me", "When it rains look for rainbows when it’s dark I look for stars.", null, ".\\Images\\brackeys.png"), new User(null, "haseebahmed", "haseebahmed@gmail.com", "Haseeb", "Ahmed", "Male", "03001233341", new Date(), "studios.com", "We have tomorrows for a reason.", null, ".\\Images\\brackeys.png"), new User(null, "alitaimur", "alitaimur@gmail.com", "Ali", "Taimur", "Male", "03006050500", new Date(), "alitaimur.me", "I don’t want to forget something that once made us smile", null, ".\\Images\\brackeys.png"), new User(null, "Ahsanzafar", "Ahsanzafar@gmail.com", "Ahsan", "Zafar", "Male", "03001235634", new Date(), "Ahsanzafar.me", "Don’t ever be afraid to shine.", null, ".\\Images\\brackeys.png"), new User(null, "HassanFarooq", "HassanFarooq@gmail.com", "Ali", "Humza", "Male", "03001234477", new Date(), "HassanFarooq.me", "Creating my own sunshine.", null, ".\\Images\\brackeys.png"), new User(null, "MudassirWaheed", "MudassirWaheed@gmail.com", "Rehman", "Butt", "Male", "03001232400", new Date(), "MudassirWaheed.me", "Going where I feel most alive.", null, ".\\Images\\brackeys.png"), new User(null, "Ahmedmukhtar", "Ahmedmukhtar@gmail.com", "Usama", "Zahid", "Male", "03001254432", new Date(), "Ahmedmukhtar.com", "Die having memories don’t die with just dreams.", null, ".\\Images\\brackeys.png"), new User(null, "SuffianSheikh", "SuffianSheikh@gmail.com", "Haseeb", "Ahmed", "Male", "03001234445", new Date(), "SuffianSheikh.me", "You is kind, you is smart, you is important.", null, ".\\Images\\brackeys.png"), new User(null, "AhmedNoor", "AhmedNoor@gmail.com", "Ali", "Taimur", "Male", "03006060234", new Date(), "AhmedNoor.me", " survived because the fire inside me burned brighter than the fire around me.", null, ".\\Images\\brackeys.png"), new User(null, "HassanRaza", "HassanRaza@gmail.com", "Ahsan", "Zafar", "Male", "03001235234", new Date(), "HassanRaza.me", "Life is what happens to you while you scroll through Instagram.", null, ".\\Images\\brackeys.png"), new User(null, "FahadAhmed", "FahadAhmed@gmail.com", "Ali", "Humza", "Male", "03001234546", new Date(), "FahadAhmed.com", "It won’t always be easy, but always try to do what’s right.", null, ".\\Images\\brackeys.png"), new User(null, "AqibAmir", "AqibAmir@gmail.com", "Rehman", "Butt", "Male", "03001234789", new Date(), "AqibAmir.com", "Just make sure to love your life.", null, ".\\Images\\brackeys.png"), new User(null, "FaisalLatif", "FaisalLatif@gmail.com", "Usama", "Zahid", "Male", "03001234666", new Date(), "FaisalLatif.me", "A warrior in a world of worriers.", null, ".\\Images\\brackeys.png"), new User(null, "AbidAli", "AbidAli@gmail.com", "Haseeb", "Ahmed", "Male", "03001234879", new Date(), "AbidAli.com", "These are the days we live for.", null, ".\\Images\\brackeys.png"), new User(null, "FaizaAhmed", "FaizaAhmed@gmail.com", "Faiza", "Ahmed", "Female", "03001231112", new Date(), "FaizaAhmed.com", "I'm not perfect, but stories are always better with a touch of imperfection..", null, ".\\Images\\brackeys.png"), new User(null, "NaziaButt", "NaziaButt@gmail.com", "Nazia", "Butt", "Female", "03001233332", new Date(), "NaziaButt.com", "Just make sure to love your life.", null, ".\\Images\\brackeys.png"), new User(null, "SidraFarooq", "SidraFarooq@gmail.com", "Sidra", "Farooq", "Female", "03002324666", new Date(), "SidraFarooq.com", "Turned my dreams into my vision and my vision into my reality..", null, ".\\Images\\brackeys.png"), new User(null, "ShafaqNaz", "ShafaqNaz@gmail.com", "Shafaq", "Naz", "Female", "03001234345", new Date(), "ShafaqNaz.me", "Leaving a bit of sparkle everywhere I go", null, ".\\Images\\brackeys.png"))) {
            userIds.add(_IDB.addObject(user, IDB_Operations.ModelType.User));
            if (userIds.size() > 1) {
                //follow,following
                for (int i = 0; i < userIds.size(); i++) {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, userIds.size());
                    Pair<String, Object> pair = new Pair<String, Object>("followersList", userIds.get(randomNum));
                    _IDB.updateArrayObject(userIds.get(userIds.size() - 1), pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.User);
                    Pair<String, Object> pair2 = new Pair<String, Object>("followingsList", userIds.get(userIds.size() - 1));
                    _IDB.updateArrayObject(userIds.get(randomNum), pair2, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.User);
                }
                //block
                int outRandomNum = ThreadLocalRandom.current().nextInt(0, 2);
                for (int i = 0; i < outRandomNum; i++) {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, userIds.size());
                    Pair<String, Object> pair = new Pair<String, Object>("blockedUsersList", userIds.get(randomNum));
                    _IDB.updateArrayObject(userIds.get(userIds.size() - 1), pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.User);
                }
            }
            //post
            for (int i = 0; i < 5; i++) {

                int postRandomNum = ThreadLocalRandom.current().nextInt(2, 5);
                if (postRandomNum > 3) {
                    int postTextRandomNum = ThreadLocalRandom.current().nextInt(0, 9);
                    postIds.add(_IDB.addObject(new Post(
                            null,
                            userIds.get(userIds.size() - 1),
                            ".\\Images\\s.png",
                            Arrays.asList(
                                    "Winter is not a season; it's a celebration.",
                                    "Live in the sunshine. Swim in the sea. Drink in the wild air.",
                                    "A little bit of summer is what the whole year is all about",
                                    "Live in the sunshine. Swim in the sea. Drink in the wild air.",
                                    "Happy Sunday! There may be no excuse for laziness, but [I'm/we're] still looking",
                                    "It is better to fail in originality than to succeed in imitation",
                                    "Always bear in mind that your own resolution to succeed is more important than any other.",
                                    "Diversity isn't a recruitment metric — it's an ingredient for success. At VagueStudios, we thrive on the unique backgrounds, experiences, and perspectives of our people",
                                    "For those of you who cannot be with family this Thanksgiving, please resist the urge to brag",
                                    "I live for the nights that I can't remember, with the people that I won't forget."
                            ).get(postTextRandomNum),
                            null,
                            null,
                            null
                    ), IDB_Operations.ModelType.Post));
                    Pair<String, Object> pair = new Pair<String, Object>("postList", postIds.get(postIds.size() - 1));
                    _IDB.updateArrayObject(userIds.get(userIds.size() - 1), pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.User);
                }
            }
            //comments
            for (int i = 0; i < userIds.size(); i++) {
                String randomPostId = postIds.get(ThreadLocalRandom.current().nextInt(0, postIds.size()));
                int userIdRandomNum = ThreadLocalRandom.current().nextInt(0, userIds.size());
                int commentTextRandomNum = ThreadLocalRandom.current().nextInt(0, 9);
                String commentId = _IDB.addObject(new Comment(
                        null,
                        userIds.get(userIdRandomNum),
                        Arrays.asList(
                                "Wow did I get so lucky to have such a cool best friend?",
                                "The world wanted me to let you know that it’s so grateful for you blessing us with this selfie.",
                                "A little bit of summer is what the whole year is all about",
                                "Live in the sunshine. Swim in the sea. Drink in the wild air.",
                                "Happy Sunday! There may be no excuse for laziness, but [I'm/we're] still looking",
                                "So you've been the coolest kid since day one? Knew it.",
                                "This is exactly why we're best friends.",
                                "Diversity isn't a recruitment metric — it's an ingredient for success. At VagueStudios, we thrive on the unique backgrounds, experiences, and perspectives of our people",
                                "LOL, can I have this picture framed?",
                                "I live for the nights that I can't remember, with the people that I won't forget."
                        ).get(commentTextRandomNum),
                        null
                ), IDB_Operations.ModelType.Comment);

                Pair<String, Object> pair = new Pair<String, Object>("commentsList", commentId);
                _IDB.updateArrayObject(randomPostId, pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.Post);
            }
            ArrayList<String> usersWhoLiked = new ArrayList<>();
            ArrayList<String> postsGotLiked = new ArrayList<>();

            //likes
            for (int i = 0; i < userIds.size(); i++) {
                String randomPostId = postIds.get(ThreadLocalRandom.current().nextInt(0, postIds.size()));
                postsGotLiked.add(randomPostId);
                int userIdRandomNum = ThreadLocalRandom.current().nextInt(0, userIds.size());
                String randomUserId = userIds.get(userIdRandomNum);
                usersWhoLiked.add(randomUserId);
                if (!(usersWhoLiked.contains(randomUserId) && postsGotLiked.contains(randomPostId))) {
                    String likeId = _IDB.addObject(new Like(
                            null,
                            randomUserId,
                            null
                    ), IDB_Operations.ModelType.Like);

                    Pair<String, Object> pair = new Pair<String, Object>("likesList", likeId);
                    _IDB.updateArrayObject(randomPostId, pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.Post);
                }
            }

            //share/notification
            for (int i = 0; i < userIds.size(); i++) {
                String randomPostId = postIds.get(ThreadLocalRandom.current().nextInt(0, postIds.size()));
                int userIdRandomNum = ThreadLocalRandom.current().nextInt(0, userIds.size());
                String randomUserId = userIds.get(userIdRandomNum);
                int commentTextRandomNum = ThreadLocalRandom.current().nextInt(0, 9);
                //is blocked
                boolean _shouldShow = true;
                User _user = (User) _IDB.getObject(randomUserId, IDB_Operations.ModelType.User);
                _shouldShow = !(_user.blockedUsersList != null && _user.blockedUsersList.contains(userIds.get(userIds.size() - 1)));
                ///**************

                String notificationId = _IDB.addObject(new Notification(
                        null,
                        randomPostId,
                        userIds.get(userIds.size() - 1),
                        randomUserId,
                        Arrays.asList(
                                "Wow did I get so lucky to have such a cool best friend?",
                                "The world wanted me to let you know that it’s so grateful for you blessing us with this selfie.",
                                "A little bit of summer is what the whole year is all about",
                                "Live in the sunshine. Swim in the sea. Drink in the wild air.",
                                "Happy Sunday! There may be no excuse for laziness, but [I'm/we're] still looking",
                                "So you've been the coolest kid since day one? Knew it.",
                                "This is exactly why we're best friends.",
                                "Diversity isn't a recruitment metric — it's an ingredient for success. At VagueStudios, we thrive on the unique backgrounds, experiences, and perspectives of our people",
                                "LOL, can I have this picture framed?",
                                "I live for the nights that I can't remember, with the people that I won't forget."
                        ).get(commentTextRandomNum),
                        false,
                        _shouldShow,
                        null
                ), IDB_Operations.ModelType.Notification);

                Pair<String, Object> pair = new Pair<String, Object>("notificationList", notificationId);
                _IDB.updateArrayObject(randomUserId, pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.User);

            }
        }
    }*/
}
/*IDB_Operations _IDB = new DB_TextOperations();
        _IDB.initDB();
        Pair<String, Object> pair = new Pair<String, Object>("followersList", "786");
        _IDB.updateArrayObject(
                _IDB.addObject(
                        new User(null,
                                "anserbutt",
                                "anserbutt@gmail.com",
                                "Anser",
                                "Butt",
                                "Male",
                                "03001235644",
                                new Date(),
                                "anserbutt.com",
                                "We have tomorrows for a reason.",
                                null,
                                ".\\Images\\brackeys.png"),
                        IDB_Operations.ModelType.User
                        ),
                pair,
                IDB_Operations.UpdateOperation.Add,
                IDB_Operations.ModelType.User
        );*/
/*

    CreateDummyDB();
    IDB_Operations _IDB = new DB_TextOperations();
        _IDB.initDB();
                //add users
                for (User user : Arrays.asList(new User(null, "nabeelbaghoor", "nabeelbaghoor@gmail.com", "Nabeel", "Hassan", "Male", "03001234456", new Date(), "nabeelbaghoor.me", "Trying to remember who I was before the world told me who to be.", null, ".\\Images\\brackeys.png"), new User(null, "anserbutt", "anserbutt@gmail.com", "Anser", "Butt", "Male", "03001235644", new Date(), "anserbutt.com", "We have tomorrows for a reason.", null, ".\\Images\\brackeys.png"), new User(null, "alihumza", "alihumza@gmail.com", "Ali", "Humza", "Male", "03001234456", new Date(), "alihumza.bio", "Trying to remember who I was before the world told me who to be.", null, ".\\Images\\brackeys.png"), new User(null, "rehmanbutt", "rehmanbutt@gmail.com", "Rehman", "Butt", "Male", "03001759445", new Date(), "rehmanbutt.bio", "Just making sure to love life.", null, ".\\Images\\brackeys.png"), new User(null, "usamazahid", "usamazahid@gmail.com", "Usama", "Zahid", "Male", "03001234466", new Date(), "usamazahid.me", "When it rains look for rainbows when it’s dark I look for stars.", null, ".\\Images\\brackeys.png"), new User(null, "haseebahmed", "haseebahmed@gmail.com", "Haseeb", "Ahmed", "Male", "03001233341", new Date(), "studios.com", "We have tomorrows for a reason.", null, ".\\Images\\brackeys.png"), new User(null, "alitaimur", "alitaimur@gmail.com", "Ali", "Taimur", "Male", "03006050500", new Date(), "alitaimur.me", "I don’t want to forget something that once made us smile", null, ".\\Images\\brackeys.png"), new User(null, "Ahsanzafar", "Ahsanzafar@gmail.com", "Ahsan", "Zafar", "Male", "03001235634", new Date(), "Ahsanzafar.me", "Don’t ever be afraid to shine.", null, ".\\Images\\brackeys.png"), new User(null, "HassanFarooq", "HassanFarooq@gmail.com", "Hassan", "Farooq", "Male", "03001234477", new Date(), "HassanFarooq.me", "Creating my own sunshine.", null, ".\\Images\\brackeys.png"), new User(null, "MudassirWaheed", "MudassirWaheed@gmail.com", "Mudassir", "Waheed", "Male", "03001232400", new Date(), "MudassirWaheed.me", "Going where I feel most alive.", null, ".\\Images\\brackeys.png"), new User(null, "Ahmedmukhtar", "Ahmedmukhtar@gmail.com", "Ahmed", "Mukhtar", "Male", "03001254432", new Date(), "Ahmedmukhtar.com", "Die having memories don’t die with just dreams.", null, ".\\Images\\brackeys.png"), new User(null, "SuffianSheikh", "SuffianSheikh@gmail.com", "Suffian", "Sheikh", "Male", "03001234445", new Date(), "SuffianSheikh.me", "You is kind, you is smart, you is important.", null, ".\\Images\\brackeys.png"), new User(null, "AhmedNoor", "AhmedNoor@gmail.com", "Ahmed", "Noor", "Male", "03006060234", new Date(), "AhmedNoor.me", " survived because the fire inside me burned brighter than the fire around me.", null, ".\\Images\\brackeys.png"), new User(null, "HassanRaza", "HassanRaza@gmail.com", "Hassan", "Raza", "Male", "03001235234", new Date(), "HassanRaza.me", "Life is what happens to you while you scroll through Instagram.", null, ".\\Images\\brackeys.png"), new User(null, "FahadAhmed", "FahadAhmed@gmail.com", "Fahad", "Ahmed", "Male", "03001234546", new Date(), "FahadAhmed.com", "It won’t always be easy, but always try to do what’s right.", null, ".\\Images\\brackeys.png"), new User(null, "AqibAmir", "AqibAmir@gmail.com", "Aqib", "Amir", "Male", "03001234789", new Date(), "AqibAmir.com", "Just make sure to love your life.", null, ".\\Images\\brackeys.png"), new User(null, "FaisalLatif", "FaisalLatif@gmail.com", "Faisal", "Latif", "Male", "03001234666", new Date(), "FaisalLatif.me", "A warrior in a world of worriers.", null, ".\\Images\\brackeys.png"), new User(null, "AbidAli", "AbidAli@gmail.com", "Abid", "Ali", "Male", "03001234879", new Date(), "AbidAli.com", "These are the days we live for.", null, ".\\Images\\brackeys.png"), new User(null, "FaizaAhmed", "FaizaAhmed@gmail.com", "Faiza", "Ahmed", "Female", "03001231112", new Date(), "FaizaAhmed.com", "I'm not perfect, but stories are always better with a touch of imperfection..", null, ".\\Images\\brackeys.png"), new User(null, "NaziaButt", "NaziaButt@gmail.com", "Nazia", "Butt", "Female", "03001233332", new Date(), "NaziaButt.com", "Just make sure to love your life.", null, ".\\Images\\brackeys.png"), new User(null, "SidraFarooq", "SidraFarooq@gmail.com", "Sidra", "Farooq", "Female", "03002324666", new Date(), "SidraFarooq.com", "Turned my dreams into my vision and my vision into my reality..", null, ".\\Images\\brackeys.png"), new User(null, "ShafaqNaz", "ShafaqNaz@gmail.com", "Shafaq", "Naz", "Female", "03001234345", new Date(), "ShafaqNaz.me", "Leaving a bit of sparkle everywhere I go", null, ".\\Images\\brackeys.png"))) {
                _IDB.addObject(user, IDB_Operations.ModelType.User);
                }

                //get those users
                ArrayList<String> userIds = new ArrayList<>();
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("gender","Female");
        map.put("gender","Male");

        ArrayList<IModel> models = _IDB.getObjectsList(
        map,
        IDB_Operations.ModelType.User);
        //print those users
        models.forEach(IModel::print);

        //follow,following,block....
        for (IModel model:models) {
        userIds.add(model.getID());
        if (userIds.size() > 1) {
        //follow,following
        for (int i = 0; i < userIds.size(); i++) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, userIds.size());
        Pair<String, Object> pair = new Pair<String, Object>("followersList", userIds.get(randomNum));
        _IDB.updateArrayObject(userIds.get(userIds.size() - 1), pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.User);
        Pair<String, Object> pair2 = new Pair<String, Object>("followingsList", userIds.get(userIds.size() - 1));
        _IDB.updateArrayObject(userIds.get(randomNum), pair2, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.User);
        }
        //block
        int outRandomNum = ThreadLocalRandom.current().nextInt(0, 2);
        for (int i = 0; i < outRandomNum; i++) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, userIds.size());
        Pair<String, Object> pair = new Pair<String, Object>("blockedUsersList", userIds.get(randomNum));
        _IDB.updateArrayObject(userIds.get(userIds.size() - 1), pair, IDB_Operations.UpdateOperation.Add, IDB_Operations.ModelType.User);
        }
        }
        }*/
