package id.ac.polinema.uts.hotel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Polinema Hotel");
        Hotel hotel = new Hotel("Polinema Hotel");
        HotelApp app = new HotelApp(hotel, new Scanner(System.in), System.out);
        app.run();
    }
}
