package model;

public class Artist implements MusicData {

    private long id;
    private String name;

    public Artist(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return this.name;
    }

    @Override
    public String getUrl() {
        return "/albums?ArtistId=" + this.id;
    }
}
