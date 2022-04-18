import java.util.Scanner;

/**
 * @author Nathan Parnell & Treyton Grossman
 */
public class MobileApp {
    //Main Menu GUI, based on the backend.
    public void MainMenu(FeatureHandler backend){
        Scanner sc = new Scanner(System.in);
        String choice = "";
        while(("Q".equalsIgnoreCase(choice))!= true){
            System.out.println("---------------------------------------------------");
            System.out.println("Choose One Of Your Devices:");
            System.out.println("A.Door");
            System.out.println("B.Lights");
            System.out.println("C.Cameras");
            System.out.println("D.Edit Users");
            System.out.println("Q.Quit");
            choice = sc.next();
            //Switch Statement block that calls respective manipulateDevice methods.
            switch(choice.toUpperCase()){
                case "A":
                    ManipulateDoor(backend);
                    break;
                case "B":
                    ManipulateLight(backend);
                    break;
                case "C":
                    ManipulateCamera(backend);
                    break;
                case "D":
                    ManipulateUserArray(backend);
                    break;
                case "Q":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Unrecognized Input");
                    break;
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

        switch(choice.toUpperCase()){
            case "A":
                System.out.println("Door Unlocked!");
                backend.lockDoor(false);
                break;
            case "B":
                System.out.println("Door Locked!");
                backend.lockDoor(true);
                break;
            default:
                System.out.println("No Status Update.");
                break;
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
        switch(choice.toUpperCase()){
            case "A":
                System.out.println("Light Turned Off!");
                backend.turnOnLights(false);
                break;
            case "B":
                System.out.println("Light Turned On!");
                backend.turnOnLights(true);
                break;
            default:
                System.out.println("No Status Update.");
                break;
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
        switch(choice.toUpperCase()){
            case "A":
                System.out.println("Camera Deactivated!");
                backend.activateCam(false);
                break;
            case "B":
                System.out.println("Camera Activated!");
                backend.activateCam(true);
                break;
            default:
                System.out.println("No Status Update.");
                break;
        }
        return;
    }
    
    /**
     * @author Treyton Grossman
     * @param backend
     * 
     * Method UI for users to manipulate the current list of system users
     */
    public void ManipulateUserArray(FeatureHandler backend){
        System.out.println("Would you like to add, remove, or view users?");
        System.out.println("A.Add");
        System.out.println("B.Remove");
        System.out.println("C.View");
        System.out.println("Any Other Key to Quit.");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        switch(input.toUpperCase()){
            case "A":
                User newUser = new User(backend);
                backend.registerUser(newUser);
                break;
            case "B":
                System.out.println("Enter ID of user to delete:");
                scan.reset();
                int inputID = scan.nextInt();
                backend.removeUser(inputID);
                break;
            case "C":
                backend.viewUsers();
                break;
            default:
                System.out.println("Users Not Updated");
                break;
        }
    }

}
