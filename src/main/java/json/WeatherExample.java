package json;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class WeatherExample {
    private static HttpClient client = HttpClient.newHttpClient();
    private static String APP_ID = "d95c9ff2574806a82a5fa5c926a49d69"; // TODO: Remove from source code

    public static void main(String[] args) throws Exception {
        String weatherJson = get(
                "https://api.openweathermap.org/data/2.5/weather?q=helsinki,fi&appid=" + APP_ID + "&units=metric");

        JsonObject json = new Gson().fromJson(weatherJson, JsonObject.class);

        double output = json.getAsJsonObject("main").get("temp").getAsDouble();
        System.out.println(output);
    }

    public static String get(String uri) throws Exception {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return response.body();
    }
}
