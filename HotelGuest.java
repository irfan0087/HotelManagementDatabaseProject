import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class HotelGuest {

    private String guestName;
    private String room;
    private String roomType;
    private int nightlyCost;
    private int duration;
    private int totalCost;

    public HotelGuest(String name) {
        try {
            File hotelData = new File(
                    "C:\\Users\\306972\\Desktop\\AP CSA\\HotelManagementDataBaseProject\\HotelData.csv");
            BufferedReader in = new BufferedReader(new FileReader(hotelData));
            String line;
            while ((line = in.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields[0].equals(name)) {
                    this.guestName = fields[0];
                    this.room = fields[1];
                    this.roomType = fields[2];
                    this.nightlyCost = Integer.parseInt(fields[3]);
                    this.duration = Integer.parseInt(fields[4]);
                    this.totalCost = Integer.parseInt(fields[5]);
                }
            }

            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNightlyCost() {
        return nightlyCost;
    }

    public void setNightlyCost(int nightlyCost) {
        this.nightlyCost = nightlyCost;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
