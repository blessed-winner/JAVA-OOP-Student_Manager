class Truck extends Vehicle{
    private double loadCapacity;
    public Truck(int id,String brand,String model,boolean isRented,double loadCapacity){
        super(id,brand, model,isRented);
        this.loadCapacity=loadCapacity;
    }
    public double getloadCapacity() {
        return loadCapacity;
    }
    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String getType() {
        return "Truck";
    }

    @Override
    public String toString() {
        return getType() + "[ ID: " +super.getId() + ", Brand: " +super.getBrand() + ",Model: " +super.getModel() + ",isRented: " +super.getIsRented() + "Load Capacity: " +loadCapacity +"]";
    }

}
