import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import utils.Sorter;

import java.io.*;

public class Hotel {

    private ArrayList<HotelGuest> allGuests;

    public Hotel() {
        allGuests = new ArrayList<HotelGuest>(); // Initialize new arrayList
        try {
            File hotelData = new File(
                    "C:\\Users\\306972\\Desktop\\AP CSA\\HotelManagementDataBaseProject\\HotelData.csv"); // Get File
            BufferedReader in = new BufferedReader(new FileReader(hotelData)); // Like Scanner. Easier to use while File
                                                                               // reading
            String line;

            while ((line = in.readLine()) != null) { // While current line is not equal to null
                /*
                 * Create an array of strings with each element being seperated by commas. Get
                 * the first element from that array
                 */
                String name = line.split(",")[0];
                allGuests.add(new HotelGuest(name)); // Add Hotel Guest with name into arrayList of guests.
            }

            in.close(); // Ends connection from File Reader to File
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void collect() {
        // System.out.println(Arrays.toString(getCommand()));
        System.out.print(
                "Hello! Welcome to Hotel Scootiness! You must be an employee. Please enter in your command using this format:\n"
                        +
                        "\n\tCOMMAND, \n\t(SEARCH - TITLE OF THING) OR \n\t(SORT - ATRRIBUTE) OR \n\t(LIST_BETTER - OBJECT) OR \n\t(COMPARE - COMPARE) OR \n\t(QUIT)\n\n");
        while (true) { // Forever while loop
            String[] command = getCommand();

            if (command[0].equalsIgnoreCase("quit") || command[0].toLowerCase().substring(0, 1).equals("q")) {
                System.out.println("Bye-Bye!\nDon't Die");
                break;
            } else if (command[0].equals("search")) {
                if (command[2] == null || command[1] == null) {
                    System.out.println("Please put in the correct arguments");
                    continue;
                }
                search(command[1], command[2]);
            } else if (command[0].equalsIgnoreCase("compare")) {
                if (command[2] == null || command[1] == null) {
                    System.out.println("Please enter the person you want to compare to.");
                    continue;
                } else if (getGuest(command[1]) == null || getGuest(command[2]) == null) {
                    System.out.println((getGuest(command[1]) == null) ? command[1] + " was not found."
                            : command[2] + " was not found.");
                    continue;
                }
                compareGuest(command[1], command[2]);
            } else if (command[0].equalsIgnoreCase("better-than")) {
                betterThan(command[1]);
            } else if (command[0].equalsIgnoreCase("sort")) {
                sortByAttribute(command[1]);
            } else {
                System.out.println("That isn't a valid command!");
            }
        }
    }

    private void search(String type, String thing) {
        switch (type.toLowerCase()) {
            case "name":
            case "names":
                System.out.println(getGuest(thing));
                break;
            case "room":
            case "rooms":
                for (HotelGuest hG : allGuests) {
                    if (hG.getRoom().toLowerCase().equals(thing.toLowerCase())) {
                        System.out.println(hG);
                    }
                }

                break;
            default:
                System.out.println("Invalid Search Query");
        }
    }

    private void compareGuest(String nameOne, String nameTwo) {
        HotelGuest guestOne = this.getGuest(nameOne);
        HotelGuest guestTwo = this.getGuest(nameTwo);

        System.out.println(guestOne.getGuestName() + " :: " + guestOne.getRoom() + " :: " + guestOne.getRoomType());
        System.out.println(guestTwo.getGuestName() + " :: " + guestTwo.getRoom() + " :: " + guestTwo.getRoomType());

        String duration = (guestOne.getDuration() > guestTwo.getDuration())
                ? guestOne.getGuestName() + " is Staying Longer"
                : guestTwo.getGuestName() + " is Staying Longer";
        if (guestOne.getDuration() == guestTwo.getDuration())
            duration = "Duration is the same";

        String totalCost = (guestOne.getTotalCost() > guestTwo.getTotalCost())
                ? guestOne.getGuestName() + " is paying more."
                : guestTwo.getGuestName() + " is paying more";
        if (guestOne.getTotalCost() == guestTwo.getTotalCost())
            totalCost = "Total Cost is the same";

        System.out.println("\n" + duration);
        System.out.println(totalCost);

    }

    private void betterThan(String atr) {

    }

    private void sortByAttribute(String atr) {
        switch (atr.toLowerCase()) {
            case "name":
            case "names":
                ArrayList<String> names = new ArrayList<String>();
                for (int i = 0; i < allGuests.size(); i++) {
                    names.add(allGuests.get(i).getGuestName());
                }
                Collections.sort(names);

                System.out.println(names);
                break;
            case "duration":
            case "durations":
                ArrayList<Integer> durations = new ArrayList<Integer>();
                for (int i = 0; i < allGuests.size(); i++) {
                    durations.add(allGuests.get(i).getDuration());
                }
                durations = Sorter.sortS(durations);
                System.out.println("Shortest: " + durations.get(0) + "\nLongest: " + durations.get(durations.size() - 1)
                        + "\n\n" + durations);
                break;
            case "expense":
            case "cost":
                ArrayList<Integer> costs = new ArrayList<Integer>();
                for (int i = 0; i < allGuests.size(); i++) {
                    costs.add(allGuests.get(i).getTotalCost());
                }
                costs = Sorter.sortS(costs);
                System.out.println("Cheapest: " + costs.get(0) + "\nMost Expensive: " + costs.get(costs.size() - 1)
                        + "\n\n" + costs);
                break;
            default:
                System.out.println("Invalid Attribute");
        }
    }

    private String[] getCommand() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Command >> ");
        String commandStr = sc.nextLine();
        String[] command = (commandStr.contains(", ")) ? commandStr.split(", ") : commandStr.split(",");

        String[] commandToReturn = new String[3];
        for (int i = 0; i < command.length; i++) {
            commandToReturn[i] = command[i];
        }
        // System.out.println(Arrays.toString(command));

        return commandToReturn;
    }

    /**
     * Gets all the guests currently living in the Hotel.
     * 
     * @return ArrayList with all the HotelGuest Objects that have een created
     */
    public ArrayList<HotelGuest> getGuests() {
        return allGuests;
    }

    /**
     * Gets a specific guest from the hotel catalog
     * 
     * @param name The Name of the Guest you want to find
     * @return The HotelGuest Object when it matches
     */
    public HotelGuest getGuest(String name) {
        for (HotelGuest hG : allGuests) {
            if (hG.getGuestName().toLowerCase().equals(name.toLowerCase())) {
                return hG;
            }
        }

        return null;
    }
}
