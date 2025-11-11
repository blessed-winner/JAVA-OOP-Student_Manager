class Bike extends Vehicle {
    private boolean hasHelmet;
    public Bike(int id,String brand,String model,boolean isRented,boolean hasHelmet) {
        super(id, brand, model, isRented);
        this.hasHelmet = hasHelmet;
    }
    public void setHasHelmet(boolean hasHelmet) {
        this.hasHelmet = hasHelmet;
    }
    public boolean getHasHelmet(){
        return hasHelmet;
    }
    @Override
    public String getType(){
        return "Bike";
    }

    @Override
    public String toString() {
        return getType() + "[ ID: " +super.getId() + ", Brand: " +super.getBrand() + ",Model: " +super.getModel() + ",isRented: " +super.getIsRented() + "hasHelmet: " +hasHelmet +"]";
    }
}
