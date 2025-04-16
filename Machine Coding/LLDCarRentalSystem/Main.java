package LLDCarRentalSystem;

import LLDCarRentalSystem.Product.Car;
import LLDCarRentalSystem.Product.Vehicle;
import LLDCarRentalSystem.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        System.out.println("==== Starting Car Rental System ====");

        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        System.out.println("Users, Vehicles, and Stores initialized successfully.");

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);

        //0. User comes
        User user = users.get(0);
        System.out.println("User " + user.getUserId() + " has entered the system.");

        //1. user search store based on location
        Location location = new Location(403012, "Bangalore", "Karnataka", "India");
        Store store = rentalSystem.getStore(location);
        System.out.println("Store found at location: " + location.city + ", " + location.state);

        //2. get All vehicles you are interested in (based upon different filters)
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);
        System.out.println("Available cars in store:");
        for (Vehicle v : storeVehicles) {
            System.out.println("Vehicle ID: " + v.getVehicleID() + ", Type: " + v.getVehicleType());
        }

        //3. reserving the particular vehicle
        Reservation reservation = store.createReservation(storeVehicles.get(0), user);
        System.out.println("Vehicle ID " + storeVehicles.get(0).getVehicleID() + " reserved for User ID " + user.getUserId());

        //4. generate the bill
        Bill bill = new Bill(reservation);
        System.out.println("Bill generated. Amount: ₹" + bill.totalBillAmount);

        //5. make payment
        Payment payment = new Payment();
        payment.payBill(bill);
        System.out.println("Payment completed for Bill ID: " + bill.totalBillAmount);

        //6. trip completed, submit the vehicle and close the reservation
        store.completeReservation(reservation.reservationId);
        System.out.println("Reservation ID " + reservation.reservationId + " completed and closed.");

        System.out.println("==== Car Rental Flow Completed ====");
    }




    public static List<Vehicle> addVehicles(){

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car();
        vehicle1.setVehicleID(1);
        vehicle1.setVehicleType(VehicleType.CAR);

        Vehicle vehicle2 = new Car();
        vehicle1.setVehicleID(2);
        vehicle1.setVehicleType(VehicleType.CAR);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }

    public static List<User> addUsers(){

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);

        users.add(user1);
        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles){

        List<Store> stores = new ArrayList<>();
        Store store1 = new Store();
        store1.storeId=1;
        store1.setVehicles(vehicles);

        stores.add(store1);
        return stores;
    }

}
