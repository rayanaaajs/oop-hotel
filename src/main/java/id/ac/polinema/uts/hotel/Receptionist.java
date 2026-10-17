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

    public boolean checkOut(Guest guest, StandardRoom room){
        if (guest.getBookingCount() > 0 && !room.isAvailable()) {
            room.release();
            guest.removeBooking();
            return true;
        }
        return false;
    }
}
