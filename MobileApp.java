/**
 * @author Patrick Tung
 */
public class MobileApp {
    public static void main(String[] args) {

        FeatureHandler backend = new FeatureHandler();

        User user0 = new User(backend);

        backend.activateCam(false);
        backend.lockDoor(true);
        backend.turnOnLights(true);

        user0.getUserID();
        user0.display();

        User user1 = new User(backend);

        backend.activateCam(true);
        backend.lockDoor(false);
        backend.turnOnLights(false);

        user1.getUserID();
        backend.removeUser(user1);

        user1.display();

        User user2 = new User(backend);
        user2.display();

        User user3 = new User(backend);

        backend.notifyUsers();
        user2.display();
        user3.display();

        backend.removeUser(user2);
        backend.removeUser(user3);

        user2.display();
        user3.display();
    }
}