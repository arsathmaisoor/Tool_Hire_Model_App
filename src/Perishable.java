package src;

import java.util.*;

public class Perishable extends Accessories{
    private Boolean isIrritant;
    private String useByDate;
    private int volume;
    
    public Perishable(Boolean isRecyclable, String toolName, String toolCode, int cost, Boolean isIrritant, String useByDate, int volume) {
        super(isRecyclable, toolName, toolCode, cost);
        this.isIrritant = isIrritant;
        this.useByDate = useByDate;
        this.volume = volume;
    }

    public Boolean getIsIrritant() {
        return isIrritant;
    }

    public void setIsIrritant(Boolean isIrritant) {
        this.isIrritant = isIrritant;
    }

    public String getUseByDate() {
        return useByDate;
    }

    public void setUseByDate(String useByDate) {
        this.useByDate = useByDate;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("is irritant: " + this.isIrritant+"; Use By date: "+ this.useByDate+"; volume: "+ this.volume);
    }

    @Override
    public void readData(Scanner scanner) {
        super.readData(scanner);
        if(scanner.hasNextBoolean()) {
            this.isIrritant = scanner.nextBoolean();
        }
        if(scanner.hasNext()) {
            this.useByDate = scanner.next();
        }
        if(scanner.hasNextInt()) {
            this.volume = scanner.nextInt();
        }
    }

    @Override
    public String toString(){
        return isRecyclable + ", "+toolName+", "+toolCode+", "+cost+", "+isIrritant+", "+useByDate+", "+volume;
    }
}
