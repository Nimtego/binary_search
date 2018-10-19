package javasrc;
import java.util.Random;

/**
 * Created by nimtego_loc on 19.06.2018.
 */
public class MainJ {
    public static void main() {
        Random r = new Random();
        SearchJ<Integer> integerSearch = new BinarySearchJ<>();
        for (int i = 0; i < 30; i++) {
            integerSearch.putItem(r.nextInt(100));
        }
        System.out.println(integerSearch);
        integerSearch.sort();
        System.out.println(integerSearch);
        for (int i = 0; i < 30; i++) {
            int number = r.nextInt(100);
            System.out.println(integerSearch.binary(number) +" search - " +number);
        }


        SearchJ<Float> integerSearchFloat = new BinarySearchJ<>();
        float min = 1f;
        float max = 10f;
        for (int i = 0; i < 30; i++) {
            integerSearchFloat.putItem(min + r.nextFloat() * (max - min));
        }
        System.out.println(integerSearchFloat);
        integerSearchFloat.sort();
        System.out.println(integerSearchFloat);
        for (int i = 0; i < 30; i++) {
            float number = min + r.nextFloat() * (max - min);
            System.out.println(integerSearchFloat.binary(number) +" search - " +number);
        }
    }
}
