import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book bookOne, Book bookTwo) {
        int result = bookOne.getTitle().compareTo(bookTwo.getTitle());
        if (result == 0) {
            if (bookOne.getYear() > bookTwo.getYear()) {
                result = 1;
            } else if (bookOne.getYear() < bookTwo.getYear()) {
                result = -1;
            }
        }
        return result;
    }
}
