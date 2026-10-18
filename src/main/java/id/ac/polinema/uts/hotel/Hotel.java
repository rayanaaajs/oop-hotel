package id.ac.polinema.uts.hotel;

import java.util.Arrays;

public class Hotel {
    private String name;
    private HotelRoom[] rooms = new HotelRoom[20];
    private int roomCount = 0;
    private Guest[] guests = new Guest[10];
    private int guestCount = 0;

    public Hotel(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean addRoom(HotelRoom room){
        if (room == null || roomCount == rooms.length) {
            return false;
        }
        rooms[roomCount] = room;
        roomCount++;
        return true;
    }

    public boolean addGuest(Guest guest){
        if (guest == null || guestCount == guests.length) {
            return false;
        }

        for (int i = 0; i < guestCount; i++) {
        if (guests[i].getGuestId().equalsIgnoreCase(guest.getGuestId())) {
            return false;
            }
        }
        guests[guestCount] = guest;
        guestCount++;
        return true;
    }

    public HotelRoom[] getRooms(){
        return Arrays.copyOf(rooms, roomCount);
    }

    public Guest[] getGuests(){
        return Arrays.copyOf(guests, guestCount);
    }

    public HotelRoom findRoomByName(String name){
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].getName().equalsIgnoreCase(name)) {
                return rooms[i];
            }
        }
        return null;
    }

    public Guest findGuest(String guestId){
        for (int i = 0; i < guestCount; i++) {
            if (guests[i].getGuestId().equalsIgnoreCase(guestId)) {
                return guests[i];
            }
        }
        return null;
    }

    public HotelRoom[] searchByKeyword(String keyword){
        HotelRoom[] temp = new HotelRoom[roomCount];
        int found = 0;
        String lowerKeyword = keyword.toLowerCase();
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].getName().toLowerCase().contains(lowerKeyword)) {
                temp[found] = rooms[i];
                found++;
            }
        }
        return Arrays.copyOf(temp, found);
    }

    public boolean checkIn(String roomName, String guestId){
        Guest guest = findGuest(guestId);
        HotelRoom room = findRoomByName(roomName);

        if (guest == null || room == null) {
            return false;
        }

        if (guest.canBook() && room.isAvailable()) {
            room.reserve();
            guest.addBooking();
            return true;
        }
        return false;
    }

    public boolean checkOut(String roomName, String guestId){
        Guest guest = findGuest(guestId);
        HotelRoom room = findRoomByName(roomName);

        if (guest == null || room == null) {
            return false;
        }

        if (!room.isAvailable() && guest.getBookingCount() > 0) {
            room.release();
            guest.removeBooking();
            return true;
        }
        return false;  
    }
}
