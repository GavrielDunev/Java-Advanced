package CustomList;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        for (int i = 0; i < customList.getSize() - 1; i++) {
            if (customList.get(i).compareTo(customList.get(i + 1)) > 0) {
                customList.swap(i, i + 1);
                for (int j = i + 1; j < customList.getSize(); j++) {
                    if (customList.get(i).compareTo(customList.get(j)) > 0) {
                        customList.swap(i, j);
                    }
                }
            }

        }
    }
}
