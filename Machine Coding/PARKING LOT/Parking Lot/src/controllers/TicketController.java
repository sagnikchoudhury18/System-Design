package controllers;

import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import exceptions.GateNotFoundException;
import models.Ticket;
import services.TicketService;

public class TicketController {

    TicketService ticketService;

    public  TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }


    public IssueTicketResponse issueTicket(IssueTicketRequest request) {
        Ticket ticket = null;
        try{
            ticket = ticketService.issueTicket(
                    request.getParkingLotId(),
                    request.getVehicleNumber(),
                    request.getVehicleType(),
                    request.getGateId());
        } catch (GateNotFoundException e) {
            return IssueTicketResponse.builder().statusCode(400).message("BAD REQUEST").build();
        }

        return IssueTicketResponse.builder()
                .ticketId(ticket.getNumber())
                .gateNumber(ticket.getGeneratedAt().getGateNumber())
                .floorNumber(ticket.getParkingSpot().getParkingFloor().getFloorNumber())
                .entryTime(ticket.getEntryTime())
                .spotNumber(ticket.getParkingSpot().getSlotNumber())
                .vehicleNumber(ticket.getVehicle().getVehicleNumber())
                .build();

    }
}
