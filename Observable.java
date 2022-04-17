/**
 * Purpose: To act as a contract for Home security system feature classes.
 * This interface handles registering, removing and updating all Observers.
 * 
 * @author Patrick Tung
 */
public interface Observable {

    public void registerUser(Observer o);

    public void removeUser(int ID);
    
    public void viewUsers();

    public void notifyUsers();

}