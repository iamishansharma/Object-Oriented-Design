/*
    Requirements -> 
    https://youtu.be/V9NEOLpt3tg

    Entities ->     

    ParkingLot      
    Vehicle         
    ParkingSpots
    Floors
    EntryGate
    ExitGate

    UseCases -> 

    1. Multiple Floors (ParkingLot)
    2. Multiple Gates (Parking Lot)
    3. Attendant at gate (EntryGate and ExitGate)
    4. Ticket Processing (Assign / Bill) (EntryGate and ExitGate)
    6. Different size of parking spots (ParkingSpots)
    7. Display board for vacant spots (Floor)

*/

public class ParkingLot {
    List<Floor> floors;
    List<Gate> gates;

    Address address;

    public boolean isParkingSpaceAvailable(Vehicle vehicle);
}

public class Address {
    Integer pincode;
    String street;
    String locality;
    String city;
    String state;
}

public class Floor {
    Integer floorID;
    boolean isFull;
    DisplayBoard displayBoard;
    List<ParkingSpots> parkingSpots;

    public List<ParkingSpot> getVacantSpots();
}

public class DisplayBoard {
    Map<SpotType, Integer> vacantSpots;
}

public class ParkingSpot {
    Integer parkingSpotID;
    SpotType spotType;
    boolean isOccupied;
    Vehicle vehicle;
    Integer price;
}

public enum SpotType {
    SMALL, MEDIUM, LARGE
}

public class Gate {
    Integer gateID;
    Attendant attendant;
}

public class EntryGate extends Gate {
    public Ticket getTicket(Vehicle vehicle);
}

public class ExitGate extends Gate {
    public Ticket processTicket(Vehicle vehicle);
}

public class Ticket {
    Integer ticketID;
    Date date;
    Date entryTime;
    Date exitTime;
    ParkingSpot parkingSpot;
    Vehicle vehicle;
}

public class Vehicle {
    Integer vehicleID;
    VehicleType vehicleType;
    Ticket ticket;
    PaymentInfo paymentInfo;
}

public enum VehicleType {
    SMALL, MEDIUM, LARGE
}

public class Employee {
    Integer empID;
    Credentials credentials;
    String name;
    String email;
    Address address;
}

public class Credentials {
    String username;
    String password;
}

public class Admin extends Employee {
    public void addParkingFloors(Floor floor);

    public void addParkingSpots(ParkingSpot parkingSpot, Floor floor);

    public void updateDisplayBoard(DisplayBoard displayBoard);
}

public class Attendant extends Employee {
    PaymentService paymentService;

    public boolean processVehicleEntry(Vehicle vehicle);

    public PaymentInfo processPaymentAtExit(Ticket ticket, Date currDate, Date currTime);
}

public class PaymentService {
    public PaymentInfo makePayment(Ticket ticket);
}

public class PaymentInfo {
    Integer paymentID;
    Date paymentDate;
    Double totalAmount;
    PaymentStatus paymentStatus;
}

public enum PaymentStatus {
    UNPAID, PAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED;
}