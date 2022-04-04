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

        user0.display();

        User user1 = new User(backend);

        backend.activateCam(true);
        backend.lockDoor(false);
        backend.turnOnLights(false);

        user1.display();
    }
}