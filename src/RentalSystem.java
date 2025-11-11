import java.io.*;
import java.util.*;

class RentalSystem implements VehicleOperations {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    @Override
    public void addVehicle(Vehicle vehicle){
        try{
            vehicles.add(vehicle);
            System.out.println("Vehicle added successfully");
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void viewVehicles(){
        try{
            if(vehicles.isEmpty()){
                System.out.println("No vehicles available");
            }
            for(Vehicle v : vehicles){
                System.out.println(v);
            }
        } catch(Exception e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }

    }

    @Override
    public Vehicle findById(int id){
        try{
            for(Vehicle v : vehicles){
                if(v.getId() == id){
                    return v;
                }
            }
        } catch(Exception e){
           e.printStackTrace();
        }
      return null;
    }

    @Override
    public void updateVehicle(int id, String newBrand,String newModel){
       try{
          Vehicle v = findById(id);
          if(v != null){
              v.setBrand(newBrand);
              v.setModel(newModel);
          } else System.out.println("Vehicle not found");
       }catch(Exception e){
           e.printStackTrace();
       }
    }

    @Override
    public void deleteVehicle(int id){
        try{
            Vehicle v = findById(id);
            if(v != null){
                vehicles.remove(v);
            } else  System.out.println("Vehicle not found");

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void rentVehicle(int id){
        try{
            Vehicle v = findById(id);
            if(v != null && v.getIsRented() == false){
                v.rent();
            } else System.out.println("Vehicle not found");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void returnVehicle(int id){
        try{
            Vehicle v = findById(id);
            if(v != null && v.getIsRented() == true){
                v.returnVehicle();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void saveToFile(){
        try(PrintWriter pw = new PrintWriter(new File("Vehicles.txt"))){
            for(Vehicle v:vehicles){
                if(v instanceof Car){
                    Car c = (Car) v;
                    pw.println("Car," + c.getId() + "," + c.getBrand() + "," + c.getModel() + "," + c.getIsRented() + "," + c.getSeats());
                } else if(v instanceof Bike){
                    Bike b = (Bike) v;
                    pw.println("Car," + b.getId() + "," + b.getBrand() + "," + b.getModel() + "," + b.getIsRented() + "," + b.getSeats());
                } else if(v instanceof Truck){
                    Truck t = (Truck) v;
                    pw.println("Car," + t.getId() + "," + t.getBrand() + "," + t.getModel() + "," + t.getIsRented() + "," + t.getSeats());
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadFromFile(){
        File file = new File("Vehicles.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))){

        }catch(IOException){

        }
    }
}
