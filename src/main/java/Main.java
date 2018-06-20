/**
 * Created by nimtego_loc on 19.06.2018.
 */
public class Main {
    public static void main(String[] args) {
        Search<Integer> integerSearch = new BinarySearch<>();
        integerSearch.putItem(44);
        integerSearch.putItem(5);
        integerSearch.putItem(72342);
        integerSearch.putItem(60);
        integerSearch.putItem(842);
        integerSearch.putItem(31);
        System.out.println(integerSearch);
        integerSearch.sort();
        System.out.println(integerSearch);
    }
}
