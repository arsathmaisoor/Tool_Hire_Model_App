package src;

import java.util.Scanner;
import java.io.PrintWriter;

public class Customer {
    private String customerID;
    private String surname;
    private String firstName;
    private String otherInitials;
    private String title;
    
    public Customer(String surname, String firstName, String otherInitials, String title) {
        this.customerID = "unknown";
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
    }
    
    public Customer() {
        this.customerID = "unknown";
        this.surname = "";
        this.firstName = "";
        this.otherInitials = "";
        this.title = "";
    }
    
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOtherInitials() {
        return otherInitials;
    }

    public void setOtherInitials(String otherInitials) {
        this.otherInitials = otherInitials;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void printDetails() {
        System.out.println("Customer ID: " + this.customerID);
        System.out.println("Title: " + this.title);
        System.out.println("First name: " + this.firstName);
        System.out.println("Other initials: " + this.otherInitials);
        System.out.println("Surname: " + this.surname);
    }
    
    public void readData(Scanner scanner) {
        System.out.println("Enter customer title: ");
        this.title = scanner.nextLine();
        
        System.out.println("Enter customer first name: ");
        this.firstName = scanner.nextLine();
        
        System.out.println("Enter customer other initials: ");
        this.otherInitials = scanner.nextLine();
        
        System.out.println("Enter customer surname: ");
        this.surname = scanner.nextLine();
    }

    public void writeData(PrintWriter writer) {
        writer.println(customerID + ", " + surname + ", " + firstName + ", " + otherInitials + ", " + title);
    }
}
