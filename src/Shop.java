package src;

//import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import java.util.Date;
import src.DataWriter;
import java.util.*;




public class Shop {
    ArrayList<Tool> toolList = new ArrayList<Tool>();
    ArrayList<Accessories> accessoriesList = new ArrayList<Accessories>();
    ArrayList<Customer> customerList = new ArrayList<Customer>();

    
    HashMap<String, Tool> toolMap;
    HashMap<String, Accessories> accessoriesMap;


    HashMap<String, ShopItem> itemMap;
    HashMap<String, Customer> customerMap;
    HashMap<String, ShopItemReservation> itemReservationMap;
    



    private Random randomGenerator = new Random();



    public Shop() {
        toolList = new ArrayList<Tool>();
        accessoriesList = new ArrayList<Accessories>();
        customerList = new ArrayList<Customer>();
        accessoriesMap = new HashMap<>();
        toolMap = new HashMap<>();

        customerMap = new HashMap<>();
        itemMap = new HashMap<>();
        itemReservationMap = new HashMap<>();
        
    }

    public void storeTool(Tool tool) {
        toolList.add(tool);
        toolMap.put(tool.getItemCode(), tool);
        itemMap.put(tool.getItemCode(), tool);
    }

    public void storeAccessory(Accessories accessories) {
        accessoriesList.add(accessories);
        accessoriesMap.put(accessories.getItemCode(), accessories);
        itemMap.put(accessories.getItemCode(), accessories);
    }

    public void storeItem(ShopItem item) {
        itemMap.put(item.getItemCode(), item);
    }
    
    public void storeCustomer(Customer customer) {
        if (customer.getCustomerID().equals("unknown")) {
            String newID = generateCustomerID("AB-", 6);
            customer.setCustomerID(newID);
        }
        customerList.add(customer);
        customerMap.put(customer.getCustomerID(), customer);
    }

    public void printAllItems() {
        for (Tool tool : toolList) {
            System.out.println(tool);
        }
        //
        for (Accessories accessories:accessoriesList) {
            System.out.println(accessories);
        }
        //
    }

    public void readItemData() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            try {
                Scanner fileScanner = new Scanner(selectedFile);
                String typeOfData = null;
                while (fileScanner.hasNextLine()) {
                    String lineOfText = fileScanner.nextLine().trim();
                    if (!lineOfText.startsWith("//") && !lineOfText.isEmpty()) {
                        if (lineOfText.startsWith("[")) {
                            // Found a flag denoting a type of data
                            typeOfData = lineOfText;
                        } else {
                            if (typeOfData != null) {
                                // Found data for the current type of data
                                if (typeOfData.equals("[ElectricTool data]") || typeOfData.equals("[electricTool data]")) {
                                    Scanner lineScanner = new Scanner(lineOfText).useDelimiter("\\s*,\\s*");
                                    String toolName = lineScanner.next();
                                    String toolCode = lineScanner.next();
                                    int cost = lineScanner.nextInt();
                                    int timesBorrowed = lineScanner.nextInt();
                                    boolean onLoan = lineScanner.nextBoolean();
                                    int weight = lineScanner.nextInt();
                                    boolean rechargeable = lineScanner.nextBoolean();
                                    String power = lineScanner.next();
                                    ElectricTool tool = new ElectricTool(toolName, toolCode,cost, timesBorrowed, onLoan,
                                             weight, rechargeable, power);
                                    storeTool(tool);
                                    lineScanner.close();
                                } 
                                if (typeOfData.equals("[HandTool data]")) {
                                    Scanner lineScanner = new Scanner(lineOfText).useDelimiter("\\s*,\\s*");
                                    String toolName = lineScanner.next();
                                    String toolCode = lineScanner.next();
                                    int cost = lineScanner.nextInt();
                                    int timesBorrowed = lineScanner.nextInt();
                                    boolean onLoan = lineScanner.nextBoolean();
                                    int weight = lineScanner.nextInt();
                                    boolean sharpenable = lineScanner.nextBoolean();
                                    
                                    HandTool tool = new HandTool(toolName, toolCode, timesBorrowed, onLoan,
                                            cost, weight, sharpenable);
                                    storeTool(tool);
                                    lineScanner.close();
                                }
                                if (typeOfData.equals("[Perishable data]")) {
                                    Scanner lineScanner = new Scanner(lineOfText).useDelimiter("\\s*,\\s*");
                                    Boolean isRecyclable = lineScanner.nextBoolean();
                                    String toolName = lineScanner.next();
                                    String toolCode = lineScanner.next();
                                    int cost = lineScanner.nextInt();
                                    boolean isIrritant = lineScanner.nextBoolean();
                                    String useByDate = lineScanner.next();
                                    int volume = lineScanner.nextInt();
                                    
                                    Perishable tool = new Perishable(isRecyclable,toolName, toolCode, cost, isIrritant, useByDate,volume);
                                    storeAccessory(tool);
                                    lineScanner.close();
                                }
                                if (typeOfData.equals("[Workwear data]")) {
                                    Scanner lineScanner = new Scanner(lineOfText).useDelimiter("\\s*,\\s*");
                                    Boolean isRecyclable = lineScanner.nextBoolean();
                                    String toolName = lineScanner.next();
                                    String toolCode = lineScanner.next();
                                    int cost = lineScanner.nextInt();
                                    String manufacturingStandard = lineScanner.next();
                                    String color = lineScanner.next();
                                    char size = lineScanner.next().charAt(0);
                                    
                                    Workwear tool = new Workwear(isRecyclable,toolName, toolCode, cost, manufacturingStandard, color,size);
                                    storeAccessory(tool);
                                    lineScanner.close();
                                }

                            } else {
                                System.out.println("Ignoring data outside of a type block");
                            }
                        }
                    }
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + selectedFile.getAbsolutePath());

            }
        }
    }

    public void readCustomerData() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            try {
                Scanner fileScanner = new Scanner(selectedFile);
                //String typeOfData = null;
                while (fileScanner.hasNextLine()) {
                    String lineOfText = fileScanner.nextLine().trim();
                    if (!lineOfText.startsWith("//") && !lineOfText.isEmpty()) 
                        {
                            
                                    Scanner lineScanner = new Scanner(lineOfText).useDelimiter("\\s*,\\s*");
                                    String customerID = lineScanner.next();
                                    String surname = lineScanner.next();
                                    String firstName = lineScanner.next();
                                    String otherInitials = lineScanner.next();
                                    String title = lineScanner.next();                                    
                                    Customer customer = new Customer(surname, firstName, otherInitials, title);
                                    storeCustomer(customer);
                                    lineScanner.close();
                                 
                                 
                            }
                            else {
                                System.out.println("");
                        }
                    }
                    
                
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + selectedFile.getAbsolutePath());

            }
        }
    }

    

    public void printAllCustomers() {
        for (Customer customer : customerList) {
            customer.printDetails();
        }
    }

    public void writeCustomerData(String filename) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(filename));

        for (Customer customer : customerList) {
            customer.writeData(writer);
        }

        writer.close();
    }

        
    public String generateCustomerID(String prefix, int numDigits) {
        String id = prefix;
        int maxNumber = (int) Math.pow(10, numDigits) - 1;
        int randomNum = randomGenerator.nextInt(maxNumber) + 1;
        id += String.format("%0" + numDigits + "d", randomNum);
        return id;
    }
    
    public ShopItem getTool(String toolCode) {
        
        return toolMap.get(toolCode);
    }

    public ShopItem getAccessory(String accessoryCode) {
        
        return toolMap.get(accessoryCode);
    }

    public ShopItem getItem(String itemCode) {
        return itemMap.get(itemCode);
    }


    public Customer getCustomer(String customerID) {
        return customerMap.get(customerID);
    }

    public Boolean makeItemReservation(String customerID, String itemID, String startDate, int noOfDays) {
        if (!customerMap.containsKey(customerID)) {
            System.out.println("Invalid customer ID");
            return false;
        }
        if (!itemMap.containsKey(itemID)) {
            System.out.println("Invalid item ID");
            return false;
        }
        Date start = DateUtil.convertStringToDate(startDate);
        if (start == null) {
            System.out.println("Invalid start date");
            return false;
        }
        if (noOfDays < 1) {
            System.out.println("Invalid number of days");
            return false;
        }
        String reservationNo = generateReservationNo();
        ShopItemReservation reservation = new ShopItemReservation(reservationNo, itemID, customerID, startDate, noOfDays);
        itemReservationMap.put(reservationNo, reservation);
        return true;
    }
    
    public ShopItemReservation getItemReservation(String reservationNo) {
        return itemReservationMap.get(reservationNo);
    }
    
    public void printItemReservations() {
        System.out.println("Item Reservations:");
        for (ShopItemReservation reservation : itemReservationMap.values()) {
            reservation.displayDetails();
        }
    }
    
    
    
    public void readItemReservationData() {
        List<String> data = FileUtil.readLinesFromFile("itemReservations.txt");
        itemReservationMap.clear();
        for (String line : data) {
            ShopItemReservation reservation = new ShopItemReservation();
            reservation.readData(line);
            itemReservationMap.put(reservation.getReservationNo(), reservation);
        }
    }public void writeItemReservationData() {
        List<String> data = new ArrayList<String>();
        for (ShopItemReservation reservation : itemReservationMap.values()) {
            data.add(reservation.writeData());
        }
        FileUtil.writeLinesToFile("itemReservations.txt", data);
    }
    
    private String generateReservationNo() {
        int lastReservationNo = 0;
        if (!itemReservationMap.isEmpty()) {
            String lastReservationNoStr = Collections.max(itemReservationMap.keySet());
            lastReservationNo = Integer.parseInt(lastReservationNoStr);
        }
        lastReservationNo++;
        return String.format("%06d", lastReservationNo);
    }
}
