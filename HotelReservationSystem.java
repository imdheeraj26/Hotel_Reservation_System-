package hotelManagement;
import java.util.*;


public class HotelReservationSystem {
	private static List<Room> rooms = new ArrayList<>();
	private static List<Reservation> reservations = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		rooms.add(new Room("Single", 101, 100.0));
		rooms.add(new Room("Double", 102, 150.0));
		rooms.add(new Room("Suite", 103, 300.0));

		boolean exit = false;

		while (!exit) {
			System.out.println("\nHotel Reservation System:");
			System.out.println("1. Search Available Rooms");
			System.out.println("2. Make a Reservation");
			System.out.println("3. View Reservations");
			System.out.println("4. Cancel a Reservation");
			System.out.println("5. Exit");

			System.out.print("Choose an option (1-4): ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				searchAvailableRooms();
				break;
			case 2:
				makeReservation(scanner);
				break;
			case 3:
				viewReservations();
				break;
			case 4:
				cancelReservation(scanner);
				break;
			case 5:
				exit = true;
				System.out.println("Exiting system...");
				break;
			default:
				System.out.println("Invalid option, please choose a valid option.");
			}
		}

		scanner.close();
	}

	// Method to search for available rooms
	public static void searchAvailableRooms() {
		System.out.println("\nAvailable Rooms:");
		for (Room room : rooms) {
			if (room.isAvailable) {
				room.displayDetails();
			}
		}
	}

	public static void makeReservation(Scanner scanner) {
		System.out.print("Enter your name: ");
		scanner.nextLine(); 
		String guestName = scanner.nextLine();

		System.out.print("Enter room number to reserve: ");
		int roomNumber = scanner.nextInt();

		Room selectedRoom = null;
		for (Room room : rooms) {
			if (room.roomNumber == roomNumber && room.isAvailable) {
				selectedRoom = room;
				break;
			}
		}

		if (selectedRoom != null) {
			System.out.print("Enter number of nights: ");
			int nights = scanner.nextInt();

			Reservation reservation = new Reservation(guestName, selectedRoom, nights);
			reservations.add(reservation);

			selectedRoom.bookRoom();

			reservation.displayBookingDetails();

			System.out.println("Processing payment...");
			System.out.println("Payment successful! Thank you for your reservation.");
		} else {
			System.out.println("Room is either not available or does not exist.");
		}
	}
	public static void cancelReservation(Scanner scanner) {
		System.out.print("Enter your name: ");
		scanner.nextLine();
		String guestName = scanner.nextLine();

		Reservation reservationToCancel = null;
		for (Reservation reservation : reservations) {
			if (reservation.guestName.equalsIgnoreCase(guestName)) {
				reservationToCancel = reservation;
				break;
			}
		}

		if (reservationToCancel != null) {
			reservations.remove(reservationToCancel);
			reservationToCancel.room.isAvailable = true;
			System.out.println("Reservation for " + guestName + " has been cancelled.");
		} else {
			System.out.println("No reservation found for " + guestName + ".");
		}
	}

	public static void viewReservations() {
		if (reservations.isEmpty()) {
			System.out.println("\nNo reservations found.");
		} else {
			for (Reservation reservation : reservations) {
				reservation.displayBookingDetails();
			}
		}
	}
}
