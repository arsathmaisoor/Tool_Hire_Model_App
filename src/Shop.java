package src;

//import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Shop {
    ArrayList<Tool> toolList = new ArrayList<Tool>();
    ArrayList<Accessories> accessoriesList = new ArrayList<Accessories>();

    public void storeTool(Tool tool) {
        toolList.add(tool);
    }

    public void storeAccessory(Accessories accessories) {
        accessoriesList.add(accessories);
    }

    public void printAllTools() {
        for (Tool tool : toolList) {
            System.out.println(tool);
        }
        //
        for (Accessories accessories:accessoriesList) {
            System.out.println(accessories);
        }
    }

    public void readToolData() {
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

}
