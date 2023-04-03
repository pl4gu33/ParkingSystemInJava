/**
 * @author PL4GU3
 */
import java.util.Date;
import java.util.Objects;
/**
 * Class vehicle is used to store the instance variables of the vehicle type and the entry time
 */
public class Vehicle{
    private String vehicle_type;
    private Date entry_time;
    /**
     * Constructor Vehicle which sets the entry time of the vehicle to the parking spot
     * @param entry_time is used to set the entry time when the vehicle enters the parking spot so that it can be used
     * later in the method
     */
    public Vehicle(Date entry_time){
        setEntryTime(entry_time);
    }
    /**
     * The getDuration calculates the time difference between the exit time and the entry time and cast it to double
     * @param exitTime is used to determine the exit time which is when a vehicle exits the parking spot
     * @return duration after getting the difference between the exit time and the entry time
     */
    public double getDuration(Date exitTime){
        double duration = 0;
        if(exitTime.after(entry_time)){
            long difference = (exitTime.getTime() - entry_time.getTime());
            duration = ((double) difference);
        }
        return duration;
    }
    /**
     * @param entryTime sets the entry time instance variable to the entry time with the date class
     */
    public void setEntryTime(Date entryTime){
        entry_time = entryTime;
    }
    /**
     * The setType which has type in its parameters check if the type object equals to the strings of the types
     * @param type is the type of the vehicle (Sedan, SUV and Truck)
     */
    public void setType(String type){
        if(Objects.equals(type, "SUV") || Objects.equals(type, "Truck") || Objects.equals(type, "Sedan"))
            vehicle_type = type;
    }
    /**
     * @return the vehicle type which was set in the previous method
     */
    public String getType(){
        return vehicle_type;
    }
}