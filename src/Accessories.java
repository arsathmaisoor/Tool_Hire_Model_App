package src;

import java.util.*;
public class Accessories extends ShopItem {
    protected Boolean isRecyclable;

    public Accessories(Boolean isRecyclable, String toolName, String toolCode, int cost) {
        super(toolName, toolCode, cost);
        this.isRecyclable = isRecyclable;
    }

    public Boolean getIsRecyclable() {
        return isRecyclable;
    }

    public void setIsRecyclable(Boolean isRecyclable) {
        this.isRecyclable = isRecyclable;
    }

    // Method that outputs details of the accessories to the terminal window
    public void printDetails() {
        System.out.println("Is Recyclable: " + (isRecyclable ? "yes" : "no") + "; tool name: " + toolName
                + "; tool code: " + toolCode );
    }

    public void readData(Scanner scanner) {
        isRecyclable = scanner.nextBoolean();
        toolName = scanner.next();
        toolCode = scanner.next();
        cost = scanner.nextInt();
    }

    @Override
    public String toString() {
        return isRecyclable+", " +toolName + ", " + toolCode + ", " +cost;
    }
}
