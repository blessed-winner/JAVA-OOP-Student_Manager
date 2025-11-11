import java.util.*;

class RentalSystem implements VehicleOperations {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    @Override
    public void addVehicle(Vehicle vehicle){
        
        vehicles.add(vehicle);
    }
}
