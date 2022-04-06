/**
 * @author Patrick Tung
 */
public class User implements Observer, Display {

    private boolean doorIsLocked;
    private boolean camFunctional;
    private boolean lightsOn;
    private boolean isRegistered;

    private static int userIDtracker = 0;

    private int userID;

    private Observable backend;

    public User(Observable backend) {
        this.backend = backend;
        this.userID = userIDtracker++;
        System.out.println("\nNew user " + this.userID);
        backend.registerUser(this);
    }

    @Override
    public void update(boolean doorIsLocked, boolean camFunctional, boolean lightsOn) {
        this.doorIsLocked = doorIsLocked;
        this.camFunctional = camFunctional;
        this.lightsOn = lightsOn;
    }

    @Override
    public void display() {
        if (this.isRegistered)
            System.out.println("\nDoor is locked : " + this.doorIsLocked + "\nCamera is functional : "
                    + this.camFunctional + "\nLights are on : " + this.lightsOn);
        else
            System.out.println("Access Denied");
    }

    @Override
    public void setRegistrationStatus(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    @Override
    public int getUserID() {
        return this.userID;
    }
}