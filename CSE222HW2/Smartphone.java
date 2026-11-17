package CSE222HW2;
/**
 * Represents a smartphone device.
 * <p>
 * This class extends the abstractDevice class and represents a specific type of device, namely a smartphone.
 * </p>
 * <p>
 */
public class Smartphone extends abstractDevice{
    public Smartphone(String Name, int Quantity, double Price){
        super(Name, Quantity, Price);
    }
    /**
     * Returns the category of the headset.
     * @return The category "Smartphone".
     * Time complexity is O(1) since the method has only one return statement.
     * </p>
     * <p>
     */
    @Override
    public String getCategory(){
        return "Smartphone";
    }

    
}

