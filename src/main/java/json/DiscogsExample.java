package json;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import json.discogs.Artist;
import json.discogs.Release;
import json.discogs.ReleasesResponse;

public class DiscogsExample {

    private static HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();

        // Popeda: 264333, Poju: 2209399
        Scanner input = new Scanner(System.in);

        System.out.print("Insert artist id: ");
        int id = input.nextInt();

        String json = get("https://api.discogs.com/artists/" + id);

        Artist artist = gson.fromJson(json, Artist.class);

        System.out.println(artist.getName());

        String releasesJson = get(artist.getReleases_url());

        ReleasesResponse response = gson.fromJson(releasesJson, ReleasesResponse.class);
        List<Release> albums = response.getReleases();

        for (Release album : albums) {
            System.out.println(" * " + album.getTitle());
        }
    }

    public static String get(String uri) throws Exception {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return response.body();
    }
}
