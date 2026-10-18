package id.ac.polinema.uts.hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Polinema Hotel");
        Hotel hotel = new Hotel("Polinema Hotel");

        try {
            StandardRoom std = new StandardRoom("101", "Garden Room", 2015);
            std.setFacility(new Facility("Swimming Pool", "Floor 1"));
            hotel.addRoom(std);

            DeluxeRoom deluxe = new DeluxeRoom("Skyline Deluxe", 2018, "City");
            hotel.addRoom(deluxe);

            SuiteRoom suite = new SuiteRoom("Royal Suite", 2021, 3);
            hotel.addRoom(suite);

            Guest guest = new Guest("G001", "Rina");
            hotel.addGuest(guest);

        } catch (Exception e) {
            
        }


        HotelApp app = new HotelApp(hotel, new Scanner(System.in), System.out);
        app.run();
    }
}
