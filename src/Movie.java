import java.util.ArrayList;
import java.util.List;

public class Movie implements MediaItem, Rentable, Rateable {
    private String title, director;
    private int releaseYear, duration;
    private boolean isAvailable;
    private List<Integer> ratings;

    public Movie(String title, String director, int year, int duration) {
        this.title = title;
        this.director = director;
        this.releaseYear = year;
        this.duration = duration;
        this.isAvailable = true;
        this.ratings = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getYear() {
        return releaseYear;
    }

    @Override
    public String getDisplayString() {
        return "Movie: " + title + " directed by " + director + " (" + releaseYear + "), " + duration + " min";
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public boolean rent() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    @Override
    public void returnItem() {
        isAvailable = true;
    }

    @Override
    public void addRating(int stars) {
        if (stars >= 1 && stars <= 5) {
            ratings.add(stars);
        }
    }

    @Override
    public double getAverageRating() {
        if (ratings.isEmpty()) return 0.0;
        int total = 0;
        for (int rating : ratings) {
            total += rating;
        }
        return (double) total / ratings.size();
    }
}
