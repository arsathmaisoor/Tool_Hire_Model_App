package src;

import java.util.*;


public class ElectricTool extends Tool {
    private boolean rechargeable;
    private String power;

    public ElectricTool(String toolName, String itemCode, int timesBorrowed, boolean onLoan, int cost, int weight, boolean rechargeable, String power) {
        super(toolName, itemCode, timesBorrowed, onLoan, cost, weight);
        this.rechargeable = rechargeable;
        this.power = power;
    }


    public boolean isRechargeable() {
        return rechargeable;
    }

    public void setRechargeable(boolean rechargeable) {
        this.rechargeable = rechargeable;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Rechargeable: " + this.rechargeable);
        System.out.println("Power: " + this.power);
    }

    @Override
    public void readData(Scanner scanner) {
        super.readData(scanner);
        if (scanner.hasNextBoolean()) {
            this.rechargeable = scanner.nextBoolean();
        }
        if (scanner.hasNextInt()) {
            this.power = scanner.next();
        }
    }
}
