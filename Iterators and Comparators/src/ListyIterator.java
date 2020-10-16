import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    List<String> elements;
    int index;

    public ListyIterator(List<String> elements) {
        this.elements = elements;
    }

    public boolean move(){
        if (this.index < this.elements.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext(){
        if (this.index < this.elements.size() - 1) {
            return true;
        }
        return false;
    }

    public void print(){
        if (this.elements.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.elements.get(this.index));
        }
    }

    public void printAll(){
        int counter = 0;
        while (counter < this.elements.size()) {
            System.out.print(this.elements.get(counter) + " ");
            counter++;
        }
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }
}