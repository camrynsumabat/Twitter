package twitter;

import java.util.ArrayList;
import java.util.List;

//COMPOSITE PATTERN: User is the leaf (implements UserComponent)
//OBSERVER PATTERN: User is a subject (implements Subject) and observer (implements Follower)
public class User extends Subject {

    private String userID = "", tweet;
    private List<String> timeline = new ArrayList<String>();

    public User(String newID) {
        setID(newID);
        System.out.println("New user added called " + newID);
    }

    public void setID(String newID) {
        userID = newID;
    }

    public String getID() {
        return userID;
    }

    public List<String> getFollowingID() {
        List<String> followingID = new ArrayList<String>();
        for (User i: following) {
            followingID.add(i.getID());
        }
        return followingID;
    }

    public List<String> getFollowersID() {
        List<String> followersID = new ArrayList<String>();
        for (User i: followers) {
            followersID.add(i.getID());
        }
        return followersID;
    }

    public void setTweet(String newTweet) {
        this.tweet = newTweet;
        notifyAllFollowers();
        timeline.add(tweet);
        System.out.println("Tweet added to " + this.getID() + "'s timeline");
    }

    public String getTweet() {
        return tweet;
    }

    //DEBUGGING
    public List<String> getTimeline() {
        System.out.println(this.getID() + "'s timeline");
        for(String i: timeline) {
            System.out.println(i);
        }
        return timeline;
    }

    @Override
    public String accept(iVisitor visitor) {
        return "";
    }
}
