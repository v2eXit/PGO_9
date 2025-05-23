public class Book implements MediaItem, Rentable {
    private String title, author, isbn;
    private int publicationYear;
    private boolean isAvailable;

    public Book(String title, String author, int year, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = year;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getYear() {
        return publicationYear;
    }

    @Override
    public String getDisplayString() {
        return "Book: " + title + " by " + author + " (" + publicationYear + "), ISBN: " + isbn;
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
}
