package CSE222HW2;
/**
 * The interface for the devices.
 * </p>
 * <p>
 */
public interface Device {
        String getCategory();
        String getName();
        void setName(String Name);
        double getPrice();
        void setPrice(double Price);
        int getQuantity();
        void setQuantity(int Quantity);
        Device getDevice();
}

