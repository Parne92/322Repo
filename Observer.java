/**
 * Purpose: To act as a contract for mobile app user classes. The interface
 * manage user access and updates itself be fetching states from Observable.
 * 
 * @author Patrick Tung
 */
public interface Observer {

    public void update(boolean doorIsLocked, boolean camFunctional, boolean lightsOn);

    public void setRegistrationStatus(boolean isRegistered);

    public int getUserID();
}
