/**
 * @author PL4GU3
 * importing all the necessary libraries that are needed to be used in the program
 */
import java.util.Date;
/**
 * CarParking class which first is used to create the instance variables (floor, row and col) and create a public
 * 3D array, and we should also declare it as public so that it can be used in the following methods
 */
public class CarParking {
    int floor = 3;
    int row = 7;
    int col = 7;
    public Vehicle[][][] vehicles = new Vehicle[row][col][floor];
    /**
     * CarParking constructor used to intialise the instance variables that were created in the class above and finally
     * assign them to the 3D array. We used te "this reference" to differentiate between the instance and the local
     * variables.
     * @param floors is the number of floors in the multistory parking spaces
     * @param rows is the number of rows in the multistory parking spaces
     * @param columns is the number of columns in the multistory parking spaces
     */
    public CarParking(int floors, int rows, int columns) {
        this.floor = floors;
        this.row = rows;
        this.col = columns;
        vehicles = new Vehicle[rows][columns][floors];
    }
    /**
     * isOccupied method is used to declare whether the parking spaces are occupied or not so that the car can fit in
     * the parking spot or not. And this is done by saying that it is not equal to null or nothing
     * @param floor is declared in the 3D array, and it says that it is not equal to null which means it has a value
     * @param row is declared in the 3D array, and it says that it is not equal to null which means it has a value
     * @param col is declared in the 3D array, and it says that it is not equal to null which means it has a value
     * @return the 3D arrays with the floor, row and columns not equal to null
     */
    public boolean isOccupied(int floor, int row, int col) {
        return vehicles[row][col][floor] != null;
    }
    /**
     * the add method is used to add Vehicle v in the for loop after looping all over the rows, columns and floors,
     * and it adds the vehicle when it makes sure that the spot isn't occupied by using the isOccupied method. If it is
     * not occupied then add a vehicle to that spot.
     * @param v is the vehicle is that is added to the parking lot
     */
    public void add(Vehicle v) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < floor; k++) {
                    if (!isOccupied(i, j, k)) {
                        vehicles[i][j][k] = v;
                        System.out.println("The car was added successfully.");
                        return;
                    }
                }
            }
        }
    }
    /**
     * The remove method is used to remove the vehicle according to the directions of the user input. After removing
     * the vehicle from the parking spot, it calculates the fee of the parking lot according to the rate of the type,
     * and it calculates it also according to the duration it takes in the parking spot
     * @param floor  is the floor to get the vehicle removed from
     * @param row is the row to get the vehicle removed from
     * @param col is the column to get the vehicle removed from
     * @param rate is the rate of the type of vehicles specified
     * @return the fee of the parking lot
     */
    public double remove(int floor, int row, int col, double rate, Date exitTime) {
        double fee = 0;
        Vehicle v = vehicles[floor][row][col];
        double duration_of_parking = v.getDuration(exitTime) / 60000;
        fee = duration_of_parking * rate;
        if (floor != 0) {
            fee = fee - (fee * 5 / 100);
        }
        vehicles[floor][row][col] = null;
        return fee;
    }
    /**
     * The getTotalExpectedRevenue method calculates the total revenue when all the vehicles exit the parking spots of
     * the multistory parking lot and to be able to calculate that we have to know the exit time and we have to also
     * know the rates of each vehicle. And, just like the remove method, the fee is calculated by multiplying the rate
     * with the duration of the parking spoit until it exits. To calculate the total revenue we have to add it to the
     * fee of the parking spot.
     * @param exitTime is needed to calculate the total revenue when all the vehicles exit the parking spots of
     * the multistory parking lot
     * @return the total revenue after adding it to the fee
     */
    public double getTotalExpectedRevenue(double[] rates, Date exitTime) {
        int floor = 0;int row = 0;int col = 0;double revenue = 0;
        for (row = 0; row < this.row; row++) {
            for (col = 0; col < this.col; col++) {
                for (floor = 0; floor < this.floor; floor++) {
                    if (isOccupied(floor, row, col)) {
                        double fee = 0;
                        Vehicle v = vehicles[row][col][floor];
                        double duration_of_parking = v.getDuration(exitTime) / 60000;
                        double rate = switch (v.getType()) {
                            case "Sedan" -> rates[0];
                            case "SUV" -> rates[1];
                            case "Truck" -> rates[2];
                            default -> 0;
                        };
                        fee = duration_of_parking * rate;
                        if (floor != 0) {
                            fee = fee - (fee * 5 / 100);
                        }
                        revenue = revenue + fee;
                        vehicles[floor][row][col] = v;
                    }
                }
            }
        }
        return revenue;
    }
    /**
     * The getVehicleCount method is used to count the occupied parking spots according to the types
     * @param type is required to specify what kind of vehicle is in that parking spot
     * @param floor is needed to know which floor the type of the car is in
     * @return return the count of the vehicle which gets incremented when the type is found in the specified floor
     */
    public int getVehicleCount(String type, int floor) {
        int count = 0;
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (isOccupied(floor, i, j)) {
                    Vehicle v = vehicles[i][j][floor];
                    if (v.getType().equals(type)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    /**
     * The getRevenue calculates the total revenue of a given car type in a given floor for a given rate. It is done
     * by first calculating the fee by multiplying the duration of the type until it exits the parking lot
     * multiplied by the rate of that vehicle
     * @param type is needed to specify the type of the vehicle of the car in the parking lot
     * @param floor is needed to know which floor the type of the car is in
     * @param rate is the rate of the specified type which affects the fee
     * @return the revenue added to the fee which is affected by the duration and the rate of the vehicle
     */
    public double getRevenue(String type, int floor, double rate, Date exitTime) {
        int row;int col;double revenue = 0;
        for (row = 0; row < this.row; row++) {
            for (col = 0; col < this.col; col++) {
                if (isOccupied(floor, row, col)) {
                    if (vehicles[row][col][floor].getType().equals(type)) {
                        Vehicle v = vehicles[row][col][floor];
                        double duration_of_parking = v.getDuration(exitTime) / 60000;
                        double fee = duration_of_parking * rate;
                        if (floor != 0) {
                            fee = fee - (fee * 5 / 100);
                            revenue = revenue + fee;
                            return revenue;
                        }
                    }
                }
            }
        }
        return revenue;
    }
    /**
     * @return true if it is possible to accommodate all cars of the same type in separate floors. This is done by
     * comparing the type with the string of the type.
     */
    public boolean canOrganizeByType() {
        int sedan_count = 0;
        int suv_count = 0;
        int truck_count = 0;
        for (int i = 0; i < floor; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (isOccupied(i, j, k)) {
                        Vehicle v = vehicles[i][j][k];
                        switch (v.getType()) {
                            case "Sedan" -> sedan_count++;
                            case "SUV" -> suv_count++;
                            case "Truck" -> truck_count++;
                        }
                    }

                }
            }
        }
        System.out.println("The cars of the same type can be arranged into separate floors");
        return sedan_count <= floor && suv_count <= floor && truck_count <= floor;
    }
}