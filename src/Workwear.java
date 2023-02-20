package src;

import java.util.*;
public class Workwear extends Accessories{
    private String manufacturingStandard;
    private String color;
    private char size;

    public Workwear(Boolean isRecyclable, String toolName, String toolCode, int cost, String manufacturingStandard, String color, char size) {
        super(isRecyclable, toolName, toolCode, cost);
        this.manufacturingStandard = manufacturingStandard;
        this.color = color;
        this.size = size;
    }

    public String getManufacturingStandard() {
        return manufacturingStandard;
    }

    public void setManufacturingStandard(String manufacturingStandard) {
        this.manufacturingStandard = manufacturingStandard;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("manufacturing standard: " + this.manufacturingStandard+"; color: "+ this.color+"; size: "+ this.size);
    }

    @Override
    public void readData(Scanner scanner) {
        super.readData(scanner);
        if(scanner.hasNext()) {
            this.manufacturingStandard = scanner.next();
        }
        if(scanner.hasNext()) {
            this.color = scanner.next();
        }
        if(scanner.hasNextInt()) {
            this.size = scanner.next().charAt(0);
        }
    }

    @Override
    public String toString(){
        return isRecyclable + ", "+toolName+", "+toolCode+", "+cost+", "+manufacturingStandard+", "+color+", "+size;
    }

}
