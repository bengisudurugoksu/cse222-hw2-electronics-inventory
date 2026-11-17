package CSE222HW2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;   
/**
 * Represents an inventory management system for electronic devices.
 * <p>
 * The Inventory class manages a collection of electronic devices and provides functionality for adding, removing, updating, displaying, and exporting the inventory.
 * </p>
 * <p>
 * It uses a LinkedList to store ArrayLists of the 5 device categories.
 * </p>
 */
public class Inventory {
    private LinkedList<ArrayList<? extends Device>> categoryList = new LinkedList<>();
    public ArrayList<Smartphone> smartphoneList = new ArrayList<>();
    public ArrayList<TV> TVList = new ArrayList<>();
    public ArrayList<Laptop> laptopList = new ArrayList<>();
    public ArrayList<Tablet> tabletList = new ArrayList<>();
    public ArrayList<Headset> headsetList = new ArrayList<>();
    /**
     * Constructs a new Inventory object and initializes the category lists.
     */
    public Inventory(){
    categoryList = new LinkedList<>();
    smartphoneList = new ArrayList<>();
    categoryList.add(smartphoneList);
    TVList = new ArrayList<>();
    categoryList.add(TVList);
    laptopList = new ArrayList<>();
    categoryList.add(laptopList);
    tabletList = new ArrayList<>();
    categoryList.add(tabletList);
    headsetList = new ArrayList<>();
    categoryList.add(headsetList);    
    }
    /**
     * Adds a new device to the inventory.
     * <p>
     * The user is prompted to enter the category, name, price, and quantity of the device.
     * If the user inputs a category name other than "Smartphone", "Smart Phone", "Tablet", "Headset", "TV" or "Laptop", the method will throw an exception and quit the program.
     * If the user inputs a name that already exists, the method gives a warning and returns to the main menu.
     * The device is then added to the appropriate category list.
     * </p>
     * The add method of the ArrayList has a time complexity of O(n) since it resizes dynamically everytime we call the add method.
     * Time complexity will be O(n) if we say the device number in the ArrayList is n since there is a nested loop, the first for statement will iterate five times since there are only five categories, therefore the time complexity will be O(5n) which will give us O(n). The rest are all simple statements and have a time complexity of O(1).
     */
    @SuppressWarnings("resource")
    public void add(){
        Scanner scanner = new Scanner(System.in);
        try{
        System.out.println("___________________________________________________________\n");
        System.out.println("Enter category name: ");
        String category = scanner.nextLine();
        if (!category.equals("Smartphone") && !category.equals("TV") && !category.equals("Smart Phone")&& !category.equals("Laptop") && !category.equals("Headset") && !category.equals("Tablet")) {
            throw new IllegalArgumentException("Invalid category: " + category);
        }
        System.out.println("Enter device name: ");
        String name = scanner.nextLine();
        for (ArrayList<? extends Device> list : categoryList) {
            for (Device device : list) {
                if(name.equals(device.getName())){
                    System.out.println("The device with the given name already exists. Try again.");
                    System.out.println("___________________________________________________________\n");
                    return;
                }
            }
        }
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.println("\n" + category +" , " + name + " , " + price + "$ , " + quantity + " amount added...");
        System.out.println("___________________________________________________________");
        switch(category){
            case "Smartphone":
            case "Smart Phone":
            Smartphone smartphone = new Smartphone(name, quantity, price);
            smartphoneList.add(smartphone);
            break;
            case "TV":
            TV tv = new TV(name, quantity, price);
            TVList.add(tv);
            break;
            case "Headset":
            Headset headset = new Headset(name, quantity, price);
            headsetList.add(headset);
            break;
            case "Tablet":
            Tablet tablet = new Tablet(name, quantity, price);
            tabletList.add(tablet);
            break;
            case "Laptop":
            Laptop laptop = new Laptop(name, quantity, price);
            laptopList.add(laptop);
            break;
        }
    }
        finally{            
        }
    }
    /**
     * Removes a device from the inventory.
     * <p>
     * The user is prompted to enter the name of the device to remove.
     * If the device exists, it is removed from the inventory.
     * </p>
     * The remove method of the ArrayList has a time complexity of O(n) since it goes through the entire List to find the object to remove.
     * Time complexity will be O(n^2) if we say the device number in the ArrayList is n since there is a nested loop, the first for statement will iterate five times since there are only five categories, when it finds the device to be removed it will call the remove method which has a time complexity of O(n), therefore the time complexity will be O(5n^2) which will give us O(n^2). The rest are all simple statements and have a time complexity of O(1).
     */
    @SuppressWarnings("resource")
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("___________________________________________________________\n\nEnter the name of the device to remove:");
        String name = scanner.nextLine();
        boolean found = false;
    
        for (ArrayList<? extends Device> list : categoryList) {
            for (Device device : list) {
                if (name.equals(device.getName())) {
                    list.remove(device);
                    found = true;
                    break; 
                }
            }
            if (found) {
                break;
            }
        }
    
        if (found) {
            System.out.println("Device " + name + " successfully removed.");
        } else {
            System.out.println("The device " + name + " does not exist.");
        }
    
        System.out.println("___________________________________________________________");
    }
    /**
     * Updates the details of a device in the inventory.
     * <p>
     * The user is prompted to enter the name of the device to update, then they can choose to update the price and/or quantity of the device.
     * </p>
     * Time complexity will be O(n) if we say the device number in the ArrayList is n since there is a nested loop, the first for statement will iterate five times since there are only five categories, therefore the time complexity will be O(5n) which will give us O(n). The rest are all simple statements and have a time complexity of O(1).
     */
    @SuppressWarnings("resource")
    public void update(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("___________________________________________________________\n\nEnter the name of the device to update: ");
        String name = scanner.nextLine();
        for (ArrayList<? extends Device> list : categoryList) {
            for (Device device : list) {
                if(name.equals(device.getName())){
                    System.out.println("Enter new name (leave blank to keep current price): ");
                    String newname = scanner.nextLine();
                    if(!newname.equals("")){
                            device.setName(newname);
                        }                       
                    System.out.println("Enter new price (leave blank to keep current price): ");
                    String newprice = scanner.nextLine();
                    if(!newprice.equals("")){
                        try {
                            double price = Double.parseDouble(newprice);
                            device.setPrice(price);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid format: " + newprice);
                        }                       
                    }
                    System.out.println("Enter new quantity (leave blank to keep current price): ");
                    String newquantity = scanner.nextLine();
                    if(!newquantity.equals("")){
                        try {
                            int quantity = Integer.parseInt(newquantity);
                            device.setQuantity(quantity);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid format: " + newquantity);
                        }                        
                    }
                    System.out.println(name +" details updated: Price - " + device.getPrice() +"$, Quantity - " + device.getQuantity());
                    System.out.println("___________________________________________________________");
                }
            }
        }    
    }
    /**
     * Displays the list of devices in the inventory.
     * <p>
     * This method prints details of all devices in the inventory, including category, name, price, and quantity.
     * </p>
     * Time complexity will be O(n) if we say the device number in the ArrayList is n since there is a nested loop, the first for statement will iterate five times since there are only five categories, therefore the time complexity will be O(5n) which will give us O(n). The rest are all simple statements and have a time complexity of O(1).
     */
    public void display(){
        int count=1;
        System.out.println("___________________________________________________________\n\nDevice List");
        for (ArrayList<? extends Device> list : categoryList) {
            for (Device device : list) {
                System.out.println(count + ". Category : " + device.getCategory() +", Name: " + device.getName() +", Price: " + device.getPrice() + "$, Quantity: " + device.getQuantity());
                count++;
            }
        }
        System.out.println("___________________________________________________________");
    }
    /**
     * Finds and displays the device with the minimum price in the inventory.
     * <p>
     * This method iterates through all devices in the inventory and finds the one with the minimum price. It then prints the details of that device.
     * </p>
     * Time complexity will be O(n) if we say the device number in the ArrayList is n since there is a nested loop, the first for statement will iterate five times since there are only five categories, therefore the time complexity will be O(5n) which will give us O(n). The rest are all simple statements and have a time complexity of O(1).
     */    
    @SuppressWarnings("null")
    public void minimumPrice(){
    if(smartphoneList.isEmpty() && tabletList.isEmpty() && TVList.isEmpty() && headsetList.isEmpty() && laptopList.isEmpty()){
        System.out.println("The inventory is empty.");
        return;
    }
    Device cheapestdevice = null;
    double minimumPrice=0.0;
    int count=1;
        for (ArrayList<? extends Device> list : categoryList) {
            for (Device device : list) {
                if(count==1){
                    minimumPrice=device.getPrice();  
                    cheapestdevice = device;                  
                }
                else{
                    if(minimumPrice>device.getPrice()){
                        minimumPrice=device.getPrice();
                        cheapestdevice=device.getDevice();
                    }
                }
                count++;
            }
        }
        if(cheapestdevice != null){
        System.out.println("___________________________________________________________\n\nThe cheapest device is:");
        System.out.println("Category : " + cheapestdevice.getCategory() +", Name: " + cheapestdevice.getName() +", Price: " + cheapestdevice.getPrice() + "$, Quantity: " + cheapestdevice.getQuantity());
        }
        else{
            System.out.println("The device " + cheapestdevice.getName() + " does not exist.");
        }
        System.out.println("___________________________________________________________");
    }
    /**
     * Sorts the devices in the inventory by price and displays the sorted list.
     * <p>
     * This method creates a new ArrayList of devices sorted by their prices in ascending order. It then prints the details of devices in the sorted list.
     * </p>
     * The add method of the ArrayList has a time complexity of O(n) since it resizes dynamically everytime we call the add method.
     * Time complexity will be O(n^2) if we say the device number in the ArrayList is n since there is a nested loop, the first for statement will iterate five times since there are only five categories, all of the devices will be added to a new ArrayList to sort with price, the add method has a time complexity of O(n), therefore the time complexity will be O(5n^2) which will give us O(n^2).
     */
    public void sortwithPrice(){
        ArrayList<Device> sortedList = new ArrayList<Device>();
        System.out.println("___________________________________________________________\n\nDevices sorted by price:");
        for (ArrayList<? extends Device> list : categoryList) {
            for (Device device : list) {
                sortedList.add(device);
            }
        } 
        for(int i=0; i<sortedList.size() ;i++){
            for(int j=0; j<sortedList.size()-1;j++){
                if(sortedList.get(i).getPrice()<sortedList.get(j).getPrice()){
                    Device temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, temp);

                }
            }        
        }
        int count=1;
        for(Device device : sortedList){
            System.out.println(count + ". Category : " + device.getCategory() +", Name: " + device.getName() +", Price: " + device.getPrice() + "$, Quantity: " + device.getQuantity());
            count++;
        }
        System.out.println("___________________________________________________________");
    }
    /**
     * Calculates and returns the total price value of the inventory.
     * <p>
     * This method calculates the total value of all devices in the inventory by summing up their prices. It then prints the total value.
     * </p>
     * Returns the total price of the inventory.
     * @return The total price of the inventory.
     * Time complexity will be O(n) if we say the device number in the ArrayList is n since there is a nested loop, the first for statement will iterate five times since there are only five categories, therefore the time complexity will be O(5n) which will give us O(n). The rest are all simple statements and have a time complexity of O(1).
     */
    public double totalvalue(){
        double totalPrice=0.0;
        for (ArrayList<? extends Device> list : categoryList) {
            for (Device device : list) {
            totalPrice+=device.getPrice();
            }
        }
        System.out.println("___________________________________________________________\n");
        System.out.println("Total inventory value: $" + totalPrice);
        System.out.println("___________________________________________________________");
        return totalPrice;
    }
    /**
     * Restocks or reduces stock for a device in the inventory.
     * <p>
     * This method allows the user to restock or reduce the stock quantity of a device in the inventory. The user is prompted to enter the name of the device and choose whether to add or remove stock. Then they can specify the quantity to add or remove.
     * </p>
     * Time complexity will be O(n) if we say the device number in the ArrayList is n since there is a nested loop, the first for statement will iterate five times since there are only five categories, therefore the time complexity will be O(5n) which will give us O(n). The rest are all simple statements and have a time complexity of O(1).
     */
    @SuppressWarnings("resource")
    public void restock(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("___________________________________________________________\n\nEnter the name of the device to restock: ");
        String name = scanner.nextLine();
        for (ArrayList<? extends Device> list : categoryList) {
            for (Device device : list) {
                if(name.equals(device.getName())){
                    System.out.println("Do you want to add or remove stock? (Add/Remove): ");
                    String choice = scanner.nextLine();
                    switch(choice){
                        case "Add":
                        System.out.println("Enter the quantity to add: ");
                        int quantity = scanner.nextInt();
                        if(quantity<0){
                            System.out.println("Quantity should be 0 or greater.");
                            break;
                        }
                        quantity = device.getQuantity() + quantity;
                        device.setQuantity(quantity);
                        System.out.println(name + " restocked. New quantity: " + device.getQuantity());
                        break;
                        case "Remove":
                        System.out.println("Enter the quantity to remove: ");
                        int quantity2 = scanner.nextInt();
                        if(quantity2>device.getQuantity()){
                            System.out.println("Entered quantity should not be greater than the current quantity.");
                            break;
                        }
                        else if(quantity2<0){
                            System.out.println("Quantity should be 0 or greater.");
                            break;
                        }
                        quantity2 = device.getQuantity() - quantity2;
                        device.setQuantity(quantity2);
                        System.out.println(name + " stock reduced. New quantity: " + device.getQuantity());
                        break;
                        default:
                        System.out.println(choice + " is an unvalid operation.");
                        break;

                    }
                }
                else{
                    System.out.println("The device " + name +" does not exist.");
                }
                System.out.println("___________________________________________________________");
            }
        }        
        


    }
    /**
     * Exports the inventory details to a text file.
     * <p>
     * This method writes the details of all devices in the inventory to a text file, including the category, name, price, and quantity. Additionally, it calculates and writes the total number of devices and the total inventory value to the file.
     * </p>
     * Time complexity will be O(n) if we say the device number in the ArrayList is n since there is a nested loop, the first for statement will iterate five times since there are only five categories, therefore the time complexity will be O(5n) which will give us O(n). The rest are all simple statements and have a time complexity of O(1).
     */
    public void exportInventory(){
        String fileName = "CSE222HW2/Inventory_report.txt";
        int count=1;
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Electronics Shop Inventory Report\n");
            writer.write("Generated on: " + java.time.LocalDate.now() + "\n");	
            writer.write("-----------------------------------------------------------\n");
            
            writer.write("| No. | Category  | Name              | Price  | Quantity |\n");
            writer.write("-----------------------------------------------------------\n");
            for (ArrayList<? extends Device> list : categoryList) {
                for (Device device : list) {
                    writer.write("| " + count + "  | " + device.getCategory() +" | "  + device.getName() +" | $" + device.getPrice() + " | " + device.getQuantity() + "  |\n");
                    count++;
                }
            }
            writer.write("-----------------------------------------------------------\n\n\n");
            writer.write("Summary:\n- Total Number Of Devices: " + count);
            writer.write("\n- Total Inventory Value: $" + this.totalvalue() +"\n\n\nEnd of Report");

            System.out.println("Successfully exported the Inventory Report.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }


    
}

