package json.discogs;

public class Release {

    private long id;
    private String title;

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return "Release [id=" + id + ", title=" + title + "]";
    }

}
