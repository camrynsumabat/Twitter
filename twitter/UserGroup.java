package twitter;

import java.util.ArrayList;
import java.util.List;

//COMPOSITE PATTERN: UserGroup is the composite
public class UserGroup implements UserComponent {
    private String groupID = "";
    private List<UserComponent> userGroup = new ArrayList<UserComponent>();

    public UserGroup(String newID) {
        setID(newID);
        System.out.println("New group created called " + newID);
    }

    public void setID(String newID) {
        groupID = newID;
    }

    public String getID() {
        return groupID;
    }

    public void add(UserComponent userComponent) {
        userGroup.add(userComponent);
        System.out.println(userComponent.getID() + " has been added to user group " + this.getID());
    }

    @Override
    public String accept(iVisitor visitor) {
        return "";
    }
}
