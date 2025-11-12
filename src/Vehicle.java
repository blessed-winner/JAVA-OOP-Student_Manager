abstract class Vehicle {
    private int id;
    private String brand;
    private String model;
    private boolean isRented;

    public Vehicle(int id, String brand,String model,boolean isRented){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.isRented = isRented;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getBrand(){
        return brand;
    }

    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return model;
    }

    public void setIsRented(boolean isRented){
        this.isRented = isRented;
    }
    public boolean getIsRented(){
        return isRented;
    }

    public void rent(){
        setIsRented(true);
    }

    public void returnVehicle(){
        setIsRented(false);
    }

    abstract String getType();

    @Override
    public String toString() {
        return getType() + "[ ID: " +id + ", Brand: " +brand + ",Model: " +model + ",isRented: " +isRented + "]";
    }
}
