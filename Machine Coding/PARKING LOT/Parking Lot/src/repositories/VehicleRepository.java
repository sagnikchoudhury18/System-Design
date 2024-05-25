package repositories;

import models.ParkingLot;
import models.Vehicle;

import java.util.HashMap;
import java.util.Optional;

public class VehicleRepository {

    private HashMap<String, Vehicle> vehicles = new HashMap<>();

    public Optional<Vehicle> findVehicleById(String vehicleNumber) {
        if(vehicles!=null && vehicles.containsKey(vehicleNumber)){
            return  Optional.of(vehicles.get(vehicleNumber));
        }
        return Optional.empty();
    }

    public void save(Vehicle vehicle){
        if(!vehicles.containsKey(vehicle.getVehicleNumber())) {
            vehicles.put(vehicle.getVehicleNumber(), vehicle);
        }
    }

}
