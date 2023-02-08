package src;

import java.util.*;

public class Shop {
    private ArrayList<Tool> toolList;
    
    public Shop() {
        toolList = new ArrayList<>();
    }
    
    public void storeTool(Tool tool) {
        toolList.add(tool);
    }
    
    public void printAllTools() {
        for (Tool tool : toolList) {
            tool.printDetails();
        }
    }
}
