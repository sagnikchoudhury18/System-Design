package services;

import exceptions.GateNotFoundException;
import models.*;
import repositories.GateRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import strategies.SpotAssignmentStrategy;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;



public class TicketService {

    private final GateRepository gateRepository;
    private final VehicleRepository vehicleRepository;
    private final TicketRepository ticketRepository;
    private final SpotAssignmentStrategy spotAssignmentStrategy;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, SpotAssignmentStrategy spotAssignmentStrategy, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(Long parkingLotId, String vehicleNumber, VehicleType vehicleType, Long gateId) throws GateNotFoundException{
        Ticket ticket = new Ticket();
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);


        if (gateOptional.isEmpty()) {
            throw new GateNotFoundException();
        }

        Gate gate = gateOptional.get();

        Vehicle savedVehicle;

        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleById(vehicleNumber);

        if(vehicleOptional.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            savedVehicle = vehicle;
        } else {
            savedVehicle = vehicleOptional.get();
        }

        ticket.setGeneratedAt(gate);
        ticket.setVehicle(savedVehicle);
        ticket.setEntryTime(new Date());
        ticket.setGeneratedBy(gate.getCurrentOperator());
        ticket.setNumber(String.valueOf(Instant.now().getEpochSecond()));

        ParkingSpot parkingSpot = spotAssignmentStrategy.getSpot(parkingLotId, gate, vehicleType);
        ticket.setParkingSpot(parkingSpot);

        ticketRepository.save(ticket);

        return  ticket;

    }
}
