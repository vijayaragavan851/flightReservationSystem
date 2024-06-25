package flightReservationSystem;
import java.util.*;

public class Flight {
    
	static int id=1;
	
	int totalSeats;
	int flightId;
	int price;
	
	ArrayList<String>passengersDetails;
	ArrayList<Integer>passengersId;
	HashMap<Integer,Passenger>passengers;
	
	Flight(){
		totalSeats = 50;
		flightId = id++;
		price = 5000;
		passengersDetails = new ArrayList<>();
		passengersId = new ArrayList<>(); 
		passengers = new HashMap<>();
		
	}
	

	public void bookFlight(Passenger passenger, String passengerDetails) {
		
		this.passengersDetails.add(passengerDetails);
		this.passengersId.add(passenger.id);
		this.passengers.put(passenger.id, passenger);
		
		price += passenger.noOfSeats * 200;
		totalSeats -= passenger.noOfSeats;  
		System.out.println("Flight Ticket booked successfully");
		System.out.println(this);
	}
	
	public void cancelTicket(int passengerId) {
		
		int index = passengersId.indexOf(passengerId);
		passengersId.remove(index);
		passengersDetails.remove(index);
		Passenger passenger = passengers.get(passengerId);
		this.totalSeats += passenger.noOfSeats;
		this.price -= passenger.noOfSeats * 200;
		System.out.println("Ticket cancellation successfully");
		
	}
	
	public String toString() {
		return "Flight:"+this.flightId+" NoOfSeats:"+this.totalSeats+" Price:"+this.price;
	}
	
	public void printPassengerDetails() {
		System.out.println("Flight "+this.flightId+" passengers Details");
		for(String details: passengersDetails){
			System.out.println(details);
		}
		System.out.println();
	}
}
