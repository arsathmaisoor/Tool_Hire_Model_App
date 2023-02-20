package src;

public class ShopItem {
    protected String toolName;
    protected String toolCode;
    protected int cost;

    public ShopItem(String toolName, String toolCode, int cost)
    {
        this.toolName = toolName;
        this.toolCode = toolCode;
        this.cost = cost;
    }

        //Accessor and Mutator of toolName
    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    //Accessor and Mutator of toolCode
    public String getItemCode() {
        return toolCode;
    }

    public void setItemCode(String toolCode) {
        this.toolCode = toolCode;
    }

    //Accessor and Mutator of cost
    public int  getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
        
}
