package src;

import java.util.*;


public class HandTool extends Tool {
    private boolean sharpenable;
    

    public HandTool(String toolName, String itemCode, int timesBorrowed, boolean onLoan, int cost, int weight, boolean sharpenable) {
        super(toolName, itemCode, timesBorrowed, onLoan, cost, weight);
        this.sharpenable = sharpenable;
    }


    public boolean sharpenable() {
        return sharpenable;
    }

    public void setRechargeable(boolean sharpenable) {
        this.sharpenable = sharpenable;
    }


    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Rechargeable: " + this.sharpenable);
    }

    @Override
    public void readData(Scanner scanner) {
        super.readData(scanner);
        if (scanner.hasNextBoolean()) {
            this.sharpenable = scanner.nextBoolean();
        }
    }
}
