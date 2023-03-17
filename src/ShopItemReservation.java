package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShopItemReservation {
    private String reservationNo;
    private String itemID;
    private String customerID;
    private Date startDate;
    private int noOfDays;

    public ShopItemReservation(String reservationNo, String itemID, String customerID,
                                String startDate, int noOfDays) {
        this.reservationNo = reservationNo;
        this.itemID = itemID;
        this.customerID = customerID;
        this.noOfDays = noOfDays;

        // Parse the startDate parameter from string to Date
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.startDate = formatter.parse(startDate);
        } catch (ParseException e) {
            System.out.println("Error: Invalid date format. Please use the format dd-MM-yyyy.");
        }
    }

    public ShopItemReservation() {}

    // Getters and setters
    public String getReservationNo() {
        return reservationNo;
    }

    public String getItemID() {
        return itemID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setReservationNo(String reservationNo) {
        this.reservationNo = reservationNo;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public void displayDetails() {
        System.out.println("Reservation details:");
        System.out.println("Customer ID: " + this.customerID);
        System.out.println("Item code: " + this.itemID);
        System.out.println("Reservation date: " + this.startDate);
        System.out.println("Reservation period: " + this.noOfDays);
    }
    
    public static ShopItemReservation readData(String input) {
        // Split the input string into its components
        String[] components = input.split(",");
    
        // Parse the components into the appropriate types
        String reservationNo = components[0];
        String itemID = components[1];
        String customerID = components[2];
        String startDateString = components[3];
        int noOfDays = Integer.parseInt(components[4]);
    
        // Create a new ShopItemReservation object and return it
        return new ShopItemReservation(reservationNo, itemID, customerID, startDateString, noOfDays);
    }

    public String writeData() {
        StringBuilder sb = new StringBuilder();
        sb.append(reservationNo);
        sb.append(",");
        sb.append(itemID);
        sb.append(",");
        sb.append(customerID);
        sb.append(",");
        sb.append(startDate.getTime()); // write the date as milliseconds since epoch
        sb.append(",");
        sb.append(noOfDays);
        return sb.toString();
    }
    
    

    
    
}
