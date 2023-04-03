# ParkingSystemInJava
Parking system in java
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
