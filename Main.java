// PL4GU3
//                              Algorithm
//                               Vehicle
// -First of all you want to import the important packages that are going to be used in your program
// -We first have to create the instance variables and the constructor which initialises the instance variables
// -In the vehicle class we first have to create a method called getDuration which basically gets the difference between the exit time and the entry time
// -Then we create a method called setEntryTime which sets the entry time so that we know when the vehicle enters the parking spot
// -Lastly for the vehicle class we create a setType method which basically equalises each type with its string and then we getType which returns the vehicle type

//                              CarParking
// -First of all you want to import the important packages that are going to be used in your program
// -We first have to create the instance variables and the constructor which initialises the instance variables
// -After we create the floor rows and columns as instance variables we put them in the 3D array
// -We create method isOccupied which tells us whether the the parking space is empty or not
// -Then, we create method add which adds vehicles with the specified types to the 3D array
// -Then we create the remove method which removed vehicle with specified user input location
// -Then, we create the getTotalExpectedRevenue which basically counts the total revenue of all vehicles after taking their rate
// -Then, we create the getVehicleCount which returns the count of every vehicle type in each floor
// -Then, we create the getRevenue which returns the revenue of each vehicle type in each floor
// -Then, we create the canOrganizeByType which basically tells us whether we can accommodate all cars of the same type in separate floors or not


//                             Purpose Of The Program
// The purpose of this program is to create a 3D array and makes us figure out how we can add things into the 3D array list without overriding older variables. In this case, we have a parking lot that has 3 floors and has
// vehicles entering and leaving the parking space. We also have to provide methods which calculates the fees and the duration of the entry and the exiting time for these time and of course every vehicle type varies with
// their rates and durations. Lastly, it asks us whether the cars of the same type can be arranged into separate floors after checking all the floors and returning true or false since it is a boolean method.
import java.util.Date; // import date class
import java.util.Scanner; // import the scanner class
public class Main { // main class
    public static void main(String[] args) { // main method
        Date entrydate = new Date(2022, 12, 17, 1, 30, 15); // set the entry date
        Date exittime = new Date(2022, 12, 17, 2, 30, 15); // set the exit time
        Vehicle vehicle1 = new Vehicle(entrydate); // create an object for the vehicle class with the entry date in its parameters
        CarParking carparking = new CarParking(3, 7, 7); // create an object for the car parking class with identifying the number of floors, rows and columns
        double time = vehicle1.getDuration(exittime); // set the get duration to the exit time
        Scanner in = new Scanner(System.in); // create object in for the scanner
        while (true) { // while true so that it loops everytime the output is tru
            System.out.println("""
                    -----------------------------------------------
                    WELCOME TO PARKING SPACES
                    Choose the options below to invoke the methods!
                    -----------------------------------------------
                    1. Add Vehicle
                    2. Remove Vehicle
                    3. Display Statistics
                    4. Check arrangement
                    5. Exit the program
                    -----------------------------------------------"""); // print out the menu
            System.out.print("-------- Your Selection -------- : "); // prompt to select which option the user chooses from the menu
            int option = in.nextInt(); // save the selection in variable option
            if (option == 1) { // if the user chooses option 1
                System.out.print("Enter 'Sedan' or 'SUV' or 'Truck: "); // user should select either Sedan, SUV or Truck
                String option1 = in.next(); // save the selection in option1
                vehicle1.setType(option1); // we set the type of the vehicle entered the prompt to either Sedan, SUV or Truck
                carparking.add(vehicle1); // add the vehicle after we set the type of it to the parking spaces
            }
            else if (option == 2) { // if the user chooses option 2
                System.out.print("Please enter the car location (floor row column): "); // we enter the index/location of the vehicle we want it to get removed
                int floor = in.nextInt();int rows = in.nextInt();int column = in.nextInt(); // we set the index/location to their variables
                System.out.print("Please enter the parking rate: "); // we enter the rate of the parking
                double rate = in.nextDouble(); // save the prompt to the rate variable
                System.out.println("The car has been removed. The fee is: " + carparking.remove(floor, rows, column, rate, exittime)); // prompt that states that the vehicle with the specified location was removed including the parking fee
            } else if (option == 3) { // if the user chooses option 3
                System.out.print("Please enter the rate for the Sedan type: "); // prompt that asks the user to enter the sedan rate
                int sedan_type = in.nextInt(); // save the prompt to variable sedan_type
                System.out.print("Please enter the rate for the SUV type: "); // prompt that asks the user to enter the suv rate
                int suv_type = in.nextInt();// save the prompt to variable suv_type
                System.out.print("Please enter the rate for the Truck type: ");// prompt that asks the user to enter the truck rate
                int truck_type = in.nextInt();// save the prompt to variable truck_type
                double[] types = {sedan_type, suv_type, truck_type}; // create a double array that includes all the types of the vehicles
                System.out.println("-----------------------------------------------");
                System.out.println("Total expected revenue is: " + carparking.getTotalExpectedRevenue(types, exittime)); // create a total expected revenue which includes the total of all the types and their duration
                System.out.println("---------- Number of cars per floor ----------"); // number of cars per floors
                System.out.println("Floor         Sedan         SUV         Truck         Empty");
                        for (int k = 0; k < carparking.floor; k++) { // for loop for when k is less than the number of floors in the car parking
                            System.out.println(k + "               " + carparking.getVehicleCount("Sedan", k) + "            " + carparking.getVehicleCount("SUV", k) + "            " + carparking.getVehicleCount("Truck", k) + "            " + !carparking.isOccupied(k, k, k)); // print out the vehicle count of every car type in every floor and then print a boolean whether the floor is empty or not
                }
                    System.out.println("-----------------------------------------------");
                    System.out.println("---------- Revenue per floor ----------"); // revenue per floor
                    System.out.println("Floor         Sedan         SUV         Truck         ");
                    for(int m = 0; m < carparking.floor; m++) { // for loop for when m is less than the number of floors in the car parking
                                System.out.println(m + "              " + carparking.getRevenue("Sedan", m, sedan_type, exittime) + "          " + carparking.getRevenue("SUV", m, suv_type, exittime) + "           " + carparking.getRevenue("Truck", m, truck_type, exittime)); // print out the revenue of each floor by having the type of the vehicle in the parameter and the floors and the type and lastly the exit time which is the duration
                            }
                        }
                     else if (option == 4) { // if the user chooses option 4
                System.out.println(carparking.canOrganizeByType()); // prints out a statement whether same type of cars can be arranged into separate floors
            } else if (option == 5) { // if the user chooses option 5
                System.out.println("System quits...!"); // system quits and prints this statement before quitting
                System.exit(0); // system exits
            }
        }
    }
}
