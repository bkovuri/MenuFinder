/**
 * Created by Bhanu on 4/13/14.
 */
public class Item {

    private double price;
    private String itemId;

    Item(String itemId, double price)
    {
        this.itemId = itemId;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
