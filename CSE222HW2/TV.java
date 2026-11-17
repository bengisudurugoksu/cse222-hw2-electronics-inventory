package CSE222HW2;
/**
 * Represents a TV device.
 * <p>
 * This class extends the abstractDevice class and represents a specific type of device, namely a TV.
 * </p>
 * <p>
 */
public class TV extends abstractDevice{
    public TV(String Name, int Quantity, double Price){
        super(Name, Quantity, Price);
    }
     /**
     * Returns the category of the headset.
     * @return The category "TV".
     * Time complexity is O(1) since the method has only one return statement.
     * </p>
     * <p>
     */
    @Override
    public String getCategory(){
        return "TV";
    }    
}

