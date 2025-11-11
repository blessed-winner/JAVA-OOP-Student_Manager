import java.util.*;

class RentalSystem implements VehicleOperations {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    @Override
    public void addVehicle(Vehicle vehicle){
        try{
            vehicles.add(vehicle);
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Vehicle added successfully");
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
            if(v != null && v.getIsRented() == true){
                v.rent();
            } else System.out.println("Vehicle not found");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void returnVehicle(int id){
        try{
            Vehicle v = findById(id);
            if(v != null){
                v.returnVehicle();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
