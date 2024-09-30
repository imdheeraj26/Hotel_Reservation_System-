package hotelManagement;

class Room {
	String roomType;
	int roomNumber;
	double price;
	boolean isAvailable;

	public Room(String roomType, int roomNumber, double price) {
		this.roomType = roomType;
		this.roomNumber = roomNumber;
		this.price = price;
		this.isAvailable = true;
	}

	public void bookRoom() {
		if (isAvailable) {
			isAvailable = false;
			System.out.println("Room " + roomNumber + " (" + roomType + ") has been reserved.");
		} else {
			System.out.println("Room is already booked.");
		}
	}

	public void displayDetails() {
		System.out.println("Room " + roomNumber + ": " + roomType + " - $" + price + " per night");
		System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
	}
}

