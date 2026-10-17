package id.ac.polinema.uts.hotel;

/**
 * Bagian 3: tamu hotel.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README
 * (semua field harus private).
 *
 * Kerangka field (lengkapi dari diagram), letakkan di atas constructor:
 *   private ____ guestId;
 *   private ____ name;
 *   private int bookingCount;   // nilai awal 0
 */
public class Guest {
    private String guestId;
    private String name;
    private int bookingCount = 0;

    /**
     * Membuat tamu yang belum punya pemesanan.
     * guestId dan name tidak boleh null atau kosong: lempar
     * IllegalArgumentException jika tidak valid.
     */
    public Guest(String guestId, String name) {
        // TODO Bantuan: validasi dulu sebelum mengisi field. Aturan nama sama dengan setName.
        // Bagian 4: kartu tamu juga dibuat di sini (lihat diagram Bagian 4).
        //
        // Kerangka:
        //   if (guestId == null || ____) {
        //       throw new IllegalArgumentException("____");
        //   }
        //   this.guestId = guestId;
        //   setName(____);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getGuestId() {
        // TODO Bantuan: kembalikan data yang disimpan constructor.
        return guestId;
    }

    public String getName() {
        // TODO Bantuan: sama seperti getGuestId.
        return name;
    }

    /** Nama tidak boleh null atau kosong: lempar IllegalArgumentException dan biarkan nama lama. */
    public void setName(String name) {
        // TODO Bantuan: periksa dulu, baru isi field.
        //
        // Kerangka:
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("nama tidak boleh kosong");
        }
        this.name = name;
    }

    public int getBookingCount() {
        // TODO Bantuan: kembalikan jumlah pemesanan saat ini.
        return bookingCount;
    }

    /** True jika tamu masih boleh memesan (batasnya 2 pemesanan). */
    public boolean canBook() {
        // TODO Bantuan: apakah perlu field baru, atau cukup dihitung dari data yang sudah ada?
        //
        // Kerangka:
        return bookingCount < 2;
    }

    /** Menambah jumlah pemesanan. Jika sudah di batas, tidak berubah dan hasilnya false. */
    public boolean addBooking() {
        // TODO Bantuan: periksa batas dulu. Adakah method lain di kelas ini yang sudah
        // menjawab pertanyaan "boleh atau tidak"?
        //
        // Kerangka:
        if (!canBook()) {
            return false;
        }
        bookingCount++;
        return true;
    }

    /** Mengurangi jumlah pemesanan. Jika sudah tidak ada pemesanan, tidak berubah dan hasilnya false. */
    public boolean removeBooking() {
        // TODO Bantuan: batas bawah jumlah pemesanan adalah berapa?
        //
        // Kerangka:
        if (bookingCount == 0) {
            return false;
        }
        bookingCount--;
        return true;
    }
}
