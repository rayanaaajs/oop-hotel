package id.ac.polinema.uts.hotel;

/**
 * Bagian 2 dan 3: kamar standard hotel.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README.
 * Method untuk bagian berikutnya (setFacility, getFacility, dan seterusnya) kamu
 * tambahkan sendiri sesuai diagram di bagian tersebut.
 *
 * Kerangka field (lengkapi tipe dan nama dari diagram), letakkan di atas constructor:
 *   public String roomNo;
 *   public ____ name;
 *   public ____ yearBuilt;
 *   public ____ available;
 */
public class StandardRoom extends HotelRoom {
    private String roomNo;
    private Facility facility;

    public StandardRoom(String roomNo, String name, int yearBuilt) {
        super(name, yearBuilt);
        if (roomNo == null || roomNo.trim().isEmpty()) {
            throw new IllegalArgumentException("nomor kamar tidak boleh kosong");
        }
        this.roomNo = roomNo;
    }

    public StandardRoom(String roomNo, String name, int yearBuilt, Facility facility ){
        this(roomNo, name, yearBuilt);
        this.facility = facility;
    }

    public Facility getFacility(){
        return facility;
    }

    public void setFacility(Facility facility){
        this.facility = facility;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public String describe(){
        String facilityName = (facility != null) ? facility.getName() : "None";
        return super.describe() + "facility: " + facilityName ;
    }

}
