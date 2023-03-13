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
}
