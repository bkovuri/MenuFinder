import java.util.Collection;
import java.util.Set;

/**
 * Created by Bhanu on 4/13/14.
 */
public class ValueMeal {

    private Set<String> items_ids;
    private double price;

    public ValueMeal(double price, Set<String> item_ids)
    {
        this.price = price;
        this.items_ids = item_ids;
    }

    public Set<String> getItems_ids() {
        return items_ids;
    }

    public void setItems_ids(Set<String> items_ids) {
        this.items_ids = items_ids;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
