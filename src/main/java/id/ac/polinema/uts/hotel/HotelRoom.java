package id.ac.polinema.uts.hotel;

public class HotelRoom {
    protected String name;
    protected int yearBuilt;
    private boolean available;
    private int extraNights;

    public HotelRoom(String name, int yearBuilt){
        setName(name);
        setYearBuilt(yearBuilt);
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean reserve() {
        if (!available) {
            return false;
        }
        available = false;
        return true;
    }

    public void release() {
        available = true;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("nama tidak boleh kosong");
        }
        this.name = name;
    }

    public void setYearBuilt(int yearBuilt) {
        if (yearBuilt < 1950) {
            throw new IllegalArgumentException("tahun tidak boleh dibawah 1950");
        }
        this.yearBuilt = yearBuilt;
    }
    
    public int pricePerNight(){
        return 400000;
    }

    public String describe(){
        return name + " (built " + yearBuilt + ")";
    }

    @Override 
    public String toString(){
        return describe();
    }
    
    public void extendStay(){
        extendStay(2);
    }

    public void extendStay(int nights){
        if (nights <= 0) {
            throw new IllegalArgumentException("perpanjang malam harus lebih dari 0");
        }
        extraNights += nights;
    }

    public int getTotalNights(){
        return 1 + extraNights;
    }

    public int getTotalPrice(){
        return pricePerNight()*getTotalNights();
    }
}
