package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Shop {
    ArrayList<Tool> toolList = new ArrayList<Tool>();

    public void storeTool(Tool tool) {
        toolList.add(tool);
    }

    public void printAllTools() {
        for (Tool tool : toolList) {
            System.out.println(tool);
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
                                if (typeOfData.equals("[ElectricTool data]")) {
                                    Scanner lineScanner = new Scanner(lineOfText).useDelimiter("\\s*,\\s*");
                                    String toolName = lineScanner.next();
                                    String toolCode = lineScanner.next();
                                    int timesBorrowed = lineScanner.nextInt();
                                    boolean onLoan = lineScanner.nextBoolean();
                                    int cost = lineScanner.nextInt();
                                    int weight = lineScanner.nextInt();
                                    boolean rechargeable = lineScanner.nextBoolean();
                                    String power = lineScanner.next();
                                    ElectricTool tool = new ElectricTool(toolName, toolCode, timesBorrowed, onLoan,
                                            cost, weight, rechargeable, power);
                                    storeTool(tool);
                                    lineScanner.close();
                                } 
                                if (typeOfData.equals("[HandTool data]")) {
                                    Scanner lineScanner = new Scanner(lineOfText).useDelimiter("\\s*,\\s*");
                                    String toolName = lineScanner.next();
                                    String toolCode = lineScanner.next();
                                    int timesBorrowed = lineScanner.nextInt();
                                    boolean onLoan = lineScanner.nextBoolean();
                                    int cost = lineScanner.nextInt();
                                    int weight = lineScanner.nextInt();
                                    boolean sharpenable = lineScanner.nextBoolean();
                                    
                                    HandTool tool = new HandTool(toolName, toolCode, timesBorrowed, onLoan,
                                            cost, weight, sharpenable);
                                    storeTool(tool);
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
