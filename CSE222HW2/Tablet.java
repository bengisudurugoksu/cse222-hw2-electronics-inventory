package CSE222HW2;
/**
 * Represents a tablet device.
 * <p>
 * This class extends the abstractDevice class and represents a specific type of device, namely a tablet.
 * </p>
 * <p>
 */
public class Tablet extends abstractDevice{
    public Tablet(String Name, int Quantity, double Price){
        super(Name, Quantity, Price);
    }
    /**
     * Returns the category of the headset.
     * @return The category "Tablet".
     * Time complexity is O(1) since the method has only one return statement.
     * </p>
     * <p>
     */
    @Override
    public String getCategory(){
        return "Tablet";
    }  
    
}

