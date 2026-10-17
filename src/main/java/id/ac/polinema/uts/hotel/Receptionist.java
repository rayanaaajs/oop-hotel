package id.ac.polinema.uts.hotel;

public class Receptionist {
    public boolean checkIn(Guest guest, StandardRoom room){
        if (guest.canBook() && room.isAvailable()) {
            room.reserve();
            guest.addBooking();
            return true;
        }
        return false;
    }

    public boolean checkOut(StandardRoom room, Guest guest){
        if (!room.isAvailable() && guest.getBookingCount() > 0) {
            room.release();
            guest.removeBooking();
            return true;
        }
        return false;
    }
}
