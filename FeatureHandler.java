import java.util.ArrayList;

/**
 * The FeatureHandler is basically the backend of the app that keeps track of a
 * list of Users (Observers) that depend on it. The FeatureHandler object
 * will notify its dependents automatically of any state changes by
 * calling one of their methods.
 * 
 * @author Patrick Tung
 */
public class FeatureHandler implements Observable {

    // Declare and initialize an ArrayList to keep track of all observers
    private ArrayList<Observer> users = new ArrayList<>();
    // field that keeps track of door lock state
    private boolean doorIsLocked;
    // field that keeps track of security camera state
    private boolean camFunctional;
    // field that keeps track of indoor lighting state
    private boolean lightsOn;

    /**
     * Add a dependent Observer to the ArrayList. Grant user access.
     */
    @Override
    public void registerUser(Observer newUser) {
        users.add(newUser);
        newUser.setRegistrationStatus(true);
    }

    /**
     * Print out message. Remove a dependent Observer from the ArrayList. Remove
     * user access.
     */
    @Override
    public void removeUser(int ID) {
        for (int i = 0; i < users.size(); i++){
            if (ID == 0){
                System.out.println("Default user cannot be deleted!");
                break;
            }
            if (users.get(i).getUserID() == ID){
                System.out.println("\nUser " + users.get(i).getUserID() + " has been deleted");
                users.remove(i);
            }
        }
        
    }
    
    /**
     * Prints list of registered users
     */
    public void viewUsers(){
        System.out.println("List of current registered users:\n" + users.size() + " users registered.");
        for (int i = 0; i < users.size(); i++){
            System.out.println("User ID: " + users.get(i).getUserID() + "\tRegistration Status: " + users.get(i).getRegistrationStatus());
        }
    }

    /**
     * Notify all Observers of any state changes.
     */
    @Override
    public void notifyUsers() {
        for (Observer user : users) {
            user.update(doorIsLocked, camFunctional, lightsOn);
        }
    }

    /**
     * Change door lock state.
     * 
     * @param lockDoor boolean that will set lock state. Set {@code lockDoor} to
     *                 {@code true} and
     *                 the door is locked.
     */
    public void lockDoor(boolean lockDoor) {
        if (lockDoor) {
            this.doorIsLocked = true;
        } else {
            this.doorIsLocked = false;
        }
        notifyUsers();
    }

    /**
     * Change Security Camera state.
     * 
     * @param activateCam boolean that will set Security Camera state. Set
     *                    {@code activateCam} to {@code true} and the camera is
     *                    turned on.
     */
    public void activateCam(boolean activateCam) {
        if (activateCam) {
            this.camFunctional = true;
        } else {
            this.camFunctional = false;
        }
        notifyUsers();
    }

    /**
     * Change Indoor Lighting state.
     * 
     * @param turnOnLights boolean that will set Indoor Lighting state. Set
     *                     {@code turnOnLights} to {@code true} and the lights will
     *                     turn on.
     */
    public void turnOnLights(boolean turnOnLights) {
        if (turnOnLights) {
            this.lightsOn = true;
        } else {
            this.lightsOn = false;
        }
        notifyUsers();
    }
}
