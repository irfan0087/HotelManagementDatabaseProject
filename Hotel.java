import java.util.ArrayList;
import java.io.*;

public class Hotel {

    private ArrayList<HotelGuest> allGuests;

    public Hotel() {
        allGuests = new ArrayList<HotelGuest>(); // Initialize new arrayList
        try {
            File hotelData = new File(
                    "C:\\Users\\306972\\Desktop\\AP CSA\\HotelManagementDataBaseProject\\HotelData.csv"); // Get File
            BufferedReader in = new BufferedReader(new FileReader(hotelData)); // Like Scanner. Easier to use while File reading
            String line;

            while ((line = in.readLine()) != null) { // While current line is not equal to null
                /* Create an array of strings with each element being seperated by commas. Get the first element from that array */
                String name = line.split(",")[0];
                allGuests.add(new HotelGuest(name)); // Add Hotel Guest with name into arrayList of guests.
            }

            in.close(); // Ends connection from File Reader to File
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Gets all the guests currently living in the Hotel.
     * @return ArrayList with all the HotelGuest Objects that have een created
     */
    public ArrayList<HotelGuest> getGuests() {
        return allGuests;
    }

    /**
     * Gets a specific guest from the hotel catalog
     * @param name The Name of the Guest you want to find
     * @return The HotelGuest Object when it matches
     */
    public HotelGuest getGuest(String name) {
        for (HotelGuest hG : allGuests) {
            if (hG.getGuestName().equals(name)) {
                return hG;
            }
        }

        return null;
    }
}
