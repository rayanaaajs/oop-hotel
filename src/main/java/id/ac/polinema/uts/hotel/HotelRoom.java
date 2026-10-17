package id.ac.polinema.uts.hotel;

public class HotelRoom {
    protected String name;
    protected int yearBuilt;
    private boolean available;

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
}
