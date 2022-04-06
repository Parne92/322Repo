/**
 * Purpose: To act as a contract for Home security system feature classes
 * 
 * @author Patrick Tung
 */
public interface Observable {

    public void registerUser(Observer o);

    public void removeUser(Observer o);

    public void notifyUsers();
}