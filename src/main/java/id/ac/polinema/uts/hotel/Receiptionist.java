package id.ac.polinema.uts.hotel;

public class Receiptionist {
    public boolean checkIn(StandardRoom room, Guest guest){
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
