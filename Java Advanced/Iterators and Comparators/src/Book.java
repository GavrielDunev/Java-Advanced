import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setAuthors(authors);
        this.setTitle(title);
        this.setYear(year);
    }

    private void setTitle(String title){
        this.title = title;
    }

    private void setYear(int year){
        this.year = year;
    }

    private void setAuthors(String... authors){
        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        }else {
            this.authors = Arrays.asList(authors);
        }
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    @Override
    public int compareTo(Book other) {
        if (this.title.compareTo(other.getTitle()) == 0) {
            if (this.getYear() > other.getYear()) {
                return 1;
            } else if (this.getYear() < other.getYear()) {
                return -1;
            } else {
                return 0;
            }
        }
        return this.getTitle().compareTo(other.getTitle());
    }
}
