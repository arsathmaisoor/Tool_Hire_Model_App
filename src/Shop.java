package src;

import java.io.*;
import java.util.*;
import javafx.stage.*;

public class Shop {
    private ArrayList<Tool> toolList;
    
    public Shop() {
        toolList = new ArrayList<>();
    }
    
    public void storeTool(Tool tool) {
        toolList.add(tool);
    }

    public void readToolData() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select tool data file");
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    String toolName = data[0];
                    String itemCode = data[1];
                    int timesBorrowed = Integer.parseInt(data[2]);
                    boolean onLoan = Boolean.parseBoolean(data[3]);
                    int cost = Integer.parseInt(data[4]);
                    int weight = Integer.parseInt(data[5]);
                    Tool tool = new Tool(toolName, itemCode, timesBorrowed, onLoan, cost, weight);
                    toolList.add(tool);
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
    
    public void printAllTools() {
        for (Tool tool : toolList) {
            tool.printDetails();
        }
    }
}
