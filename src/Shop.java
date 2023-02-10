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
                while (fileScanner.hasNextLine()) {
                    String lineOfText = fileScanner.nextLine().trim();
                    if (!lineOfText.startsWith("//") && !lineOfText.isEmpty()) {
                        Scanner lineScanner = new Scanner(lineOfText).useDelimiter(",");
                        String toolName = lineScanner.next();
                        String itemCode = lineScanner.next();
                        int timesBorrowed = lineScanner.nextInt();
                        boolean onLoan = lineScanner.nextBoolean();
                        int cost = lineScanner.nextInt();
                        int weight = lineScanner.nextInt();
                        Tool tool = new Tool(toolName, itemCode, timesBorrowed, onLoan, cost, weight);
                        toolList.add(tool);
                        lineScanner.close();
                    }
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + selectedFile.getAbsolutePath());
            }
        }
    }

}

