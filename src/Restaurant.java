/**
 * Created by Bhanu on 4/13/14.
 */
public class Restaurant {

    private Integer restaurantId;

    private Menu menu;

    Restaurant(Integer restaurantId)
    {
        this.restaurantId = restaurantId;
        menu = new Menu();
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
