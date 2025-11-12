import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      RentalSystem system = new RentalSystem();
      System.out.println("Enter the choice among the following:");
      System.out.println("1.Add Vehicle");
      System.out.println("2.Display Vehicles");
      System.out.println("3.View a vehicle");
      System.out.println("4.Update a vehicle");
      System.out.println("5.Delete a vehicle");
      System.out.println("6.Rent a vehicle");
      System.out.println("7.Return a vehicle");
      System.out.println("8.Exit");

      System.out.print("Choice: ");
      int choice = sc.nextInt();
      switch(choice){
          case 1:
           System.out.print("Enter the ID: ");
           int id = sc.nextInt();
           sc.nextLine();
           for(Vehicle v: system.vehicles){
               if(v.getId() == id){
                   System.out.println("Vehicle with id " + id + " already exists");
                   return;
               }
           }
           System.out.print("Enter the Brand: ");
           String brand = sc.nextLine();
           System.out.print("Enter the Model: ");
           String model = sc.nextLine();
           boolean isRented = false;
           System.out.println("Choose the type among the following:");
           System.out.println("1.Car");
           System.out.println("2.Bike");
           System.out.println("3.Truck");
           System.out.print("Choice: ");
           int typeChoice = sc.nextInt();
           switch(typeChoice){
               case 1:
                   System.out.print("Enter the number of seats: ");
                   int seats = sc.nextInt();
                   Car c = new Car(id,brand,model,isRented,seats);
                   system.addVehicle(c);
                   break;
               case 2:
                   boolean hasHelmet = true;
                   Bike b = new Bike(id,brand,model,isRented,hasHelmet);
                   system.addVehicle(b);
                   break;
               case 3:
                   System.out.print("Enter the load capacity: ");
                   double loadCapacity = sc.nextDouble();
                   Truck t = new Truck(id,brand,model,isRented,loadCapacity);
                   system.addVehicle(t);
                   break;
               default:
                   System.out.println("Invalid choice.Try again");
                   break;
           }
           break;

          case 2:
              System.out.println("List of vehicles\n");
              system.viewVehicles();
              break;
          case 3:
              System.out.print("Enter the vehicle ID: ");
              int toFind = sc.nextInt();
              system.findById(toFind);
              break;
          case 4:
              System.out.print("Enter the vehicle ID: ");
              int toUpdate = sc.nextInt();
              System.out.print("Enter the vehicle brand: ");
              String newBrand = sc.next();
              System.out.print("Enter the vehicle model: ");
              String newModel = sc.next();
              system.updateVehicle(toUpdate,newBrand,newModel);
              break;
          case 5:
              System.out.print("Enter the vehicle ID: ");
              int toDelete = sc.nextInt();
              system.deleteVehicle(toDelete);
              break;
          case 6:
              System.out.print("Enter the vehicle ID: ");
              int toRent = sc.nextInt();
              system.rentVehicle(toRent);
              break;
          case 7:
              System.out.print("Enter the vehicle ID: ");
              int returnedId = sc.nextInt();
              system.returnVehicle(returnedId);
              break;
          default:
              System.out.println("Invalid choice. Try again");

      }
    }
}