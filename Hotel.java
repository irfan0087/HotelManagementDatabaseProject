import java.util.ArrayList;
import java.io.*;

public class Hotel {

    private ArrayList<HotelGuest> allGuests;

    public Hotel() {
        allGuests = new ArrayList<HotelGuest>();
        try {
            File hotelData = new File(
                    "C:\\Users\\306972\\Desktop\\AP CSA\\HotelManagementDataBaseProject\\HotelData.csv");
            BufferedReader in = new BufferedReader(new FileReader(hotelData));
            String line;

            while ((line = in.readLine()) != null) {
                String name = line.split(",")[0];
                allGuests.add(new HotelGuest(name));
            }

            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<HotelGuest> getGuests() {
        return allGuests;
    }

    public HotelGuest getGuest(String name) {
        for (HotelGuest hG : allGuests) {
            if (hG.getGuestName().equals(name)) {
                return hG;
            }
        }

        return null;
    }
}
