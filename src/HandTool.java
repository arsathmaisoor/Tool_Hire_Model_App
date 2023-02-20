package src;

import java.util.*;

public class HandTool extends Tool {
    private boolean sharpenable;

    public HandTool(String toolName, String toolCode, int timesBorrowed, boolean onLoan, int cost, int weight,
            boolean sharpenable) {
        super(toolName, toolCode, cost, timesBorrowed, onLoan, weight);
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

    @Override
    public String toString() {
        return toolName + ", " + toolCode + ", " + cost + ", " + timesBorrowed + ", " + onLoan + ", " + weight + ", "
                + sharpenable;
    }
}
