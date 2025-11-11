interface VehicleOperations {
     void addVehicle(Vehicle v);
     void viewVehicles();
     Vehicle findById(int id);
     void updateVehicle(int id, String newBrand, String newModel);
     void deleteVehicle(int id);
     void rentVehicle(int id);
     void returnVehicle(int id);
}
