import java.util.ArrayList;

/**
 * @author Patrick Tung
 */
public class FeatureHandler implements Observable {

    private ArrayList<Observer> users = new ArrayList<>();
    private boolean doorIsLocked;
    private boolean camFunctional;
    private boolean lightsOn;

    public void registerUser(Observer newUser) {
        users.add(newUser);
        newUser.setRegistrationStatus(true);
    }

    public void removeUser(Observer user) {
        int userIndex = users.indexOf(user);
        System.out.println("\nUser " + user.getUserID() + " has been deleted");
        users.remove(userIndex);
        user.setRegistrationStatus(false);
    }

    public void notifyUsers() {
        for (Observer user : users) {
            user.update(doorIsLocked, camFunctional, lightsOn);
        }
    }

    public void lockDoor(boolean lockDoor) {
        if (lockDoor) {
            this.doorIsLocked = true;
        } else {
            this.doorIsLocked = false;
        }
        notifyUsers();
    }

    public void activateCam(boolean activateCam) {
        if (activateCam) {
            this.camFunctional = true;
        } else {
            this.camFunctional = false;
        }
        notifyUsers();
    }

    public void turnOnLights(boolean turnOnLights) {
        if (turnOnLights) {
            this.lightsOn = true;
        } else {
            this.lightsOn = false;
        }
        notifyUsers();
    }
}
