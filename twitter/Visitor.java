package twitter;

//VISITOR PATTERN: Implements visit methods for all objects
public class Visitor implements iVisitor {

    @Override
    public String visit(AllUsers allUsers) {
        ControlPanel control = ControlPanel.getInstance();
        String userList = "";
        for (User i: control.getAllUsers()) {
            userList += "\n" + i.getID();
        }
        return "Total number of users: " + control.getAllUsers().size() + "\n\nUsers are: " + userList;
    }

    @Override
    public String visit(AllGroups allGroups) {
        ControlPanel control = ControlPanel.getInstance();
        String groupList = "";
        for (UserGroup i: control.getAllGroups()) {
            groupList += "\n" + i.getID();
        }
        return "Total number of user groups: " + control.getAllGroups().size() + "\n\nUser groups are: " + groupList;
    }

    @Override
    public String visit(AllTweets allTweets) {
        ControlPanel control = ControlPanel.getInstance();
        return "Total number of tweets: " + control.getAllTweets().size();
    }

    @Override
    public String visit(PosTweets posTweets) {
        ControlPanel control = ControlPanel.getInstance();
        int happyTweets = 0;
        for(String i: control.getAllTweets()) {
            if (i.contains("happy") || i.contains("good")) {
                happyTweets++;
            }
        }
        float percentage = (float)happyTweets/control.getAllTweets().size()*100;
        return percentage + "% of total messages are positive.";
    }
}
