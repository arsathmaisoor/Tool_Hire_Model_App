package src;

import java.util.*;

public class Tool{
    protected String toolName;
    protected String itemCode;
    protected int timesBorrowed;
    protected boolean onLoan;
    protected int cost;
    protected int weight;

    public Tool(String toolName, String itemCode, int timesBorrowed, boolean onLoan, int cost, int weight) {
        this.toolName = toolName;
        this.itemCode = itemCode;
        this.timesBorrowed = timesBorrowed;
        this.onLoan = onLoan;
        this.cost = cost;
        this.weight = weight;
    }


    //Accessor and Mutator of toolName
    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    //Accessor and Mutator of itemCode
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    //Accessor and Mutator of timesBorrowed
    public int getTimesBorrowed() {
        return timesBorrowed;
    }

    public void setTimesBorrowed(int timesBorrowed) {
        this.timesBorrowed = timesBorrowed;
    }

    //Accessor and Mutator of onLoan
    public boolean getOnLoan() {
        return onLoan;
    }    

    public void setOnloan(boolean onLoan) {
        this.onLoan = onLoan;
    }
    
    //Accessor and Mutator of cost
    public int  getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    //Accessor and Mutator of weight
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    //Method that outputs details of the tool to the terminal window
    public void printDetails() {
        System.out.println("Tool name: " + toolName + "; code: " + itemCode + "; timesBorrowed: " + timesBorrowed + "; onLoan: " + (onLoan ? "yes" : "no") + "; cost: " + cost + "; weight: " + weight);
    }

    public void readData(Scanner scanner) {
        toolName = scanner.next();
        itemCode = scanner.next();
        timesBorrowed = scanner.nextInt();
        onLoan = scanner.nextBoolean();
        cost = scanner.nextInt();
        weight = scanner.nextInt();
    }

    @Override
    public String toString() {
        return toolName + ", " + itemCode + ", " + timesBorrowed + ", " + onLoan + ", " + cost + ", " + weight;
    }
}


