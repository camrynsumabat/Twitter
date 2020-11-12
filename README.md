# Twitter
CS3560 Assignment 2 - Twitter Simulation with OOP design patterns and a JavaFX UI

## Required Components

### GUI (JavaFX)
* UI control panel - `Admin.java`, `Alert.java`
  * Tree view with all users and user groups that allows for user selection
  * Text area and button that allows a new user to be added to the tree
  * Text area and button that allows a new user group to be added to the tree
  * Button to open the user view, selected from the tree view (opens `UserView.java`)
  * Button to show total users
  * Button to show total user groups
  * Button to show total messages between all users
  * Button to show the percentage of positive messages between all users
  
* User View - `UserView.java`
  * Displays user ID at the top of the window
  * Text area and button that allows the user to follow another user
  * List view of who the user is following
  * Text area and button that allows the user to tweet
  * List view of the user's "timeline", showing the user's tweets and tweets from the user's following
  
### Patterns
* Singleton Pattern
  * `ControlPanel.java`
* Composite Pattern
  * `UserComponent.java` - "The Component": An interface implemented in User.java and UserGroup.java
  * `User.java` - "The Leaf": A class implementing UserComponent.java
  * `UserGroup.java` - "The Composite": A class implementing UserComponent.java and containing a list of UserComponent objects
* Observer Pattern
  * `Subject.java` - "The Subject": An interface with the subject methods - `attach()` (`follow(User user)`), `detach()` (not required in this assignment), `notifyObservers()`
  * `Follower.java` - "The Observer": An interface with the observer method - `update()`
  * `User.java` - "The Concrete Subject" & "The Concrete Observer": In this case, implementation of both subject and observer interfaces
* Visitor Pattern
  * `iVisitor.java` - An interface implemented in Visitor.java
  * `Visitor.java` - A class that implements each `visit(this)` for the specified object
  * `Visitable.java` - An interface implemented in all visitable objects with method `accept(Visitor visitor)` where the method only enacts `visitor.visit(this)`
  * `AllUsers.java`
  * `AllGroups.java`
  * `AllTweets.java`
  * `PosTweets.java`
  
