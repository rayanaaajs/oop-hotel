package id.ac.polinema.uts.hotel;

public class Floor {
    private String code;
    private StandardRoom[] rooms = new StandardRoom[5];
    private int count = 0;

    public Floor(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public int getRoomCount(){
        return count;
    }

    public boolean addRoom(StandardRoom room){
        if (room == null || count == rooms.length) {
            return false;
        }
        rooms[count] = room;
        count++;
        return true;
    }

    public StandardRoom findByRoomNo(String roomNo){
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] != null && rooms[i].getRoomNo().equalsIgnoreCase(roomNo)) {
                return rooms[i];
            }
        }
        return null;
    }

    public int countAvailable(){
        int availableCount = 0;
        for (int i = 0; i < count; i++) {
            if (rooms[i].isAvailable()) {
                availableCount++;
            }
        }
        return availableCount;
    }
}
