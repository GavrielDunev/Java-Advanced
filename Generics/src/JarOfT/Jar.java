package JarOfT;

import java.util.ArrayDeque;

public class Jar<Type> {

    private ArrayDeque<Type> content;

    public Jar() {
        this.content = new ArrayDeque<>();
    }

    public void add(Type element) {
        this.content.push(element);
    }

    public Type remove(){
        return this.content.pop();
    }
}
