package CSE222HW2;
/**
 * Represents an abstract device.
 * <p>
 * This class serves as a base for concrete device implementations. It defines common
 * properties and behaviors that are shared among different types of devices.
 * </p>
 * <p>
*/
public abstract class abstractDevice implements Device{
    private String name;
    private int quantity;
    private double price;
    public abstractDevice(){}
    /**
     * Constructor for the abstractDevice class.
     * @param Name
     * @param Quantity
     * @param Price
     */
    public abstractDevice(String Name, int Quantity, double Price){
        name = Name;
        quantity = Quantity;
        price = Price;
    }
    /**
     * Returns the category of the device.
     * @return null
     * Differentiates in subclasses since they will return different categories.
     * Time complexity is O(1) since there is only one return statement.
     * </p>
     * <p>
     */
    @Override
    public String getCategory() {
        return null;
    }
    /**
     * Sets the name of the device.
     * @param Name The name to set.
     * Time complexity is O(1) since there is only one assignment statement.     
     * </p>
     * <p>
     */
    @Override
    public void setName(String Name) {
        name=Name;
    }
    /**
     * Returns the name of the device.
     * @return The name of the device.
     * Time complexity is O(1) since there is only one return statement.
     * </p>
     * <p>
     */
    @Override
    public String getName(){
        return name;
    }
    /**
     * Returns the quantity of the device.
     * @return The quantity of the device.
     * Time complexity is O(1) since there is only one return statement.
     * </p>
     * <p>
     */
    @Override
    public int getQuantity(){
        return quantity;
    }
    /**
     * Sets the quantity of the device.
     * @param Quantity The quantity to set.
     * Time complexity is O(1) since there is only one assignment statement.
     * </p>
     * <p>
     */
    @Override
    public void setQuantity(int Quantity){
        quantity=Quantity;
    }
    /**
     * Returns the price of the device.
     * @return The price of the device.
     * Time complexity is O(1) since there is only one return statement.
     * </p>
     * <p>
     */
    @Override
    public double getPrice(){
        return price;
    }
    /**
     * Sets the price of the device.
     * @param Price The price to set.
     * Time complexity is O(1) since there is only one assignment statement.
     * </p>
     * <p>
      */
    @Override
    public void setPrice(double Price){
        price = Price;        
    }
    /**
     * Returns the Device object.
     * @return The Device object.
     * Time complexity is O(1) since there is only one return statement.
     * </p>
     * <p>
     */
    @Override
    public Device getDevice(){
            return this;
    }
    
}

