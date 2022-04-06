/**
 * Purpose: To act as a contract for mobile app user classes
 * 
 * @author Patrick Tung
 */
public interface Observer {
    public void update(boolean doorIsLocked, boolean camFunctional, boolean lightsOn);
    public void setRegistrationStatus(boolean isRegistered);
    public boolean getRegistrationStatus();
    public int getUserID();

    // public void display();
}
