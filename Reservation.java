package hotelManagement;

class Reservation {
	String guestName;
	Room room;
	int numberOfNights;
	double totalAmount;

	public Reservation(String guestName, Room room, int numberOfNights) {
		this.guestName = guestName;
		this.room = room;
		this.numberOfNights = numberOfNights;
		this.totalAmount = room.price * numberOfNights;
	}

	public void displayBookingDetails() {
		System.out.println("\nReservation Details:");
		System.out.println("Guest Name: " + guestName);
		System.out.println("Room: " + room.roomType + " (Room " + room.roomNumber + ")");
		System.out.println("Number of Nights: " + numberOfNights);
		System.out.println("Total Amount: $" + totalAmount);
	}
}