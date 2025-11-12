import java.io.*;
import java.util.*;

class RentalSystem implements VehicleOperations {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    public RentalSystem() {
        loadFromFile();
    }
    @Override
    public void addVehicle(Vehicle vehicle){
        try{
            vehicles.add(vehicle);
            saveToFile();
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
              saveToFile();
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
                saveToFile();
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
                saveToFile();
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
                saveToFile();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void saveToFile(){
        try(PrintWriter pw = new PrintWriter(new File("Vehicles.txt"))){
            for(Vehicle v:vehicles){
                if(v instanceof Car){
                    Car c = (Car) v;
                    pw.println("Car," + c.getId() + "," + c.getBrand() + "," + c.getModel() + "," + c.getIsRented() + "," + c.getSeats());
                } else if(v instanceof Bike){
                    Bike b = (Bike) v;
                    pw.println("Bike," + b.getId() + "," + b.getBrand() + "," + b.getModel() + "," + b.getIsRented() + "," + b.getHasHelmet());
                } else if(v instanceof Truck){
                    Truck t = (Truck) v;
                    pw.println("Truck," + t.getId() + "," + t.getBrand() + "," + t.getModel() + "," + t.getIsRented() + "," + t.getloadCapacity());
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void loadFromFile(){
        File file = new File("Vehicles.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                String type = data[0];
                int id = Integer.parseInt(data[1]);
                String brand = data[2];
                String model = data[3];
                boolean rented = Boolean.parseBoolean(data[4]);
                switch(type){
                    case "Car":
                        int seats = Integer.parseInt(data[5]);
                        vehicles.add(new Car(id, brand, model, rented, seats));
                        break;
                    case "Bike":
                        boolean hasHelmet = Boolean.parseBoolean(data[5]);
                        vehicles.add(new Bike(id,brand,model,rented,hasHelmet));
                        break;
                    case "Truck":
                        double loadCapacity = Double.parseDouble(data[5]);
                        vehicles.add(new Truck(id,brand,model,rented,loadCapacity));
                        break;
                    default:
                        System.out.println("Problem encountered.type not valid");
                }
            }
        }catch(IOException e){

        }
    }
}
