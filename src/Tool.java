package src;

import java.util.*;

public class Tool extends ShopItem {

    protected int timesBorrowed;
    protected boolean onLoan;
    protected int weight;

    public Tool(String toolName, String toolCode, int cost, int timesBorrowed, boolean onLoan, int weight) {
        super(toolName, toolCode, cost);
        this.timesBorrowed = timesBorrowed;
        this.onLoan = onLoan;
        this.weight = weight;
    }

    // Accessor and Mutator of timesBorrowed
    public int getTimesBorrowed() {
        return timesBorrowed;
    }

    public void setTimesBorrowed(int timesBorrowed) {
        this.timesBorrowed = timesBorrowed;
    }

    // Accessor and Mutator of onLoan
    public boolean getOnLoan() {
        return onLoan;
    }

    public void setOnloan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    // Accessor and Mutator of weight
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // Method that outputs details of the tool to the terminal window
    public void printDetails() {
        System.out.println("Tool name: " + toolName + "; code: " + toolCode + "; timesBorrowed: " + timesBorrowed
                + "; onLoan: " + (onLoan ? "yes" : "no") + "; cost: " + cost + "; weight: " + weight);
    }

    public void readData(Scanner scanner) {
        toolName = scanner.next();
        toolCode = scanner.next();
        timesBorrowed = scanner.nextInt();
        onLoan = scanner.nextBoolean();
        cost = scanner.nextInt();
        weight = scanner.nextInt();
    }

    @Override
    public String toString() {
        return toolName + ", " + toolCode + ", " + cost + ", " + timesBorrowed + ", " + onLoan + ", " + weight;
    }
}
