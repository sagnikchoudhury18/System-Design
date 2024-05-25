import controllers.TicketController;
import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import models.VehicleType;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;
import strategies.RandomSpotAssignmentStrategy;
import strategies.SpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the parking system!");

        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingLotRepository);
        TicketRepository ticketRepository = new TicketRepository();

        TicketService ticketService = new TicketService(gateRepository, vehicleRepository,spotAssignmentStrategy, ticketRepository);
        TicketController ticketController = new TicketController(ticketService);

        IssueTicketResponse response = ticketController.issueTicket(IssueTicketRequest.builder()
                        .parkingLotId(1L)
                        .gateId(1L)
                        .vehicleNumber("123")
                        .vehicleType(VehicleType.CAR)
                        .build());
    }
}