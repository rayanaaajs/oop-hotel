package id.ac.polinema.uts.hotel;

import java.io.PrintStream;
import java.util.Scanner;

public class HotelApp {
    private Hotel hotel;
    private Scanner in;
    private PrintStream out;

    public HotelApp(Hotel hotel, Scanner in, PrintStream out){
        this.hotel = hotel;
        this.in = in;
        this.out = out;
    }

    public void run(){
        while (true) {
            printMenu();
            if (!in.hasNextLine()) {
                return;
            }
            String choice = in.nextLine().trim();
            switch (choice) {
                case "1":
                    showRooms();
                    break;
                case "2":
                    addStandardRoom();
                    break;
                case "3":
                    addDeluxeRoom();
                    break;
                case "4":
                    addSuiteRoom();
                    break;
                case "5":
                    registerGuest();
                    break;
                case "6":
                    checkIn();
                    break;
                case "7":
                    checkOut();
                    break;
                case "8":
                    searchRooms();
                    break;
                case "9":
                    showGuests();
                    break;
                case "0":
                    out.println("Thank you, goodbye");
                    return;               
                default:
                    out.println("Unknown option");
            }
        }
    }

    private void printMenu(){
        out.println("=== " + hotel.getName() + " ===");
        out.println("1. List rooms");
        out.println("2. Add standard room");
        out.println("3. Add deluxe room");
        out.println("4. Add suite");
        out.println("5. Register guest");
        out.println("6. Check in");
        out.println("7. Check out");
        out.println("8. Search rooms");
        out.println("9. List guests");
        out.println("0. Exit");
        out.print("Choose: ");
    }

    private String readLine(String prompt) {
        out.print(prompt);
        return in.hasNextLine() ? in.nextLine().trim() : "";
    }

    private int readInt(String prompt) {
        String text = readLine(prompt);
        if (text.isEmpty() || text.length() > 9) {
            return -1;
        }
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return -1;
            }
        }
        int value = Integer.parseInt(text);
        return value > 0 ? value : -1;
    }

    private void printRoomLine(HotelRoom room) {
        String status = room.isAvailable() ? "Available" : "Occupied";
        out.println(room.describe() + " | " + status + " | " + room.getTotalPrice() + "/night");
    }

    private void showRooms(){
        HotelRoom[] rooms = hotel.getRooms();
        if (rooms.length == 0) {
            out.println("No rooms");
        }
        for (HotelRoom hotelRoom : rooms) {
            printRoomLine(hotelRoom);
        }
    }

    private void addStandardRoom(){
        String roomNo = readLine("Room no: ");
        String name = readLine("Name: ");
        int yearBuilt = readInt("Year built: ");
        if (yearBuilt == -1) {
            out.println("Not a valid number");
            return;
        }
        try {
            StandardRoom room = new StandardRoom(roomNo, name, yearBuilt);
            String facilityName = readLine("Facility name (blank for none): ");
            if (!facilityName.isEmpty()){
                String facilityFloor = readLine("Facility floor: ");
                Facility facility = new Facility(facilityName, facilityFloor);
                room.setFacility(facility);
            }

            boolean added = hotel.addRoom(room);
            if (added) {
                out.println("Room added");
            } else {
                out.println("Hotel is full");
            }
            
        } catch (IllegalArgumentException e) {
            out.println("Rejected: " + e.getMessage());
        }
    }

    private void addDeluxeRoom() {
        String name = readLine("Name: ");
        int yearBuilt = readInt("Year built: ");
        if (yearBuilt == -1) {
            out.println("Not a valid number");
            return;
        }
        String viewType = readLine("View type: ");

        try {
            DeluxeRoom room = new DeluxeRoom(name, yearBuilt, viewType);
            boolean added = hotel.addRoom(room);
            if (added) {
                out.println("Room added");
            } else {
                out.println("Hotel is full");
            }
        } catch (IllegalArgumentException e) {
            out.println("Rejected: " + e.getMessage());
        }
    }

    private void addSuiteRoom() {
        String name = readLine("Name: ");
        int yearBuilt = readInt("Year built: ");
        int bedCount = readInt("Bed count: ");
        if (yearBuilt == -1 || bedCount == -1) {
            out.println("Not a valid number");
            return;
        }

        try {
            SuiteRoom room = new SuiteRoom(name, yearBuilt, bedCount);
            boolean added = hotel.addRoom(room);
            if (added) {
                out.println("Room added");
            } else {
                out.println("Hotel is full");
            }
        } catch (IllegalArgumentException e) {
            out.println("Rejected: " + e.getMessage());
        }
    }

    private void registerGuest(){
        String guestId = readLine("Guest ID: ");
        String name = readLine("Name: ");

        try {
            Guest guest = new Guest(guestId, name);
            boolean added = hotel.addGuest(guest);
            if (added) {
                out.println("Guest registered");
            } else {
                out.println("Guest ID already exists");
            }
        } catch (IllegalArgumentException e) {
            out.println("Rejected: " + e.getMessage());
        }
    }

    private void checkIn(){
        String guestId = readLine("Guest ID: ");
        String roomName = readLine("Room name: ");

        boolean success = hotel.checkIn(guestId, roomName);
        if (success) {
            out.println("Check-in successful");
        } else {
            out.println("Check-in failed");
        }
    }

    private void checkOut(){
        String guestId = readLine("Guest ID: ");
        String roomName = readLine("Room name: ");

        boolean success = hotel.checkOut(guestId, roomName);
        if (success) {
            out.println("Check-out successfull");
        } else {
            out.println("Check-out failed");
        }
    }

    private void searchRooms(){
        String keyword = readLine("Keyword: ");
        HotelRoom[] results = hotel.searchByKeyword(keyword);

        if (results.length == 0) {
            out.println("No rooms found");
        }

        for (HotelRoom hotelRoom : results) {
            printRoomLine(hotelRoom);
        }
    }

    private void showGuests(){
        Guest[] guests = hotel.getGuests();

        if (guests.length == 0) {
            out.println("No guests");
        }

        for (Guest guest : guests) {
            out.println(guest.getGuestId() + " - " + guest.getName() + " (" + guest.getBookingCount() + " bookings)");
        }

    }




}
