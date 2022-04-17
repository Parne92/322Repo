/**
        * The home security mobile app will connect to the backend and prompt user to
        * create a new account.
        * Upon account creation, the app will offer users a set of options that control
        * various features within the app.
        * After user interacts with the app, backend will automatically update all
        * users with the current state of the sensors.
        * When a user deletes their account, they will no longer have access to the
        * app.
        *
        * @author Patrick Tung
        */
public class GroupProjectTest {

    /**
     * Main method that instantiate the app. Everything else is hidden.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        // TODO Comment out everything

        
        FeatureHandler backend = new FeatureHandler();
        MobileApp MA = new MobileApp();

        //This is only a test, i.e what this hypothetical user left their home as.
        backend.activateCam(false);
        backend.lockDoor(true);
        backend.turnOnLights(true);

        //user0.getUserID();
        //user0.display();

        MA.MainMenu(backend);

        /*
        User user1 = new User(backend);

        //Another hypothetical situation.
        backend.activateCam(true);
        backend.lockDoor(false);
        backend.turnOnLights(false);

        user1.getUserID();
        backend.removeUser(1);

        user1.display();

        User user2 = new User(backend);
        user2.display();

        User user3 = new User(backend);

        backend.notifyUsers();
        user2.display();
        user3.display();

        backend.removeUser(2);
        backend.removeUser(3);

        user2.display();
        user3.display();
        */
    }
}

