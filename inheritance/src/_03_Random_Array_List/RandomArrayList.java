package _03_Random_Array_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(this.size() - 1);

        T element = this.get(randomIndex);
        this.remove(element);
        return element;
    }


}
