class Car extends Vehicle{
    private int seats;

    public Car(int id,String brand,String model,boolean isRented,int seats){
        super(id,brand,model,isRented);
        this.seats = seats;
    }

    public void setSeats(int seats){
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }
    @Override
    public String getType(){
        return "Car";
    }

    @Override
    public String toString() {
        return getType() + "[ ID: " +super.getId() + ", Brand: " +super.getBrand() + ",Model: " +super.getModel() + ",isRented: " +super.getIsRented() + "Seats: " +seats +"]";
    }
}
