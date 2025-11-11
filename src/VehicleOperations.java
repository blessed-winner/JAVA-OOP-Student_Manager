interface VehicleOperations {
    public void addVehicle(Vehicle v);
    public Vehicle viewVehicles();
    public Vehicle findById(int id);
    public void updateVehicle(int id, String newBrand, String newModel);
    public void deleteVehicle(int id);
    public void rentVehicle(int id);
    public void returnVehicle(int id);
}
