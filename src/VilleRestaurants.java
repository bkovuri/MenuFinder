
import java.io.*;
import java.util.*;

/**
 * Created by Bhanu on 4/13/14.
 */
public class VilleRestaurants {

    private Map<String, Restaurant> restaurants;

    VilleRestaurants()
    {
        restaurants = new LinkedHashMap<String, Restaurant>();
    }

    public static void main(String[] args) throws Exception
    {

        VilleRestaurants villeRestaurants = new VilleRestaurants();
        if(args != null && args.length > 1)
        {
            villeRestaurants.readInputDataFromCSV(args[0]);
            Collection<String> searchItems = new ArrayList<String>();
            for(int i=1; i< args.length;i++)
            {
                searchItems.add(args[i]);
            }
            villeRestaurants.findBestRestaurant(searchItems);
        }
    }

    void readInputDataFromCSV(String fileName) throws IOException {


        BufferedReader br = null;
        String line;
        String colSeparator = ",";
            try
            {
                br = new BufferedReader( new FileReader(fileName));
                while((line = br.readLine()) != null)
                {
                   String[] row = line.split(colSeparator);
                    for(int i=0; i<row.length;i++)
                    {
                        row[i] = row[i].replaceAll("\\s+","");
                    }
                    if(row.length == 3)
                    {
                        Restaurant restaurant;
                        if(restaurants.containsKey(row[0]))
                        {
                           restaurant = restaurants.get(row[0]);
                        }
                        else
                        {
                            restaurant = new Restaurant(Integer.parseInt(row[0]));
                            restaurants.put(row[0], restaurant);
                        }
                        Double price = new Double(row[1]);
                        restaurant.getMenu().addItem(new Item(row[2], price));
                    }
                    else if(row.length > 3)
                    {
                        Restaurant restaurant;
                        if(restaurants.containsKey(row[0]))
                        {
                            restaurant = restaurants.get(row[0]);
                        }
                        else
                        {
                            restaurant = new Restaurant(Integer.parseInt(row[0]));
                            restaurants.put(row[0], restaurant);
                        }
                        Double price = new Double(row[1]);
                        Set<String> itemIds = new LinkedHashSet<String>();
                        for(int i=2;i<row.length;i++)
                        {
                            itemIds.add(row[i]);
                        }
                        restaurant.getMenu().addValueMeal(new ValueMeal(price, itemIds));
                    }
                }

            }
            catch(FileNotFoundException fe)
            {
                System.err.println(new StringBuilder("Failed to create/read from given csv file: ")
                        .append(fileName).toString());
                throw fe;
            }
    }

    public void findBestRestaurant(Collection<String> itemIds)
    {
        Double minCost = -1.0;
        Integer restaurantId = -1;
        for(Restaurant restaurant: restaurants.values())
        {
            Double mCost = 0.0;
            restaurantId = restaurant.getRestaurantId();
            Map<String, Item> items = restaurant.getMenu().getItems();
            Set<ValueMeal> valueMeals = restaurant.getMenu().getValueMeals();
            for(String searchItem: itemIds)
            {
               Item item = null;
               if(items.containsKey(searchItem))
               {
                  item = items.get(searchItem);
               }
               ValueMeal valueMeal = null;
               for(ValueMeal element: valueMeals)
               {
                  if(element.getItems_ids().contains(searchItem))
                  {
                      if(valueMeal == null)
                        valueMeal = element;
                      else if(element.getPrice() < valueMeal.getPrice())
                      {
                          valueMeal = element;
                      }
                  }
               }
               if(item == null && valueMeal == null)
               {
                    mCost = 0.0;
                    break;
               }
               if(item != null && valueMeal != null)
               {
                   mCost += item.getPrice() > valueMeal.getPrice() ? item.getPrice() : valueMeal.getPrice();
               }
               else
               {
                   mCost += item == null ? valueMeal.getPrice() : item.getPrice();
               }
            }
            if(minCost == -1 || mCost < minCost)
            {
                restaurantId = restaurant.getRestaurantId();
                minCost = mCost;
            }
        }
        if(minCost > 0)
        {
            System.out.println(restaurantId+","+minCost);
        }
        else
        {
            //Non Zero Number, if we do not find item in any of the restaurants
            System.out.println(-1);
        }
    }
}
