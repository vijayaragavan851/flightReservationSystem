package flightReservationSystem;

import java.util.*;

public class FlightBooking{
          
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		
		ArrayList<Flight> flights = new ArrayList<>();
		
		int id = 1;
		
		//creating flights
		for(int i=0;i<2;i++) {
			Flight flight = new Flight();
			flights.add(flight);
		}
		
		System.out.println("Welcome to the flight reservation System");
		while(true) {
			System.out.println("1.Book\n2.Cancel\n3.Print\n4.Exit");
			System.out.println("------------------------------------");
			
			System.out.print("Enter your choice:");
			int choice = scanner.nextInt();
			System.out.println("------------------------------------");
			
			switch(choice) {
			   
			    case 1:{
			
			    	
			    	System.out.println("Flight booking");
			    	System.out.println("Flights:");
			    	System.out.println("------------------------------------");
			    	for(Flight flight:flights) {
			    		System.out.println(flight);
			    	}
			    	System.out.println("------------------------------------");
			    	System.out.print("Enter the flight Id:");
			    	int flightId = scanner.nextInt();
			    	
			    	//invalid fligthId
			    	if(flightId<1 || flightId>flights.size()) {
			    		System.out.println("Invalid Flights");
			    		System.out.println("------------------------------------");
			    		break;
			    	}
			    	
			    	Flight currentFlight = flights.get(flightId-1);
			    	
			    	System.out.print("Enter the no of tickets :");
			    	int noOfTickets = scanner.nextInt();
			    	
			    	//checking the available seats
			    	if(currentFlight.totalSeats<noOfTickets){
			    		System.out.println("Only "+currentFlight.totalSeats+" are left");
			    		System.out.println("------------------------------------");
			    		break;
			    	}
			    	
			    	int price = noOfTickets*currentFlight.price;
			    	Passenger passenger = new Passenger(id,noOfTickets,price);
			    	String passengerDetails = "Passenger Id:"+id++ + " noOfTickets:"+noOfTickets+" price:"+price;
			    	currentFlight.bookFlight(passenger,passengerDetails);
			    	System.out.println("------------------------------------");
			    	
			    	
			    }
			    break;
			    
			    case 2:{
			    	
			    	System.out.print("\nEnter the flight Id:");
			    	int flightId = scanner.nextInt();
			    	
			    	//invalid fligthId
			    	if(flightId<1 || flightId>flights.size()) {
			    		System.out.println("Invalid Flight Id");
			    		System.out.println("------------------------------------");
			    		break;
			    	}
			    	
			    	Flight currentFlight = flights.get(flightId-1);
			    	
			    	
			    	System.out.print("Enter the passener Id :");
			    	int passengerId = scanner.nextInt();
			    	
			    	//invalid fligthId
			    	if(!currentFlight.passengersId.contains(passengerId)){
			    		System.out.println("Invalid Passenger Id");
			    		System.out.println("------------------------------------");
			    		break;
			    	}
			    	
			    	currentFlight.cancelTicket(passengerId);
			    	System.out.println("Cancel Booking");
			    	System.out.println("------------------------------------");
			    	
			    }
			    break;
			    
			    
			    case 3:{
			    	//getting a flight from flights
			    	for(Flight flight:flights) {
			    		
			    		if(flight.passengersDetails.size() == 0) {
			    			System.out.println("Flight "+flight.flightId+"has is no Passengers");
			    		}else {
			    			flight.printPassengerDetails();
			    		}
			
			    	}
			    	System.out.println("------------------------------------");
			    	
			    }
			    break;
			    
			    
			    case 4:{
			    	System.out.println("Exit");
			    	loop = false;
			    	
			    }
			    break;
			    
			    default:
			    	System.out.println("Invalid Choice");
			
			}
			
			
			
		 	
			
		}
		
	}
}
