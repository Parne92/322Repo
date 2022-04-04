import java.util.ArrayList;

/**
 * @author Patrick Tung
 */
public class FeatureHandler implements Observable {

    private ArrayList<Observer> users;
    private boolean doorIsLocked;
    private boolean camFunctional;
    private boolean lightsOn;

    @Override
    public registerUser(Observer newUser) {
        users.add(newUser);
    }

    @Override
    public removeUser(Observer user) {
        int userIndex = users.indexOf(user);
        System.out.println("User " + (userIndex + 1) + " has been deleted");
        users.remove(userIndex);
    }

    @Override
    public notifyUsers() {
        for (Observer user : users) {
            user.update(doorIsLocked, camFunctional, lightsOn);
        }
    }

    public void setDoorState(boolean lockDoor) {
        if (lockDoor) {
            this.doorIsLocked = True;
        } else {
            this.doorIsLocked = False;
        }
    }
}