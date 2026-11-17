package CSE222HW2;
import java.util.Scanner;
/**
 * Main class to run the Electronics Inventory Management System.
 * </p>
 * <p>
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Inventory inventory = new Inventory();
    /**
     * Main method to start the program.
     * @param args Command line arguments (not used).
     * Time complexity will vary according to the functions that are run. Worst-case time complexity will be O(n^2*m) if we assume that the while loop iterates m times since the remove and sortwithPrice methods have a time complexity of O(n^2). The rest are all simple statements and have a time complexity of O(1).
     * </p>
     * <p>
     */
    public static void main(String args[]) {
        
        
        boolean val=true;
        System.out.println("___________________________________________________________\nWelcome to the Electronics Inventory Management System!\n");

        while (val==true) {
            System.out.println("\nPlease select an option:\n1. Add a new device\n2. Remove a device\n3. Update device details\n4. List all devices\n5. Find the cheapest device\n6. Sort devices by price\n7. Calculate total inventory value\n8. Restock a device\n9. Export inventory report\n0. Exit");
            System.out.println("___________________________________________________________\n");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        System.out.println("Goodbye!");
                        val=false;
                        return;
                    case 1:
                        inventory.add();
                        break;
                    case 2:
                        inventory.remove();
                        break;
                    case 3:
                        inventory.update();
                        break;
                    case 4:
                        inventory.display();
                        break;
                    case 5:
                        inventory.minimumPrice();
                        break;
                    case 6:
                        inventory.sortwithPrice();
                        break;
                    case 7:
                        inventory.totalvalue();
                        break;
                    case 8:
                        inventory.restock();
                        break;
                    case 9:
                        inventory.exportInventory();
                        break;
    
                        default:
                    System.out.println("___________________________________________________________\n");
                        System.out.println("Invalid choice. Please enter a valid option.");
                        System.out.println("___________________________________________________________");
                        break;
                }
            } 
        
    }
}

