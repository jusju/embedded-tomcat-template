package json;

import com.google.gson.Gson;

import model.ShoppingListItem;

public class JsonWritingExample {

    public static void main(String[] args) {
        Gson gson = new Gson();

        ShoppingListItem item = new ShoppingListItem(123, "Coffee");

        String jsonOutput = gson.toJson(item);

        System.out.println(jsonOutput);
    }
}
