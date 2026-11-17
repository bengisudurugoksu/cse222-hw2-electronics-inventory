package CSE222HW2;
/**
 * Represents a headset device.
 * <p>
 * This class extends the abstractDevice class and represents a specific type of device, namely a laptop.
 * </p>
 * <p>
 */
public class Headset extends abstractDevice{
    public Headset(String Name, int Quantity, double Price){
        super(Name, Quantity, Price);
    }
    /**
     * Returns the category of the headset.
     * @return The category "Headset".
     * Time complexity is O(1) since the method has only one return statement.
     * </p>
     * <p>
     */
    @Override
    public String getCategory(){
        return "Headset";
    }  
}

