package strategies;

import models.*;
import repositories.ParkingLotRepository;

public class RandomSpotAssignmentStrategy implements  SpotAssignmentStrategy{

    ParkingLotRepository parkingLotRepository;

    public RandomSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }
    @Override
    public ParkingSpot getSpot(Long parkingLotId, Gate gate, VehicleType vehicleType) {
        ParkingLot parkingLot = null;
        if(parkingLotRepository!=null && parkingLotRepository.getParkingLotById(parkingLotId)!=null){
            if (parkingLotRepository.getParkingLotById(parkingLotId)!=null){
                parkingLot = parkingLotRepository.getParkingLotById(parkingLotId).get();
            }
        }


        for (ParkingFloor parkingFloor: parkingLot.getParkingFloorList()) {
            for (ParkingSpot parkingSpot: parkingFloor.getParkingSpotsList()) {
                if (parkingSpot.getVehicleType().equals(vehicleType) &&
                        parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)) {
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
