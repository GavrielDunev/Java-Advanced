package Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {

    private int[] numbers;

    public Lake(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = 0;
            int lastEvenIndex = numbers.length % 2 == 0 ? numbers.length - 2 : numbers.length - 1;

            @Override
            public boolean hasNext() {
                return this.index < numbers.length;
            }

            @Override
            public Integer next() {
                if (index == lastEvenIndex) {
                    int element = numbers[lastEvenIndex];
                    this.index = 1;
                    return element;
                }
                int element = numbers[index];
                this.index += 2;
                return element;
            }
        };
    }
}
