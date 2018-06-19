import java.util.Random;

/**
 * Created by nimtego_loc on 19.06.2018.
 */
public class Main {
    public static void main(String[] args) {
        Search<Float> integerSearch = new BinarySearch<>();
        float max = 30.5f;
        float min = 1.6f;
        Random r = new Random();
        for (int i = 0; i < 30; i++) {
            integerSearch.putItem(r.nextFloat() * (max - min) + min);
        }
        System.out.println(integerSearch);
        integerSearch.sort();
        System.out.println(integerSearch);
        integerSearch.putItem(45f);
        System.out.println(integerSearch);
        System.out.println(integerSearch.binary(1f));

        Search<Integer> integerSearch2 = new BinarySearch<>();

        for (int i = 0; i < 30; i++) {
            integerSearch2.putItem(r.nextInt(100));
        }
        System.out.println(integerSearch2);
        integerSearch2.sort();
        System.out.println(integerSearch2);
        integerSearch2.putItem(45);
        System.out.println(integerSearch2);
        System.out.println(integerSearch2.binary(14));
    }
}
