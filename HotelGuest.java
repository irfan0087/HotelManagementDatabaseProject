import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class HotelGuest {

    // [GUEST_NAME, ROOM_NUMBER, ROOM_TYPE, NIGHTLY_COST, DURATION, TOTAL_COST] \\

    private String guestName; // Name of Guest.
    private String room; // Room of Guest
    private String roomType; // Room Type of Guest
    private int nightlyCost; // Nightly Cost of Room Type
    private int duration; // Duration of Stay for the Guest
    private int totalCost; // Total Cost of Stay

    public HotelGuest(String name) {
        try {
            File hotelData = new File(
                    "C:\\Users\\306972\\Desktop\\AP CSA\\HotelManagementDataBaseProject\\HotelData.csv"); // Gets File
            BufferedReader in = new BufferedReader(new FileReader(hotelData)); // Like Scanner. Easier to use while File Reading
            String line;
            while ((line = in.readLine()) != null) { // While current line is not equal to null
                String[] fields = line.split(","); // Seperate the line into a String array. Seperate at the commas.
                if (fields[0].equals(name)) { // If the name matches the name in the constructor, initialize all the variables with those attributes
                    this.guestName = fields[0];
                    this.room = fields[1];
                    this.roomType = fields[2];
                    this.nightlyCost = Integer.parseInt(fields[3]);
                    this.duration = Integer.parseInt(fields[4]);
                    this.totalCost = Integer.parseInt(fields[5]);
                    break; // When Guest is found, break out of loop. (For efficiency)
                }
            }

            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Gets the name of the Guest
     * @return The Guest name stored in the database
     */
    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    /**
     * Gets the room number of the Guest
     * @return Room Number from Database
     */
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * Gets the room type of the Guest
     * @return Room Type from the database
     */
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * Gets the nightly cost of the room
     * @return The Nightly Cost from the Database
     */
    public int getNightlyCost() {
        return nightlyCost;
    }

    public void setNightlyCost(int nightlyCost) {
        this.nightlyCost = nightlyCost;
    }

    /**
     * Gets the stay time/duration of the Guest
     * @return The Duration from the database
     */
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets the total cost of the Guest's stay
     * @return The calculated total cost from the database
     */
    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public String toString() {
        return "Name: " + this.guestName + "\nRoom: " + this.room + "\nRoom Type: " + this.roomType + "\nNightly Cost: " + this.nightlyCost + "\nDuration: " + this.duration + "\n\nTotal Cost: " + this.totalCost;
    }
}
