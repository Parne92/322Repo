import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nathan Parnell
 */
public class MobileApp {

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
    public void ManipulateDoor(FeatureHandler backend) {
        System.out.println("Would you like to update your door?");
        System.out.println("A.Unlock");
        System.out.println("B.Lock");
        System.out.println("Any Other Key to Quit.");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("A")) {
            System.out.println("Door Unlocked!");
            backend.lockDoor(false);

        } else if (choice.equalsIgnoreCase("B")) {
            System.out.println("Door Locked!");
            backend.lockDoor(true);
        } else {
            System.out.println("No Status Update.");
        }
        return;
    }

    public void ManipulateLight(FeatureHandler backend) {
        System.out.println("Would you like to update your Lights?");
        System.out.println("A.Turn Off");
        System.out.println("B.Turn On");
        System.out.println("Any Other Key to Quit.");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("A")) {
            System.out.println("Lights off!");
            backend.turnOnLights(false);

        } else if (choice.equalsIgnoreCase("B")) {
            System.out.println("Lights On!");
            backend.turnOnLights(true);
        } else {
            System.out.println("No Status Update.");
        }
        return;
    }
    public void ManipulateCamera(FeatureHandler backend) {
        System.out.println("Would you like to update your camera?");
        System.out.println("A.Turn Off");
        System.out.println("B.Turn On");
        System.out.println("Any Other Key to Quit.");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
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
