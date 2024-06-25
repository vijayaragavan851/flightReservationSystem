package flightReservationSystem;

public class Passenger {
     
	int id;
	int noOfSeats;
	int price;
	
	Passenger(int id,int noOfSeats,int price){
		
		this.id = id;
		this.noOfSeats = noOfSeats;
		this.price = price;
	}

	@Override
	public String toString() {
		
		return "Id: " +this.id +" No of seats:"+noOfSeats+" Price:"+price;
	}
	
	
	
	
}
