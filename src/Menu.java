import java.util.*;

/**
 * Created by Bhanu on 4/13/14.
 */
public class Menu {

    private Map<String, Item> items;

    private Set<ValueMeal> valueMeals;

    Menu()
    {
        items = new LinkedHashMap<String, Item>();
        valueMeals = new LinkedHashSet<ValueMeal>();
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public void setItems(Map<String, Item> items) {
        this.items = items;
    }

    public void addItem(Item item)
    {
        items.put(item.getItemId(), item);
    }

    public void addValueMeal(ValueMeal valueMeal)
    {
        valueMeals.add(valueMeal);
    }

    public Set<ValueMeal> getValueMeals() {
        return valueMeals;
    }

    public void setValueMeals(Set<ValueMeal> valueMeals) {
        this.valueMeals = valueMeals;
    }
}
