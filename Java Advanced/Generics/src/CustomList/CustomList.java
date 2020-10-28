package CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends  Comparable<T>> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
        if (this.elements.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return this.elements.remove(index);
    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        if (firstIndex < 0 || secondIndex < 0 || firstIndex >= this.elements.size() || secondIndex >= this.elements.size()) {
            throw new IndexOutOfBoundsException();
        }
        T firstElement = this.elements.get(firstIndex);
        T secondElement = this.elements.get(secondIndex);
        this.elements.add(firstIndex, secondElement);
        this.elements.remove(firstIndex + 1);
        this.elements.add(secondIndex, firstElement);
        this.elements.remove(secondIndex + 1);
    }

    public int countGreaterThan(T element){
        return (int)this.elements.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax(){
        T max = this.elements.get(0);
        for (int i = 0; i < this.elements.size(); i++) {
            if (this.elements.get(i).compareTo(max) > 0) {
                max = this.elements.get(i);
            }
        }
        return max;
    }

    public T getMin(){
        T min = this.elements.get(0);
        for (int i = 0; i < this.elements.size(); i++) {
            if (this.elements.get(i).compareTo(min) < 0) {
                min = this.elements.get(i);
            }
        }
        return min;
    }

    public int getSize(){
        return this.elements.size();
    }

    public T get(int index){
        return this.elements.get(index);
    }

    public void print(){
        for (T element : this.elements) {
            System.out.println(element);
        }
    }
}
