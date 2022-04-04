/**
 * Purpose: To act as a contract for Home security system feature classes
 * 
 * @author Patrick Tung
 */
public interface Observable {

    public registerUser(Observer o);

    public removeUser(Observer o);

    public notifyUsers();
}