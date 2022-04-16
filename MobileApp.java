import java.util.Scanner;

/**
 * @author Nathan Parnell
 */
public class MobileApp {
    //Main Menu GUI, based on the backend.
    public void MainMenu(FeatureHandler backend){
        Scanner sc = new Scanner(System.in);
        String choice = "";
        while(("D".equalsIgnoreCase(choice))!= true){
            System.out.println("---------------------------------------------------");
            System.out.println("Choose One Of Your Devices:");
            System.out.println("A.Door");
            System.out.println("B.Lights");
            System.out.println("C.Cameras");
            System.out.println("D.Quit");
            choice = sc.next();
            //If Statement block that calls respective manipulateDevice methods.
            if(choice.equalsIgnoreCase("A")){
                ManipulateDoor(backend);
            }
            else if(choice.equalsIgnoreCase("B")){
                ManipulateLight(backend);
            }
            else if(choice.equalsIgnoreCase("C")){
                ManipulateCamera(backend);
            }
            else{
                System.out.println("Unrecognized Input");
            }
        }
        return;
    }

    //Manipulate Door Method, updates the backend with user's choice.
    public void ManipulateDoor(FeatureHandler backend) {
        System.out.println("Would you like to update your door?");
        System.out.println("A.Unlock");
        System.out.println("B.Lock");
        System.out.println("Any Other Key to Quit.");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("A")) {
            System.out.println("Door Unlocked!");
            //"Unlocking" the door at the backend.
            backend.lockDoor(false);

        } else if (choice.equalsIgnoreCase("B")) {
            System.out.println("Door Locked!");
            //"Locking the door" at the backend.
            backend.lockDoor(true);
        } else {
            //No update to teh backend.
            System.out.println("No Status Update.");
        }
        return;
    }
    //Manipulate Device for the lights, functionally similar to the doors.
    public void ManipulateLight(FeatureHandler backend) {
        System.out.println("Would you like to update your Lights?");
        System.out.println("A.Turn Off");
        System.out.println("B.Turn On");
        System.out.println("Any Other Key to Quit.");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("A")) {
            //Turning off the lights in the backend.
            System.out.println("Lights off!");
            backend.turnOnLights(false);

        } else if (choice.equalsIgnoreCase("B")) {
            //Turning on the lights in the backend.
            System.out.println("Lights On!");
            backend.turnOnLights(true);
        } else {
            //Nothing to change.
            System.out.println("No Status Update.");
        }
        return;
    }
    //Respective method for the camera.
    public void ManipulateCamera(FeatureHandler backend) {
        System.out.println("Would you like to update your camera?");
        System.out.println("A.Turn Off");
        System.out.println("B.Turn On");
        System.out.println("Any Other Key to Quit.");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        //Backend Camera Update.
        if (choice.equalsIgnoreCase("A")) {
            System.out.println("Camera Deactivated!");
            backend.activateCam(false);

        } else if (choice.equalsIgnoreCase("B")) {
            System.out.println("Camera Activated!");
            backend.activateCam(true);
        } else {
            System.out.println("No Status Update.");
        }
        return;
    }

}
