import java.util.Random;

/**
 * Created by nimtego_loc on 19.06.2018.
 */
public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        Search<Integer> integerSearch = new BinarySearch<>();
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
        System.out.println(integerSearch.binary(1));

        Search<Float> integerSearchFloat = new BinarySearch<>();
        float min = 1f;
        float max = 10f;
        for (int i = 0; i < 30; i++) {
            integerSearchFloat.putItem(min + r.nextFloat() * (max - min));
        }
        System.out.println(integerSearchFloat);
        integerSearchFloat.sort();
        System.out.println(integerSearchFloat);
        System.out.println(integerSearchFloat.binary(1f));
    }
}
