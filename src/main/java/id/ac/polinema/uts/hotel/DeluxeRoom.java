package id.ac.polinema.uts.hotel;

public class DeluxeRoom extends HotelRoom {
    private String viewType;

    public DeluxeRoom(String name, int yearBuilt, String viewType){
        super(name, yearBuilt);
        if (viewType == null || viewType.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipe view tidak boleh kosong");
        }
        this.viewType = viewType;
    }

    public String getViewType(){
        return viewType;
    }
}
