package json.dicogs;

public class Artist {

    private String name;

    // katso @SerializedName jos haluat muuttaa nimen
    private String releases_url;

    public String getName() {
        return name;
    }

    public String getReleases_url() {
        return releases_url;
    }
}
