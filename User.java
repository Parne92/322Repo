/**
 * Represents each mobile app instance (Observer) that's monitoring state
 * changes in the backend (Observable). The mobile app instance is also capable
 * of displaying current Observable states on your mobile device.
 * 
 * @author Patrick Tung
 */
public class User implements Observer, Display {

    // same as the fields in FeatureHandler class
    private boolean doorIsLocked;
    private boolean camFunctional;
    private boolean lightsOn;
    // tracks user access
    private boolean isRegistered;

    // static User counter
    private static int userIDtracker = 0;

    // used to identify and track users
    private int userID;

    // holds a reference to the Observable
    private Observable backend;

    public User(Observable backend) {
        // store the reference to the Observable object so we can make calls to its
        // methods
        this.backend = backend;
        // assign a userID and increment the static counter
        this.userID = userIDtracker++;
        // message notifying user of their account registration
        System.out.println("\nNew user " + this.userID);
        // Add the new user account to the list of dependent observers that the
        // Observable tracks
        backend.registerUser(this);
    }

    /**
     * The update method is called when the Observable changes state.
     */
    @Override
    public void update(boolean doorIsLocked, boolean camFunctional, boolean lightsOn) {
        this.doorIsLocked = doorIsLocked;
        this.camFunctional = camFunctional;
        this.lightsOn = lightsOn;
    }

    /**
     * This method is called to display current Observable state through the mobile
     * app
     */
    @Override
    public void display() {
        if (this.isRegistered)
            System.out.println("\nDoor is locked : " + this.doorIsLocked + "\nCamera is functional : "
                    + this.camFunctional + "\nLights are on : " + this.lightsOn);
        else
            System.out.println("Access Denied");
    }

    /**
     * This method is called to turn user access on/off.
     * 
     * @param isRegistered boolean that will set user access to current Observable
     *                     states. Set
     *                     {@code isRegistered} to {@code true} and the user will be
     *                     able to view current Observable states on their mobile
     *                     device.
     */
    @Override
    public void setRegistrationStatus(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    /**
     * This method is called so we can get the current user's ID
     */
    @Override
    public int getUserID() {
        return this.userID;
    }
}